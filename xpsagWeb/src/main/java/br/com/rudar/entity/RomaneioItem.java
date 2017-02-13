package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "FAT_ROMANEIO_PAO_ITEM")
public class RomaneioItem implements Serializable {

	private static final long serialVersionUID = 1164766338027159492L;


	@Id
    @SequenceGenerator(name="G_FAT_ROMANEIO_PAO_ITEM", sequenceName="\"G_FAT_ROMANEIO_PAO_ITEM\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_FAT_ROMANEIO_PAO_ITEM")
	@Column(name = "COD_FATROMANEIOPAOITEM")
	private Integer Id;
	
	
	@Column(name = "ITEM")
	private Integer item;
	
	@Column(name = "QUANTIDADE")
	private Double quantidade;
	
	@Column(name = "VALOR_UNITARIO")
	private Double valorUnitario;
	
	
	@Column(name = "QUANTIDADE_TROCA")
	private Double quantidadeTroca;
	

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="COD_CADPRODUTO")
	private Produto produto;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="COD_CADUNIDADE")
	private Unidade unidade;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="COD_FATOPERACAOSAIDA")
	private OperacaoSaida operacaoSaida;
	
	
	@ManyToOne
	@JoinColumn(name= "COD_FATROMANEIOPAO")
	private Romaneio romaneio;


	//--------------------------------	GETs and SETs------------------------------//
	
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}


	
	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}


	
	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}


	
	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	
	public Double getQuantidadeTroca() {
		return quantidadeTroca;
	}

	public void setQuantidadeTroca(Double quantidadeTroca) {
		this.quantidadeTroca = quantidadeTroca;
	}

	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}


	
	public OperacaoSaida getOperacaoSaida() {
		return operacaoSaida;
	}

	public void setOperacaoSaida(OperacaoSaida operacaoSaida) {
		this.operacaoSaida = operacaoSaida;
	}


	
	public Romaneio getRomaneio() {
		return romaneio;
	}

	public void setRomaneio(Romaneio romaneio) {
		this.romaneio = romaneio;
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
		RomaneioItem other = (RomaneioItem) obj;
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
