package br.com.rudar.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.rudar.entity.Vendedor;

@FacesConverter(forClass = Vendedor.class)
public class VendedorConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Vendedor) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Vendedor) {
        	Vendedor vendedor = (Vendedor) value;
            if (vendedor != null && vendedor instanceof Vendedor && vendedor.getId() != null) {
                uiComponent.getAttributes().put( vendedor.getId().toString(), vendedor);
                return vendedor.getId().toString();
            }
        }
        return "";
    }
}