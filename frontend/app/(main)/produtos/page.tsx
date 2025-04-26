/* eslint-disable @next/next/no-img-element */
'use client';
import { Button } from 'primereact/button';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Dialog } from 'primereact/dialog';
import { FileUpload } from 'primereact/fileupload';
import { InputNumber, InputNumberValueChangeEvent } from 'primereact/inputnumber';
import { InputText } from 'primereact/inputtext';
import { InputTextarea } from 'primereact/inputtextarea';
import { RadioButton, RadioButtonChangeEvent } from 'primereact/radiobutton';
import { Rating } from 'primereact/rating';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import React, { useEffect, useMemo, useRef, useState } from 'react';
import { ProdutoService } from '@/service/ProdutoService';

const Produto = () => {
    let produtoVazio: Projeto.Produto = {
        id: '',
        name: '',
        barCode: '',
        price: 0,
        stock: 0,
        imgUrl: '',
    };

    const [produtos, setProdutos] = useState<Projeto.Produto[]>([]);
    const [produtoDialog, setProdutoDialog] = useState(false);
    const [deleteProdutoDialog, setDeleteProdutoDialog] = useState(false);
    const [deleteProdutosDialog, setDeleteProdutosDialog] = useState(false);
    const [produto, setProduto] = useState<Projeto.Produto>(produtoVazio);
    const [selectedProdutos, setSelectedProdutos] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const produtoService = useMemo(() => new ProdutoService(), []);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const [shouldReloadResources, setShouldReloadResources] = useState(false);
    

    useEffect(() => {
            const loadData = () => {
                produtoService.listarTodos()
                    .then((response) => {
                        setShouldReloadResources(false); 
                        setProdutos(response.data.content);
                        console.log(response);
                    })
                    .catch((error) => {
                        console.log(error);
                        toast.current?.show({
                            severity: 'error',
                            summary: 'Erro',
                            detail: 'Falha ao carregar produtos',
                            life: 5000
                        });
                    });
            };
            if (shouldReloadResources || produtos.length === 0) {
                loadData();
            }
        }, [produtoService, shouldReloadResources, produtos.length]);

    const formatCurrency = (value: number) => {
        return value.toLocaleString('pt-BR', {
            style: 'currency',
            currency: 'BRL'
        });
    };

    const openNew = () => {
        setProduto(produtoVazio);
        setSubmitted(false);
        setProdutoDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setProdutoDialog(false);
    };

    const hideDeleteProdutoDialog = () => {
        setDeleteProdutoDialog(false);
    };

    const hideDeleteProdutosDialog = () => {
        setDeleteProdutosDialog(false);
    };

    const saveProduto = () => {
        setSubmitted(true);
    
        let _produtos = [...(produtos as any)];
        
        if (produto.id != '') {
            produtoService.alterar(produto)
            toast.current?.show({
                severity: 'success',
                summary: 'Sucesso',
                detail: 'Produto Atualizado',
                life: 5000
            });
            console.log(produto)
            setShouldReloadResources(true);
        } else {
            produtoService.inserir(produto)
                .then(() => {
                    toast.current?.show({
                        severity: 'success',
                        summary: 'Sucesso',
                        detail: 'Produto Criado!',
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
                });
        }
    
        setProdutos(_produtos as any);
        setProdutoDialog(false);
        setProduto(produtoVazio);
    };

    const editProduto = (produto: Projeto.Produto) => {
        setProduto({ ...produto });
        setProdutoDialog(true);
    };

    const confirmDeleteProduto = (produto: Projeto.Produto) => {
        setProduto(produto);
        setDeleteProdutoDialog(true);
    };

    const deleteProduto = () => {
        let _produtos = (produtos as any)?.filter((val: any) => val.id !== produto.id);
        setProdutos(_produtos);
        setDeleteProdutoDialog(false);
        setProduto(produtoVazio);
        toast.current?.show({
            severity: 'success',
            summary: 'Sucesso',
            detail: 'Produto Removido',
            life: 3000
        });
    };

    const confirmDeleteSelected = () => {
        setDeleteProdutosDialog(true);
    };

    const deleteSelectedProdutos = () => {
        let _produtos = (produtos as any)?.filter((val: any) => !(selectedProdutos as any)?.includes(val));
        setProdutos(_produtos);
        setDeleteProdutosDialog(false);
        setSelectedProdutos(null);
        toast.current?.show({
            severity: 'success',
            summary: 'Sucesso',
            detail: 'Produtos Deletados',
            life: 3000
        });
    };

    const onInputChange = (
        e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
        nome: keyof Projeto.Produto
      ) => {
        const val: string = e.target?.value ?? '';

        let _produto = { ...produto };
      
        if (nome === 'price' || nome === 'stock') {
          _produto[nome] = Number(val) as Projeto.Produto[typeof nome];
        } else {
          _produto[nome] = val as Projeto.Produto[typeof nome];
        }
      
        setProduto(_produto);
      };
      

      const onInputNumberChange = (
        e: InputNumberValueChangeEvent,
        name: keyof Projeto.Produto
      ) => {
        const val = e.value ?? 0;
        const _produto = { ...produto };
      
        // Aqui garantimos que estamos atualizando apenas campos que são numéricos
        if (name === 'price') {
          _produto[name] = val as Projeto.Produto[typeof name];
        }
      
        setProduto(_produto);
      };

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo Produto" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Deletar" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedProdutos || !(selectedProdutos as any).length} />
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

    const barCodeBodyTemplate = (rowData: Projeto.Produto) => {
        return (
            <>
                <span className="p-column-title">Código de barras</span>
                {rowData.barCode}
            </>
        );
    };

    const nameBodyTemplate = (rowData: Projeto.Produto) => {
        return (
            <>
                <span className="p-column-title">Nome</span>
                {rowData.name}
            </>
        );
    };

    const imgUrlBodyTemplate = (rowData: Projeto.Produto) => {
        return (
            <>
                <span className="p-column-title">Produto</span>
                <img src={rowData.imgUrl} alt="produto" className="shadow-2" width="100" />
            </>
        );
    };

    const priceBodyTemplate = (rowData: Projeto.Produto) => {
        return (
            <>
                <span className="p-column-title">Preço</span>
                {formatCurrency(rowData.price as number)}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Projeto.Produto) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editProduto(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteProduto(rowData)} />
            </>
        );
    };

  

    const produtoDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Salvar" icon="pi pi-check" text onClick={saveProduto} />
        </>
    );
    const deleteProdutoDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteProdutoDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteProduto} />
        </>
    );
    const deleteProdutosDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteProdutosDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedProdutos} />
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
                        value={produtos}
                        selection={selectedProdutos}
                        onSelectionChange={(e) => setSelectedProdutos(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Mostrando {first} a {last} de {totalRecords} produtos"
                       
                    >
                        <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}></Column>
                        <Column header="Produto" body={imgUrlBodyTemplate}></Column>
                        <Column field="barCode" header="Código de barras" sortable body={barCodeBodyTemplate} headerStyle={{ minWidth: '3rem' }}></Column>
                        <Column field="name" header="Nome" sortable body={nameBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="price" header="Preço" body={priceBodyTemplate} sortable></Column>
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={produtoDialog} style={{ width: '450px' }} header="Detalhes do Produto" modal className="p-fluid" footer={produtoDialogFooter} onHide={hideDialog}>
                        {produto.imgUrl && <img src={produto.imgUrl} alt="Imagem do produto" width="150" className="mt-0 mx-auto mb-5 block shadow-2" />}
                        <div className="field">
                            <label htmlFor="name">Nome</label>
                            <InputText
                                id="name"
                                value={produto.name}
                                onChange={(e) => onInputChange(e, 'name')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !produto.name
                                })}
                            />
                            {submitted && !produto.name && <small className="p-invalid">Name is required.</small>}
                        </div>
                        <div className="field col">
                            <label htmlFor="barCode">Código de barras</label>
                            <InputText id="barCode" value={produto.barCode} onChange={(e) => onInputChange(e, 'barCode')} />
                        </div>

                        <div className="formgrid grid">
                            <div className="field col">
                                <label htmlFor="price">Preço</label>
                                <InputNumber id="price" value={produto.price} onValueChange={(e) => onInputNumberChange(e, 'price')} mode="currency" currency="BRL" locale="pt-BR" />
                            </div>
                            <div className="field col">
                                <label htmlFor="stock">Quantidade</label>
                                <InputNumber id="stock" value={produto.stock} onValueChange={(e) => onInputNumberChange(e, 'stock')} />
                            </div>
                        </div>
                        <div className="field col">
                            <label htmlFor="stock">Imagem do produto</label>
                            <InputTextarea id="stock" value={produto.imgUrl} onChange={(e) => onInputChange(e, 'imgUrl')} rows={5} cols={30} />
                        </div>
                    </Dialog>

                    <Dialog visible={deleteProdutoDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteProdutoDialogFooter} onHide={hideDeleteProdutoDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {produto && (
                                <span>
                                    Tem certeza de que deseja excluir <b>{produto.name}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteProdutosDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteProdutosDialogFooter} onHide={hideDeleteProdutosDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {produto && <span>Tem certeza de que deseja excluir os produtos selecionado?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default Produto;
