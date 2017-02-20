package br.com.rudar.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the EPI_ORCAMENTO_ITEM_PROCESSO database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM_PROCESSO")
@NamedQuery(name="EpiOrcamentoItemProcesso.findAll", query="SELECT e FROM EpiOrcamentoItemProcesso e")
public class EpiOrcamentoItemProcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_EPIORCAMENTOITEMPROCESSO")
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM_PROCESSO", sequenceName="G_EPI_ORCAMENTO_ITEM_PROCESSO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM_PROCESSO")
	private Integer id;

	@Column(name="ITEM")
	private Integer item;
	
	
	@Column(name="DESCRICAO")
	private String descricao;
	
		
	@Column(name="PROCESSO")
	private Integer processo;
	
	@Column(name="CUSTO_MINUTO")
	private BigDecimal custoMinuto;


	@Column(name="TEMPO_EXECUCAO")
	private BigDecimal tempoExecucao;

	@Column(name="VALOR_TOTAL",insertable=false,updatable=false)
	private BigDecimal valorTotal;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_EPIGRUPOMAQUINA")
	private GrupoMaquina grupomaquina;
	
	
	//bi-directional many-to-one association to EpiOrcamentoItem
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTOITEM")
	private EpiOrcamentoItem epiOrcamentoItem;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public EpiOrcamentoItemProcesso() {
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public GrupoMaquina getGrupoMaquina() {
		return this.grupomaquina;
	}

	public void setGrupoMaquina(GrupoMaquina grupomaquina) {
		this.grupomaquina = grupomaquina;
	}

	
	public BigDecimal getCustoMinuto() {
		return this.custoMinuto;
	}

	public void setCustoMinuto(BigDecimal custoMinuto) {
		this.custoMinuto = custoMinuto;
	}

	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public int getProcesso() {
		return this.processo;
	}

	public void setProcesso(int processo) {
		this.processo = processo;
	}

	
	public BigDecimal getTempoExecucao() {
		return this.tempoExecucao;
	}

	public void setTempoExecucao(BigDecimal tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	
	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	public EpiOrcamentoItem getEpiOrcamentoItem() {
		return this.epiOrcamentoItem;
	}

	public void setEpiOrcamentoItem(EpiOrcamentoItem epiOrcamentoItem) {
		this.epiOrcamentoItem = epiOrcamentoItem;
	}


	
	
	//--------------------------------	Métodos Auxiliares------------------------------//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EpiOrcamentoItemProcesso other = (EpiOrcamentoItemProcesso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}