package br.com.rudar.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rudar.core.enumerated.TipoFrete;


/**
 * The persistent class for the EPI_ORCAMENTO database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO")
@NamedQuery(name="Orcamento.findAll", query="SELECT e FROM Orcamento e")
public class Orcamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="G_EPI_ORCAMENTO", sequenceName="G_EPI_ORCAMENTO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_ORCAMENTO")
	@Column(name="COD_EPIORCAMENTO")
	private Integer id; 

	
	@Column(name="CODIGO")
	private Integer codigo;
	
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
	private Integer diasValidade;

	

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

	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_FRETE")
	private TipoFrete tipoFrete;

	
	@Column(name="USUARIO")
	private String usuario;

		
	
	@Column(name="VALOR_COMISSAO",insertable=false,updatable=false)
	private BigDecimal valorComissao;

	@Column(name="VALOR_FRETE",insertable=false,updatable=false)
	private BigDecimal valorFrete;

	@Column(name="VALOR_INSUMOS",insertable=false,updatable=false)
	private BigDecimal valorInsumos;

	@Column(name="VALOR_MAO_OBRA",insertable=false,updatable=false)
	private BigDecimal valorMaoObra;

	@Column(name="VALOR_MATERIA_PRIMA",insertable=false,updatable=false)
	private BigDecimal valorMateriaPrima;

	@Column(name="VALOR_TOTAL_CALCULADO",insertable=false,updatable=false)
	private BigDecimal valorTotalCalculado;

	@Column(name="VALOR_TOTAL_VENDA",insertable=false,updatable=false)
	private BigDecimal valorTotalVenda;

	
	
	//bi-directional many-to-one association to OrcamentoItem
	@OneToMany(mappedBy="orcamento", targetEntity = OrcamentoItem.class,
			fetch = FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<OrcamentoItem> orcamentoItems;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Orcamento() {
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

	
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	
	public String getDataEmissaoFormatada() {
		if(this.dataEmissao != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(dataEmissao);
		}
		return null;
	}
	
	public Date getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	
	public String getDataEntregaFormatada() {
		if(this.dataEntrega != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(dataEntrega);
		}
		return null;
	}
	
	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	
	public Integer getDiasValidade() {
		return this.diasValidade;
	}

	public void setDiasValidade(Integer diasValidade) {
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

	
	public List<OrcamentoItem> getOrcamentoItems() {
		if(this.orcamentoItems == null){
			this.orcamentoItems = new ArrayList<>();
		}
		return this.orcamentoItems;
	}

	public void setOrcamentoItems(List<OrcamentoItem> orcamentoItems) {
		this.orcamentoItems = orcamentoItems;
	}

	
	//--------------------------------	Métodos Auxiliares------------------------------//

	
	public OrcamentoItem addOrcamentoItem(OrcamentoItem orcamentoItem) {
		getOrcamentoItems().add(orcamentoItem);
		orcamentoItem.setOrcamento(this);

		return orcamentoItem;
	}

	public OrcamentoItem removeOrcamentoItem(OrcamentoItem orcamentoItem) {
		getOrcamentoItems().remove(orcamentoItem);
		orcamentoItem.setOrcamento(null);

		return orcamentoItem;
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
		Orcamento other = (Orcamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}