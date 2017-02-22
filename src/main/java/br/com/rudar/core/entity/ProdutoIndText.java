package br.com.rudar.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the CAD_PRODUTO_IND_TEXT database table.
 * 
 */
@Entity
@Table(name="CAD_PRODUTO_IND_TEXT")
public class ProdutoIndText implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_CAD_PRODUTOINDTEXT", sequenceName="G_CAD_PRODUTOINDTEXT",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PRODUTOINDTEXT")
	@Column(name="COD_CADPRODUTOINDTEXT")
	private Integer id;

	
	@Column(name="APROVADO")
	private Character aprovado;

	@Column(name="COMPOSICAO")
	private String composicao;

	@Column(name="CONE_POR_EMBALAGEM")
	private Integer conePorEmbalagem;

	@Column(name="COR")
	private String cor;

	
	@Column(name="COR_CONE")
	private String corCone;

	@Column(name="MOVIMENTA_UND_POR_EMBALAGEM")
	private Character movimentaUndPorEmbalagem;

	@Column(name="PESO_MAXIMO")
	private Double pesoMaximo;

	@Column(name="PESO_MINIMO")
	private Double pesoMinimo;

	@Column(name="QUALIDADE")
	private String qualidade;

	@Column(name="SEM_ETIQUETA_DE_CONE")
	private Character semEtiquetaDeCone;

	@Column(name="TARA")
	private Double tara;

	
	
	//bi-directional one-to-one association to ProdutoInd
	@OneToOne
	@JoinColumn(name="COD_CADPRODUTOIND")
	private ProdutoInd produtoInd;
	
	
	//--------------------------------	METODOS CONSTRUTORES -----------------------//
	
	public ProdutoIndText() {
	}

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Character getAprovado() {
		return this.aprovado;
	}

	public void setAprovado(Character aprovado) {
		this.aprovado = aprovado;
	}

	
	public String getComposicao() {
		return this.composicao;
	}

	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}

	
	public Integer getConePorEmbalagem() {
		return this.conePorEmbalagem;
	}

	public void setConePorEmbalagem(Integer conePorEmbalagem) {
		this.conePorEmbalagem = conePorEmbalagem;
	}

	
	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	
	public String getCorCone() {
		return this.corCone;
	}

	public void setCorCone(String corCone) {
		this.corCone = corCone;
	}

	
	public Character getMovimentaUndPorEmbalagem() {
		return this.movimentaUndPorEmbalagem;
	}

	public void setMovimentaUndPorEmbalagem(Character movimentaUndPorEmbalagem) {
		this.movimentaUndPorEmbalagem = movimentaUndPorEmbalagem;
	}

	
	public Double getPesoMaximo() {
		return this.pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	
	public Double getPesoMinimo() {
		return this.pesoMinimo;
	}

	public void setPesoMinimo(Double pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	
	public String getQualidade() {
		return this.qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	
	public Character getSemEtiquetaDeCone() {
		return this.semEtiquetaDeCone;
	}

	public void setSemEtiquetaDeCone(Character semEtiquetaDeCone) {
		this.semEtiquetaDeCone = semEtiquetaDeCone;
	}

	
	public Double getTara() {
		return this.tara;
	}

	public void setTara(Double tara) {
		this.tara = tara;
	}

	
	public ProdutoInd getProdutoInd() {
		return this.produtoInd;
	}

	public void setProdutoInd(ProdutoInd produtoInd) {
		this.produtoInd = produtoInd;
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
		ProdutoIndText other = (ProdutoIndText) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}