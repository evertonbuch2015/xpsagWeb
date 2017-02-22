package br.com.rudar.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rudar.core.entity.ClasFiscal;

@FacesConverter(forClass = ClasFiscal.class)
public class ClasFiscalConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (ClasFiscal) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof ClasFiscal) {
        	ClasFiscal clasFiscal = (ClasFiscal) value;
            if (clasFiscal != null && clasFiscal instanceof ClasFiscal && clasFiscal.getId() != null) {
                uiComponent.getAttributes().put( clasFiscal.getId().toString(), clasFiscal);
                return clasFiscal.getId().toString();
            }
        }
        return "";
    }
}