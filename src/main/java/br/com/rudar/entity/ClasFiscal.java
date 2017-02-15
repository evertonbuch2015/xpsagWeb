package br.com.rudar.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the CAD_CLAS_FISCAL database table.
 * 
 */
@Entity
@Table(name="CAD_CLAS_FISCAL")
public class ClasFiscal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_CAD_CLAS_FISCAL", sequenceName="G_CAD_CLAS_FISCAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_CLAS_FISCAL")
	@Column(name="COD_CADCLASFISCAL")
	private Integer id;

	@Column(name="CODIGO")
	private Integer codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="COD_CADCLASFISCAL")
	@OneToMany(mappedBy = "clasFiscal", targetEntity = ClasFiscalItem.class, 
			fetch = FetchType.LAZY,	cascade = CascadeType.ALL)
	private List<ClasFiscalItem> clasFiscalItems;
	
	
	//--------------------------------	GETs and SETs------------------------------//
	
	public ClasFiscal() {
	}

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public List<ClasFiscalItem> getClasFiscalItems() {
		if(this.clasFiscalItems == null){
			this.clasFiscalItems = new ArrayList<ClasFiscalItem>();
		}
		return clasFiscalItems;
	}
	
	public void setClasFiscalItems(List<ClasFiscalItem> clasFiscalItems) {
		this.clasFiscalItems = clasFiscalItems;
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
		ClasFiscal other = (ClasFiscal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}