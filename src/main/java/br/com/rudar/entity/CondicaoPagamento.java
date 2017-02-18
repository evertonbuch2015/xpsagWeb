package br.com.rudar.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.rudar.enumerated.TipoCondicaoPagamento;

@Entity
@Table(name = "CAD_COND_PAGAMENTO")
public class CondicaoPagamento implements Serializable {
	
	private static final long serialVersionUID = 9187035227643332274L;


	@Id
    @SequenceGenerator(name="G_CAD_COND_PAGAMENTO", sequenceName="\"G_CAD_COND_PAGAMENTO\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_COND_PAGAMENTO")
	@Column(name = "COD_CADCONDPAGAMENTO")
	private Integer Id;
	
	
	@Column(name = "CEMP", length = 2)
	private Character cemp;
	
	
	@Column(name = "NOME", length = 30)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO", length = 1)
	private TipoCondicaoPagamento tipo;
	
	
	@Column(name = "PERC_CUSTO_FINANCEIRO")
	private Double percCustoFinanceiro;
	
	@Column(name = "COD_CEAHISTORICO")
	private Integer codCeaHistorico;
	
	
	//Acrescimo	= A		Desconto = D
	@Column(name = "ACRESCIMO_DESCONTO", length =1)
	private Character acrescimoDesconto;
	
	
	@Column(name = "PERC_ACRES_DESCONTO")
	private Double percAcrescimoDesconto;

	
	@OneToMany(mappedBy = "condicaoPagamento", targetEntity = CondicaoPagamentoDias.class, 
			fetch = FetchType.LAZY,	cascade = CascadeType.ALL)
	private List<CondicaoPagamentoDias> dias;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Character getCemp() {
		return cemp;
	}


	public void setCemp(Character cemp) {
		this.cemp = cemp;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public TipoCondicaoPagamento getTipo() {
		return tipo;
	}


	public void setTipo(TipoCondicaoPagamento tipo) {
		this.tipo = tipo;
	}


	public Double getPercCustoFinanceiro() {
		return percCustoFinanceiro;
	}


	public void setPercCustoFinanceiro(Double percCustoFinanceiro) {
		this.percCustoFinanceiro = percCustoFinanceiro;
	}


	public Integer getCodCeaHistorico() {
		return codCeaHistorico;
	}


	public void setCodCeaHistorico(Integer codCeaHistorico) {
		this.codCeaHistorico = codCeaHistorico;
	}


	public Character getAcrescimoDesconto() {
		return acrescimoDesconto;
	}


	public void setAcrescimoDesconto(Character acrescimoDesconto) {
		this.acrescimoDesconto = acrescimoDesconto;
	}


	public Double getPercAcrescimoDesconto() {
		return percAcrescimoDesconto;
	}


	public void setPercAcrescimoDesconto(Double percAcrescimoDesconto) {
		this.percAcrescimoDesconto = percAcrescimoDesconto;
	}


	public List<CondicaoPagamentoDias> getDias() {
		if(this.dias == null){
			this.dias = new ArrayList<>();
		}
		return dias;
	}


	public void setDias(List<CondicaoPagamentoDias> dias) {
		this.dias = dias;
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
		CondicaoPagamento other = (CondicaoPagamento) obj;
		if (Id == null) {
			if (other.Id != null) {
				return false;
			}
		} else if (!Id.equals(other.Id)) {
			return false;
		}
		return true;
	}
}
