package br.com.rudar.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the CAD_TIPOSERVICO_ITEM database table.
 * 
 */
@Entity
@Table(name="CAD_TIPOSERVICO_ITEM")
@NamedQuery(name="TipoServicoItem.findAll", query="SELECT c FROM TipoServicoItem c")
public class TipoServicoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_CAD_TIPO_SERVICO_ITEM", 
					   sequenceName="G_CAD_TIPO_SERVICO_ITEM", allocationSize= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_TIPO_SERVICO_ITEM")
	@Column(name="COD_CADTIPOSERVICOITEM")
	private Integer id;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CADCOLABORADOR")
	private Colaborador colaborador;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CADUNIDADE")
	private Unidade unidade;

	
	@Column(name="LEADTIME")
	private Integer leadtime;

	@Lob
	@Column(name="OBSERVACAO")
	private byte[] observacao;

	
	@Column(name="VALOR")
	private Double valor;

	
	//bi-directional many-to-one association to Tiposervico
	@ManyToOne
	@JoinColumn(name="COD_CADTIPOSERVICO")
	private TipoServico tipoServico;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public TipoServicoItem() {
	}

	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	
	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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

	
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	public TipoServico getTipoServico() {
		return this.tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
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
		TipoServicoItem other = (TipoServicoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}