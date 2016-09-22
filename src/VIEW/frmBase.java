package VIEW;
import DAO.IDataAccessObject;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
/**
 *
 * @author philipe.pompeu
 */
public class frmBase extends javax.swing.JPanel {
    protected boolean isEditing = false;
    protected boolean isInsert = false; 
    protected IDataAccessObject entidade;
    private String lastMessageError;
    protected NumberFormat intFormat;
    protected NumberFormat doubleFormat;   
    
    /**
     * Creates new form frmBase
     */
    public frmBase()
    {
        try 
        {
            this.intFormat = NumberFormat.getIntegerInstance();
            this.intFormat.setParseIntegerOnly(true);
            this.doubleFormat = NumberFormat.getNumberInstance();
            this.doubleFormat.setMaximumFractionDigits(2);
            
            initComponents();
            
            this.tabela.setToolTipText("Listagem");            
            this.lastMessageError = "";
            onLoad();

            if (this.tabela.getModel() == null) {
                this.tabela.setVisible(false);
            }else
            {
                if (this.tabela.getRowCount() > 0) {
                    this.tabela.setRowSelectionInterval(0,0);
                }
            }

            activeDeactiveText(true);   
        } catch (Exception e)
        {            
            JOptionPane.showMessageDialog(null, e.getMessage() + e.getCause(),"Aviso",JOptionPane.ERROR_MESSAGE);
        }      
        
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelListar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {

                return (false);
            }
        };
        panelEditar = new javax.swing.JPanel();

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnIncluir.setText("Incluir");
        btnIncluir.setFocusable(false);
        btnIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnIncluir);

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.setFocusable(false);
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAlterar);

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvar);

        btnCancel.setText("Cancelar");
        btnCancel.setEnabled(false);
        btnCancel.setFocusable(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancel);

        btnClose.setText("Fechar");
        btnClose.setFocusable(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jToolBar1.add(btnClose);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1"
            }
        ));
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout panelListarLayout = new javax.swing.GroupLayout(panelListar);
        panelListar.setLayout(panelListarLayout);
        panelListarLayout.setHorizontalGroup(
            panelListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        panelListarLayout.setVerticalGroup(
            panelListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", panelListar);

        javax.swing.GroupLayout panelEditarLayout = new javax.swing.GroupLayout(panelEditar);
        panelEditar.setLayout(panelEditarLayout);
        panelEditarLayout.setHorizontalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        panelEditarLayout.setVerticalGroup(
            panelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Dados", panelEditar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        
        JTabbedPane paizao = (JTabbedPane)this.getParent();
        
        paizao.removeTabAt(paizao.getSelectedIndex());
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        isEditing = true;        
        activeDeactiveText(false);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void activeDeactiveText(boolean isFirst)
    {
        
        if (!isFirst) {
            
            try{
                this.refresh();    
            } catch (Exception e)
            {            
                JOptionPane.showMessageDialog(null, e.getMessage() + e.getCause(),"Aviso",JOptionPane.ERROR_MESSAGE);
            }
            
        }        
        
        if (isInsert) {
            isEditing = false;            
        }
        if (isEditing) {
            isInsert = false;
        }
        
         if (isInsert) {
            btnIncluir.setEnabled(false);
            btnSalvar.setEnabled(true);
            btnRemover.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnCancel.setEnabled(true);
        }
        
        if (isEditing) {
            btnIncluir.setEnabled(false);
            btnSalvar.setEnabled(true);
            btnRemover.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnCancel.setEnabled(true);
        }
        
        
        if (!isInsert && !isEditing) {
            btnIncluir.setEnabled(true);
            btnSalvar.setEnabled(false);
            btnRemover.setEnabled(true);
            btnCancel.setEnabled(false);
            if (isFirst) {
                if (this.tabela.getRowCount() > -1) {
                    this.tabela.setSelectionMode(1);
                    btnAlterar.setEnabled(true); 
                }                
            }
        }
    }
    protected void onSave() throws Exception
    {
    
    }
    protected void onRemove() throws Exception
    {
    
    }
    protected void onInsert() throws Exception
    {
    
    }
    
    protected void onLoad() throws Exception
    {
    
    }
    
    protected void onTableClick() throws Exception
    {
    
    }
    protected void refresh() throws Exception
    {
        
    }
    
    protected boolean validForm() throws Exception
    {
        return true;
    }
    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
        String mensagem = "Confirma a Exclusão?";
        int dialogResult = JOptionPane.showConfirmDialog (null, mensagem,"Aviso",JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION)
        {   
            try{
                onRemove();
                onLoad();
                jTabbedPane1.setSelectedIndex(0); 
                JOptionPane.showMessageDialog(null,"Registro removido com sucesso!");    
            } catch (Exception e)
            {            
                JOptionPane.showMessageDialog(null, e.getMessage() + e.getCause(),"Aviso",JOptionPane.ERROR_MESSAGE);
            } 
        }        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String mensagem = isEditing ? "Confirma as Alterações?" : "Confirma a Inclusão?";
        int dialogResult = JOptionPane.showConfirmDialog (null, mensagem,"Aviso",JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION)
        {          
            try{
                if (this.validForm()) {
                    onSave();
                    activeDeactiveText(false);
                    onLoad();        
                    jTabbedPane1.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(null,"Registro salvo com sucesso!");
                }else
                {
                    JOptionPane.showMessageDialog(null,this.lastMessageError,"Corrigir",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e)
            {            
                JOptionPane.showMessageDialog(null, e.getMessage()+ e.getStackTrace(),"Aviso",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    protected void setLastMessage(String erro)
    {
        this.lastMessageError = erro;
    }
    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
       try{
           onInsert();            
           this.isInsert = true;
           this.isEditing = false;  
           //((this.tabela.getRowCount() > 0)?false:true)
           activeDeactiveText(false);   
           jTabbedPane1.setSelectedIndex(1);
        } catch (Exception e)
        {            
            JOptionPane.showMessageDialog(null, e.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (this.tabela.getRowCount() > 0) 
        {                       
            try{ 
                onTableClick();

                if (this.tabela.getSelectedRow() > -1) {
                    btnAlterar.setEnabled(true);
                    btnRemover.setEnabled(true);
                }
                jTabbedPane1.setSelectedIndex(1);  
            } catch (Exception e)
            {            
                JOptionPane.showMessageDialog(null, e.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
            }              
        }        
    }//GEN-LAST:event_tabelaMouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        /*if (isInsert || isEditing) 
        {
            this.isInsert = false;
            this.isEditing = false;
            activeDeactiveText();
        }*/
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
      
        try {            
            
            int dialogResult = JOptionPane.showConfirmDialog (null, "Cancelar operação?","Aviso",JOptionPane.YES_NO_OPTION);
            
            if (dialogResult == JOptionPane.YES_OPTION) {
                this.isInsert = false;
                this.isEditing = false;
                this.activeDeactiveText(false);
                //this.onLoad();
                //this.refresh();
                jTabbedPane1.setSelectedIndex(0);      
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    protected javax.swing.JPanel panelEditar;
    private javax.swing.JPanel panelListar;
    protected javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}