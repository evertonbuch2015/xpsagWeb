package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAD_TIPOSERVICO_ITEM database table.
 * 
 */
@Entity
@Table(name="CAD_TIPOSERVICO_ITEM")
@NamedQuery(name="CadTipoServicoItem.findAll", query="SELECT c FROM CadTipoServicoItem c")
public class CadTipoServicoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAD_TIPOSERVICO_ITEM_ID_GENERATOR", 
					   sequenceName="G_CAD_TIPO_SERVICO_ITEM", allocationSize= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAD_TIPOSERVICO_ITEM_ID_GENERATOR")
	@Column(name="COD_CADTIPOSERVICOITEM")
	private Integer id;

	@Column(name="COD_CADCOLABORADOR")
	private int codCadcolaborador;

	@Column(name="COD_CADUNIDADE")
	private int codCadunidade;

	
	@Column(name="LEADTIME")
	private Integer leadtime;

	@Lob
	@Column(name="OBSERVACAO")
	private byte[] observacao;

	
	@Column(name="VALOR")
	private double valor;

	
	//bi-directional many-to-one association to CadTiposervico
	@ManyToOne
	@JoinColumn(name="COD_CADTIPOSERVICO")
	private CadTiposervico tipoServico;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public CadTipoServicoItem() {
	}

	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public int getCodCadcolaborador() {
		return this.codCadcolaborador;
	}

	public void setCodCadcolaborador(int codCadcolaborador) {
		this.codCadcolaborador = codCadcolaborador;
	}

	
	public int getCodCadunidade() {
		return this.codCadunidade;
	}

	public void setCodCadunidade(int codCadunidade) {
		this.codCadunidade = codCadunidade;
	}

	
	public Integer getLeadtime() {
		return this.leadtime;
	}

	public void setLeadtime(Integer leadtime) {
		this.leadtime = leadtime;
	}

	
	public byte[] getObservacao() {
		return this.observacao;
	}

	public void setObservacao(byte[] observacao) {
		this.observacao = observacao;
	}

	
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	public CadTiposervico getTipoServico() {
		return this.tipoServico;
	}

	public void setTipoServico(CadTiposervico tipoServico) {
		this.tipoServico = tipoServico;
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
		CadTipoServicoItem other = (CadTipoServicoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}