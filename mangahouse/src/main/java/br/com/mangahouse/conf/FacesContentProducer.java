package br.com.mangahouse.conf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContentProducer {

	@RequestScoped
	@Produces
	public FacesContext getFacesContent() {
		return FacesContext.getCurrentInstance();
	}

}
