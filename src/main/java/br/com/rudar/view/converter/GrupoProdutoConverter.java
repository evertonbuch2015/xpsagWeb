package br.com.rudar.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rudar.core.entity.GrupoProduto;



@FacesConverter(forClass = GrupoProduto.class)
public class GrupoProdutoConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (GrupoProduto) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof GrupoProduto) {
        	GrupoProduto grupoProduto = (GrupoProduto) value;
            if (grupoProduto != null && grupoProduto instanceof GrupoProduto && grupoProduto.getId() != null) {
                uiComponent.getAttributes().put( grupoProduto.getId().toString(), grupoProduto);
                return grupoProduto.getId().toString();
            }
        }
        return "";
    }
}