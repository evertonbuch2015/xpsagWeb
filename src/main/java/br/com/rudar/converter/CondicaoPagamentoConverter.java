package br.com.rudar.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.rudar.entity.CondicaoPagamento;

@FacesConverter(forClass = CondicaoPagamento.class)
public class CondicaoPagamentoConverter  implements Converter {
    
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (CondicaoPagamento) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof CondicaoPagamento) {
        	CondicaoPagamento condicaoPagamento = (CondicaoPagamento) value;
            if (condicaoPagamento != null && condicaoPagamento instanceof CondicaoPagamento && condicaoPagamento.getId() != null) {
                uiComponent.getAttributes().put( condicaoPagamento.getId().toString(), condicaoPagamento);
                return condicaoPagamento.getId().toString();
            }
        }
        return "";
    }
}