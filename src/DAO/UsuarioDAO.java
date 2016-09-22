package DAO;
import BUS.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author philipe.pompeu
 */
public class UsuarioDAO implements  IDataAccessObject<Usuario>{

    private BancoDados bd = new BancoDados();
    @Override
    public void Incluir(Usuario obj) throws Exception{         
             
        String sql = "INSERT INTO USUARIO (";
        sql += "NOME, SENHA";
        sql += ") VALUES (?,?)";

        PreparedStatement p = this.bd.getStatement(sql);

        MessageDigest m;        
        m = MessageDigest.getInstance("MD5");
        m.update(obj.getSenha().getBytes(),0,obj.getSenha().length());

        p.setString(1, obj.getNome());
        p.setString(2, String.format("%1$032X", new BigInteger(1,m.digest())));

        this.bd.executarComando(p);
        this.bd.desconectar();
        
    }

    @Override
    public void Excluir(int id) throws Exception{        
        String sql = "DELETE FROM USUARIO where codigo = ?";
        PreparedStatement p = this.bd.getStatement(sql);                                             
        p.setInt(1, id);

        this.bd.executarComando(p);
        this.bd.desconectar();        
    }

    @Override
    public void Alterar(Usuario obj) throws Exception 
    {       
        String sql = "update usuario set NOME=?, SENHA=? where codigo = ?";
        PreparedStatement p = this.bd.getStatement(sql);            
        p.setString(1, obj.getNome());
        p.setString(2, obj.getSenha());                        
        p.setInt(3, obj.getCodigo());

        this.bd.executarComando(p);
        this.bd.desconectar();
        
    }

    @Override
    public ArrayList<Usuario> Consultar()throws Exception {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();        
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM USUARIO");                    
        while (rs.next()) {
            Usuario obj = new Usuario();
            obj.setCodigo(rs.getInt("codigo"));
            obj.setNome(rs.getString("nome"));                
            obj.setSenha(rs.getString("senha"));                
            lista.add(obj);
        }            
        
        return lista;
    }

    @Override
    public Usuario Consultar(int id)throws Exception{         
        Usuario obj = new Usuario(); 
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM USUARIO");                    
        if(rs.next()) {
            
            obj.setCodigo(rs.getInt("codigo"));
            obj.setNome(rs.getString("nome"));                
            obj.setSenha(rs.getString("senha"));                
            
        }
        return obj;
    }    
    
    public Usuario Consultar(String username)throws Exception{         
        Usuario obj = new Usuario(); 
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM USUARIO WHERE NOME LIKE '%"+ username +"%'");                    
        if(rs.next()) {            
            obj.setCodigo(rs.getInt("codigo"));
            obj.setNome(rs.getString("nome"));                
            obj.setSenha(rs.getString("senha"));                            
        }
        return obj;
    }
    
}
