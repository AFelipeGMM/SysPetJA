package dao.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Validation {
	public void mensagemConfirmarCadastro(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(mensagem));
	}
}
