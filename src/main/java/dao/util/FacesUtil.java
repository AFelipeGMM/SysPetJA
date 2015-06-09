package dao.util;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import bean.ClienteMB;
import bean.FuncionarioMB;
import bean.LoginPessoaMB;

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
     *
    public static LoginClienteMB getLoginClienteMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginClienteMB loginClienteMB = (LoginClienteMB) app.evaluateExpressionGet(facesContext, "#{loginClienteMB}",LoginClienteMB.class);
        return loginClienteMB;
    }
    **/
    
    public static LoginPessoaMB getLoginPessoaMB(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        LoginPessoaMB loginPessoaMB = (LoginPessoaMB) app.evaluateExpressionGet(facesContext, "#{loginPessoaMB}",LoginPessoaMB.class);
        return loginPessoaMB;
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
