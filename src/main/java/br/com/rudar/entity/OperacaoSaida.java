package br.com.rudar.entity;

import java.io.Serializable;
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


@Entity
@Table(name = "FAT_OPERACAO_SAIDA")
public class OperacaoSaida implements Serializable {
	
	private static final long serialVersionUID = -35613185238217636L;


	@Id
    @SequenceGenerator(name="G_FAT_OPERACAO_SAIDA", sequenceName="\"G_FAT_OPERACAO_SAIDA\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_FAT_OPERACAO_SAIDA")
	@Column(name = "COD_FATOPERACAOSAIDA")
	private Integer Id;
	
	
	@Column(name = "NOME", length = 60)
	private String nome;
	
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
	
	
	@OneToMany(mappedBy = "operacaoSaida", targetEntity = Produto.class, 
			fetch = FetchType.LAZY,	cascade = CascadeType.ALL)
    private List<Produto> produtos;
	
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
		OperacaoSaida other = (OperacaoSaida) obj;
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