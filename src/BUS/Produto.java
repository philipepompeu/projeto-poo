package BUS;

/**
 *
 * @author philipe.pompeu
 */
public class Produto 
{
    private int codigo;
    private String descricao;
    private String tipo;
    private Double valorCusto;
    private Double valorVarejo;
    private Double valorAtacado;
    private int quantidade;
    private Fornecedor fornecedor;

    public Produto() {
        this.tipo = "0";
        this.quantidade = 0;
        this.valorCusto = 0.0;
        this.valorVarejo = 0.0;
        this.valorAtacado = 0.0;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valorCusto
     */
    public Double getValorCusto() {
        return valorCusto;
    }

    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    /**
     * @return the valorVarejo
     */
    public Double getValorVarejo() {
        return valorVarejo;
    }

    /**
     * @param valorVarejo the valorVarejo to set
     */
    public void setValorVarejo(Double valorVarejo) {
        this.valorVarejo = valorVarejo;
    }

    /**
     * @return the valorAtacado
     */
    public Double getValorAtacado() {
        return valorAtacado;
    }

    /**
     * @param valorAtacado the valorAtacado to set
     */
    public void setValorAtacado(Double valorAtacado) {
        this.valorAtacado = valorAtacado;
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
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
