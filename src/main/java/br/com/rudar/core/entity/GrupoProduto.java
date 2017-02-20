package br.com.rudar.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CEA_GRUPO")
public class GrupoProduto implements Serializable {
	
	private static final long serialVersionUID = 5236854867248324393L;

	@Id
    @SequenceGenerator(name="G_CEA_GRUPO", sequenceName="\"G_CEA_GRUPO\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CEA_GRUPO")
	@Column(name = "COD_CEAGRUPO")
	private Integer Id;
	
	
	@Column(name = "CEMP", length = 2)
	private String cemp;
	
	@Column(name = "CFIL", length = 2)
	private String filial;
	
	@Column(name = "CODIGO_ESTRUTURAL", length = 30, unique=true)
	private String codigoEstrutural;

	@Column(name = "NOME", length = 30, unique=true)
	private String nome;
	
	@Column(name = "TIPO", length = 1)
	private Character tipo;
	
	
	@Column(name = "MOVIMENTA_ESTOQUE", length = 1)
	private Character movimentaEstoque;
	
	@Column(name = "ESTOQUE_MINIMO_MES")
	private Integer estoqueMinMes;
	
	@Column(name = "ESTOQUE_MINIMO_DIAS")
	private Integer estoqueMinDias;
	
	
	@Column(name = "PERC_PERDA")
	private Double percPerda;
	
	@Column(name = "PERC_VARIACAO")
	private Double percVariacao;
	
	
	@Column(name = "LEADTIME")
	private Integer leadTime;
	
	@Column(name = "MARK_UP")
	private Double markUp;
	
	@Column(name = "MARK_UP_SERVICO")
	private Double markUpServico;
		
	@Column(name = "GRAU")
	private Integer grau;
	
	
	@Column(name = "ENTRA_AUTOMATICO_ESTOQUE", length = 1)
	private Character entraAutoEstoque;
		
	@Column(name = "BAIXA_AUTOMATICO_ESTOQUE", length = 1)
	private Character baixaAutoEstoque;
	
	@Column(name = "GERA_ESTOQUE_NECESSIDADE", length = 1)
	private Character geraEstoqueNecessidade;
	
	@Column(name = "NAO_GERA_SIC_EPI_USAENCOMENDA", length = 1)
	private Character EpiUsaEncomenda;
	
	@Column(name = "NAO_GERA_SIC_EPI_NAOUSAENCOMEN", length = 1)
	private Character EpiNaoUsaEncomenda;
	
	@Column(name = "NAO_USA_CUSTO", length = 1)
	private Character naoUsaCusto;
	
	@Column(name = "AMOSTRA", length = 1)
	private Character amostra;
	
	@Column(name = "TIPO_ANO", length = 1)
	private Character tipoAno;
	
	@Column(name = "MESES", length = 30, unique=true)
	private String meses;
		
	@Column(name = "TIPO_ESTOQUE_MINIMO", length = 1)
	private Character tipoEstoqueMinimo;
	
	@Column(name = "MEDICAMENTO", length = 1)
	private Character medicamento;
	
	@Column(name = "CONTROLA_LOTE", length = 1)
	private Character controlaLote;
	
	
	@Column(name = "PERC_PRECO_REPOSICAO")
	private Double percPrecoReposicao;
	
	
	@Column(name = "REGISTRO_DE_INVENTARIO", length = 1)
	private Character registroInventario;
	
	
	@Column(name = "BAIXA_AUT_ULTIMO_PROCESSO", length = 1)
	private Character baixaAutoUltimoProc;
	
	@Column(name = "FANTASIA", length = 30, unique=true)
	private String fantasia;
	
	@Column(name = "PRODUTO_ACABADO", length = 1)
	private Character produtoAcabado;
	
	@Column(name = "RESUMO_MAT_MOSTRAR_MP", length = 1)
	private Character resumoMatMostrarMp;
	
	@Column(name = "INATIVO", length = 1)
	private Character inativo;	
	
	@Column(name = "TIPO_ITEM_SPED", length = 1)
	private String tipoItemSped;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	
	public String getCemp() {
		return cemp;
	}

	public void setCemp(String cemp) {
		this.cemp = cemp;
	}

	
	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	
	public String getCodigoEstrutural() {
		return codigoEstrutural;
	}

	public void setCodigoEstrutural(String codigoEstrutural) {
		this.codigoEstrutural = codigoEstrutural;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	
	public Character getMovimentaEstoque() {
		return movimentaEstoque;
	}

	public void setMovimentaEstoque(Character movimentaEstoque) {
		this.movimentaEstoque = movimentaEstoque;
	}

	
	public Integer getEstoqueMinMes() {
		return estoqueMinMes;
	}

	public void setEstoqueMinMes(Integer estoqueMinMes) {
		this.estoqueMinMes = estoqueMinMes;
	}

	
	public Integer getEstoqueMinDias() {
		return estoqueMinDias;
	}

	public void setEstoqueMinDias(Integer estoqueMinDias) {
		this.estoqueMinDias = estoqueMinDias;
	}

	
	public Double getPercPerda() {
		return percPerda;
	}

	public void setPercPerda(Double percPerda) {
		this.percPerda = percPerda;
	}

	
	public Double getPercVariacao() {
		return percVariacao;
	}

	public void setPercVariacao(Double percVariacao) {
		this.percVariacao = percVariacao;
	}

	
	public Integer getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
	}

	
	public Double getMarkUp() {
		return markUp;
	}

	public void setMarkUp(Double markUp) {
		this.markUp = markUp;
	}

	
	public Double getMarkUpServico() {
		return markUpServico;
	}

	public void setMarkUpServico(Double markUpServico) {
		this.markUpServico = markUpServico;
	}

	
	public Integer getGrau() {
		return grau;
	}

	public void setGrau(Integer grau) {
		this.grau = grau;
	}

	
	public Character getEntraAutoEstoque() {
		return entraAutoEstoque;
	}

	public void setEntraAutoEstoque(Character entraAutoEstoque) {
		this.entraAutoEstoque = entraAutoEstoque;
	}

	
	public Character getBaixaAutoEstoque() {
		return baixaAutoEstoque;
	}

	public void setBaixaAutoEstoque(Character baixaAutoEstoque) {
		this.baixaAutoEstoque = baixaAutoEstoque;
	}

	
	public Character getGeraEstoqueNecessidade() {
		return geraEstoqueNecessidade;
	}

	public void setGeraEstoqueNecessidade(Character geraEstoqueNecessidade) {
		this.geraEstoqueNecessidade = geraEstoqueNecessidade;
	}

	
	public Character getEpiUsaEncomenda() {
		return EpiUsaEncomenda;
	}

	public void setEpiUsaEncomenda(Character epiUsaEncomenda) {
		EpiUsaEncomenda = epiUsaEncomenda;
	}

	
	public Character getEpiNaoUsaEncomenda() {
		return EpiNaoUsaEncomenda;
	}

	public void setEpiNaoUsaEncomenda(Character epiNaoUsaEncomenda) {
		EpiNaoUsaEncomenda = epiNaoUsaEncomenda;
	}

	
	public Character getNaoUsaCusto() {
		return naoUsaCusto;
	}

	public void setNaoUsaCusto(Character naoUsaCusto) {
		this.naoUsaCusto = naoUsaCusto;
	}

	
	public Character getAmostra() {
		return amostra;
	}

	public void setAmostra(Character amostra) {
		this.amostra = amostra;
	}

	
	public Character getTipoAno() {
		return tipoAno;
	}

	public void setTipoAno(Character tipoAno) {
		this.tipoAno = tipoAno;
	}

	
	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	
	public Character getTipoEstoqueMinimo() {
		return tipoEstoqueMinimo;
	}

	public void setTipoEstoqueMinimo(Character tipoEstoqueMinimo) {
		this.tipoEstoqueMinimo = tipoEstoqueMinimo;
	}

	
	public Character getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Character medicamento) {
		this.medicamento = medicamento;
	}

	
	public Character getControlaLote() {
		return controlaLote;
	}

	public void setControlaLote(Character controlaLote) {
		this.controlaLote = controlaLote;
	}

	
	public Double getPercPrecoReposicao() {
		return percPrecoReposicao;
	}

	public void setPercPrecoReposicao(Double percPrecoReposicao) {
		this.percPrecoReposicao = percPrecoReposicao;
	}

	
	public Character getRegistroInventario() {
		return registroInventario;
	}

	public void setRegistroInventario(Character registroInventario) {
		this.registroInventario = registroInventario;
	}

	
	public Character getBaixaAutoUltimoProc() {
		return baixaAutoUltimoProc;
	}

	public void setBaixaAutoUltimoProc(Character baixaAutoUltimoProc) {
		this.baixaAutoUltimoProc = baixaAutoUltimoProc;
	}

	
	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	
	public Character getProdutoAcabado() {
		return produtoAcabado;
	}

	public void setProdutoAcabado(Character produtoAcabado) {
		this.produtoAcabado = produtoAcabado;
	}

	
	public Character getResumoMatMostrarMp() {
		return resumoMatMostrarMp;
	}

	public void setResumoMatMostrarMp(Character resumoMatMostrarMp) {
		this.resumoMatMostrarMp = resumoMatMostrarMp;
	}

	
	public Character getInativo() {
		return inativo;
	}

	public void setInativo(Character inativo) {
		this.inativo = inativo;
	}

	
	public String getTipoItemSped() {
		return tipoItemSped;
	}

	public void setTipoItemSped(String tipoItemSped) {
		this.tipoItemSped = tipoItemSped;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoProduto other = (GrupoProduto) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}	
}
