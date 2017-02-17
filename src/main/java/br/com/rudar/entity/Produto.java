package br.com.rudar.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rudar.enumerated.OrigemMercadoria;


@Entity
@Table(name = "CAD_PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -4327127418545137030L;


	@Id
    @SequenceGenerator(name="G_CAD_PRODUTO", sequenceName="\"G_CAD_PRODUTO\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PRODUTO")
	@Column(name = "COD_CADPRODUTO")
	private Integer Id;
	
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "CEMP", length = 2)
	private String cemp;
	
	
	@Column(name = "NOME", length = 60)
	private String nome;
	
	@Lob
	@Column(name = "DESCRICAO_TECNICA")
	private String descricaTecnica;
	
	@Column(name = "REFERENCIA_FABRICA",length=20)
	private String refFabrica;
	
	@Column(name = "CODIGO_BARRAS",length=15)
	private String codigoBarras;
	
	@Column(name = "CODIGO_BARRAS_EAN14",length=15)
	private String codigoBarrasEan14;
	
	@Column(name = "CODIGO_NCM")
	private Double codigoNcm;
	
	@Column(name = "CODIGO_NCM_EXTIPI",length=3)
	private String codigoNcmExtipi;
	
	@Column(name = "PESO_BRUTO")
	private Double pesoBruto;
	
	@Column(name = "PESO_LIQUIDO")
	private Double pesoLiquido;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ORIGEM_MERCADORIA")
	private OrigemMercadoria origemMercadoria;
	
	@Column(name = "NCM_USA_MVA_AJUSTADO")
	private Character ncmUsaMvaAjustado;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_INSERCAO")
	private Date dataInsercao;
	
	//true = ATIVO(N)		false = INATIVO(I)
	@Column(name = "SITUACAO", length = 1)
	private Character situacao;
	
	
	@Column(name = "USUARIO",length=10)
	private String usuario;
	
	@Column(name = "CODIGO_CEST",length=3)
	private Integer codigoCest;
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CADCLASFISCAL")
	private ClasFiscal clasFiscal;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CEAGRUPO")
	private GrupoProduto gupoProduto;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="COD_CADUNIDADE")
	private Unidade unidade;
	
	
	@ManyToOne
	@JoinTable(name="CAD_PRODUTO_FATOPESAIDA", 
				joinColumns={@JoinColumn(name="COD_CADPRODUTO", referencedColumnName="COD_CADPRODUTO")}, 
				inverseJoinColumns={@JoinColumn(name="COD_FATOPERACAOSAIDA", referencedColumnName="COD_FATOPERACAOSAIDA")})
    private OperacaoSaida operacaoSaida;
 
	
	//--------------------------------	GETs and SETs------------------------------//
	

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	

	public String getCemp() {
		return cemp;
	}
	
	public void setCemp(String cemp) {
		this.cemp = cemp;
	}

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

		
	public Unidade getUnidade() {
		return unidade;
	}
	
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
	public GrupoProduto getGupoProduto() {
		return gupoProduto;
	}
	
	public void setGupoProduto(GrupoProduto gupoProduto) {
		this.gupoProduto = gupoProduto;
	}

	
	public OperacaoSaida getOperacaoSaida() {
		return operacaoSaida;
	}
	
	public void setOperacaoSaida(OperacaoSaida operacaoSaida) {
		this.operacaoSaida = operacaoSaida;
	}
	
	
	public String getDescricaTecnica() {
		return descricaTecnica;
	}

	public void setDescricaTecnica(String descricaTecnica) {
		this.descricaTecnica = descricaTecnica;
	}
	
	
	public String getRefFabrica() {
		return refFabrica;
	}
	
	public void setRefFabrica(String refFabrica) {
		this.refFabrica = refFabrica;
	}
	
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	
	public String getCodigoBarrasEan14() {
		return codigoBarrasEan14;
	}
	
	public void setCodigoBarrasEan14(String codigoBarrasEan14) {
		this.codigoBarrasEan14 = codigoBarrasEan14;
	}
	
	
	public Double getCodigoNcm() {
		return codigoNcm;
	}
	
	public void setCodigoNcm(Double codigoNcm) {
		this.codigoNcm = codigoNcm;
	}
	
	
	public String getCodigoNcmExtipi() {
		return codigoNcmExtipi;
	}
	
	public void setCodigoNcmExtipi(String codigoNcmExtipi) {
		this.codigoNcmExtipi = codigoNcmExtipi;
	}
	
	
	public Double getPesoBruto() {
		return pesoBruto;
	}
	
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	
	
	public Double getPesoLiquido() {
		return pesoLiquido;
	}
	
	public void setPesoLiquido(Double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	
	
	public OrigemMercadoria getOrigemMercadoria() {
		return origemMercadoria;
	}
	
	public void setOrigemMercadoria(OrigemMercadoria origemMercadoria) {
		this.origemMercadoria = origemMercadoria;
	}
	
	
	public Character getNcmUsaMvaAjustado() {
		return ncmUsaMvaAjustado;
	}
	
	public void setNcmUsaMvaAjustado(Character ncmUsaMvaAjustado) {
		this.ncmUsaMvaAjustado = ncmUsaMvaAjustado;
	}
	
	
	public Date getDataInsercao() {
		return dataInsercao;
	}
	
	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public Integer getCodigoCest() {
		return codigoCest;
	}
	
	public void setCodigoCest(Integer codigoCest) {
		this.codigoCest = codigoCest;
	}
	
	
	public ClasFiscal getClasFiscal() {
		return clasFiscal;
	}
	
	public void setClasFiscal(ClasFiscal clasFiscal) {
		this.clasFiscal = clasFiscal;
	}
	
	
	//Métodos Modificados
	public Boolean getSituacao() {
		if(this.situacao == null) return null;
		
		return situacao.equals("N") ? Boolean.TRUE : Boolean.TRUE;
	}

	public void setSituacao(Boolean value) {
		if(value == null){ 
			this.situacao = null;
		}else{
			this.situacao = value == true ? 'N' : 'I';
		}
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
		Produto other = (Produto) obj;
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