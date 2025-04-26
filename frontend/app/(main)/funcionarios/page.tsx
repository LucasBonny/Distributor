'use client';
import { Button } from 'primereact/button';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import React, { useEffect, useMemo, useRef, useState } from 'react';
import { Projeto } from '@/types';
import { FuncionarioService } from '@/service/FuncionarioService';

const Funcionario = () => {
    let funcionarioVazio: Projeto.Funcionario = {
        id: '',
        name: '',
        email: '',
        password: '',
        cpf: '',
        birthDate: '',
        phoneNumber: '',
        status: ''
    };

    const [funcionarios, setFuncionarios] = useState<Projeto.Funcionario[]>([]);
    const [funcionarioDialog, setFuncionarioDialog] = useState(false);
    const [deleteFuncionarioDialog, setDeleteFuncionarioDialog] = useState(false);
    const [deleteFuncionariosDialog, setDeleteFuncionariosDialog] = useState(false);
    const [funcionario, setFuncionario] = useState<Projeto.Funcionario>(funcionarioVazio);
    const [selectedFuncionarios, setSelectedFuncionarios] = useState<Projeto.Funcionario[]>([]);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const funcionarioService = useMemo(() => new FuncionarioService(), []);
    const [shouldReloadResources, setShouldReloadResources] = useState(false);

    useEffect(() => {
        const loadData = () => {
            funcionarioService.listarTodos()
                .then((response) => {
                    setShouldReloadResources(false); 
                    setFuncionarios(response.data.content);
                })
                .catch((error) => {
                    console.log(error);
                    toast.current?.show({
                        severity: 'error',
                        summary: 'Erro',
                        detail: 'Falha ao carregar funcionários',
                        life: 5000
                    });
                });
        };
        if (shouldReloadResources || funcionarios.length === 0) {
            loadData();
        }
    }, [funcionarioService, shouldReloadResources, funcionarios.length]);

    const openNew = () => {
        setFuncionario(funcionarioVazio);
        setSubmitted(false);
        setFuncionarioDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setFuncionarioDialog(false);
    };

    const hideDeleteFuncionarioDialog = () => {
        setDeleteFuncionarioDialog(false);
    };

    const hideDeleteFuncionariosDialog = () => {
        setDeleteFuncionariosDialog(false);
    };

    const saveFuncionario = () => {
        setSubmitted(true);
    
        if (funcionario.id) {
            funcionarioService.alterar(funcionario);
            toast.current?.show({
                severity: 'success',
                summary: 'Sucesso',
                detail: 'Funcionário Atualizado',
                life: 5000
            });
            setShouldReloadResources(true);
        } else {
            funcionarioService.inserir(funcionario)
                .then(() => {
                    toast.current?.show({
                        severity: 'success',
                        summary: 'Sucesso',
                        detail: 'Funcionário Criado!',
                        life: 5000
                    });
                    setShouldReloadResources(true);
                })
                .catch((error) => {
                    toast.current?.show({
                        severity: 'error',
                        summary: 'Erro!',
                        detail: error.response?.data?.message || 'Erro desconhecido',
                        life: 5000
                    });
                    console.log(funcionario);
                });
        }
    
        setFuncionarioDialog(false);
        setFuncionario(funcionarioVazio);
    };

    const editFuncionario = (funcionario: Projeto.Funcionario) => {
        setFuncionario({ ...funcionario });
        setFuncionarioDialog(true);
    };

    const confirmDeleteFuncionario = (funcionario: Projeto.Funcionario) => {
        setFuncionario(funcionario);
        setDeleteFuncionarioDialog(true);
    };

    const deleteFuncionario = () => {
        funcionarioService.excluir(funcionario.id)
            .then(() => {
                setFuncionarios((prev) => prev.filter((val) => val.id !== funcionario.id));
                toast.current?.show({
                    severity: 'success',
                    summary: 'Sucesso!',
                    detail: 'Funcionário Deletado',
                    life: 5000
                });
            }).catch((error) => {
                toast.current?.show({
                    severity: 'error',
                    summary: 'Erro!',
                    detail: 'Erro ao deletar funcionário',
                    life: 5000
                });
            });

        setDeleteFuncionarioDialog(false);
        setFuncionario(funcionarioVazio);
    };

    const confirmDeleteSelected = () => {
        setDeleteFuncionariosDialog(true);
    };

    const deleteSelectedFuncionarios = () => {
        selectedFuncionarios.forEach((func) => {
            funcionarioService.excluir(func.id)
                .then(() => {
                    setFuncionarios((prev) => prev.filter((val) => val.id !== func.id));
                })
                .catch((error) => {
                    toast.current?.show({
                        severity: 'error',
                        summary: 'Erro!',
                        detail: 'Erro ao deletar funcionários',
                        life: 5000
                    });
                });
        });

        setDeleteFuncionariosDialog(false);
    };

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement>, nome: string) => {
        const val = (e.target && e.target.value) || '';
        let _funcionario = { ...funcionario };
        _funcionario[`${nome}`] = val;

        setFuncionario(_funcionario);
    };

    const leftToolbarTemplate = () => (
        <div className="my-2">
            <Button label="Novo" icon="pi pi-plus" severity="success" className="mr-2" onClick={openNew} />
            <Button label="Excluir" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedFuncionarios.length} />
        </div>
    );

    const actionBodyTemplate = (rowData: Projeto.Funcionario) => (
        <>
            <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editFuncionario(rowData)} />
            <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteFuncionario(rowData)} />
        </>
    );

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0">Gerenciamento de Funcionários</h5>
        </div>
    );

    const funcionarioDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Salvar" icon="pi pi-check" text onClick={saveFuncionario} />
        </>
    );

    const deleteFuncionarioDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteFuncionarioDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteFuncionario} />
        </>
    );

    const deleteFuncionariosDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteFuncionariosDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedFuncionarios} />
        </>
    );

    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={funcionarios}
                        selection={selectedFuncionarios}
                        onSelectionChange={(e) => setSelectedFuncionarios(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[10, 25, 50, 100]}
                        currentPageReportTemplate="Mostrando {first} de {last} de {totalRecords} funcionários"
                        globalFilter={globalFilter}
                        emptyMessage="Nenhum funcionário encontrado."
                        header={header}
                        responsiveLayout="scroll"
                    >
                        <Column selectionMode="multiple" headerStyle={{ width: '3rem' }}></Column>
                        <Column field="name" header="Nome" sortable></Column>
                        <Column field="email" header="Email" sortable></Column>
                        <Column field="cpf" header="CPF" sortable></Column>
                        <Column field="birthDate" header="Data de Nascimento" sortable></Column>
                        <Column field="phoneNumber" header="Telefone" sortable></Column>
                        <Column field="status" header="Status" sortable></Column>
                        <Column body={actionBodyTemplate}></Column>
                    </DataTable>

                    <Dialog visible={funcionarioDialog} style={{ width: '450px' }} header="Detalhes do Funcionário" modal className="p-fluid" footer={funcionarioDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="name">Nome</label>
                            <InputText id="name" value={funcionario.name} onChange={(e) => onInputChange(e, 'name')} autoFocus className={classNames({ 'p-invalid': submitted && !funcionario.name })} />
                            {submitted && !funcionario.name && <small className="p-invalid">Nome é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="email">Email</label>
                            <InputText id="email" value={funcionario.email} onChange={(e) => onInputChange(e, 'email')} className={classNames({ 'p-invalid': submitted && !funcionario.email })} />
                            {submitted && !funcionario.email && <small className="p-invalid">Email é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="cpf">CPF</label>
                            <InputText id="cpf" value={funcionario.cpf} onChange={(e) => onInputChange(e, 'cpf')} />
                        </div>

                        <div className="field">
                            <label htmlFor="birthDate">Data de Nascimento</label>
                            <InputText id="birthDate" value={funcionario.birthDate} onChange={(e) => onInputChange(e, 'birthDate')} />
                        </div>

                        <div className="field">
                            <label htmlFor="phoneNumber">Telefone</label>
                            <InputText id="phoneNumber" value={funcionario.phoneNumber} onChange={(e) => onInputChange(e, 'phoneNumber')} />
                        </div>

                        <div className="field">
                            <label htmlFor="status">Status</label>
                            <InputText id="status" value={funcionario.status} onChange={(e) => onInputChange(e, 'status')} />
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default Funcionario;
