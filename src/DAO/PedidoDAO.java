package DAO;
import BUS.Pedido;
import BUS.PedidoItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author philipe.pompeu
 */
public class PedidoDAO  implements  IDataAccessObject<Pedido>{
    
    private BancoDados bd = new BancoDados();
    
    @Override
    public void Incluir(Pedido obj) throws Exception{       
        String sql = "INSERT INTO PEDIDO (";
        sql += "CODIGO, DATAPEDIDO,CODIGOCLIENTE";        
        sql += ") VALUES (?,?,?)";
    
        PreparedStatement p = this.bd.getStatement(sql);            
        
        obj.setCodigo(bd.getNextId("PEDIDO", "CODIGO"));
        p.setInt(1, obj.getCodigo());
        p.setString(2, obj.getData());
        p.setInt(3, obj.getCliente().getCodigo());
        this.bd.executarComando(p);
        
        ArrayList<PedidoItem> lista = obj.getItens();
        
        for(int i=0;i<lista.size();i++)
        {
            PedidoItem tp = lista.get(i);
            
            sql = "INSERT INTO ITEM (";
            sql += "PRODUTO, QUANTIDADE,PRECO,TOTAL,PEDIDO";        
            sql += ") VALUES (?,?,?,?,?)";      
            p = this.bd.getStatement(sql);                
            
            p.setInt(1, tp.getProduto().getCodigo());
            p.setInt(2, tp.getQuantidade());
            p.setDouble(3, tp.getPreco());
            p.setDouble(4, tp.getTotal());
            p.setInt(5, obj.getCodigo());
            
            this.bd.executarComando(p);            
        }
        
        this.bd.desconectar();
    }

    @Override
    public void Excluir(int id) throws Exception{
        String sql = "DELETE FROM PEDIDO where CODIGO = ?";
        PreparedStatement p = this.bd.getStatement(sql);                                             
        p.setInt(1, id);
        this.bd.executarComando(p);
        
        this.ExcluirItens(id);
        
        this.bd.desconectar();
    }


    private void ExcluirItens(int pedido) throws Exception
    {
        String sql = "DELETE FROM ITEM where PEDIDO = ?";
        PreparedStatement p = this.bd.getStatement(sql);                                             
        p.setInt(1, pedido);        
        this.bd.executarComando(p);                
    }
    @Override
    public void Alterar(Pedido obj) throws Exception{
        
        String sql ="";     
        
        this.ExcluirItens(obj.getCodigo());
        
        ArrayList<PedidoItem> lista = obj.getItens();
        PreparedStatement p;
        
        for(int i=0;i<lista.size();i++)
        {
            PedidoItem tp = lista.get(i);
            
            sql = "INSERT INTO ITEM (";
            sql += "PRODUTO, QUANTIDADE,PRECO,TOTAL,PEDIDO";        
            sql += ") VALUES (?,?,?,?,?)";      
            p = this.bd.getStatement(sql);                
            
            p.setInt(1, tp.getProduto().getCodigo());
            p.setInt(2, tp.getQuantidade());
            p.setDouble(3, tp.getPreco());
            p.setDouble(4, tp.getTotal());
            p.setInt(5, obj.getCodigo());
            
            this.bd.executarComando(p);            
        }
        
        sql = "update PEDIDO set ";        
        sql += "DATAPEDIDO = ?,CODIGOCLIENTE = ?";        
        sql += " where CODIGO = ?";
        p = this.bd.getStatement(sql);
        
        p.setString(1, obj.getData());
        p.setInt(2, obj.getCliente().getCodigo());        
        p.setInt(3, obj.getCodigo());
        
        this.bd.executarComando(p);
        this.bd.desconectar();
    }

    @Override
    public ArrayList<Pedido> Consultar() throws Exception{
        ArrayList<Pedido> lista = new ArrayList<>();       
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM PEDIDO ORDER BY CODIGO");                    
        while (rs.next()) {
            Pedido obj = new Pedido();        
            
            obj.setCodigo(rs.getInt("CODIGO"));
            obj.setData(rs.getString("DATAPEDIDO"));            
            int clienteId = rs.getInt("CODIGOCLIENTE");
            obj.setCliente(new ClienteDAO().Consultar(clienteId));
            
            
            ResultSet items = this.bd.executarConsulta("SELECT * FROM ITEM WHERE PEDIDO = " + String.valueOf(obj.getCodigo()));
            
            ArrayList<PedidoItem> itensPedido = new ArrayList<>();  
            while(items.next())
            {
                PedidoItem item = new PedidoItem();
                item.setPedido(obj);
                item.setPreco(items.getDouble("PRECO"));
                item.setQuantidade(items.getInt("QUANTIDADE"));                
                item.setProduto(new ProdutoDAO().Consultar(items.getInt("PRODUTO")));                
                itensPedido.add(item);                
            }
            
            obj.setItens(itensPedido);
            lista.add(obj);
        }            
        
        return lista;
    }

    @Override
    public Pedido Consultar(int id) throws Exception{        
            
        ResultSet rs = this.bd.executarConsulta("SELECT * FROM PEDIDO WHERE CODIGO= "+ String.valueOf(id));                    
        Pedido obj = new Pedido();
        if(rs.next()) 
        {   
            obj.setCodigo(rs.getInt("CODIGO"));
            obj.setData(rs.getString("DATAPEDIDO"));            
            int clienteId = rs.getInt("CODIGOCLIENTE");
            obj.setCliente(new ClienteDAO().Consultar(clienteId));
            
            
            ResultSet items = this.bd.executarConsulta("SELECT * FROM ITEM WHERE PEDIDO = " + String.valueOf(obj.getCodigo()));
            
            ArrayList<PedidoItem> itensPedido = new ArrayList<>();  
            while(items.next())
            {
                PedidoItem item = new PedidoItem();
                item.setPedido(obj);
                item.setPreco(items.getDouble("PRECO"));
                item.setQuantidade(items.getInt("QUANTIDADE"));                
                item.setProduto(new ProdutoDAO().Consultar(items.getInt("PRODUTO")));                
                itensPedido.add(item);                
            }            
            obj.setItens(itensPedido);            
        }        
        return obj;
    }
    
}
