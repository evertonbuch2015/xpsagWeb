package br.com.rudar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the EPI_GRUPO_MAQUINA database table.
 * 
 */
@Entity
@Table(name="EPI_GRUPO_MAQUINA")
@NamedQuery(name="GrupoMaquina.findAll", query="SELECT g FROM GrupoMaquina g")
public class GrupoMaquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="G_EPI_GRUPO_MAQUINA", sequenceName="G_EPI_GRUPO_MAQUINA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_EPI_GRUPO_MAQUINA")
	@Column(name="COD_EPIGRUPOMAQUINA")
	private Integer id;

	private String cemp;

	private Integer codigo;


	private String nome;
	
	private Character situacao;
	
	
	@Column(name="HORAS_TRABALHADAS")
	private Double horasTrabalhadas;

	@Column(name="INICIA_FINALIZA_PREPARACAO")
	private Integer iniciaFinalizaPreparacao;

	@Column(name="INICIA_FINALIZA_TEMPO")
	private Integer iniciaFinalizaTempo;

	@Column(name="MARK_UP")
	private Double markUp;

	@Column(name="MARK_UP_SERVICO")
	private Double markUpServico;

	@Column(name="NAO_MOV_COD_BARRA")
	private Character naoMovCodBarra;

	@Column(name="NAO_OBRIGA_MOV_COD_BARRA")
	private Character naoObrigaMovCodBarra;


	@Column(name="PERCENTUAL_EFICIENCIA")
	private Double percentualEficiencia;

	@Column(name="PERCENTUAL_OCUPACAO_MAQDISP")
	private Integer percentualOcupacaoMaqdisp;

	@Column(name="PERCENTUAL_TEMPO")
	private Double percentualTempo;

	@Column(name="QUANTIDADE_MAQUINAS")
	private Integer quantidadeMaquinas;

	@Column(name="QUANTIDADE_TURNOS")
	private Integer quantidadeTurnos;

	@Column(name="TEMPO_ESPERA")
	private Double tempoEspera;

	@Column(name="TEMPO_PREPARACAO")
	private Integer tempoPreparacao;

	@Column(name="TEMPO_PREPARACAO_CENTROCUSTO")
	private Double tempoPreparacaoCentrocusto;

	
	
	private Character terceirizado;

	@Column(name="USAR_BALANCA")
	private Character usarBalanca;

	@Column(name="VALOR_CUSTO_MINUTO")
	private Double valorCustoMinuto;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public GrupoMaquina() {
	}

	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getCemp() {
		return this.cemp;
	}

	public void setCemp(String cemp) {
		this.cemp = cemp;
	}


	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	public Double getHorasTrabalhadas() {
		return this.horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	
	public Integer getIniciaFinalizaPreparacao() {
		return this.iniciaFinalizaPreparacao;
	}

	public void setIniciaFinalizaPreparacao(Integer iniciaFinalizaPreparacao) {
		this.iniciaFinalizaPreparacao = iniciaFinalizaPreparacao;
	}

	
	public Integer getIniciaFinalizaTempo() {
		return this.iniciaFinalizaTempo;
	}

	public void setIniciaFinalizaTempo(Integer iniciaFinalizaTempo) {
		this.iniciaFinalizaTempo = iniciaFinalizaTempo;
	}

	
	public Double getMarkUp() {
		return this.markUp;
	}

	public void setMarkUp(Double markUp) {
		this.markUp = markUp;
	}

	
	public Double getMarkUpServico() {
		return this.markUpServico;
	}

	public void setMarkUpServico(Double markUpServico) {
		this.markUpServico = markUpServico;
	}

	
	public Character getNaoMovCodBarra() {
		return this.naoMovCodBarra;
	}

	public void setNaoMovCodBarra(Character naoMovCodBarra) {
		this.naoMovCodBarra = naoMovCodBarra;
	}

	
	public Character getNaoObrigaMovCodBarra() {
		return this.naoObrigaMovCodBarra;
	}

	public void setNaoObrigaMovCodBarra(Character naoObrigaMovCodBarra) {
		this.naoObrigaMovCodBarra = naoObrigaMovCodBarra;
	}

	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Double getPercentualEficiencia() {
		return this.percentualEficiencia;
	}

	public void setPercentualEficiencia(Double percentualEficiencia) {
		this.percentualEficiencia = percentualEficiencia;
	}

	
	public Integer getPercentualOcupacaoMaqdisp() {
		return this.percentualOcupacaoMaqdisp;
	}

	public void setPercentualOcupacaoMaqdisp(Integer percentualOcupacaoMaqdisp) {
		this.percentualOcupacaoMaqdisp = percentualOcupacaoMaqdisp;
	}

	
	public Double getPercentualTempo() {
		return this.percentualTempo;
	}

	public void setPercentualTempo(Double percentualTempo) {
		this.percentualTempo = percentualTempo;
	}

	
	public Integer getQuantidadeMaquinas() {
		return this.quantidadeMaquinas;
	}

	public void setQuantidadeMaquinas(Integer quantidadeMaquinas) {
		this.quantidadeMaquinas = quantidadeMaquinas;
	}

	
	public Integer getQuantidadeTurnos() {
		return this.quantidadeTurnos;
	}

	public void setQuantidadeTurnos(Integer quantidadeTurnos) {
		this.quantidadeTurnos = quantidadeTurnos;
	}

	
	public Character getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	
	public Double getTempoEspera() {
		return this.tempoEspera;
	}

	public void setTempoEspera(Double tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	
	public Integer getTempoPreparacao() {
		return this.tempoPreparacao;
	}

	public void setTempoPreparacao(Integer tempoPreparacao) {
		this.tempoPreparacao = tempoPreparacao;
	}

	
	public Double getTempoPreparacaoCentrocusto() {
		return this.tempoPreparacaoCentrocusto;
	}

	public void setTempoPreparacaoCentrocusto(Double tempoPreparacaoCentrocusto) {
		this.tempoPreparacaoCentrocusto = tempoPreparacaoCentrocusto;
	}

	
	public Character getTerceirizado() {
		return this.terceirizado;
	}

	public void setTerceirizado(Character terceirizado) {
		this.terceirizado = terceirizado;
	}

	
	public Character getUsarBalanca() {
		return this.usarBalanca;
	}

	public void setUsarBalanca(Character usarBalanca) {
		this.usarBalanca = usarBalanca;
	}

	
	public Double getValorCustoMinuto() {
		return this.valorCustoMinuto;
	}

	public void setValorCustoMinuto(Double valorCustoMinuto) {
		this.valorCustoMinuto = valorCustoMinuto;
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
		GrupoMaquina other = (GrupoMaquina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}