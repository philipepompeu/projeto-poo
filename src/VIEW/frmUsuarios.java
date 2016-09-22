package VIEW;

import BUS.Usuario;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author philipe.pompeu
 */
public class frmUsuarios extends frmBase{

    private ArrayList<Usuario> lista;
    /**
     * Creates new form frmUsuarios
     */
    public frmUsuarios() {
        super();                
        
        lblUsuario = new javax.swing.JLabel("Usuário");
        txtUsuario = new javax.swing.JTextField();
        txtUsuario.setEnabled(false);
        
        lblSenha = new javax.swing.JLabel("Senha");
        txtSenha = new javax.swing.JPasswordField();
        txtSenha.setEnabled(false);
        
        lblConfirmar = new javax.swing.JLabel("Confirmar Senha");
        txtConfirmar = new javax.swing.JPasswordField();        
        txtConfirmar.setEnabled(false);
        
        txtCodigo = new javax.swing.JTextField();
        txtCodigo.setEnabled(false);
        lblCodigo = new javax.swing.JLabel("Código");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.panelEditar);
        this.panelEditar.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfirmar)
                    .addComponent(lblSenha)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirmar)
                .addGap(4, 4, 4)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }
    
    @Override
    protected void refresh() throws Exception
    {
        boolean temp = (txtUsuario.isEnabled()?false:true);                
        txtUsuario.setEnabled(temp);                        
        txtSenha.setEnabled(temp); 
        txtConfirmar.setEnabled(temp); 
        
    }
    @Override
    protected void onSave() throws Exception
    {
        this.entidade = new UsuarioDAO();
        if (this.isInsert) 
        {
            Usuario user = new Usuario();
            user.setNome(txtUsuario.getText());
            user.setSenha(txtSenha.getText());
            lista.add(user);
            isInsert = false;
            this.entidade.Incluir(user);            
        }

        if (isEditing) {
            Usuario user = null;
            int codigo = Integer.parseInt(txtCodigo.getText());
            for (Usuario f : lista) {
                if (f.getCodigo() == codigo) {
                    user = f;
                    user.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    user.setNome(txtUsuario.getText());
                    user.setSenha(txtSenha.getText());
                    
                }
            }

            isEditing = false;
            this.entidade.Alterar(user);            
        }
    }
    @Override
    protected void onRemove() throws Exception
    {
        Usuario Removido = null;
        int codigo = Integer.parseInt(txtCodigo.getText());
        for (Usuario f : lista) {
            if (f.getCodigo() == codigo) {
                Removido = f;
            }
        }
        lista.remove(Removido);
        this.entidade.Excluir(Removido.getCodigo());        
    }
    @Override
    protected void onInsert()
    {
        txtCodigo.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        txtConfirmar.setText("");
    }
    
    @Override
    protected void onLoad() throws Exception
    {
        this.entidade = new UsuarioDAO();
        this.lista = entidade.Consultar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código ");
        modelo.addColumn("Nome ");           
        modelo.addColumn("Senha ");
        
        for (Usuario f : lista) {
            modelo.addRow(new Object[]{
                f.getCodigo(),
                f.getNome(),
                f.getSenha()                     
            });
        }
        tabela.setModel(modelo);
    }
    
    @Override
    protected void onTableClick() throws Exception
    {
        int linha = tabela.getSelectedRow(); 
        txtCodigo.setText(tabela.getValueAt(linha, 0).toString());
        txtUsuario.setText(tabela.getValueAt(linha, 1).toString());        
        txtSenha.setText(tabela.getValueAt(linha, 2).toString());        
        txtConfirmar.setText(tabela.getValueAt(linha, 2).toString());        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtConfirmar = new javax.swing.JPasswordField();
        lblConfirmar = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();

        txtConfirmar.setEnabled(false);

        lblConfirmar.setText("Confirmar Senha");

        txtSenha.setEnabled(false);

        lblSenha.setText("Senha");

        txtUsuario.setEnabled(false);

        lblUsuario.setText("Usuário");

        txtCodigo.setEnabled(false);

        lblCodigo.setText("Código");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConfirmar)
                    .addComponent(lblSenha)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConfirmar)
                .addGap(4, 4, 4)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtConfirmar;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
