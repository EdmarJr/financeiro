package br.com.financeiro.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.entity.FuncaoEmpresa;

@FacesConverter(forClass = FuncaoEmpresa.class)
public class ConverterFuncao  implements Converter{

	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (FuncaoEmpresa) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof FuncaoEmpresa) {
        	FuncaoEmpresa entity= (FuncaoEmpresa) value;
            if (entity != null && entity instanceof FuncaoEmpresa && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }

}
