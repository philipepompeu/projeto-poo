package DAO;
import BUS.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author philipe.pompeu
 */
public class ClienteDAO implements  IDataAccessObject<Cliente>{
    
    private BancoDados bd = new BancoDados();
    
    @Override
    public void Incluir(Cliente obj) throws Exception{
        
        String sql = "INSERT INTO CLIENTE (";
        sql += "CODIGO, NOME,EMAIL,CONTATO,";
        sql += "CNPJ, LOGRADOURO,NUMERO,COMPLEMENTO,BAIRRO,CEP,CIDADE,UF,TIPO,CPF";
        sql += ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement p = this.bd.getStatement(sql);            
        
        obj.setCodigo(bd.getNextId("CLIENTE", "CODIGO"));
        p.setInt(1, obj.getCodigo());
        p.setString(2, obj.getNome());
        p.setString(3, obj.getEmail());
        p.setString(4, obj.getContato());
        p.setString(5, obj.getCnpj());
        p.setString(6, obj.getLogradouro());
        p.setString(7, obj.getNumero());
        p.setString(8, obj.getComplemento());
        p.setString(9, obj.getBairro());
        p.setString(10, obj.getCep());
        p.setString(11, obj.getCidade());
        p.setString(12, obj.getUf());   
        p.setString(13, obj.getTipo());
        p.setString(14, obj.getCPF());
       

        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public void Excluir(int id) throws Exception{
        String sql = "DELETE FROM CLIENTE where CODIGO = ?";
        PreparedStatement p = this.bd.getStatement(sql);                                             
        p.setInt(1, id);

        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public void Alterar(Cliente obj) throws Exception{
        
        String sql = "update CLIENTE set ";        
        sql += "NOME = ?,EMAIL = ?,CONTATO = ?,";
        sql += "CNPJ = ?, LOGRADOURO = ?,NUMERO = ?,COMPLEMENTO = ?,BAIRRO = ?,CEP = ?,CIDADE = ?,UF = ?,TIPO = ?,CPF = ?";
        sql += " where CODIGO = ?";
        PreparedStatement p = this.bd.getStatement(sql);
        
        p.setString(1, obj.getNome());
        p.setString(2, obj.getEmail());
        p.setString(3, obj.getContato());
        p.setString(4, obj.getCnpj());
        p.setString(5, obj.getLogradouro());
        p.setString(6, obj.getNumero());
        p.setString(7, obj.getComplemento());
        p.setString(8, obj.getBairro());
        p.setString(9, obj.getCep());
        p.setString(10, obj.getCidade());
        p.setString(11, obj.getUf());
        p.setString(12, obj.getTipo());
        p.setString(13, obj.getCPF());
        p.setInt(14, obj.getCodigo());

        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public ArrayList<Cliente> Consultar() throws Exception{
        ArrayList<Cliente> lista = new ArrayList<>();       
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM CLIENTE ORDER BY CODIGO");                    
        while (rs.next()) {
            Cliente obj = new Cliente();        
            
            obj.setCodigo(rs.getInt("CODIGO"));
            obj.setNome(rs.getString("NOME"));
            obj.setEmail(rs.getString("EMAIL"));
            obj.setContato(rs.getString("CONTATO"));
            obj.setCnpj(rs.getString("CNPJ"));
            obj.setLogradouro(rs.getString("LOGRADOURO"));
            obj.setNumero(rs.getString("NUMERO"));
            obj.setComplemento(rs.getString("COMPLEMENTO"));
            obj.setBairro(rs.getString("BAIRRO"));
            obj.setCep(rs.getString("CEP"));
            obj.setCidade(rs.getString("CIDADE"));
            obj.setUf(rs.getString("UF"));
            obj.setTipo(rs.getString("TIPO"));
            obj.setCPF(rs.getString("CPF"));
            
            lista.add(obj);
        }            
        
        return lista;
    }

    @Override
    public Cliente Consultar(int id) throws Exception{        
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM CLIENTE WHERE CODIGO= "+ String.valueOf(id));                    
        Cliente obj = new Cliente();
        if(rs.next()) 
        {   
            obj.setCodigo(rs.getInt("CODIGO"));
            obj.setNome(rs.getString("NOME"));
            obj.setEmail(rs.getString("EMAIL"));
            obj.setContato(rs.getString("CONTATO"));
            obj.setCnpj(rs.getString("CNPJ"));
            obj.setLogradouro(rs.getString("LOGRADOURO"));
            obj.setNumero(rs.getString("NUMERO"));
            obj.setComplemento(rs.getString("COMPLEMENTO"));
            obj.setBairro(rs.getString("BAIRRO"));
            obj.setCep(rs.getString("CEP"));
            obj.setCidade(rs.getString("CIDADE"));
            obj.setUf(rs.getString("UF"));  
            obj.setTipo(rs.getString("TIPO"));
            obj.setCPF(rs.getString("CPF"));
        }            
        
        return obj;
    }
    
}
