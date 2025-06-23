'use client';
import { useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { InputTextarea } from 'primereact/inputtextarea';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import { Calendar } from 'primereact/calendar';

type Entrega = {
  id: string;
  fornecedor: string;
  dataHora: Date | null;
  endereco: string;
  produtos: string; // texto livre ou JSON
};

const EntregaPage = () => {
  const toast = useRef<Toast>(null);

  const entregaVazia: Entrega = {
    id: '',
    fornecedor: '',
    dataHora: null,
    endereco: '',
    produtos: '',
  };

  const [entregas, setEntregas] = useState<Entrega[]>([]);
  const [entrega, setEntrega] = useState<Entrega>(entregaVazia);
  const [entregaDialog, setEntregaDialog] = useState(false);
  const [deleteDialog, setDeleteDialog] = useState(false);
  const [selectedEntregas, setSelectedEntregas] = useState<Entrega[]>([]);
  const [submitted, setSubmitted] = useState(false);

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
    if (!entrega.fornecedor || !entrega.dataHora || !entrega.endereco) return;

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

  const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, field: keyof Entrega) => {
    const val = e.target.value;
    setEntrega({ ...entrega, [field]: val });
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
          <DataTable value={entregas} selection={selectedEntregas} onSelectionChange={(e) => setSelectedEntregas(e.value)} dataKey="id" paginator rows={10} responsiveLayout="scroll" selectionMode="multiple">
            <Column selectionMode="multiple" headerStyle={{ width: '3rem' }} />
            <Column field="fornecedor" header="Fornecedor" sortable />
            <Column field="dataHora" header="Data/Hora" body={(row) => row.dataHora?.toLocaleString()} sortable />
            <Column field="endereco" header="Endereço" sortable />
            <Column field="produtos" header="Produtos" />
            <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }} />
          </DataTable>

          <Dialog visible={entregaDialog} style={{ width: '450px' }} header="Entrega" modal className="p-fluid" footer={entregaDialogFooter} onHide={hideDialog}>
            <div className="field">
              <label htmlFor="fornecedor">Fornecedor</label>
              <InputText id="fornecedor" value={entrega.fornecedor} onChange={(e) => onInputChange(e, 'fornecedor')} required className={classNames({ 'p-invalid': submitted && !entrega.fornecedor })} />
              {submitted && !entrega.fornecedor && <small className="p-invalid">Fornecedor é obrigatório.</small>}
            </div>

            <div className="field">
              <label htmlFor="dataHora">Data e Hora</label>
              <Calendar id="dataHora" value={entrega.dataHora} onChange={onDateChange} showIcon showTime dateFormat="dd/mm/yy" />
              {submitted && !entrega.dataHora && <small className="p-invalid">Data e hora obrigatórias.</small>}
            </div>

            <div className="field">
              <label htmlFor="endereco">Endereço</label>
              <InputText id="endereco" value={entrega.endereco} onChange={(e) => onInputChange(e, 'endereco')} required className={classNames({ 'p-invalid': submitted && !entrega.endereco })} />
              {submitted && !entrega.endereco && <small className="p-invalid">Endereço é obrigatório.</small>}
            </div>

            <div className="field">
              <label htmlFor="produtos">Produtos</label>
              <InputTextarea id="produtos" value={entrega.produtos} onChange={(e) => onInputChange(e, 'produtos')} rows={4} />
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
