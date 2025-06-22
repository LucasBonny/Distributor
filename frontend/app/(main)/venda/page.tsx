'use client';
import { useState, useRef } from 'react';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Toolbar } from 'primereact/toolbar';
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { Toast } from 'primereact/toast';
import { classNames } from 'primereact/utils';
import { Calendar } from 'primereact/calendar';

type Venda = {
  id: string;
  cliente: string;
  produto: string;
  quantidade: number;
  valor: number;
  data: Date | null;
};

const VendaPage = () => {
  const toast = useRef<Toast>(null);
  const emptyVenda: Venda = {
    id: '',
    cliente: '',
    produto: '',
    quantidade: 0,
    valor: 0,
    data: null,
  };

  const [vendas, setVendas] = useState<Venda[]>([]);
  const [vendaDialog, setVendaDialog] = useState(false);
  const [deleteVendaDialog, setDeleteVendaDialog] = useState(false);
  const [venda, setVenda] = useState<Venda>(emptyVenda);
  const [selectedVendas, setSelectedVendas] = useState<Venda[]>([]);
  const [submitted, setSubmitted] = useState(false);

  const openNew = () => {
    setVenda(emptyVenda);
    setSubmitted(false);
    setVendaDialog(true);
  };

  const hideDialog = () => {
    setSubmitted(false);
    setVendaDialog(false);
  };

  const saveVenda = () => {
    setSubmitted(true);
    if (!venda.cliente || !venda.produto || !venda.data) return;

    let _vendas = [...vendas];
    if (venda.id) {
      const index = _vendas.findIndex(v => v.id === venda.id);
      _vendas[index] = venda;
      toast.current?.show({ severity: 'success', summary: 'Atualizado', detail: 'Venda atualizada', life: 3000 });
    } else {
      venda.id = Date.now().toString();
      _vendas.push(venda);
      toast.current?.show({ severity: 'success', summary: 'Criado', detail: 'Venda adicionada', life: 3000 });
    }

    setVendas(_vendas);
    setVendaDialog(false);
    setVenda(emptyVenda);
  };

  const editVenda = (v: Venda) => {
    setVenda({ ...v });
    setVendaDialog(true);
  };

  const confirmDeleteVenda = (v: Venda) => {
    setVenda(v);
    setDeleteVendaDialog(true);
  };

  const deleteVenda = () => {
    setVendas(vendas.filter(v => v.id !== venda.id));
    setDeleteVendaDialog(false);
    setVenda(emptyVenda);
    toast.current?.show({ severity: 'success', summary: 'Deletado', detail: 'Venda removida', life: 3000 });
  };

  const onInputChange = (e: React.ChangeEvent<HTMLInputElement>, field: keyof Venda) => {
    const val = (e.target && e.target.value) || '';
    setVenda({ ...venda, [field]: field === 'quantidade' || field === 'valor' ? +val : val });
  };

  const onDateChange = (e: any) => {
    setVenda({ ...venda, data: e.value });
  };

  const leftToolbarTemplate = () => (
    <div className="my-2">
      <Button label="Nova Venda" icon="pi pi-plus" severity="success" onClick={openNew} />
    </div>
  );

  const actionBodyTemplate = (rowData: Venda) => (
    <>
      <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editVenda(rowData)} />
      <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteVenda(rowData)} />
    </>
  );

  const vendaDialogFooter = (
    <>
      <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
      <Button label="Salvar" icon="pi pi-check" text onClick={saveVenda} />
    </>
  );

  const deleteVendaDialogFooter = (
    <>
      <Button label="Não" icon="pi pi-times" text onClick={() => setDeleteVendaDialog(false)} />
      <Button label="Sim" icon="pi pi-check" text onClick={deleteVenda} />
    </>
  );

  return (
    <div className="grid crud-demo">
      <div className="col-12">
        <div className="card">
          <Toast ref={toast} />
          <Toolbar className="mb-4" left={leftToolbarTemplate}></Toolbar>

          <DataTable value={vendas} selection={selectedVendas} onSelectionChange={(e) => setSelectedVendas(e.value)} dataKey="id" paginator rows={10} emptyMessage="Nenhuma venda registrada." responsiveLayout="scroll">
            <Column field="cliente" header="Cliente" sortable></Column>
            <Column field="produto" header="Produto" sortable></Column>
            <Column field="quantidade" header="Qtd" sortable></Column>
            <Column field="valor" header="Valor" sortable body={(rowData) => `R$ ${rowData.valor.toFixed(2)}`}></Column>
            <Column field="data" header="Data" sortable body={(rowData) => rowData.data?.toLocaleDateString()}></Column>
            <Column body={actionBodyTemplate}></Column>
          </DataTable>

          <Dialog visible={vendaDialog} style={{ width: '450px' }} header="Detalhes da venda" modal className="p-fluid" footer={vendaDialogFooter} onHide={hideDialog}>
            <div className="field">
              <label htmlFor="cliente">Cliente</label>
              <InputText id="cliente" value={venda.cliente} onChange={(e) => onInputChange(e, 'cliente')} required className={classNames({ 'p-invalid': submitted && !venda.cliente })} />
              {submitted && !venda.cliente && <small className="p-invalid">Cliente é obrigatório.</small>}
            </div>

            <div className="field">
              <label htmlFor="produto">Produto</label>
              <InputText id="produto" value={venda.produto} onChange={(e) => onInputChange(e, 'produto')} required className={classNames({ 'p-invalid': submitted && !venda.produto })} />
              {submitted && !venda.produto && <small className="p-invalid">Produto é obrigatório.</small>}
            </div>

            <div className="field">
              <label htmlFor="quantidade">Quantidade</label>
              <InputText id="quantidade" type="number" value={venda.quantidade} onChange={(e) => onInputChange(e, 'quantidade')} />
            </div>

            <div className="field">
              <label htmlFor="valor">Valor Total</label>
              <InputText id="valor" type="number" value={venda.valor} onChange={(e) => onInputChange(e, 'valor')} />
            </div>

            <div className="field">
              <label htmlFor="data">Data</label>
              <Calendar id="data" value={venda.data} onChange={onDateChange} showIcon dateFormat="dd/mm/yy" />
              {submitted && !venda.data && <small className="p-invalid">Data é obrigatória.</small>}
            </div>
          </Dialog>

          <Dialog visible={deleteVendaDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteVendaDialogFooter} onHide={() => setDeleteVendaDialog(false)}>
            <div className="flex align-items-center justify-content-center">
              <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
              {venda && <span>Tem certeza que deseja excluir a venda de <b>{venda.cliente}</b>?</span>}
            </div>
          </Dialog>
        </div>
      </div>
    </div>
  );
};

export default VendaPage;
