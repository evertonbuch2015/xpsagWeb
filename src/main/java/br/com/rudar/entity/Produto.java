package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CAD_PRODUTO")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -4327127418545137030L;


	@Id
    @SequenceGenerator(name="G_CAD_PRODUTO", sequenceName="\"G_CAD_PRODUTO\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_PRODUTO")
	@Column(name = "COD_CADPRODUTO")
	private Integer Id;
	
	
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "CEMP", length = 2)
	private String cemp;
	
	
	@Column(name = "NOME", length = 60)
	private String nome;
	
	//true = ATIVO(N)		false = INATIVO(I)
	@Column(name = "SITUACAO", length = 1)
	private Character situacao;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="COD_CADUNIDADE")
	private Unidade unidade;
	
	
	@ManyToOne
	@JoinTable(name="CAD_PRODUTO_FATOPESAIDA", joinColumns={@JoinColumn(name="COD_CADPRODUTO", referencedColumnName="COD_CADPRODUTO")}, 
										 inverseJoinColumns={@JoinColumn(name="COD_FATOPERACAOSAIDA", referencedColumnName="COD_FATOPERACAOSAIDA")})
    private OperacaoSaida operacaoSaida;
 
	
	//--------------------------------	GETs and SETs------------------------------//
	
	
	public OperacaoSaida getOperacaoSaida() {
		return operacaoSaida;
	}
	
	public void setOperacaoSaida(OperacaoSaida operacaoSaida) {
		this.operacaoSaida = operacaoSaida;
	}
	
	
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

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Boolean getSituacao() {
		if(this.situacao == null) return null;
		
		return situacao.equals("N") ? Boolean.TRUE : Boolean.TRUE;
	}

	public void setSituacao(Boolean value) {
		if(value == null){ 
			this.situacao = null;
		}else{
			this.situacao = value == true ? 'N' : 'I';
		}
	}

	
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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
		Produto other = (Produto) obj;
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