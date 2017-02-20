package br.com.rudar.core.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.rudar.core.enumerated.TipoPessoa;


@Entity
@Table(name = "CAD_PESSOA")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = -2421597500632383633L;


	@Id
    @SequenceGenerator(name="G_CAD_PESSOA", sequenceName="\"G_CAD_PESSOA\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PESSOA")
	@Column(name = "CODIGO_PESSOA")
	private Integer Id;
	
	
	@Column(name = "NOME" , length = 70)
	private String nome;
	
	
	@Column(name = "CEMP" , length = 2)
	private String cemp;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;
	
	
	@Column(name = "INATIVO", length = 1)
	private Character inativo;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO", length = 1)
	private TipoPessoa tipo;
	
	
	@Column(name = "UTILIZAR_FANTASIA", length = 1)
	private Character utilizarFantasia;
	
	
	@Column(name = "DOCUMENTO" , length = 20)
	private String documento;
	
	
	@Column(name = "EMAIL" , length = 100)
	private String email;
		
	
	@Column(name = "HPAG" , length = 100)
	private String site;
	
	
	@Column(name = "CONTATO" , length = 50)
	private String contato;

	
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

	
	public String getCemp() {
		return cemp;
	}

	public void setCemp(String cemp) {
		this.cemp = cemp;
	}
	
	
	
	public String getDataCadastroFormatada() {
		if(this.dataCadastro != null){
			return new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
		}else{
			return null;
		}
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}
	

	
	public String getDocumento() {
		return this.documento;
	}

	public String getDocumentoFormatado(){
		switch (this.tipo) {
		case C:
			return 	documento.substring(0, 9)+ "/" + documento.substring(9);
		case J:
			return 	documento.substring(0, 2) + "." + documento.substring(2, 5) + "." + documento.substring(5, 8)
						+ "/" + documento.substring(8,12) +"-"+ documento.substring(12);
		case F:
			return 	documento.substring(0, 3) + "." + documento.substring(3, 6) + "." + documento.substring(6, 9)
						 +"-"+ documento.substring(9);
		case V:
			return 	documento.substring(0, 2) + "." + documento.substring(2, 5) + "." + documento.substring(5, 8)
					+ "/" + documento.substring(8,12) +"-"+ documento.substring(12);
		case E:
			return this.documento;
		}	
		return null;
	}
	
	public void setDocumento(String documento) {
		if(documento != null){
			this.documento = documento.replace(".", "")
					.replace("-", "").replace("/", "");			
		}
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
	
	//Métodos Modificados
	
	public Boolean getInativo() {
		if(this.inativo == null) return null;
		
		return inativo.equals("S") ? true : false;
	}

	public void setInativo(Boolean value) {
		if(value == null){ 
			this.inativo = null;
		}else{
			this.inativo = value == true ? 'S' : 'N';
		}
	}
	
	public Boolean getUtilizarFantasia() {
		if(this.utilizarFantasia == null) return null;
		
		return utilizarFantasia.equals("S") ? true : false;
	}

	public void setUtilizarFantasia(Boolean value) {
		if(value == null){ 
			this.utilizarFantasia = null;
		}else{
			this.utilizarFantasia = value == true ? 'S' : 'N';
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
		Pessoa other = (Pessoa) obj;
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
