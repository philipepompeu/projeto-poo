package BUS;


/**
 *
 * @author philipe.pompeu
 */
public class Usuario 
{
    private int codigo;
    private String nome;
    private String senha;    

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha)
    {
       this.senha = senha;       
    }
    
    public boolean validarSenha(String senhaCriptografada)
    {
    
        return true;
    }
    
    
    
}
