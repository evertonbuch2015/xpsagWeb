package br.com.rudar.core.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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


@Entity
@Table(name = "CAD_PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -4327127418545137030L;


	@Id
    @SequenceGenerator(name="G_CAD_PRODUTO", sequenceName="\"G_CAD_PRODUTO\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PRODUTO")
	@Column(name = "COD_CADPRODUTO")
	private Integer id;
	
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
	
	@Column(name = "ORIGEM_MERCADORIA")
	private Character origemMercadoria;
	
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
	private GrupoProduto grupoProduto;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="COD_CADUNIDADE")
	private Unidade unidade;
	
	
	@ManyToOne
	@JoinTable(name="CAD_PRODUTO_FATOPESAIDA", 
				joinColumns={@JoinColumn(name="COD_CADPRODUTO", referencedColumnName="COD_CADPRODUTO")}, 
				inverseJoinColumns={@JoinColumn(name="COD_FATOPERACAOSAIDA", referencedColumnName="COD_FATOPERACAOSAIDA")})
    private OperacaoSaida operacaoSaida;
 
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy="produto")
	private ProdutoInd produtoInd;
	
	
	//--------------------------------	METODOS CONSTRUTORES -----------------------//
	
	public Produto() {}
	
		
	public Produto(Integer id, Integer codigo, String nome,Integer idGrupo, String codigoEstrutural, String nomeGrupo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		
		this.grupoProduto = new GrupoProduto();
		this.grupoProduto.setId(idGrupo);
		this.grupoProduto.setCodigoEstrutural(codigoEstrutural);
		this.grupoProduto.setNome(nomeGrupo);
	}


	//--------------------------------	GETs and SETs------------------------------//

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	
	public GrupoProduto getGrupoProduto() {
		if(this.grupoProduto == null){
			this.grupoProduto = new GrupoProduto();
		}
		return grupoProduto;
	}
	
	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	
	public OperacaoSaida getOperacaoSaida() {
		if(this.operacaoSaida == null){
			this.operacaoSaida = new OperacaoSaida();
		}
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
	
	
	public Character getOrigemMercadoria() {
		return origemMercadoria;
	}
	
	public void setOrigemMercadoria(Character origemMercadoria) {
			this.origemMercadoria = origemMercadoria;		
	}
	
		
	public Date getDataInsercao() {
		return dataInsercao;
	}
	
	public String getDataInsercaoFormatada(){
		if(this.dataInsercao != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(dataInsercao);
		}
			return null;
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
		if(this.clasFiscal == null){
			this.clasFiscal = new ClasFiscal();
		}
		return clasFiscal;
	}
	
	public void setClasFiscal(ClasFiscal clasFiscal) {
		this.clasFiscal = clasFiscal;
	}
	
	
	public ProdutoInd getProdutoInd() {
		if(this.produtoInd == null){			
			this.produtoInd = new ProdutoInd();
			this.produtoInd.setProduto(this);
		}
		return produtoInd;
	}

	public void setProdutoInd(ProdutoInd produtoInd) {
		
		this.produtoInd = produtoInd;
	}


	
	//M�todos Modificados
	public Boolean getSituacao() {
		if(this.situacao == null) return null;
		return situacao.equals('N') ? true : false;
	}

	public void setSituacao(Boolean value) {
		if(value == null){ 
			this.situacao = null;
		}else{
			this.situacao = value == true ? 'N' : 'I';
		}
	}
	

	public Boolean getNcmUsaMvaAjustado() {
		if(this.ncmUsaMvaAjustado == null) return null;
		
		return ncmUsaMvaAjustado.equals('S') ? true: false;
	}
	
	public void setNcmUsaMvaAjustado(Boolean ncmUsaMvaAjustado) {
		if(ncmUsaMvaAjustado == null){ 
			this.ncmUsaMvaAjustado = null;
		}else{
			this.ncmUsaMvaAjustado = ncmUsaMvaAjustado == true ? 'S' : 'N';
		}
	}
	
			
	
	//--------------------------------	M�todos Auxiliares------------------------------//
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}