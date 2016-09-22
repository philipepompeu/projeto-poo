package DAO;

import BUS.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author philipe.pompeu
 */
public class FornecedorDAO  implements  IDataAccessObject<Fornecedor>{
    @SuppressWarnings("FieldMayBeFinal")
    private BancoDados bd = new BancoDados();
    
    /**
     *
     * @param obj
     * @throws Exception
     */
    @Override
    public void Incluir(Fornecedor obj) throws Exception{
        
        String sql = "INSERT INTO FORNECEDOR (";
        sql += "CODIGO, NOME,EMAIL,CONTATO,";
        sql += "CNPJ, LOGRADOURO,NUMERO,COMPLEMENTO,BAIRRO,CEP,CIDADE,UF";
        sql += ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement p = this.bd.getStatement(sql);            
        
        obj.setCodigo(bd.getNextId("FORNECEDOR", "CODIGO"));
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
       

        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public void Excluir(int id) throws Exception{
        String sql = "DELETE FROM FORNECEDOR where CODIGO = ?";
        PreparedStatement p = this.bd.getStatement(sql);                                             
        p.setInt(1, id);

        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public void Alterar(Fornecedor obj) throws Exception{
        
        String sql = "update FORNECEDOR set ";        
        sql += "NOME = ?,EMAIL = ?,CONTATO = ?,";
        sql += "CNPJ = ?, LOGRADOURO = ?,NUMERO = ?,COMPLEMENTO = ?,BAIRRO = ?,CEP = ?,CIDADE = ?,UF = ?";
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
        p.setInt(12, obj.getCodigo());

        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public ArrayList<Fornecedor> Consultar() throws Exception{
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();       
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM FORNECEDOR ORDER BY CODIGO");                    
        while (rs.next()) {
            Fornecedor obj = new Fornecedor();        
            
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
            
            lista.add(obj);
        }            
        
        return lista;
    }

    @Override
    public Fornecedor Consultar(int id) throws Exception{        
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM FORNECEDOR WHERE CODIGO= "+ String.valueOf(id));                    
        Fornecedor obj = new Fornecedor();
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
        }            
        
        return obj;
    }
    
}
