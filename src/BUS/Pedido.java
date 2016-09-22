package BUS;

import java.util.ArrayList;

/**
 *
 * @author philipe.pompeu
 */
public class Pedido 
{
    private int codigo;
    private String data;
    private Cliente cliente;
    private ArrayList<PedidoItem> itens;

    public void Pedido()
    {
        this.itens = new ArrayList<>();
    }
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the itens
     */
    public ArrayList<PedidoItem> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(ArrayList<PedidoItem> itens) {
        this.itens = itens;
    }
    
}
