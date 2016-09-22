package DAO;

import BUS.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author philipe.pompeu
 */
public class ProdutoDAO  implements  IDataAccessObject<Produto>{
    private BancoDados bd = new BancoDados();
    @Override
    public void Incluir(Produto obj) throws Exception{                 
             
        String sql = "INSERT INTO PRODUTO (";
        sql += "CODIGO, DESCRICAO,TIPO,VALORCUSTO,";
        sql += "VALORVAREJO, VALORATACADO,QUANTIDADE";
        sql += ") VALUES (?,?,?,?,?,?,?)";

        PreparedStatement p = this.bd.getStatement(sql);            

        obj.setCodigo(bd.getNextId("PRODUTO", "CODIGO"));
        p.setInt(1, obj.getCodigo());
        p.setString(2, obj.getDescricao());
        p.setString(3, obj.getTipo());
        p.setDouble(4, obj.getValorCusto());
        p.setDouble(5, obj.getValorVarejo());
        p.setDouble(6, obj.getValorAtacado());
        p.setInt(7, obj.getQuantidade());
        //p.setInt(8, obj.getFornecedor().getCodigo());

        this.bd.executarComando(p);
        this.bd.desconectar();
       
    }

    @Override
    public void Excluir(int id) throws Exception{
                  
        String sql = "DELETE FROM PRODUTO where codigo = ?";
        PreparedStatement p = this.bd.getStatement(sql);                                             
        p.setInt(1, id);

        this.bd.executarComando(p);
        this.bd.desconectar();
      
    }

    @Override
    public void Alterar(Produto obj) throws Exception{        
            
        String sql = "update PRODUTO set ";
        sql += "DESCRICAO = ?,TIPO = ?,VALORCUSTO = ?,";
        sql += "VALORVAREJO = ?, VALORATACADO = ?,QUANTIDADE = ?";
        sql += " where codigo = ?";
        PreparedStatement p = this.bd.getStatement(sql);            

        p.setString(1, obj.getDescricao());
        p.setString(2, obj.getTipo());
        p.setDouble(3, obj.getValorCusto());
        p.setDouble(4, obj.getValorVarejo());
        p.setDouble(5, obj.getValorAtacado());
        p.setInt(6, obj.getQuantidade());
        //p.setInt(7, obj.getFornecedor().getCodigo());            
        p.setInt(7, obj.getCodigo());

        this.bd.executarComando(p);
        this.bd.desconectar();
       
    }

    @Override
    public ArrayList<Produto> Consultar() throws Exception{
        ArrayList<Produto> lista = new ArrayList<Produto>();       
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM PRODUTO ORDER BY CODIGO");                    
        while (rs.next()) {
            Produto obj = new Produto();

            obj.setCodigo(rs.getInt("CODIGO"));
            obj.setDescricao(rs.getString("DESCRICAO"));                
            obj.setTipo(rs.getString("TIPO"));                
            obj.setValorCusto(rs.getDouble("VALORCUSTO"));
            obj.setValorVarejo(rs.getDouble("VALORVAREJO"));
            obj.setValorAtacado(rs.getDouble("VALORATACADO"));
            obj.setQuantidade(rs.getInt("QUANTIDADE"));
            //obj.setCodigo(rs.getInt("QUANTIDADE"));                
            lista.add(obj);
        }            
        
        return lista;
    }

    @Override
    public Produto Consultar(int id) throws Exception{
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM PRODUTO WHERE CODIGO = "+ String.valueOf(id));                    
        Produto obj = new Produto();
        
        if(rs.next())
        {
            obj.setCodigo(rs.getInt("CODIGO"));
            obj.setDescricao(rs.getString("DESCRICAO"));                
            obj.setTipo(rs.getString("TIPO"));                
            obj.setValorCusto(rs.getDouble("VALORCUSTO"));
            obj.setValorVarejo(rs.getDouble("VALORVAREJO"));
            obj.setValorAtacado(rs.getDouble("VALORATACADO"));
            obj.setQuantidade(rs.getInt("QUANTIDADE"));
            //obj.setCodigo(rs.getInt("QUANTIDADE"));                
        }
        
        return obj;
    }
    
}
