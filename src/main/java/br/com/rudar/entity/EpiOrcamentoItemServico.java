package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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

	@Column(name="COD_CADCOLABORADOR")
	private int codCadcolaborador;

	@Column(name="COD_CADTIPOSERVICO")
	private int codCadtiposervico;

	@Column(name="COD_CADUNIDADE")
	private int codCadunidade;

	
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
	

	public int getCodCadcolaborador() {
		return this.codCadcolaborador;
	}

	public void setCodCadcolaborador(int codCadcolaborador) {
		this.codCadcolaborador = codCadcolaborador;
	}

	
	public int getCodCadtiposervico() {
		return this.codCadtiposervico;
	}

	public void setCodCadtiposervico(int codCadtiposervico) {
		this.codCadtiposervico = codCadtiposervico;
	}

	
	public int getCodCadunidade() {
		return this.codCadunidade;
	}

	public void setCodCadunidade(int codCadunidade) {
		this.codCadunidade = codCadunidade;
	}

	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
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

}