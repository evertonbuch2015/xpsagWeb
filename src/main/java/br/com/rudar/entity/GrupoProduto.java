package br.com.rudar.entity;

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
}
