package dao.util;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import bean.ClienteMB;
import bean.FuncionarioMB;
import bean.LoginClienteMB;
import bean.LoginFuncionarioMB;

public class FacesUtil {
	
	public static ClienteMB getClienteMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ClienteMB clienteMB = (ClienteMB) app.evaluateExpressionGet(facesContext, "#{clienteMB}",ClienteMB.class);
        return clienteMB;
    }
	
	public static FuncionarioMB getFuncionarioMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        FuncionarioMB funcionarioMB = (FuncionarioMB) app.evaluateExpressionGet(facesContext, "#{funcionarioMB}",FuncionarioMB.class);
        return funcionarioMB;
    }
    
    /**
     * Pega a instância atual do LoginClienteMB.
     * @return o LoginClienteMB da sessão. 
     */
    public static LoginClienteMB getLoginClienteMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginClienteMB loginClienteMB = (LoginClienteMB) app.evaluateExpressionGet(facesContext, "#{loginClienteMB}",LoginClienteMB.class);
        return loginClienteMB;
    }
    
    public static LoginFuncionarioMB getLoginFuncionarioMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginFuncionarioMB loginFuncionarioMB = (LoginFuncionarioMB) app.evaluateExpressionGet(facesContext, "#{loginFuncionarioMB}",LoginFuncionarioMB.class);
        return loginFuncionarioMB;
    }
    
    /**
     * @param id o identificador da tag que receberá a mensagem. Por exemplo: "formCadastro:nome"
     * @param mensagem a mensagem a ser criada.
     */
    public static void adicionarMensagem(String id, String mensagem){
        FacesMessage message = new FacesMessage(mensagem);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(id, message);
    }

}
