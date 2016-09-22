package VIEW;

import BUS.Cliente;
import BUS.Pedido;
import BUS.PedidoItem;
import BUS.Produto;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author philipe.pompeu
 */
public class frmPedidos extends frmBase{
    private ArrayList<Pedido> lista;
    private ArrayList<Cliente> clientes; 
    private ArrayList<Produto> produtos;
    /**
     * Creates new form NewJPanel
     */
    public frmPedidos() throws Exception {
        super();
        
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                
                return (column > 0 && column < 4);
            }
        };
        tableItems.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        btnAddItem = new javax.swing.JButton();        
        btnDeleteItem = new javax.swing.JButton();
        btnAddItem.setEnabled(false);
        btnDeleteItem.setEnabled(false);

        jLabel1.setText("Código");

        txtCodigo.setToolTipText("");
        txtCodigo.setEnabled(false);

        txtData.setToolTipText("");
        txtData.setEnabled(false);

        jLabel2.setText("Data");

        clientes = new ClienteDAO().Consultar();
        String options[] = new String[clientes.size()];
        int i = 0;
        for (Cliente f : clientes) {
            options[i] = f.getNome();
            i++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(options));
        jComboBox1.setEnabled(false);

        jLabel3.setText("Cliente");

        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("Código ");
        modelo2.addColumn("Produto ");
        modelo2.addColumn("Quantidade ");
        modelo2.addColumn("Preço ");
        modelo2.addColumn("Total ");
        
        modelo2.addTableModelListener(
            new TableModelListener() 
            {
                @Override
                public void tableChanged(TableModelEvent evt) 
                {
                    if (evt.getColumn() == 2 ||evt.getColumn() == 3)
                    {
                        DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
                        int index = tableItems.getSelectedRow();
                        
                        Double qtd = Double.valueOf(model.getValueAt(index, 2).toString());
                        Double preco = Double.valueOf(model.getValueAt(index, 3).toString());
                        Double total = qtd * preco;                        
                        model.setValueAt(String.valueOf(total), index, 4);
                    }
                }
            });
        
        tableItems.setModel(modelo2);
        
        TableColumn col = tableItems.getColumnModel().getColumn(1);
        produtos = new ProdutoDAO().Consultar();
        String[] values = new String[produtos.size()];        
        i = 0;
        JComboBox comboBox = new JComboBox();
        
        for (Produto f : produtos) {
            values[i] = f.getDescricao();
            comboBox.addItem(f.getDescricao());
            i++;
        }      
        
        col.setCellEditor(new DefaultCellEditor(comboBox));        
        
        tableItems.setEnabled(false);
        jScrollPane1.setViewportView(tableItems);

        btnAddItem.setText("+");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnDeleteItem.setText("-");
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.panelEditar);
        this.panelEditar.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteItem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddItem)
                    .addComponent(btnDeleteItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }
    
    @Override
    protected boolean validForm()
    {
        boolean result = true;
        
        if(this.tableItems.getRowCount() <= 0)
        {
            this.setLastMessage("Informe ao menos um item no Pedido.");
            return false;
        }
        
        
         DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
            
            for(int i = 0; i < model.getRowCount();i++)
            {
                if (model.getValueAt(i, 1).toString().length() <= 0) {
                    this.setLastMessage("Informe um produto para o Item : " + String.valueOf(i));
                    return false;
                }               
                
                int teste = Integer.valueOf(model.getValueAt(i, 2).toString()); 
                
                if (teste <= 0) {
                    this.setLastMessage("Informe uma quantidade válida para o item: " + String.valueOf(i));
                    return false;   
                }
                
                if (Double.valueOf(model.getValueAt(i, 3).toString()) <= 0) {
                    this.setLastMessage("Informe um preço válido para o item: " + String.valueOf(i));
                    return false;   
                }                
            }
        
        
        return result;
    }
    
    @Override
    protected void onSave() throws Exception
    {
        this.entidade = new PedidoDAO();
        if (this.isInsert) 
        {
            Pedido pedido = new Pedido();            
            pedido.setData(txtData.getText());
            for (Cliente f : clientes) {                
                if (f.getNome() == jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString()) 
                {
                    pedido.setCliente(f);
                    break;   
                }                
            } 
            
            ArrayList<PedidoItem> itens = new ArrayList<>();
            
            DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
            
            for(int i = 0; i < model.getRowCount();i++)
            {
                PedidoItem item = new PedidoItem();                
                item.setPedido(pedido);
                
                for (Produto p : produtos) {                
                    if (p.getDescricao() == model.getValueAt(i, 1).toString()) 
                    {
                        item.setProduto(p);
                        break;   
                    }                
                }                
                
                int teste = Integer.valueOf(model.getValueAt(i, 2).toString());                
                item.setQuantidade(teste);
                item.setPreco(Double.valueOf(model.getValueAt(i, 3).toString()));
                
                itens.add(item);            
            }
            pedido.setItens(itens);
            
            lista.add(pedido);
            isInsert = false;
            this.entidade.Incluir(pedido);            
        }
        
        if (isEditing) {
            Pedido pedido = null;
            int codigo = Integer.parseInt(txtCodigo.getText());
            for (Pedido f : lista) {
                if (f.getCodigo() == codigo) {
                    pedido = f;
                    pedido.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    pedido.setData(txtData.getText()); 
                    
                    for (Cliente f1 : clientes) {                
                        if (f1.getNome() == jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).toString()) 
                        {
                            pedido.setCliente(f1);
                            break;   
                        }                
                    }
                    ArrayList<PedidoItem> itens = new ArrayList<>();            
                    DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
                    for(int i = 0; i < model.getRowCount();i++)
                    {
                        PedidoItem item = new PedidoItem();                
                        item.setPedido(pedido);

                        for (Produto p : produtos) {                
                            if (p.getDescricao() == model.getValueAt(i, 1).toString()) 
                            {
                                item.setProduto(p);
                                break;   
                            }                
                        }                

                        int teste = Integer.valueOf(model.getValueAt(i, 2).toString());                
                        item.setQuantidade(teste);
                        item.setPreco(Double.valueOf(model.getValueAt(i, 3).toString()));

                        itens.add(item);            
                    }
                    pedido.setItens(itens);
                    this.entidade.Alterar(pedido); 
                    break;
                }
            }
            isEditing = false;                       
        }
    }
    @Override
    protected void onRemove() throws Exception
    {
        Pedido Removido = null;
        int codigo = Integer.parseInt(txtCodigo.getText());
        for (Pedido f : lista) {
            if (f.getCodigo() == codigo) {
                Removido = f;
            }
        }
        lista.remove(Removido);
        this.entidade.Excluir(Removido.getCodigo());
    }
    @Override
    protected void onInsert() throws Exception
    {
        txtCodigo.setText("");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);        
        txtData.setText(reportDate);        
        
        jComboBox1.setSelectedIndex(0);         
        DefaultTableModel model = (DefaultTableModel) this.tableItems.getModel();
        if (model.getRowCount() > 0) {
            model.setRowCount(0);
        }        
        model.addRow(new Object[]{String.valueOf(model.getRowCount()), "", "0", "0","0"});        
        this.tableItems.setEnabled(true);
        
        
    }
    @Override
    protected void onLoad() throws Exception
    {
        this.entidade = new PedidoDAO();
        this.lista = entidade.Consultar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código ");
        modelo.addColumn("Data ");                   
                
        
        for (Pedido f : lista) {
            modelo.addRow(new Object[]{
                f.getCodigo(),
                f.getData()
            });
        }
        tabela.setModel(modelo);
        
    }
    @Override
    protected void onTableClick()
    {
        int linha = tabela.getSelectedRow(); 
        txtCodigo.setText(tabela.getValueAt(linha, 0).toString());
        txtData.setText(tabela.getValueAt(linha, 1).toString());
        int pedido = Integer.valueOf(tabela.getValueAt(linha, 0).toString());
        
        for (Pedido f : lista) {            
            if(f.getCodigo() == pedido)
            {                
                for(int n = 0; n < jComboBox1.getItemCount();n++)
                {
                    if(jComboBox1.getItemAt(n).toString().equals(f.getCliente().getNome()))
                    {
                    
                        jComboBox1.setSelectedIndex(n);
                        break;
                    }
                }               
                
                DefaultTableModel modelo = (DefaultTableModel) this.tableItems.getModel();
                modelo.setRowCount(0);        
                for (PedidoItem item : f.getItens()) {
                    modelo.addRow(new Object[]{
                        String.valueOf(modelo.getRowCount()),
                        item.getProduto().getDescricao(),
                        String.valueOf(item.getQuantidade()),
                        String.valueOf(item.getPreco()),
                        String.valueOf(item.getTotal())                        
                    });
                }
                break;
            }
        }
        
    }
    @Override
    protected void refresh() throws Exception
    {
        boolean temp = (jComboBox1.isEnabled()?false:true);        
        jComboBox1.setEnabled(temp);    
        tableItems.setEnabled(temp);
        btnAddItem.setEnabled(temp);
        btnDeleteItem.setEnabled(temp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        btnAddItem = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();

        jLabel1.setText("Código");

        txtCodigo.setToolTipText("");
        txtCodigo.setEnabled(false);

        txtData.setToolTipText("");
        txtData.setEnabled(false);

        jLabel2.setText("Data");

        String options[] = new String[clientes.size()];
        int i = 0;
        for (Cliente f : clientes) {
            options[i] = f.getNome();
            i++;
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(options));
        jComboBox1.setEnabled(false);

        jLabel3.setText("Cliente");

        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("Código ");
        modelo2.addColumn("PRODUTO ");
        modelo2.addColumn("QUANTIDADE ");
        modelo2.addColumn("PRECO ");
        modelo2.addColumn("TOTAL ");
        tableItems.setModel(modelo2);
        tableItems.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tableItems.setEnabled(false);
        jScrollPane1.setViewportView(tableItems);

        btnAddItem.setText("+");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnDeleteItem.setText("-");
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteItem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddItem)
                    .addComponent(btnDeleteItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.tableItems.getModel();        
        model.addRow(new Object[]{this.tableItems.getRowCount(), "", "0", "0","0"});        
        this.tableItems.setEnabled(true);        
        this.tableItems.setRowSelectionInterval(this.tableItems.getRowCount()-1, this.tableItems.getRowCount()-1);
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
       int index = this.tableItems.getSelectedRow();       
       DefaultTableModel model = (DefaultTableModel) this.tableItems.getModel();               
       model.removeRow(index);       
       this.tableItems.setRowSelectionInterval(this.tableItems.getRowCount()-1, this.tableItems.getRowCount()-1);
    }//GEN-LAST:event_btnDeleteItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableItems;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtData;
    // End of variables declaration//GEN-END:variables
}
