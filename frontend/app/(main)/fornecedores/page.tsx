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
import { InputTextarea } from 'primereact/inputtextarea';
import { FornecedorService } from '@/service/FornecedorService';

const Fornecedor = () => {
    let fornecedorVazio: Projeto.Fornecedor = {
        id: '',
        name: '',
        cnpj: '',
        cep: '',
        phoneNumber: '',
        address: ''
    };

    const [fornecedores, setFornecedores] = useState<Projeto.Fornecedor[]>([]);
    const [fornecedorDialog, setFornecedorDialog] = useState(false);
    const [deleteFornecedorDialog, setDeleteFornecedorDialog] = useState(false);
    const [deleteFornecedoresDialog, setDeleteFornecedoresDialog] = useState(false);
    const [fornecedor, setFornecedor] = useState<Projeto.Fornecedor>(fornecedorVazio);
    const [selectedFornecedores, setSelectedFornecedores] = useState<Projeto.Fornecedor[]>([]);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const fornecedorService = useMemo(() => new FornecedorService(), []);
    const [shouldReloadResources, setShouldReloadResources] = useState(false);

    useEffect(() => {
        const loadData = () => {
            fornecedorService.listarTodos()
                .then((response) => {
                    setShouldReloadResources(false); 
                    setFornecedores(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    toast.current?.show({
                        severity: 'error',
                        summary: 'Erro',
                        detail: 'Falha ao carregar fornecedores',
                        life: 5000
                    });
                });
        };
        if (shouldReloadResources || fornecedores.length === 0) {
            loadData();
        }
    }, [fornecedorService, fornecedores.length, shouldReloadResources]);

    const openNew = () => {
        setFornecedor(fornecedorVazio);
        setSubmitted(false);
        setFornecedorDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setFornecedorDialog(false);
    };

    const hideDeleteFornecedorDialog = () => {
        setDeleteFornecedorDialog(false);
    };

    const hideDeleteFornecedoresDialog = () => {
        setDeleteFornecedoresDialog(false);
    };

    const saveFornecedor = () => {
        setSubmitted(true);
    
        let _fornecedores = [...(fornecedores as any)];
        
        if (fornecedor.id != '') {
            fornecedorService.alterar(fornecedor)
            toast.current?.show({
                severity: 'success',
                summary: 'Sucesso',
                detail: 'Fornecedor Atualizado',
                life: 5000
            });
            setShouldReloadResources(true);
        } else {
            fornecedorService.inserir(fornecedor)
                .then(() => {
                    toast.current?.show({
                        severity: 'success',
                        summary: 'Sucesso',
                        detail: 'Fornecedor Criado!',
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
                    console.log(fornecedor)
                });
        }
    
        setFornecedores(_fornecedores as any);
        setFornecedorDialog(false);
        setFornecedor(fornecedorVazio);
    };

    const editFornecedor = (fornecedor: Projeto.Fornecedor) => {
        setFornecedor({ ...fornecedor });
        setFornecedorDialog(true);
    };

    const confirmDeleteFornecedor = (fornecedor: Projeto.Fornecedor) => {
        setFornecedor(fornecedor);
        setDeleteFornecedorDialog(true);
    };

    const deleteFornecedor = () => {
        let _fornecedores = (fornecedores as any)?.filter((val: any) => val.id !== fornecedor.id);
        setFornecedores(_fornecedores);
        setDeleteFornecedorDialog(false);
        setFornecedor(fornecedorVazio);
        fornecedorService.excluir(fornecedor.id)
        .then(() => {
            setFornecedores([]);
            toast.current?.show({
                severity: 'success',
                summary: 'Sucesso!',
                detail: 'Fornecedor Deletado',
                life: 5000
            });
        }).catch((error) => {
            toast.current?.show({
            severity: 'error',
            summary: 'Erro!',
            detail: 'Erro ao deletar fornecedor',
            life: 5000
        });
        }
        );
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteFornecedoresDialog(true);
    };

    const deleteSelectedFornecedores = () => {
        selectedFornecedores.map((fornecedor) => {
            let _fornecedores = (fornecedores as any)?.filter((val: any) => val.id !== fornecedor.id);
            setFornecedores(_fornecedores);
            fornecedorService.excluir(fornecedor.id)
            .then(() => {
                setFornecedores([]);
                toast.current?.show({
                    severity: 'success',
                    summary: 'Sucesso',
                    detail: 'Fornecedor Deletado',
                    life: 5000
                });
            }).catch((error) => {
                toast.current?.show({
                severity: 'error',
                summary: 'Erro!',
                detail: error.response.data.message,
                life: 5000
            });
            });
        });
        setDeleteFornecedoresDialog(false);
    };

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, nome: string) => {
        const val = (e.target && e.target.value) || '';
        let _fornecedor = { ...fornecedor };
        _fornecedor[`${nome}`] = val;

        setFornecedor(_fornecedor);
    };

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Excluir" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedFornecedores || !(selectedFornecedores as any).length} />
                </div>
            </React.Fragment>
        );
    };

    const rightToolbarTemplate = () => {
        return (
            <React.Fragment>
            </React.Fragment>
        );
    };

    const nameBodyTemplate = (rowData: Projeto.Fornecedor) => {
        return (
            <>
                <span className="p-column-title">Nome</span>
                {rowData.name}
            </>
        );
    };

    const cnpjBodyTemplate = (rowData: Projeto.Fornecedor) => {
        return (
            <>
                <span className="p-column-title">CNPJ</span>
                {rowData.cnpj}
            </>
        );
    };

    const cepBodyTemplate = (rowData: Projeto.Fornecedor) => {
        return (
            <>
                <span className="p-column-title">CEP</span>
                {rowData.cep}
            </>
        );
    };

    const phoneNumberBodyTemplate = (rowData: Projeto.Fornecedor) => {
        return (
            <>
                <span className="p-column-title">Telefone</span>
                {rowData.phoneNumber}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Projeto.Fornecedor) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editFornecedor(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteFornecedor(rowData)} />
            </>
        );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0" style={{fontSize:25}}>Gerenciamento de fornecedores</h5>
        </div>
    );

    const fornecedorDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Salvar" icon="pi pi-check" text onClick={saveFornecedor} />
        </>
    );
    const deleteFornecedorDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteFornecedorDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteFornecedor} />
        </>
    );
    const deleteFornecedoresDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteFornecedoresDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedFornecedores} />
        </>
    );

    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={fornecedores}
                        selection={selectedFornecedores}
                        onSelectionChange={(e) => setSelectedFornecedores(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[10, 25, 50, 100]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Mostrando {first} de {last} com {totalRecords} fornecedores"
                        globalFilter={globalFilter}
                        emptyMessage="Sem fornecedores registrados."
                        header={header}
                        responsiveLayout="scroll"
                    >
                        <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}></Column>
                        <Column field="name" header="Nome" sortable body={nameBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="cnpj" header="CNPJ" sortable body={cnpjBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="cep" header="CEP" sortable body={cepBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="phoneNumber" header="Telefone" sortable body={phoneNumberBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={fornecedorDialog} style={{ width: '450px' }} header="Detalhes do fornecedor" modal className="p-fluid" footer={fornecedorDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="name">Nome</label>
                            <InputText
                                id="name"
                                value={fornecedor.name}
                                onChange={(e) => onInputChange(e, 'name')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !fornecedor.name
                                })}
                            />
                            {submitted && !fornecedor.name && <small className="p-invalid">Nome é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="cnpj">CNPJ</label>
                            <InputText
                                id="cnpj"
                                value={fornecedor.cnpj}
                                onChange={(e) => onInputChange(e, 'cnpj')}
                                required
                                className={classNames({
                                    'p-invalid': submitted && !fornecedor.cnpj
                                })}
                            />
                            {submitted && !fornecedor.cnpj && <small className="p-invalid">CNPJ é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="cep">CEP</label>
                            <InputText
                                id="cep"
                                value={fornecedor.cep}
                                onChange={(e) => onInputChange(e, 'cep')}
                                required
                                className={classNames({
                                    'p-invalid': submitted && !fornecedor.cep
                                })}
                            />
                            {submitted && !fornecedor.cep && <small className="p-invalid">CEP é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="phoneNumber">Telefone</label>
                            <InputText
                                id="phoneNumber"
                                value={fornecedor.phoneNumber}
                                onChange={(e) => onInputChange(e, 'phoneNumber')}
                                required
                                className={classNames({
                                    'p-invalid': submitted && !fornecedor.phoneNumber
                                })}
                            />
                            {submitted && !fornecedor.phoneNumber && <small className="p-invalid">Telefone é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="address">Endereço</label>
                            <InputTextarea 
                                id="address"
                                value={fornecedor.address}
                                onChange={(e) => onInputChange(e, 'address')}
                                required
                                rows={5} 
                                cols={30}
                                className={classNames({
                                    'p-invalid': submitted && !fornecedor.address
                                })}
                            />
                            {submitted && !fornecedor.address && <small className="p-invalid">Endereço é obrigatório.</small>}
                        </div>

                    </Dialog>

                    <Dialog visible={deleteFornecedorDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteFornecedorDialogFooter} onHide={hideDeleteFornecedorDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {fornecedor && (
                                <span>
                                    Tem certeza de que deseja excluir <b>{fornecedor.name}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteFornecedoresDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteFornecedoresDialogFooter} onHide={hideDeleteFornecedoresDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {fornecedor && <span>Tem certeza de que deseja excluir os fornecedores selecionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default Fornecedor;
