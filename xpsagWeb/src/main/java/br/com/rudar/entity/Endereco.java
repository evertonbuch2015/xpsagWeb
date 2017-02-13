package br.com.rudar.entity;

import java.io.Serializable;

/**
 *
 * @author Everton Buchkorn de Souza
 */

//@Entity
//@Table(name = "cad_endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -7585137494415340262L;

	//@Id
	//@SequenceGenerator(name = "seq_cad_endereco_id", sequenceName = "\"seq_cad_endereco_id\"", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cad_endereco_id")
	//@Column(name = "id_endereco")
	private Integer idEndereco;

	//@Column(name = "logradouro", length = 50, nullable = true)
	private String logradouro;

	//@NotEmpty(message="O endereço deve ser informado!")
	//@Column(name = "rua", length = 100, nullable = true)
	private String rua;


	//@Column(name = "numero", nullable = true)
	private Integer numero;

	//@Column(name = "complemento", length = 50, nullable = true)
	private String complemento;

	//@Column(name = "bairro", length = 50, nullable = true)
	private String bairro;

	//@NotEmpty(message="Informe o CEP!")
	//@Column(name = "cep", length = 50, nullable = true)
	private String cep;


	//@Column(name = "estado", length = 2)
	private String estado;

	//@NotEmpty(message="A cidade deve ser informada!")
	//@Column(name = "cidade", length = 50, nullable = true)
	private String cidade;

	//@Column(name = "pais", length = 20, nullable = true)
	private String pais;

	//@Column(name = "codigo_municipio", nullable = true)
	private Integer codigoMunicipio;

	// -------------------------------------------------

	public Endereco() {
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.replace("-", "");
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(Integer codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return rua +", "+ numero+" - "+cidade+"-"+estado;
	}

}
