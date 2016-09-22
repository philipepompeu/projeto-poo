package BUS;
/**
 *
 * @author philipe.pompeu
 */
public class PedidoItem 
{
    private Pedido pedido;
    private Produto produto;
    private int quantidade;
    private Double preco;
    private Double total;

    
    public /*void*/ PedidoItem()
    {
        this.quantidade = 0;
        this.preco = Double.valueOf("0");
        this.total = Double.valueOf("0");
    }
    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        setTotal();
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
        setTotal();
    }
    
    private void setTotal()
    {
        if(this.quantidade != 0 && this.preco != 0){
            this.total = this.quantidade * this.preco;
        }       
        
    }
    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }
}
