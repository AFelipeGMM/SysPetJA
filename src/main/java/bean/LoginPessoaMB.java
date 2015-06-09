package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Cliente;
import models.Funcionario;
import models.Pessoa;
import dao.ClienteService;
import dao.FuncionarioService;
import dao.util.FacesUtil;
import dao.util.JPAUtil;

@ManagedBean
@SessionScoped
public class LoginPessoaMB {

    private Cliente cliente = new Cliente();
    
    private Funcionario funcionario = new Funcionario();
    
    private String tipoPessoa = "";
    
    private String email ="";
    
    private String senha="";
    
    private ClienteService daoCliente = new ClienteService(JPAUtil.EMF);
    
    private FuncionarioService daoFuncionario = new FuncionarioService(JPAUtil.EMF);
    
    private boolean logado = false;
    
    private String mensagem;
    
    
    
    public LoginPessoaMB() {
    }
    
    public boolean validarLogin(){
        Cliente a = daoCliente.findCliente2(email, senha);
        Funcionario f = daoFuncionario.findFuncionario(email, senha);
        
        if (a != null){
            cliente = a;
            ClienteMB umb = FacesUtil.getClienteMB();
            umb.setCliente(cliente);
            tipoPessoa = "cliente";
      
            return true;
        } else if(f != null){
        	funcionario = f;
        	FuncionarioMB fmb = FacesUtil.getFuncionarioMB();
        	fmb.setFuncionario(funcionario);
        	tipoPessoa = "funcionario";
        	
            return true;
        } else{
        	return false;
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the logado
     */
    public boolean isLogado() {
        return logado;
    }
    
    /**
     * setLogado como verdadeiro. 
     */
    private void setLogado(){
        logado = true;
    }
    
    /**
     * setDeslogado como falso.
     */
    private void setDeslogado(){
        logado = false;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * @return a página inicial da sessao do aluno.
     */
    public String logar(){
    	boolean aux = validarLogin();
    	
    	if(tipoPessoa.equals("cliente")){
	        if (aux== true){         
	            return "/cliente.xhtml";
	        } else {
	            FacesUtil.adicionarMensagem("formEntrarPessoa", "Email e senha não conferem !");
	            return null;
	        }
    	}else{
	        if (aux== true){         
	            return "/funcionario.xhtml";
	        } else {
	            FacesUtil.adicionarMensagem("formEntrarPessoa", "Email e senha não conferem !");
	            return null;
	        }
    	}
    }
    
    /**
     * 
     * @return a página inicial.
     */
    public String deslogarC(){
        setDeslogado();
        cliente = new Cliente();
        funcionario = new Funcionario();
        email = null;        
        senha = null;
        tipoPessoa = "";
        return "/homeSysPetJA.xhtml";
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
    public void setSenha(String senha) {
        this.senha = senha;
    }

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public void setFuncionario(Funcionario funcionario){
		this.funcionario = funcionario;
	}
	
	public Funcionario getFuncionario(){
		return funcionario;
	}
}
