package br.com.rudar.entity;

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
 * The persistent class for the EPI_ORCAMENTO_ITEM_SERVICO database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM_SERVICO")
@NamedQuery(name="EpiOrcamentoItemServico.findAll", query="SELECT e FROM EpiOrcamentoItemServico e")
public class EpiOrcamentoItemServico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM_SERVICO", sequenceName="G_EPI_ORCAMENTO_ITEM_SERVICO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM_SERVICO")
	@Column(name="COD_EPIORCAMENTOITEMSERVICO")
	private Integer id;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADCOLABORADOR")
	private Colaborador colaborador;

	//@Column(name="COD_CADTIPOSERVICO")
	//private int codCadtiposervico;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADUNIDADE")
	private Unidade unidade;

	
	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="ITEM")
	private int item;

	@Column(name="QUANTIDADE")
	private BigDecimal quantidade;

	@Column(name="TIPO")
	private String tipo;

	
	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	
	//bi-directional many-to-one association to EpiOrcamentoItem
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTOITEM")
	private EpiOrcamentoItem epiOrcamentoItem;

		
	//--------------------------------	GETs and SETs------------------------------//
	
	public EpiOrcamentoItemServico() {
	}

	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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

	
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
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
		EpiOrcamentoItemServico other = (EpiOrcamentoItemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}