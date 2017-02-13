package br.com.rudar.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rudar.entity.Produto;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Produto) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Produto) {
        	Produto produto = (Produto) value;
            if (produto != null && produto instanceof Produto && produto.getId() != null) {
                uiComponent.getAttributes().put( produto.getId().toString(), produto);
                return produto.getId().toString();
            }
        }
        return "";
    }
}