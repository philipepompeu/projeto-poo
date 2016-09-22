package DAO;
import BUS.Usuario;
import java.io.File;
import java.sql.*;

/*
TEMA 10: LOJA ACME
REGRAS DE NEGÓCIO QUE PRECISAM SER LEMBRADAS:
1 - OS PRODUTOS COMERCIALIZADOS SÃO CAMISAS E CAMISETAS
2 - CAMISAS SÃO VENDIDAS AO ATACADO E AO VAREJO
3 - CLIENTES COMUNS PODEM COMPRAR DE ATACADO SOMENTE SE ADQUIRIREM MAIS DE 20 UNIDADES
4 - TIPO (MANGA CURTA OU LARGA) DOS PRODUTOS;
*/
public class BancoDados {
    private Connection connection = null;    
    private final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String LOCAL = "bancodedados/app";
    private final String URL = "jdbc:derby:"+ LOCAL +";create=true";                        
    private final String LOGIN = "";
    private final String SENHA = "";
    
    public void conectar() throws Exception{
        
        File teste = new File(LOCAL);            
        boolean deveCriaBanco = !(teste.exists());                  

        Class.forName(DRIVER);            
        this.connection = DriverManager.getConnection(URL, LOGIN, SENHA);

        if (deveCriaBanco)
        {   
            String sql = "CREATE TABLE CLIENTE(";
            sql += "CODIGO INT NOT NULL,";
            sql += "NOME VARCHAR(90),";                
            sql += "EMAIL VARCHAR(30),";
            sql += "CONTATO VARCHAR(30),";
            sql += "TIPO VARCHAR(1),";
            sql += "CPF VARCHAR(30),";
            sql += "CNPJ VARCHAR(30),";
            sql += "LOGRADOURO VARCHAR(30),";
            sql += "NUMERO VARCHAR(6),";
            sql += "COMPLEMENTO VARCHAR(30),";
            sql += "BAIRRO VARCHAR(20),";
            sql += "CEP VARCHAR(8),";
            sql += "CIDADE VARCHAR(30),";
            sql += "UF VARCHAR(2)";                
            sql += ")";             
            executarComando(sql);		

            sql = "CREATE TABLE TELEFONE(";
            sql += "CODIGO INT NOT NULL,";
            sql += "ENTIDADE VARCHAR(30),"; 
            sql += "IDENTIFICADOR INT NOT NULL,";                
            sql += "TELEFONE VARCHAR(30)";                
            sql += ")";               
            executarComando(sql);

            sql = "CREATE TABLE FORNECEDOR(";
            sql += "CODIGO INT NOT NULL,";
            sql += "NOME VARCHAR(50),";               
            sql += "EMAIL VARCHAR(50),"; 
            sql += "CONTATO VARCHAR(30),";				
            sql += "CNPJ VARCHAR(30),"; 
            sql += "LOGRADOURO VARCHAR(30),";
            sql += "NUMERO VARCHAR(6),";
            sql += "COMPLEMENTO VARCHAR(30),";
            sql += "BAIRRO VARCHAR(20),";
            sql += "CEP VARCHAR(8),";
            sql += "CIDADE VARCHAR(30),";
            sql += "UF VARCHAR(2)";          
            sql += ")";           
            executarComando(sql);

            sql = "CREATE TABLE PRODUTO(";
            sql += "CODIGO INT NOT NULL,";
            sql += "DESCRICAO VARCHAR(30),";
            sql += "TIPO VARCHAR(1),";
            sql += "VALORCUSTO DOUBLE,";
            sql += "VALORVAREJO DOUBLE,";
            sql += "VALORATACADO DOUBLE,";
            sql += "QUANTIDADE INT,";				
            sql += "FORNECEDOR INT";                
            sql += ")";
            executarComando(sql);

            sql = "CREATE TABLE PEDIDO(";
            sql += "CODIGO INT NOT NULL,";
            sql += "DATAPEDIDO VARCHAR(10),";               
            sql += "CODIGOCLIENTE INT";                                              
            sql += ")"; 
            executarComando(sql);

            sql = "CREATE TABLE item(";
            sql += "CODIGO INT NOT NULL GENERATED ALWAYS AS IDENTITY,";                              
            sql += "PRODUTO INT,";               
            sql += "QUANTIDADE INT,";
            sql += "PRECO DOUBLE,";
            sql += "TOTAL DOUBLE,";
            sql += "PEDIDO INT";               
            sql += ")"; 
            executarComando(sql);

            sql = "CREATE TABLE USUARIO(";
            sql += "CODIGO INT NOT NULL GENERATED ALWAYS AS IDENTITY,";
            sql += "NOME VARCHAR(30),";                                
            sql += "SENHA VARCHAR(64)";                
            sql += ")";    
            executarComando(sql);                
            Usuario admin = new Usuario();

            admin.setNome("admin");
            admin.setSenha("admin");
            UsuarioDAO salvarAdmin = new UsuarioDAO();

            salvarAdmin.Incluir(admin);
        }        
    }
    
    private boolean isClosed() throws SQLException
    {        
        if (this.connection == null) {
            return true;
        }        
        
        return this.connection.isClosed();        
    }
    
    public void executarComando(String sql) throws Exception
    {        
        if (this.isClosed()) 
        {
            this.conectar();
        }
        PreparedStatement p;        
        p = this.connection.prepareStatement(sql);
        p.execute();               
    }
    
    public void executarComando(PreparedStatement p) throws Exception
    {   
        if (this.isClosed()) 
        {
            this.conectar();
        }
        p.execute();
        p.close();
    }
    
    public PreparedStatement getStatement(String sql) throws Exception
    {        
        if (this.isClosed()) 
        {
            this.conectar();
        }   
        return(this.connection.prepareStatement(sql));
    }
    
    
    
    public ResultSet executarConsulta(String sql) throws Exception
    {        
        if (this.isClosed()) 
        {
            this.conectar();
        }        
        PreparedStatement p;        
        p = this.connection.prepareStatement(sql);
        return(p.executeQuery());               
    }
    
    public int getNextId(String entidade, String campo)
    {
        int nextId = 1;
        try {            
            ResultSet valor = executarConsulta("select max("+ campo +")+1 as nextId from "+ entidade);                        
            while (valor.next()) {
                nextId = valor.getInt("nextId");  
            }               
        } catch (Exception e) 
        {
            nextId = 1;
        }
        
        return(nextId);        
    }
    public void desconectar() throws Exception{        
        this.connection.close();         
    }
}
