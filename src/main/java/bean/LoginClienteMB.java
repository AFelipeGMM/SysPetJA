package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Cliente;
import dao.ClienteService;
import dao.util.FacesUtil;
import dao.util.JPAUtil;

@ManagedBean
@SessionScoped
public class LoginClienteMB {

    private Cliente cliente = new Cliente();
    
    private String email ="";
    
    private String senha="";
    
    private ClienteService dao = new ClienteService(JPAUtil.EMF);
    
    private boolean logado = false;
    
    private String mensagem;
    
    
    public LoginClienteMB() {
    }
    
    public boolean validarLogin(){
        Cliente a = dao.findCliente(email, senha);
        if (a != null){
            cliente = a;
            ClienteMB umb = FacesUtil.getClienteMB();
            umb.setCliente(cliente);
      
            return true;
        } else {
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
        if (aux== true){         
            return "/aluno.xhtml";
        } else {
            FacesUtil.adicionarMensagem("formEntrarCliente", "Email e senha não conferem !");
            return null;
        }
    }
    
    /**
     * 
     * @return a página inicial.
     */
    public String deslogarA(){
        setDeslogado();
        cliente = new Cliente();
        email = null;        
        senha = null;
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
}
