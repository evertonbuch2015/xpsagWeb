package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EPI_ORCAMENTO database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO")
@NamedQuery(name="EpiOrcamento.findAll", query="SELECT e FROM EpiOrcamento e")
public class EpiOrcamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO", sequenceName="G_EPI_ORCAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO")
	@Column(name="COD_EPIORCAMENTO")
	private Integer id; 

	private String cemp;

	private String cfil;

	private String cidade;

	
	@Column(name="COD_CADCOLABORADOR")
	private int codCadcolaborador;

	@Column(name="COD_CADCONDPAGAMENTO")
	private int codCadcondpagamento;

	@Column(name="COD_CADVENDEDOR")
	private int codCadvendedor;

	@Column(name="CODIGO")
	private int codigo;

	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMISSAO")
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ENTREGA")
	private Date dataEntrega;

	@Column(name="DIAS_VALIDADE")
	private int diasValidade;

	
	
	@Column(name="DOCUMENTO_REF")
	private String documentoRef;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="NFON")
	private String nfon;

	@Column(name="PFON")
	private String pfon;

	
	@Column(name="CONTATO")
	private String contato;
	
	
	@Column(name="NOME_COLABORADOR")
	private String nomeColaborador;

	@Lob
	@Column(name="OBSERVACAO")
	private String observacao;
	
	@Column(name="SITUACAO")
	private String situacao;

	@Column(name="TIPO_FRETE")
	private String tipoFrete;

	
	@Column(name="USUARIO")
	private String usuario;

	
	
	
	@Column(name="VALOR_COMISSAO")
	private BigDecimal valorComissao;

	@Column(name="VALOR_FRETE")
	private BigDecimal valorFrete;

	@Column(name="VALOR_INSUMOS")
	private BigDecimal valorInsumos;

	@Column(name="VALOR_MAO_OBRA")
	private BigDecimal valorMaoObra;

	@Column(name="VALOR_MATERIA_PRIMA")
	private BigDecimal valorMateriaPrima;

	@Column(name="VALOR_TOTAL_CALCULADO")
	private BigDecimal valorTotalCalculado;

	@Column(name="VALOR_TOTAL_VENDA")
	private BigDecimal valorTotalVenda;

	
	
	//bi-directional many-to-one association to EpiOrcamentoItem
	@OneToMany(mappedBy="epiOrcamento", targetEntity = EpiOrcamentoItem.class,
			fetch = FetchType.LAZY)
	private List<EpiOrcamentoItem> epiOrcamentoItems;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public EpiOrcamento() {
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCemp() {
		return this.cemp;
	}

	public void setCemp(String cemp) {
		this.cemp = cemp;
	}

	public String getCfil() {
		return this.cfil;
	}

	public void setCfil(String cfil) {
		this.cfil = cfil;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCodCadcolaborador() {
		return this.codCadcolaborador;
	}

	public void setCodCadcolaborador(int codCadcolaborador) {
		this.codCadcolaborador = codCadcolaborador;
	}

	public int getCodCadcondpagamento() {
		return this.codCadcondpagamento;
	}

	public void setCodCadcondpagamento(int codCadcondpagamento) {
		this.codCadcondpagamento = codCadcondpagamento;
	}

	public int getCodCadvendedor() {
		return this.codCadvendedor;
	}

	public void setCodCadvendedor(int codCadvendedor) {
		this.codCadvendedor = codCadvendedor;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public int getDiasValidade() {
		return this.diasValidade;
	}

	public void setDiasValidade(int diasValidade) {
		this.diasValidade = diasValidade;
	}

	public String getDocumentoRef() {
		return this.documentoRef;
	}

	public void setDocumentoRef(String documentoRef) {
		this.documentoRef = documentoRef;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNfon() {
		return this.nfon;
	}

	public void setNfon(String nfon) {
		this.nfon = nfon;
	}

	public String getNomeColaborador() {
		return this.nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPfon() {
		return this.pfon;
	}

	public void setPfon(String pfon) {
		this.pfon = pfon;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTipoFrete() {
		return this.tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorComissao() {
		return this.valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public BigDecimal getValorFrete() {
		return this.valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public BigDecimal getValorInsumos() {
		return this.valorInsumos;
	}

	public void setValorInsumos(BigDecimal valorInsumos) {
		this.valorInsumos = valorInsumos;
	}

	public BigDecimal getValorMaoObra() {
		return this.valorMaoObra;
	}

	public void setValorMaoObra(BigDecimal valorMaoObra) {
		this.valorMaoObra = valorMaoObra;
	}

	public BigDecimal getValorMateriaPrima() {
		return this.valorMateriaPrima;
	}

	public void setValorMateriaPrima(BigDecimal valorMateriaPrima) {
		this.valorMateriaPrima = valorMateriaPrima;
	}

	public BigDecimal getValorTotalCalculado() {
		return this.valorTotalCalculado;
	}

	public void setValorTotalCalculado(BigDecimal valorTotalCalculado) {
		this.valorTotalCalculado = valorTotalCalculado;
	}

	public BigDecimal getValorTotalVenda() {
		return this.valorTotalVenda;
	}

	public void setValorTotalVenda(BigDecimal valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	
	public List<EpiOrcamentoItem> getEpiOrcamentoItems() {
		return this.epiOrcamentoItems;
	}

	public void setEpiOrcamentoItems(List<EpiOrcamentoItem> epiOrcamentoItems) {
		this.epiOrcamentoItems = epiOrcamentoItems;
	}

	
	public EpiOrcamentoItem addEpiOrcamentoItem(EpiOrcamentoItem epiOrcamentoItem) {
		getEpiOrcamentoItems().add(epiOrcamentoItem);
		epiOrcamentoItem.setEpiOrcamento(this);

		return epiOrcamentoItem;
	}

	public EpiOrcamentoItem removeEpiOrcamentoItem(EpiOrcamentoItem epiOrcamentoItem) {
		getEpiOrcamentoItems().remove(epiOrcamentoItem);
		epiOrcamentoItem.setEpiOrcamento(null);

		return epiOrcamentoItem;
	}

	
	//--------------------------------	Métodos Auxiliares------------------------------//
	
	
}