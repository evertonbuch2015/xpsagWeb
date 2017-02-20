package br.com.rudar.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the V_END_CEPNUMEROS database table.
 * 
 */
@Entity
@Table(name="V_END_CEPNUMEROS")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODIGO_CEPNUMERO")
	private Integer codigoCepnumero;
	
	@Column(name="BAIRRO")
	private String bairro;

	@Column(name="CEP")
	private Integer cep;

	@Column(name="CIDADE")
	private String cidade;

	@Column(name="CODIGO_PAIS")
	private Integer codigoPais;

	@Column(name="ENDERECO")
	private String endereco;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="LGR")
	private String lgr;

	
	@Column(name="NOME_PAIS")
	private String nomePais;

	@Column(name="UF")
	private String uf;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Endereco() {
	}

	

	public Integer getCodigoCepnumero() {
		return this.codigoCepnumero;
	}

	public void setCodigoCepnumero(Integer codigoCepnumero) {
		this.codigoCepnumero = codigoCepnumero;
	}
	
	
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
	public Integer getCep() {
		return this.cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	public Integer getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public String getLgr() {
		return this.lgr;
	}

	public void setLgr(String lgr) {
		this.lgr = lgr;
	}

	
	public String getNomePais() {
		return this.nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	
	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}



	
	
	@Override
	public String toString() {
		return "Endereco [codigoCepnumero=" + codigoCepnumero + ", bairro=" + bairro + ", cep=" + cep + ", cidade="
				+ cidade + ", codigoPais=" + codigoPais + ", endereco=" + endereco + ", estado=" + estado + ", lgr="
				+ lgr + ", nomePais=" + nomePais + ", uf=" + uf + "]";
	}

	
	
}