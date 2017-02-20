package br.com.rudar.core.entity;

import java.io.Serializable;

public class ClassFiscalItemPK implements Serializable{
 
    private static final long serialVersionUID = 1L;
 
    private int clasFiscal;
    private String estado;
    
    
	public int getClasFiscal() {
		return clasFiscal;
	}
	public void setClasFiscal(int clasFiscal) {
		this.clasFiscal = clasFiscal;
	}
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clasFiscal;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassFiscalItemPK other = (ClassFiscalItemPK) obj;
		if (clasFiscal != other.clasFiscal)
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}    
}
