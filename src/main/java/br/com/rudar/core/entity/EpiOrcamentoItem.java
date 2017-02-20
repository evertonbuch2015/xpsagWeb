package br.com.rudar.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the EPI_ORCAMENTO_ITEM database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM")
@NamedQuery(name="EpiOrcamentoItem.findAll", query="SELECT e FROM EpiOrcamentoItem e")
public class EpiOrcamentoItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM", sequenceName="G_EPI_ORCAMENTO_ITEM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM")
	@Column(name="COD_EPIORCAMENTOITEM")
	private Integer id;

	@Column(name="ITEM")
	private Integer item;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADPRODUTO")
	private Produto produto;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADUNIDADE")
	private Unidade unidade;

	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ENTREGA")
	private Date dataEntrega;

	
	@Column(name="FPC_INSUMOS",insertable=false,updatable=false)
	private BigDecimal fpcInsumos;

	@Column(name="FPC_MAO_OBRA",insertable=false,updatable=false)
	private BigDecimal fpcMaoObra;

	@Column(name="FPC_MATERIA_PRIMA",insertable=false,updatable=false)
	private BigDecimal fpcMateriaPrima;

	@Column(name="FPC_SERVICO_TERCEIRO",insertable=false,updatable=false)
	private BigDecimal fpcServicoTerceiro;


	@Column(name="MARK_UP",insertable=false,updatable=false)
	private Double markUp;

	
	@Column(name="QUANTIDADE")
	private BigDecimal quantidade;
	
	@Column(name="VALOR_COMISSAO",insertable=false,updatable=false)
	private Double valorComissao;

	@Column(name="VALOR_FRETE")
	private BigDecimal valorFrete;

	@Column(name="VALOR_UNITARIO",insertable=false,updatable=false)
	private BigDecimal valorUnitario;
	
	
	
	@Column(name="PERC_COMISSAO")
	private Double percComissao;

	@Column(name="PERC_MARK_UP",insertable=false,updatable=false)
	private Double percMarkUp;

	@Column(name="PERC_QUEBRA")
	private Double percQuebra;

	@Column(name="PRECO_CALCULADO",insertable=false,updatable=false)
	private BigDecimal precoCalculado;

	@Column(name="PRECO_VENDA")
	private BigDecimal precoVenda;
	
	
	
	
	@Column(name="NOME_PRODUTO")
	private String nomeProduto;
	
	@Lob
	@Column(name="OBSERVACAO")
	private String observacao;

	@Lob
	@Column(name="OBSERVACAO_CLIENTE")
	private byte[] observacaoCliente;

	@Lob
	@Column(name="OBSERVACAO_INTERNA")
	private byte[] observacaoInterna;

	@Lob
	@Column(name="OBSERVACAO_PROPOSTA")
	private byte[] observacaoProposta;

	
	@Column(name="SITUACAO")
	private String situacao;

	@Column(name="TIPO")
	private String tipo;
	
	
	//bi-directional many-to-one association to EpiOrcamento
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTO")
	private EpiOrcamento epiOrcamento;

	
	
	//bi-directional many-to-one association to EpiOrcamentoItemInsumo
	@OneToMany(mappedBy="epiOrcamentoItem",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<EpiOrcamentoItemInsumo> epiOrcamentoItemInsumos;

		
	//bi-directional many-to-one association to EpiOrcamentoItemMp
	@OneToMany(mappedBy="epiOrcamentoItem",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<EpiOrcamentoItemMp> epiOrcamentoItemMps;

	
	//bi-directional many-to-one association to EpiOrcamentoItemProcesso
	@OneToMany(mappedBy="epiOrcamentoItem",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<EpiOrcamentoItemProcesso> epiOrcamentoItemProcessos;

	
	//bi-directional many-to-one association to EpiOrcamentoItemServico
	@OneToMany(mappedBy="epiOrcamentoItem",cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<EpiOrcamentoItemServico> epiOrcamentoItemServicos;

	
	
	//--------------------------------	GETs and SETs------------------------------//
	
	public EpiOrcamentoItem() {
	}

	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	
	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	
	public BigDecimal getFpcInsumos() {
		return this.fpcInsumos;
	}

	public void setFpcInsumos(BigDecimal fpcInsumos) {
		this.fpcInsumos = fpcInsumos;
	}

	
	public BigDecimal getFpcMaoObra() {
		return this.fpcMaoObra;
	}

	public void setFpcMaoObra(BigDecimal fpcMaoObra) {
		this.fpcMaoObra = fpcMaoObra;
	}

	
	public BigDecimal getFpcMateriaPrima() {
		return this.fpcMateriaPrima;
	}

	public void setFpcMateriaPrima(BigDecimal fpcMateriaPrima) {
		this.fpcMateriaPrima = fpcMateriaPrima;
	}

	
	public BigDecimal getFpcServicoTerceiro() {
		return this.fpcServicoTerceiro;
	}

	public void setFpcServicoTerceiro(BigDecimal fpcServicoTerceiro) {
		this.fpcServicoTerceiro = fpcServicoTerceiro;
	}

	
	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	
	public Double getMarkUp() {
		return this.markUp;
	}

	public void setMarkUp(Double markUp) {
		this.markUp = markUp;
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

	
	public byte[] getObservacaoCliente() {
		return this.observacaoCliente;
	}

	public void setObservacaoCliente(byte[] observacaoCliente) {
		this.observacaoCliente = observacaoCliente;
	}

	
	public byte[] getObservacaoInterna() {
		return this.observacaoInterna;
	}

	public void setObservacaoInterna(byte[] observacaoInterna) {
		this.observacaoInterna = observacaoInterna;
	}

	
	public byte[] getObservacaoProposta() {
		return this.observacaoProposta;
	}

	public void setObservacaoProposta(byte[] observacaoProposta) {
		this.observacaoProposta = observacaoProposta;
	}

	
	public Double getPercComissao() {
		return this.percComissao;
	}

	public void setPercComissao(Double percComissao) {
		this.percComissao = percComissao;
	}

	
	public Double getPercMarkUp() {
		return this.percMarkUp;
	}

	public void setPercMarkUp(Double percMarkUp) {
		this.percMarkUp = percMarkUp;
	}

	
	public Double getPercQuebra() {
		return this.percQuebra;
	}

	public void setPercQuebra(Double percQuebra) {
		this.percQuebra = percQuebra;
	}

	
	public BigDecimal getPrecoCalculado() {
		return this.precoCalculado;
	}

	public void setPrecoCalculado(BigDecimal precoCalculado) {
		this.precoCalculado = precoCalculado;
	}

	
	public BigDecimal getPrecoVenda() {
		return this.precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	
	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	
	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public Double getValorComissao() {
		return this.valorComissao;
	}

	public void setValorComissao(Double valorComissao) {
		this.valorComissao = valorComissao;
	}

	
	public BigDecimal getValorFrete() {
		return this.valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	
	public EpiOrcamento getEpiOrcamento() {
		return this.epiOrcamento;
	}

	public void setEpiOrcamento(EpiOrcamento epiOrcamento) {
		this.epiOrcamento = epiOrcamento;
	}

	
	public List<EpiOrcamentoItemInsumo> getEpiOrcamentoItemInsumos() {
		if(this.epiOrcamentoItemInsumos == null){
			this.epiOrcamentoItemInsumos = new ArrayList<>();
		}
		return this.epiOrcamentoItemInsumos;
	}

	public void setEpiOrcamentoItemInsumos(List<EpiOrcamentoItemInsumo> epiOrcamentoItemInsumos) {
		this.epiOrcamentoItemInsumos = epiOrcamentoItemInsumos;
	}

		
	
	public List<EpiOrcamentoItemMp> getEpiOrcamentoItemMps() {
		if(this.epiOrcamentoItemMps == null){
			this.epiOrcamentoItemMps = new ArrayList<>();
		}
		return this.epiOrcamentoItemMps;
	}

	public void setEpiOrcamentoItemMps(List<EpiOrcamentoItemMp> epiOrcamentoItemMps) {
		this.epiOrcamentoItemMps = epiOrcamentoItemMps;
	}

	
	public List<EpiOrcamentoItemProcesso> getEpiOrcamentoItemProcessos() {
		if(this.epiOrcamentoItemProcessos == null){
			this.epiOrcamentoItemProcessos = new ArrayList<>();
		}
		return this.epiOrcamentoItemProcessos;
	}

	public void setEpiOrcamentoItemProcessos(List<EpiOrcamentoItemProcesso> epiOrcamentoItemProcessos) {
		this.epiOrcamentoItemProcessos = epiOrcamentoItemProcessos;
	}
	
	
	
	public List<EpiOrcamentoItemServico> getEpiOrcamentoItemServicos() {
		if(this.epiOrcamentoItemServicos == null){
			this.epiOrcamentoItemServicos = new ArrayList<>();
		}
		return this.epiOrcamentoItemServicos;
	}

	public void setEpiOrcamentoItemServicos(List<EpiOrcamentoItemServico> epiOrcamentoItemServicos) {
		this.epiOrcamentoItemServicos = epiOrcamentoItemServicos;
	}


	//--------------------------------	Métodos Auxiliares------------------------------//
	

	public EpiOrcamentoItemInsumo addEpiOrcamentoItemInsumo(EpiOrcamentoItemInsumo epiOrcamentoItemInsumo) {
		getEpiOrcamentoItemInsumos().add(epiOrcamentoItemInsumo);
		epiOrcamentoItemInsumo.setEpiOrcamentoItem(this);

		return epiOrcamentoItemInsumo;
	}

	public EpiOrcamentoItemInsumo removeEpiOrcamentoItemInsumo(EpiOrcamentoItemInsumo epiOrcamentoItemInsumo) {
		getEpiOrcamentoItemInsumos().remove(epiOrcamentoItemInsumo);
		epiOrcamentoItemInsumo.setEpiOrcamentoItem(null);

		return epiOrcamentoItemInsumo;
	}

	

	public EpiOrcamentoItemMp addEpiOrcamentoItemMp(EpiOrcamentoItemMp epiOrcamentoItemMp) {
		getEpiOrcamentoItemMps().add(epiOrcamentoItemMp);
		epiOrcamentoItemMp.setEpiOrcamentoItem(this);

		return epiOrcamentoItemMp;
	}

	public EpiOrcamentoItemMp removeEpiOrcamentoItemMp(EpiOrcamentoItemMp epiOrcamentoItemMp) {
		getEpiOrcamentoItemMps().remove(epiOrcamentoItemMp);
		epiOrcamentoItemMp.setEpiOrcamentoItem(null);

		return epiOrcamentoItemMp;
	}

	
	
	public EpiOrcamentoItemProcesso addEpiOrcamentoItemProcesso(EpiOrcamentoItemProcesso epiOrcamentoItemProcesso) {
		getEpiOrcamentoItemProcessos().add(epiOrcamentoItemProcesso);
		epiOrcamentoItemProcesso.setEpiOrcamentoItem(this);

		return epiOrcamentoItemProcesso;
	}

	public EpiOrcamentoItemProcesso removeEpiOrcamentoItemProcesso(EpiOrcamentoItemProcesso epiOrcamentoItemProcesso) {
		getEpiOrcamentoItemProcessos().remove(epiOrcamentoItemProcesso);
		epiOrcamentoItemProcesso.setEpiOrcamentoItem(null);

		return epiOrcamentoItemProcesso;
	}

	

	public EpiOrcamentoItemServico addEpiOrcamentoItemServico(EpiOrcamentoItemServico epiOrcamentoItemServico) {
		getEpiOrcamentoItemServicos().add(epiOrcamentoItemServico);
		epiOrcamentoItemServico.setEpiOrcamentoItem(this);

		return epiOrcamentoItemServico;
	}

	public EpiOrcamentoItemServico removeEpiOrcamentoItemServico(EpiOrcamentoItemServico epiOrcamentoItemServico) {
		getEpiOrcamentoItemServicos().remove(epiOrcamentoItemServico);
		epiOrcamentoItemServico.setEpiOrcamentoItem(null);

		return epiOrcamentoItemServico;
	}
	
	
}