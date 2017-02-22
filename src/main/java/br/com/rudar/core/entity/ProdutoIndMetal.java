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
 * The persistent class for the CAD_PRODUTO_IND_METAL database table.
 * 
 */
@Entity
@Table(name="CAD_PRODUTO_IND_METAL")
public class ProdutoIndMetal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_CAD_PRODUTOINDMETAL", sequenceName="G_CAD_PRODUTOINDMETAL",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PRODUTOINDMETAL")
	@Column(name="COD_CADPRODUTOINDMETAL")
	private Integer id;

	@Column(name="BARRA_QUADRADO")
	private Double barraQuadrado;

	@Column(name="BARRA_RETANGULARX")
	private Double barraRetangularx;

	@Column(name="BARRA_RETANGULARY")
	private Double barraRetangulary;

	
	
	//bi-directional one-to-one association to ProdutoInd
	@OneToOne
	@JoinColumn(name="COD_CADPRODUTOIND")
	private ProdutoInd produtoInd;

	//--------------------------------	METODOS CONSTRUTORES -----------------------//
	
	public ProdutoIndMetal() {
	}

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Double getBarraQuadrado() {
		return this.barraQuadrado;
	}

	public void setBarraQuadrado(Double barraQuadrado) {
		this.barraQuadrado = barraQuadrado;
	}

	
	public Double getBarraRetangularx() {
		return this.barraRetangularx;
	}

	public void setBarraRetangularx(Double barraRetangularx) {
		this.barraRetangularx = barraRetangularx;
	}

	
	public Double getBarraRetangulary() {
		return this.barraRetangulary;
	}

	public void setBarraRetangulary(Double barraRetangulary) {
		this.barraRetangulary = barraRetangulary;
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
		ProdutoIndMetal other = (ProdutoIndMetal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}