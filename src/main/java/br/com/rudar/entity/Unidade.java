package br.com.rudar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CAD_UNIDADE")
public class Unidade implements Serializable {
	
	private static final long serialVersionUID = 2162699180089090221L;


	@Id
    @SequenceGenerator(name="G_CAD_UNIDADE", sequenceName="\"G_CAD_UNIDADE\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_UNIDADE")
	@Column(name = "COD_CADUNIDADE")
	private Integer Id;
	
	
	@Column(name = "NOME" , length = 60)
	private String nome;
	
	
	@Column(name = "SIGLA" , length = 3)
	private Character sigla;
	
	
	@Column(name = "SITUACAO" , length = 1)
	private Character situacao;
	
	
	@Column(name = "CASA_DECIMAL" , length = 1)
	private Character casaDecimal;
	
	
	//--------------------------------	GETs and SETs------------------------------//
	
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	public Character getSigla() {
		return sigla;
	}
	
	public void setSigla(Character sigla) {
		this.sigla = sigla;
	}

	
	
	//Métodos Modificados
	public Boolean getSituacao() {
		if(this.situacao == null) return null;
		
		return situacao.equals("A") ? Boolean.TRUE : Boolean.TRUE;
	}
	
	public void setSituacao(Boolean value) {
		if(value == null){ 
			this.situacao = null;
		}else{
			this.situacao = value == true ? 'A' : 'I';
		}
	}

	
	
	public Boolean getCasaDecimal() {
		if(this.casaDecimal == null) return null;
		
		return casaDecimal.equals("S") ? Boolean.TRUE : Boolean.TRUE;
	}
	
	public void setCasaDecimal(Boolean value) {
		if(value == null){ 
			this.casaDecimal = null;
		}else{
			this.casaDecimal = value == true ? 'S' : 'N';
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
		Unidade other = (Unidade) obj;
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