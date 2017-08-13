package br.com.mangahouse.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.mangahouse.models.Author;

@FacesConverter("authorConverter")
public class AuthorConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty())
			return null;

		Author author = new Author();

		author.setId(Integer.valueOf(id));

		return author;
	}

	public String getAsString(FacesContext context, UIComponent component, Object authorObject) {
		if (authorObject == null)
			return null;

		Author author = (Author) authorObject;
		return author.getId().toString();
	}

}
