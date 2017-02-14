package br.com.rudar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAD_COND_PAGAMENTO_DIAS")
public class CondicaoPagamentoDias implements Serializable {
	
	private static final long serialVersionUID = -4507804091896584742L;


	@Id
    @SequenceGenerator(name="G_CAD_COND_PAGAMENTO_DIAS", sequenceName="\"G_CAD_COND_PAGAMENTO_DIAS\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_COND_PAGAMENTO_DIAS")
	@Column(name = "COD_CADCONDPAGAMENTODIAS")
	private Integer Id;
	
	
	@Column(name="DIAS")
	private Integer dias;
	
	
	@ManyToOne
	@JoinColumn(name= "COD_CADCONDPAGAMENTO")
	private CondicaoPagamento condicaoPagamento;


	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getDias() {
		return dias;
	}


	public void setDias(Integer dias) {
		this.dias = dias;
	}


	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}


	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	
	//--------------------------------	Métodos Auxiliares------------------------------//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CondicaoPagamentoDias other = (CondicaoPagamentoDias) obj;
		if (Id == null) {
			if (other.Id != null) {
				return false;
			}
		} else if (!Id.equals(other.Id)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "CondicaoPagamentoDias [Id=" + Id + ", dias=" + dias + "]";
	}
}
