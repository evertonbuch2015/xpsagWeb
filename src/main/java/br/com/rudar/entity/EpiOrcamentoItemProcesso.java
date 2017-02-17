package br.com.rudar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EPI_ORCAMENTO_ITEM_PROCESSO database table.
 * 
 */
@Entity
@Table(name="EPI_ORCAMENTO_ITEM_PROCESSO")
@NamedQuery(name="EpiOrcamentoItemProcesso.findAll", query="SELECT e FROM EpiOrcamentoItemProcesso e")
public class EpiOrcamentoItemProcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_EPIORCAMENTOITEMPROCESSO")
	private Integer id;

	@Column(name="COD_EPIGRUPOMAQUINA")
	private int codEpigrupomaquina;

	@Column(name="CUSTO_MINUTO")
	private BigDecimal custoMinuto;

	private String descricao;

	private int item;

	private int processo;

	@Column(name="TEMPO_EXECUCAO")
	private BigDecimal tempoExecucao;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to EpiOrcamentoItem
	@ManyToOne
	@JoinColumn(name="COD_EPIORCAMENTOITEM")
	private EpiOrcamentoItem epiOrcamentoItem;

	
	
	//--------------------------------	GETs and SETs------------------------------//
	
	public EpiOrcamentoItemProcesso() {
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public int getCodEpigrupomaquina() {
		return this.codEpigrupomaquina;
	}

	public void setCodEpigrupomaquina(int codEpigrupomaquina) {
		this.codEpigrupomaquina = codEpigrupomaquina;
	}

	public BigDecimal getCustoMinuto() {
		return this.custoMinuto;
	}

	public void setCustoMinuto(BigDecimal custoMinuto) {
		this.custoMinuto = custoMinuto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getItem() {
		return this.item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getProcesso() {
		return this.processo;
	}

	public void setProcesso(int processo) {
		this.processo = processo;
	}

	public BigDecimal getTempoExecucao() {
		return this.tempoExecucao;
	}

	public void setTempoExecucao(BigDecimal tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public EpiOrcamentoItem getEpiOrcamentoItem() {
		return this.epiOrcamentoItem;
	}

	public void setEpiOrcamentoItem(EpiOrcamentoItem epiOrcamentoItem) {
		this.epiOrcamentoItem = epiOrcamentoItem;
	}

}