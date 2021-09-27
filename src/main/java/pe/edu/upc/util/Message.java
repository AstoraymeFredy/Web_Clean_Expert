package pe.edu.upc.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Message {

	private Message() {
	}

	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public static void messageInfo(String msj) {
		addMessage(msj, FacesMessage.SEVERITY_INFO);
	}

	public static void messageError(String msj) {
		addMessage(msj, FacesMessage.SEVERITY_ERROR);
	}

	private static void addMessage(String msj, Severity severity) {
		FacesMessage menJSF = new FacesMessage();
		menJSF.setSeverity(severity);
		menJSF.setSummary(msj);
		getContext().addMessage(null, menJSF);

	}

}