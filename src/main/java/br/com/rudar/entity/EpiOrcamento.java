package br.com.rudar.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rudar.enumerated.TipoFrete;


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

	
	@Column(name="CODIGO")
	private int codigo;
	
	@Column(name="CEMP")
	private String cemp;

	@Column(name="CFIL")
	private String filial;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COD_CADCOLABORADOR")
	private Colaborador colaborador;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CADCONDPAGAMENTO")
	private CondicaoPagamento condicaoPagamento;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CADVENDEDOR")
	private Vendedor vendedor;

		
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMISSAO")
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ENTREGA")
	private Date dataEntrega;

	@Column(name="DIAS_VALIDADE")
	private int diasValidade;

	

	@Column(name="NOME_COLABORADOR")
	private String nomeColaborador;
	
	@Column(name="DOCUMENTO_REF")
	private String documentoRef;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="CIDADE")
	private String cidade;

	
	
	@Column(name="CONTATO")
	private String contato;	
	
	@Column(name="NFON")
	private String nfon;

	@Column(name="PFON")
	private String pfon;

	
	@Lob
	@Column(name="OBSERVACAO")
	private String observacao;
	
	@Column(name="SITUACAO")
	private String situacao;

	@Column(name="TIPO_FRETE")
	private TipoFrete tipoFrete;

	
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

	
	public String getFilial() {
		return this.filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	
	public CondicaoPagamento getCondicaoPagamento() {
		return this.condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	
	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
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

	
	public TipoFrete getTipoFrete() {
		return this.tipoFrete;
	}

	public void setTipoFrete(TipoFrete tipoFrete) {
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
		if(this.epiOrcamentoItems == null){
			this.epiOrcamentoItems = new ArrayList<>();
		}
		return this.epiOrcamentoItems;
	}

	public void setEpiOrcamentoItems(List<EpiOrcamentoItem> epiOrcamentoItems) {
		this.epiOrcamentoItems = epiOrcamentoItems;
	}

	
	//--------------------------------	M�todos Auxiliares------------------------------//

	
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
		EpiOrcamento other = (EpiOrcamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}