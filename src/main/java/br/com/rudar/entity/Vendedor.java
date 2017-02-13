package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CAD_VENDEDOR")
public class Vendedor implements Serializable {

	private static final long serialVersionUID = -8016908923732717386L;



	@Id
    @SequenceGenerator(name="G_CAD_VENDEDOR", sequenceName="\"G_CAD_VENDEDOR\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_VENDEDOR")
	@Column(name = "COD_CADVENDEDOR")
	private Integer Id;
	
	
	
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "CEMP", length = 2)
	private String cemp;
	
	@Column(name = "FANTASIA" , length = 60)
	private String fantasia;
	
	
	
	@Column(name = "PERC_COMISSAO_SERVICO")
	private Double percComissaoServico;
	
	@Column(name = "PERC_COMISSAO_PRODUTO")
	private Double percComissaoProduto;
	
	@Column(name = "PERC_COMISSAO_GERENTE")
	private Double percComissaoGerente;
	
	
	
	@Column(name = "PFON" , length = 2)
	private Character prefixoFone;
	
	@Column(name = "NFON" , length = 15)
	private String numeroFone;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="CODIGO_PESSOA")
	private Pessoa pessoa;


	
	//--------------------------------	GETs and SETs------------------------------//
	
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	

	public Double getPercComissaoServico() {
		return percComissaoServico;
	}

	public void setPercComissaoServico(Double percComissaoServico) {
		this.percComissaoServico = percComissaoServico;
	}

	

	public Double getPercComissaoProduto() {
		return percComissaoProduto;
	}

	public void setPercComissaoProduto(Double percComissaoProduto) {
		this.percComissaoProduto = percComissaoProduto;
	}

	

	public Double getPercComissaoGerente() {
		return percComissaoGerente;
	}

	public void setPercComissaoGerente(Double percComissaoGerente) {
		this.percComissaoGerente = percComissaoGerente;
	}

	

	public Character getPrefixoFone() {
		return prefixoFone;
	}

	public void setPrefixoFone(Character prefixoFone) {
		this.prefixoFone = prefixoFone;
	}

	

	public String getNumeroFone() {
		return numeroFone;
	}

	public void setNumeroFone(String numeroFone) {
		this.numeroFone = numeroFone;
	}


	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Vendedor other = (Vendedor) obj;
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
