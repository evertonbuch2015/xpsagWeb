package br.com.rudar.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rudar.core.entity.Unidade;

@FacesConverter(forClass = Unidade.class)
public class UnidadeConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Unidade) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Unidade) {
        	Unidade unidade = (Unidade) value;
            if (unidade != null && unidade instanceof Unidade && unidade.getId() != null) {
                uiComponent.getAttributes().put( unidade.getId().toString(), unidade);
                return unidade.getId().toString();
            }
        }
        return "";
    }
}