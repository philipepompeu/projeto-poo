package DAO;
import java.util.ArrayList;
/**
 *
 * @author philipe.pompeu
 * @param <BusinessObject>
 */
public interface IDataAccessObject<BusinessObject>
{    
    public void Incluir(BusinessObject obj)  throws Exception;
    public void Excluir(int id)  throws Exception;
    public void Alterar(BusinessObject obj)  throws Exception;
    public ArrayList<BusinessObject> Consultar()  throws Exception;
    public BusinessObject Consultar(int id)  throws Exception; 
    
}
