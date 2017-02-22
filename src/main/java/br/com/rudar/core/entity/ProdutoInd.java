package br.com.rudar.core.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the CAD_PRODUTO_IND database table.
 * 
 */
@Entity
@Table(name="CAD_PRODUTO_IND")
public class ProdutoInd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_CAD_PRODUTOIND", sequenceName="G_CAD_PRODUTOIND",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PRODUTOIND")
	@Column(name="COD_CADPRODUTOIND")
	private Integer id;

	
	private String amostra;

	@Column(name="CHECK_LIST")
	private String checkList;

	@Column(name="COD_CADPROCEDENCIA")
	private Integer codCadprocedencia;

	@Column(name="CONTROLA_ESTOQUE_MINIMO")
	private String controlaEstoqueMinimo;

	@Column(name="CONTROLE_NUMERO_SERIE")
	private String controleNumeroSerie;

	@Column(name="DESCRICAO_FATURAMENTO")
	private String descricaoFaturamento;

	@Column(name="DESCRICAO_SERVICO")
	private String descricaoServico;

	private Double diametro;

	@Column(name="DIMENSAO_COMPRIMENTO")
	private Double dimensaoComprimento;

	@Column(name="DIMENSAO_LARGURA")
	private Double dimensaoLargura;

	@Lob
	@Column(name="EPI_OBSERVACAP_OP")
	private String epiObservacapOp;

	private Double espessura;

	@Column(name="EXIGE_FCI")
	private String exigeFci;

	@Column(name="EXIGE_RASTREABILIDADE")
	private String exigeRastreabilidade;

	@Lob
	@Column(name="FAT_COMPLEMENTO_ORCAMENTO")
	private String fatComplementoOrcamento;

	private String kamban;

	private Integer leadtime;

	private String linha;

	private Double markup;

	private String modelo;

	@Lob
	private String observacao;

	private Double perfil;

	@Column(name="PESO_ESPECIFICO")
	private Double pesoEspecifico;

	@Column(name="PRODUTO_NOVO")
	private String produtoNovo;

	@Column(name="QUANTIDADE_IDEAL")
	private Double quantidadeIdeal;

	@Column(name="VLR_MAO_OBRA")
	private Double vlrMaoObra;

	
	//bi-directional one-to-one association to Produto
	@OneToOne
	@JoinColumn(name="COD_CADPRODUTO")
	private Produto produto;

	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
				orphanRemoval = true, mappedBy="produtoInd")
	private ProdutoIndMetal produtoIndMetal;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
				orphanRemoval = true, mappedBy="produtoInd")
	private ProdutoIndText produtoIndText;
	
	
	//--------------------------------	METODOS CONSTRUTORES -----------------------//
	
	public ProdutoInd() {
	}

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getAmostra() {
		return this.amostra;
	}

	public void setAmostra(String amostra) {
		this.amostra = amostra;
	}

	
	public String getCheckList() {
		return this.checkList;
	}

	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}

	
	public Integer getCodCadprocedencia() {
		return this.codCadprocedencia;
	}

	public void setCodCadprocedencia(Integer codCadprocedencia) {
		this.codCadprocedencia = codCadprocedencia;
	}

	
	public String getControlaEstoqueMinimo() {
		return this.controlaEstoqueMinimo;
	}

	public void setControlaEstoqueMinimo(String controlaEstoqueMinimo) {
		this.controlaEstoqueMinimo = controlaEstoqueMinimo;
	}

	
	public String getControleNumeroSerie() {
		return this.controleNumeroSerie;
	}

	public void setControleNumeroSerie(String controleNumeroSerie) {
		this.controleNumeroSerie = controleNumeroSerie;
	}

	
	public String getDescricaoFaturamento() {
		return this.descricaoFaturamento;
	}

	public void setDescricaoFaturamento(String descricaoFaturamento) {
		this.descricaoFaturamento = descricaoFaturamento;
	}

	
	public String getDescricaoServico() {
		return this.descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	
	public Double getDiametro() {
		return this.diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	
	public Double getDimensaoComprimento() {
		return this.dimensaoComprimento;
	}

	public void setDimensaoComprimento(Double dimensaoComprimento) {
		this.dimensaoComprimento = dimensaoComprimento;
	}

	
	public Double getDimensaoLargura() {
		return this.dimensaoLargura;
	}

	public void setDimensaoLargura(Double dimensaoLargura) {
		this.dimensaoLargura = dimensaoLargura;
	}

	
	public String getEpiObservacapOp() {
		return this.epiObservacapOp;
	}

	public void setEpiObservacapOp(String epiObservacapOp) {
		this.epiObservacapOp = epiObservacapOp;
	}

	
	public Double getEspessura() {
		return this.espessura;
	}

	public void setEspessura(Double espessura) {
		this.espessura = espessura;
	}

	
	public String getExigeFci() {
		return this.exigeFci;
	}

	public void setExigeFci(String exigeFci) {
		this.exigeFci = exigeFci;
	}

	
	public String getExigeRastreabilidade() {
		return this.exigeRastreabilidade;
	}

	public void setExigeRastreabilidade(String exigeRastreabilidade) {
		this.exigeRastreabilidade = exigeRastreabilidade;
	}

	
	public String getFatComplementoOrcamento() {
		return this.fatComplementoOrcamento;
	}

	public void setFatComplementoOrcamento(String fatComplementoOrcamento) {
		this.fatComplementoOrcamento = fatComplementoOrcamento;
	}

	
	public String getKamban() {
		return this.kamban;
	}

	public void setKamban(String kamban) {
		this.kamban = kamban;
	}

	
	public Integer getLeadtime() {
		return this.leadtime;
	}

	public void setLeadtime(Integer leadtime) {
		this.leadtime = leadtime;
	}

	
	public String getLinha() {
		return this.linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	
	public Double getMarkup() {
		return this.markup;
	}

	public void setMarkup(Double markup) {
		this.markup = markup;
	}

	
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
	public Double getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Double perfil) {
		this.perfil = perfil;
	}

	
	public Double getPesoEspecifico() {
		return this.pesoEspecifico;
	}

	public void setPesoEspecifico(Double pesoEspecifico) {
		this.pesoEspecifico = pesoEspecifico;
	}

	
	public String getProdutoNovo() {
		return this.produtoNovo;
	}

	public void setProdutoNovo(String produtoNovo) {
		this.produtoNovo = produtoNovo;
	}

	
	public Double getQuantidadeIdeal() {
		return this.quantidadeIdeal;
	}

	public void setQuantidadeIdeal(Double quantidadeIdeal) {
		this.quantidadeIdeal = quantidadeIdeal;
	}

	
	public Double getVlrMaoObra() {
		return this.vlrMaoObra;
	}

	public void setVlrMaoObra(Double vlrMaoObra) {
		this.vlrMaoObra = vlrMaoObra;
	}

	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	public ProdutoIndMetal getProdutoIndMetal() {
		if(this.produtoIndMetal == null){
			this.produtoIndMetal = new ProdutoIndMetal();
			this.produtoIndMetal.setProdutoInd(this);
		}
		return produtoIndMetal;
	}
	

	public void setProdutoIndMetal(ProdutoIndMetal produtoIndMetal) {		
		this.produtoIndMetal = produtoIndMetal;
	}
	
	

	public ProdutoIndText getProdutoIndText() {
		if(this.produtoIndText == null){
			this.produtoIndText = new ProdutoIndText();
			this.produtoIndText.setProdutoInd(this);
		}
		return produtoIndText;
	}
	

	public void setProdutoIndText(ProdutoIndText produtoIndText) {
		this.produtoIndText = produtoIndText;
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
		ProdutoInd other = (ProdutoInd) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}