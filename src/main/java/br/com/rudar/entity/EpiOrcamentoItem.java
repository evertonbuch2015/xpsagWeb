package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
	@SequenceGenerator(name="G_EPI_ORCAMENTO_ITEM", sequenceName="G_EPI_ORCAMENTO_ITEM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO_ITEM")
	@Column(name="COD_EPIORCAMENTOITEM")
	private Integer id;

	
	@Column(name="COD_CADPRODUTO")
	private int codCadproduto;

	@Column(name="COD_CADUNIDADE")
	private int codCadunidade;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ENTREGA")
	private Date dataEntrega;

	@Column(name="FPC_INSUMOS")
	private BigDecimal fpcInsumos;

	@Column(name="FPC_MAO_OBRA")
	private BigDecimal fpcMaoObra;

	@Column(name="FPC_MATERIA_PRIMA")
	private BigDecimal fpcMateriaPrima;

	@Column(name="FPC_SERVICO_TERCEIRO")
	private BigDecimal fpcServicoTerceiro;

	@Column(name="ITEM")
	private Integer item;

	@Column(name="MARK_UP")
	private double markUp;

	@Column(name="NOME_PRODUTO")
	private String nomeProduto;

	@Lob
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

	@Column(name="PERC_COMISSAO")
	private double percComissao;

	@Column(name="PERC_MARK_UP")
	private double percMarkUp;

	@Column(name="PERC_QUEBRA")
	private double percQuebra;

	@Column(name="PRECO_CALCULADO")
	private BigDecimal precoCalculado;

	@Column(name="PRECO_VENDA")
	private BigDecimal precoVenda;

	private BigDecimal quantidade;

	private String situacao;

	private String tipo;

	@Column(name="VALOR_COMISSAO")
	private double valorComissao;

	@Column(name="VALOR_FRETE")
	private BigDecimal valorFrete;

	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	
	//bi-directional many-to-one association to EpiOrcamento
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTO")
	private EpiOrcamento epiOrcamento;

	
	//bi-directional many-to-one association to EpiOrcamentoItemInsumo
	@OneToMany(mappedBy="epiOrcamentoItem")
	private List<EpiOrcamentoItemInsumo> epiOrcamentoItemInsumos;

		
	//bi-directional many-to-one association to EpiOrcamentoItemMp
	@OneToMany(mappedBy="epiOrcamentoItem")
	private List<EpiOrcamentoItemMp> epiOrcamentoItemMps;

	
	//bi-directional many-to-one association to EpiOrcamentoItemProcesso
	@OneToMany(mappedBy="epiOrcamentoItem")
	private List<EpiOrcamentoItemProcesso> epiOrcamentoItemProcessos;

	
	//bi-directional many-to-one association to EpiOrcamentoItemServico
	@OneToMany(mappedBy="epiOrcamentoItem")
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

	public double getMarkUp() {
		return this.markUp;
	}

	public void setMarkUp(double markUp) {
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

	public double getPercComissao() {
		return this.percComissao;
	}

	public void setPercComissao(double percComissao) {
		this.percComissao = percComissao;
	}

	public double getPercMarkUp() {
		return this.percMarkUp;
	}

	public void setPercMarkUp(double percMarkUp) {
		this.percMarkUp = percMarkUp;
	}

	public double getPercQuebra() {
		return this.percQuebra;
	}

	public void setPercQuebra(double percQuebra) {
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

	public double getValorComissao() {
		return this.valorComissao;
	}

	public void setValorComissao(double valorComissao) {
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
		return this.epiOrcamentoItemInsumos;
	}

	public void setEpiOrcamentoItemInsumos(List<EpiOrcamentoItemInsumo> epiOrcamentoItemInsumos) {
		this.epiOrcamentoItemInsumos = epiOrcamentoItemInsumos;
	}

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

	public List<EpiOrcamentoItemMp> getEpiOrcamentoItemMps() {
		return this.epiOrcamentoItemMps;
	}

	public void setEpiOrcamentoItemMps(List<EpiOrcamentoItemMp> epiOrcamentoItemMps) {
		this.epiOrcamentoItemMps = epiOrcamentoItemMps;
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

	public List<EpiOrcamentoItemProcesso> getEpiOrcamentoItemProcessos() {
		return this.epiOrcamentoItemProcessos;
	}

	public void setEpiOrcamentoItemProcessos(List<EpiOrcamentoItemProcesso> epiOrcamentoItemProcessos) {
		this.epiOrcamentoItemProcessos = epiOrcamentoItemProcessos;
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

	public List<EpiOrcamentoItemServico> getEpiOrcamentoItemServicos() {
		return this.epiOrcamentoItemServicos;
	}

	public void setEpiOrcamentoItemServicos(List<EpiOrcamentoItemServico> epiOrcamentoItemServicos) {
		this.epiOrcamentoItemServicos = epiOrcamentoItemServicos;
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