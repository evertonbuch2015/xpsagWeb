package br.com.rudar.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rudar.core.entity.Colaborador;

@FacesConverter(forClass = Colaborador.class)
public class ColaboradorConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Colaborador) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Colaborador) {
        	Colaborador colaborador = (Colaborador) value;
            if (colaborador != null && colaborador instanceof Colaborador && colaborador.getId() != null) {
                uiComponent.getAttributes().put( colaborador.getId().toString(), colaborador);
                return colaborador.getId().toString();
            }
        }
        return "";
    }
}