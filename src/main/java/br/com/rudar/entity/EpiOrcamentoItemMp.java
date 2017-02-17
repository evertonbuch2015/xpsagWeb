package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EPI_ORCAMENTO_ITEM_MP database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM_MP")
@NamedQuery(name="EpiOrcamentoItemMp.findAll", query="SELECT e FROM EpiOrcamentoItemMp e")
public class EpiOrcamentoItemMp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM_MP", sequenceName="G_EPI_ORCAMENTO_ITEM_MP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM_MP")
	@Column(name="COD_EPIORCAMENTOITEMMP")
	private Integer id;

	@Column(name="COD_CADPRODUTO")
	private int codCadproduto;

	@Column(name="COD_CADUNIDADE")
	private int codCadunidade;

	private BigDecimal comprimento;

	private BigDecimal diametro;

	private BigDecimal espessura;

	private int item;

	private BigDecimal largura;

	@Column(name="NOME_PRODUTO")
	private String nomeProduto;

	private String observacao;

	private BigDecimal perfil;

	private BigDecimal peso;

	@Column(name="PESO_ESPECIFICO")
	private BigDecimal pesoEspecifico;

	@Column(name="PESO_INFORMADO")
	private BigDecimal pesoInformado;

	private BigDecimal quantidade;

	private String unidade;

	@Column(name="VALOR_TOTAL")
	private double valorTotal;

	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	//bi-directional many-to-one association to EpiOrcamentoItem
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTOITEM")
	private EpiOrcamentoItem epiOrcamentoItem;

	
	
	//--------------------------------	GETs and SETs------------------------------//
	
	public EpiOrcamentoItemMp() {
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCodCadproduto() {
		return this.codCadproduto;
	}

	public void setCodCadproduto(int codCadproduto) {
		this.codCadproduto = codCadproduto;
	}

	public int getCodCadunidade() {
		return this.codCadunidade;
	}

	public void setCodCadunidade(int codCadunidade) {
		this.codCadunidade = codCadunidade;
	}

	public BigDecimal getComprimento() {
		return this.comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getDiametro() {
		return this.diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public BigDecimal getEspessura() {
		return this.espessura;
	}

	public void setEspessura(BigDecimal espessura) {
		this.espessura = espessura;
	}

	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public BigDecimal getLargura() {
		return this.largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getPerfil() {
		return this.perfil;
	}

	public void setPerfil(BigDecimal perfil) {
		this.perfil = perfil;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getPesoEspecifico() {
		return this.pesoEspecifico;
	}

	public void setPesoEspecifico(BigDecimal pesoEspecifico) {
		this.pesoEspecifico = pesoEspecifico;
	}

	public BigDecimal getPesoInformado() {
		return this.pesoInformado;
	}

	public void setPesoInformado(BigDecimal pesoInformado) {
		this.pesoInformado = pesoInformado;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
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