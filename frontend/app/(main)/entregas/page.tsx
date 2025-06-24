'use client';
import { useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import { Calendar } from 'primereact/calendar';
import { Dropdown } from 'primereact/dropdown';

type Entrega = {
  id: string;
  fornecedor: string;
  dataHora: Date | null;
  produtos: string;
};

const EntregaPage = () => {
  const toast = useRef<Toast>(null);

  const entregaVazia: Entrega = {
    id: '',
    fornecedor: '',
    dataHora: null,
    produtos: '',
  };

  const [entregas, setEntregas] = useState<Entrega[]>([]);
  const [entrega, setEntrega] = useState<Entrega>(entregaVazia);
  const [entregaDialog, setEntregaDialog] = useState(false);
  const [deleteDialog, setDeleteDialog] = useState(false);
  const [selectedEntregas, setSelectedEntregas] = useState<Entrega[]>([]);
  const [submitted, setSubmitted] = useState(false);

  const fornecedores = [
    { name: 'Ambev', code: 'AMBEV' },
    { name: 'Nestlé', code: 'NESTLE' },
    { name: 'Coca-Cola', code: 'COCA' },
    { name: 'PepsiCo', code: 'PEPSI' },
  ];

  const produtos = [
    { name: 'Coca-Cola 2L', code: 'COCA2L' },
    { name: 'Guaraná Antarctica 1L', code: 'GUARA1L' },
    { name: 'Água Mineral', code: 'AGUA' },
    { name: 'Cerveja Skol', code: 'SKOL' },
  ];

  const openNew = () => {
    setEntrega(entregaVazia);
    setSubmitted(false);
    setEntregaDialog(true);
  };

  const hideDialog = () => {
    setSubmitted(false);
    setEntregaDialog(false);
  };

  const saveEntrega = () => {
    setSubmitted(true);
    if (!entrega.fornecedor || !entrega.dataHora || !entrega.produtos) return;

    let _entregas = [...entregas];
    if (entrega.id) {
      const index = _entregas.findIndex((e) => e.id === entrega.id);
      _entregas[index] = entrega;
      toast.current?.show({ severity: 'success', summary: 'Atualizada', detail: 'Entrega atualizada', life: 3000 });
    } else {
      entrega.id = Date.now().toString();
      _entregas.push(entrega);
      toast.current?.show({ severity: 'success', summary: 'Criada', detail: 'Entrega registrada', life: 3000 });
    }

    setEntregas(_entregas);
    setEntregaDialog(false);
    setEntrega(entregaVazia);
  };

  const editEntrega = (entrega: Entrega) => {
    setEntrega({ ...entrega });
    setEntregaDialog(true);
  };

  const confirmDeleteEntrega = (entrega: Entrega) => {
    setEntrega(entrega);
    setDeleteDialog(true);
  };

  const deleteEntrega = () => {
    setEntregas(entregas.filter((e) => e.id !== entrega.id));
    setDeleteDialog(false);
    toast.current?.show({ severity: 'success', summary: 'Excluída', detail: 'Entrega removida', life: 3000 });
  };

  const onDateChange = (e: any) => {
    setEntrega({ ...entrega, dataHora: e.value });
  };

  const leftToolbarTemplate = () => (
    <div className="my-2">
      <Button label="Nova Entrega" icon="pi pi-plus" severity="success" onClick={openNew} />
      <Button label="Excluir" icon="pi pi-trash" severity="danger" className="ml-2" disabled={!selectedEntregas.length} onClick={() => {
        setEntregas(entregas.filter((e) => !selectedEntregas.includes(e)));
        setSelectedEntregas([]);
        toast.current?.show({ severity: 'success', summary: 'Excluídas', detail: 'Entregas removidas', life: 3000 });
      }} />
    </div>
  );

  const actionBodyTemplate = (rowData: Entrega) => (
    <>
      <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editEntrega(rowData)} />
      <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteEntrega(rowData)} />
    </>
  );

  const entregaDialogFooter = (
    <>
      <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
      <Button label="Salvar" icon="pi pi-check" text onClick={saveEntrega} />
    </>
  );

  const deleteDialogFooter = (
    <>
      <Button label="Não" icon="pi pi-times" text onClick={() => setDeleteDialog(false)} />
      <Button label="Sim" icon="pi pi-check" text onClick={deleteEntrega} />
    </>
  );

  return (
    <div className="grid crud-demo">
      <div className="col-12">
        <div className="card">
          <Toast ref={toast} />
          <Toolbar className="mb-4" left={leftToolbarTemplate} />
          <DataTable
  value={entregas}
  selection={selectedEntregas}
  onSelectionChange={(e) => setSelectedEntregas(e.value)}
  dataKey="id"
  paginator
  rows={10}
  responsiveLayout="scroll"
  selectionMode="multiple"  // move selectionMode para o DataTable, não para a Column
>
  <Column selectionMode="multiple" headerStyle={{ width: '3rem' }} />
  <Column field="fornecedor" header="Fornecedor" sortable />
  <Column
    field="dataHora"
    header="Data/Hora"
    body={(row) => {
      const date = new Date(row.dataHora);
      return date.toLocaleString();
    }}
    sortable
  />
  <Column field="produtos" header="Produtos" />
  <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }} />
</DataTable>


          <Dialog visible={entregaDialog} style={{ width: '450px' }} header="Nova Entrega" modal className="p-fluid" footer={entregaDialogFooter} onHide={hideDialog}>
            <div className="field">
              <label htmlFor="fornecedor">Fornecedor</label>
              <Dropdown
                id="fornecedor"
                value={fornecedores.find(f => f.name === entrega.fornecedor)}
                onChange={(e) => setEntrega({ ...entrega, fornecedor: e.value.name })}
                options={fornecedores}
                optionLabel="name"
                placeholder="Selecione um Fornecedor"
                filter
                className={classNames('w-full', { 'p-invalid': submitted && !entrega.fornecedor })}
              />
              {submitted && !entrega.fornecedor && <small className="p-invalid">Fornecedor é obrigatório.</small>}
            </div>

            <div className="field">
              <label htmlFor="dataHora">Data e Hora</label>
              <Calendar id="dataHora" value={entrega.dataHora} onChange={onDateChange} showIcon showTime dateFormat="dd/mm/yy" />
              {submitted && !entrega.dataHora && <small className="p-invalid">Data e hora obrigatórias.</small>}
            </div>

            <div className="field">
              <label htmlFor="produtos">Produtos</label>
              <Dropdown
                id="produtos"
                value={produtos.find(p => p.name === entrega.produtos)}
                onChange={(e) => setEntrega({ ...entrega, produtos: e.value.name })}
                options={produtos}
                optionLabel="name"
                placeholder="Selecione um Produto"
                filter
                className={classNames('w-full', { 'p-invalid': submitted && !entrega.produtos })}
              />
              {submitted && !entrega.produtos && <small className="p-invalid">Produto é obrigatório.</small>}
            </div>
          </Dialog>

          <Dialog visible={deleteDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteDialogFooter} onHide={() => setDeleteDialog(false)}>
            <div className="flex align-items-center justify-content-center">
              <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
              {entrega && <span>Tem certeza de que deseja excluir a entrega de <b>{entrega.fornecedor}</b>?</span>}
            </div>
          </Dialog>
        </div>
      </div>
    </div>
  );
};

export default EntregaPage;
