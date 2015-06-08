package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Funcionario;
import dao.FuncionarioService;
import dao.util.FacesUtil;
import dao.util.JPAUtil;

@ManagedBean
@SessionScoped
public class LoginFuncionarioMB {

    private Funcionario funcionario = new Funcionario();
    
    private String email ="";
    
    private String senha="";
    
    private FuncionarioService dao = new FuncionarioService(JPAUtil.EMF);
    
    private boolean logado = false;
    
    private String mensagem;
    
    
    public LoginFuncionarioMB() {
    }
    
    public boolean validarLogin(){
        Funcionario a = dao.findFuncionario(email, senha);
        if (a != null){
            funcionario = a;
            FuncionarioMB umb = FacesUtil.getFuncionarioMB();
            umb.setFuncionario(funcionario);
      
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
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
            return "/funcionario.xhtml";
        } else {
            FacesUtil.adicionarMensagem("formEntrarFuncionario", "Email e senha não conferem !");
            return null;
        }
    }
    
    /**
     * 
     * @return a página inicial.
     */
    public String deslogarC(){
        setDeslogado();
        funcionario = new Funcionario();
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
