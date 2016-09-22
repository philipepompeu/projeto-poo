package VIEW;

import BUS.Fornecedor;
import BUS.Produto;
import DAO.FornecedorDAO;
import DAO.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author philipe.pompeu
 */
public class frmProdutos extends frmBase {
    private ArrayList<Produto> lista;
    private ArrayList<Fornecedor> fornecedores = new FornecedorDAO().Consultar(); 
    /**
     * Creates new form frmProdutos
     */
    public frmProdutos() throws Exception{
        super();                
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVarejo = new javax.swing.JFormattedTextField(this.doubleFormat);
        jLabel3 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JFormattedTextField(this.doubleFormat);
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAtacado = new javax.swing.JFormattedTextField(this.doubleFormat);
        jLabel6 = new javax.swing.JLabel();
        txtCusto = new javax.swing.JFormattedTextField(this.doubleFormat);
        jLabel7 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        comboFornecedor = new javax.swing.JComboBox();

        lblCodigo.setText("Código");

        txtCodigo.setEnabled(false);

        jLabel2.setText("Tipo");

        txtVarejo.setEnabled(false);

        jLabel3.setText("Varejo");

        txtEstoque.setEnabled(false);

        jLabel4.setText("Estoque");

        jLabel5.setText("Fornecedor");

        txtAtacado.setEnabled(false);

        jLabel6.setText("Atacado");

        txtCusto.setEnabled(false);

        jLabel7.setText("Custo");

        txtDescricao.setEnabled(false);

        jLabel8.setText("Descrição");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Camisa", "Camiseta" }));
        comboTipo.setEnabled(false);

        comboFornecedor.setEnabled(false);                    
        
        String options[] = new String[fornecedores.size()];
        
        int i = 0;
        for (Fornecedor f : fornecedores) {
            options[i] = f.getNome();
            i++;
        }              
        comboFornecedor.setModel(new javax.swing.DefaultComboBoxModel(options));  
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.panelEditar);
        this.panelEditar.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtVarejo, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo)
                            .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(txtAtacado, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txtCusto, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                    .addComponent(comboFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAtacado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
    }
    @Override
    protected boolean validForm()
    {
        boolean result = true;
        
        if(txtDescricao.getText().length() <= 0)
        {
            this.setLastMessage("Descrição obrigatória.");
            return false;
        }               
        
        return result;
    }
    @Override
    protected void onSave() throws Exception
    {
        this.entidade = new ProdutoDAO();
        if (this.isInsert) 
        {
            Produto produto = new Produto();            
            produto.setDescricao(txtDescricao.getText());
            produto.setQuantidade(Integer.parseInt(txtEstoque.getText()));
            produto.setValorAtacado(Double.parseDouble(txtAtacado.getText()));
            produto.setValorVarejo(Double.parseDouble(txtVarejo.getText()));
            produto.setValorCusto(Double.parseDouble(txtCusto.getText()));
            produto.setTipo(String.valueOf(comboTipo.getSelectedIndex()));
            for (Fornecedor f : fornecedores) {                
                if (f.getNome() == comboFornecedor.getItemAt(comboFornecedor.getSelectedIndex()).toString()) 
                {
                    produto.setFornecedor(f);
                    break;   
                }                
            } 
            
            lista.add(produto);
            isInsert = false;
            this.entidade.Incluir(produto);            
        }
        
        if (isEditing) {
            Produto produto = null;
            int codigo = Integer.parseInt(txtCodigo.getText());
            for (Produto f : lista) {
                if (f.getCodigo() == codigo) {
                    produto = f;
                    produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    produto.setDescricao(txtDescricao.getText());
                    produto.setQuantidade(Integer.parseInt(txtEstoque.getText()));
                    produto.setValorAtacado(Double.parseDouble(txtAtacado.getText()));
                    produto.setValorVarejo(Double.parseDouble(txtVarejo.getText()));
                    produto.setValorCusto(Double.parseDouble(txtCusto.getText()));
                    produto.setTipo(String.valueOf(comboTipo.getSelectedIndex()));
                    for (Fornecedor f2 : fornecedores) {                
                        if (f2.getNome() == comboFornecedor.getItemAt(comboFornecedor.getSelectedIndex()).toString()) 
                        {
                            produto.setFornecedor(f2);
                            break;   
                        }                
                    }
                    
                }
            }
            isEditing = false;
            this.entidade.Alterar(produto);            
        }
    }
    @Override
    protected void onRemove() throws Exception
    {
        Produto Removido = null;
        int codigo = Integer.parseInt(txtCodigo.getText());
        for (Produto f : lista) {
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
        txtAtacado.setText("");
        txtCusto.setText("");
        txtDescricao.setText("");
        txtEstoque.setText("");
        txtVarejo.setText("");
        //comboFornecedor.setSelectedIndex(0);
        comboTipo.setSelectedIndex(0);
        
    }
    @Override
    protected void onLoad() throws Exception
    {
        this.entidade = new ProdutoDAO();
        this.lista = entidade.Consultar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código ");
        modelo.addColumn("Descricao ");           
        modelo.addColumn("Tipo ");
        modelo.addColumn("Custo ");
        modelo.addColumn("Varejo ");
        modelo.addColumn("Atacado ");
        modelo.addColumn("Quantidade ");        
        
        for (Produto f : lista) {
            modelo.addRow(new Object[]{
                f.getCodigo(),
                f.getDescricao(),
                f.getTipo(),
                f.getValorCusto(),
                f.getValorVarejo(),
                f.getValorAtacado(),
                f.getQuantidade()
            });
        }
        tabela.setModel(modelo);
    }
    @Override
    protected void onTableClick()
    {
        int linha = tabela.getSelectedRow(); 
        txtCodigo.setText(tabela.getValueAt(linha, 0).toString());
        txtDescricao.setText(tabela.getValueAt(linha, 1).toString());
        comboTipo.setSelectedIndex(Integer.parseInt(tabela.getValueAt(linha, 2).toString()));                
        txtCusto.setText(tabela.getValueAt(linha, 3).toString());
        txtVarejo.setText(tabela.getValueAt(linha, 4).toString());
        txtAtacado.setText(tabela.getValueAt(linha, 5).toString());     
        txtEstoque.setText(tabela.getValueAt(linha, 6).toString());        
        
        //comboFornecedor.setSelectedIndex(0);
    }
    @Override
    protected void refresh() throws Exception
    {
        boolean temp = (txtDescricao.isEnabled()?false:true);                
        //txtCodigo.setEnabled(temp);
        txtAtacado.setEnabled(temp);
        txtCusto.setEnabled(temp);
        txtDescricao.setEnabled(temp);
        txtEstoque.setEnabled(temp);
        txtVarejo.setEnabled(temp);
        comboFornecedor.setEnabled(temp);
        comboTipo.setEnabled(temp);        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVarejo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAtacado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCusto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        comboFornecedor = new javax.swing.JComboBox();

        lblCodigo.setText("Código");

        txtCodigo.setEnabled(false);

        jLabel2.setText("Tipo");

        txtVarejo.setEnabled(false);

        jLabel3.setText("Varejo");

        txtEstoque.setEnabled(false);

        jLabel4.setText("Estoque");

        jLabel5.setText("Fornecedor");

        txtAtacado.setEnabled(false);

        jLabel6.setText("Atacado");

        txtCusto.setEnabled(false);
        txtCusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustoKeyTyped(evt);
            }
        });

        jLabel7.setText("Custo");

        txtDescricao.setEnabled(false);

        jLabel8.setText("Descrição");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Física", "Jurídica" }));
        comboTipo.setEnabled(false);

        comboFornecedor.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtVarejo, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo)
                            .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(txtAtacado, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txtCusto, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                    .addComponent(comboFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAtacado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(comboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustoKeyTyped
        int tecla =  (int)evt.getKeyChar();
        
        if (!(tecla > 17) && !(tecla < 58))
        {
            evt.setKeyCode(8);
        }
    }//GEN-LAST:event_txtCustoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboFornecedor;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JTextField txtAtacado;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtVarejo;
    // End of variables declaration//GEN-END:variables
}
