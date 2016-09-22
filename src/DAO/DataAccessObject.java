package DAO;
import BUS.BusinessObject;
import java.util.ArrayList;
import DAO.BancoDados;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author philipe.pompeu
 */
public class DataAccessObject implements IDataAccessObject<BusinessObject>
{

    protected BusinessObject obj;
    protected BancoDados db = new BancoDados();
    protected String entidade = "";

    public DataAccessObject(String entidade) 
    {
        this.entidade = entidade;
    }   
    
    @Override
    public BusinessObject Consultar(int id){
        
        BusinessObject inst = null;
        String sql = "Select * from ";
        sql += entidade;
        sql += " where ID = ";               
        sql += String.valueOf(id);
        
        ResultSet rs;
        try {
            rs = db.executarConsulta(sql);
            if (rs.next()) {
            this.obj.setId(rs.getInt(1));
            Field[] campos = this.obj.getClass().getDeclaredFields();
            
            for (int i = 0; i < campos.length; i++) {
                Field campo = campos[i];
                
                this.obj.
                rs.getObject(campo.getName(), null)
                

            }
            
            
            
        }
        } catch (Exception ex) {
            
        }
        
        return inst;
    }
    
    @Override
    public void Incluir(BusinessObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void Excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Alterar(BusinessObject obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BusinessObject> Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
