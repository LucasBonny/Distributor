'use client';
import { Button } from 'primereact/button';
import { Column } from 'primereact/column';
import { DataTable, DataTableExpandedRows, DataTableFilterMeta } from 'primereact/datatable';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import React, { useEffect, useMemo, useRef, useState } from 'react';
import { Projeto } from '@/types';
import { InputTextarea } from 'primereact/inputtextarea';
import { EntregaService } from '@/service/EntregaService';

const Entrega = () => {
    let entregaVazia: Projeto.Entrega = {
        id: '',
        dateTimeDelivery: '',
        supplier: '',
        products: []
    };

    const [entregas, setEntregas] = useState<Projeto.Entrega[]>([]);
    const [entregaDialog, setEntregaDialog] = useState(false);
    const [deleteEntregaDialog, setDeleteEntregaDialog] = useState(false);
    const [deleteEntregasDialog, setDeleteEntregasDialog] = useState(false);
    const [entrega, setEntrega] = useState<Projeto.Entrega>(entregaVazia);
    const [selectedEntregas, setSelectedEntregas] = useState<Projeto.Entrega[]>([]);
    const [expandedRows, setExpandedRows] = useState<any[] | DataTableExpandedRows>([]);
    const [submitted, setSubmitted] = useState(false);
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const entregaService = useMemo(() => new EntregaService(), []);
    const [shouldReloadResources, setShouldReloadResources] = useState(false);

    useEffect(() => {
        const loadData = () => {
            entregaService.listarTodos()
                .then((response) => {
                    setShouldReloadResources(false); 
                    setEntregas(response.data);
                })
                .catch((error) => {
                    console.log(error);
                    toast.current?.show({
                        severity: 'error',
                        summary: 'Erro',
                        detail: 'Falha ao carregar entregas',
                        life: 5000
                    });
                });
        };
        if (shouldReloadResources || entregas.length === 0) {
            loadData();
        }
    }, [entregaService, shouldReloadResources, entregas.length]);

    const openNew = () => {
        setEntrega(entregaVazia);
        setSubmitted(false);
        setEntregaDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setEntregaDialog(false);
    };

    const hideDeleteEntregaDialog = () => {
        setDeleteEntregaDialog(false);
    };

    const hideDeleteEntregasDialog = () => {
        setDeleteEntregasDialog(false);
    };

    const saveEntrega = () => {
        setSubmitted(true);
    
        let _entregas = [...(entregas as any)];
        
        if (entrega.id != '') {
            entregaService.alterar(entrega)
            toast.current?.show({
                severity: 'success',
                summary: 'Sucesso',
                detail: 'Entrega Atualizada',
                life: 5000
            });
            setShouldReloadResources(true);
        } else {
            entregaService.inserir(entrega)
                .then(() => {
                    toast.current?.show({
                        severity: 'success',
                        summary: 'Sucesso',
                        detail: 'Entrega Criada!',
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
                    console.log(entrega)
                });
        }
    
        setEntregas(_entregas as any);
        setEntregaDialog(false);
        setEntrega(entregaVazia);
    };

    const editEntrega = (fornecedor: Projeto.Entrega) => {
        setEntrega({ ...fornecedor });
        setEntregaDialog(true);
    };

    const confirmDeleteEntrega = (entrega: Projeto.Entrega) => {
        setEntrega(entrega);
        setDeleteEntregaDialog(true);
    };

    const deleteEntrega = () => {
        let _entregas = (entregas as any)?.filter((val: any) => val.id !== entrega.id);
        setEntregas(_entregas);
        setDeleteEntregaDialog(false);
        setEntrega(entregaVazia);
        entregaService.excluir(entrega.id)
        .then(() => {
            setEntregas([]);
            toast.current?.show({
                severity: 'success',
                summary: 'Sucesso!',
                detail: 'Entrega Deletada',
                life: 5000
            });
        }).catch((error) => {
            toast.current?.show({
            severity: 'error',
            summary: 'Erro!',
            detail: 'Erro ao deletar entrega',
            life: 5000
        });
        }
        );
    };

    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteEntregasDialog(true);
    };

    const deleteSelectedEntregas = () => {
        selectedEntregas.map((entrega) => {
            let _entregas = (entregas as any)?.filter((val: any) => val.id !== entrega.id);
            setEntregas(_entregas);
            entregaService.excluir(entrega.id)
            .then(() => {
                setEntregas([]);
                toast.current?.show({
                    severity: 'success',
                    summary: 'Sucesso',
                    detail: 'Entrega Deletada',
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
        setDeleteEntregasDialog(false);
    };

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, nome: string) => {
        const val = (e.target && e.target.value) || '';
        let _entrega = { ...entrega };
        _entrega[`${nome}`] = val;

        setEntrega(_entrega);
    };

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Excluir" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedEntregas || !(selectedEntregas as any).length} />
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

    const nameBodyTemplate = (rowData: Projeto.Entrega) => {
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
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editEntrega(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteEntrega(rowData)} />
            </>
        );
    };

    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0">Gerenciamento de entregas</h5>
        </div>
    );

    const entregaDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Salvar" icon="pi pi-check" text onClick={saveEntrega} />
        </>
    );
    const deleteEntregaDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteEntregaDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteEntrega} />
        </>
    );
    const deleteEntregasDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteEntregasDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedEntregas} />
        </>
    );

    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable value={entregas} expandedRows={expandedRows} onRowToggle={(e) => setExpandedRows(e.data)} responsiveLayout="scroll" dataKey="id" header={header}>
                        <Column expander style={{ width: '3em' }} />
                        <Column field="id" header="ID" sortable />
                        <Column field="dateTimeDelivery" header="Horário" sortable />
                        <Column field="supplier" header="Fornecedor" sortable />
                    </DataTable>

                    <Dialog visible={entregaDialog} style={{ width: '450px' }} header="Detalhes da entrega" modal className="p-fluid" footer={entregaDialogFooter} onHide={hideDialog}>
                        <div className="field">
                            <label htmlFor="name">Nome</label>
                            <InputText
                                id="name"
                                value={entrega.name}
                                onChange={(e) => onInputChange(e, 'name')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !entrega.name
                                })}
                            />
                            {submitted && !entrega.name && <small className="p-invalid">Nome é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="cnpj">CNPJ</label>
                            <InputText
                                id="cnpj"
                                value={entrega.cnpj}
                                onChange={(e) => onInputChange(e, 'cnpj')}
                                required
                                className={classNames({
                                    'p-invalid': submitted && !entrega.cnpj
                                })}
                            />
                            {submitted && !entrega.cnpj && <small className="p-invalid">CNPJ é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="cep">CEP</label>
                            <InputText
                                id="cep"
                                value={entrega.cep}
                                onChange={(e) => onInputChange(e, 'cep')}
                                required
                                className={classNames({
                                    'p-invalid': submitted && !entrega.cep
                                })}
                            />
                            {submitted && !entrega.cep && <small className="p-invalid">CEP é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="phoneNumber">Telefone</label>
                            <InputText
                                id="phoneNumber"
                                value={entrega.phoneNumber}
                                onChange={(e) => onInputChange(e, 'phoneNumber')}
                                required
                                className={classNames({
                                    'p-invalid': submitted && !entrega.phoneNumber
                                })}
                            />
                            {submitted && !entrega.phoneNumber && <small className="p-invalid">Telefone é obrigatório.</small>}
                        </div>

                        <div className="field">
                            <label htmlFor="address">Endereço</label>
                            <InputTextarea 
                                id="address"
                                value={entrega.address}
                                onChange={(e) => onInputChange(e, 'address')}
                                required
                                rows={5} 
                                cols={30}
                                className={classNames({
                                    'p-invalid': submitted && !entrega.address
                                })}
                            />
                            {submitted && !entrega.address && <small className="p-invalid">Endereço é obrigatório.</small>}
                        </div>

                    </Dialog>

                    <Dialog visible={deleteEntregaDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteEntregaDialogFooter} onHide={hideDeleteEntregaDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {entrega && (
                                <span>
                                    Tem certeza de que deseja excluir <b>{entrega.name}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteEntregasDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteEntregasDialogFooter} onHide={hideDeleteEntregasDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {entrega && <span>Tem certeza de que deseja excluir os fornecedores selecionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default Entrega;
