package br.com.rudar.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.rudar.enumerated.TipoFrete;

@Entity
@Table(name = "FAT_ROMANEIO_PAO")
public class Romaneio implements Serializable{
	
	private static final long serialVersionUID = 7946040661061518085L;


	@Id
    @SequenceGenerator(name="G_FAT_ROMANEIO_PAO", sequenceName="\"G_FAT_ROMANEIO_PAO\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_FAT_ROMANEIO_PAO")
	@Column(name = "COD_FATROMANEIOPAO")
	private Integer id;
	
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "CEMP", length = 2)
	private String cemp;
	
	@Column(name = "CFIL", length = 2)
	private String filial;
	
		
	@Column(name = "COD_FATPEDIDO")
	private Integer codigoPedido;
	
	@Column(name = "CODIGO_OC_CLIENTE", length = 20)
	private String codigoOcCliente;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_FRETE", length = 1)
	private TipoFrete tipoFrete;
	
		
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_EMISSAO")
	private Date dataEmissao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ENTREGA")
	private Date dataEntrega;

	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name ="COD_CADCONDPAGAMENTO")
	private CondicaoPagamento condicaoPagamento;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name ="COD_CADVENDEDOR")
	private Vendedor vendedor;
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="COD_CADCOLABORADOR")
	private Colaborador colaborador;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name ="COD_CADENTREGADOR")
	private Colaborador entregador;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name ="COD_CADTRANSPORTADORA")
	private Colaborador transportadora;
	
	
	@OneToMany(mappedBy = "romaneio", targetEntity = RomaneioItem.class, 
			fetch = FetchType.LAZY,	cascade = CascadeType.ALL)
	private List<RomaneioItem> romaneioItens;


	//--------------------------------	GETs and SETs------------------------------//
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	
	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	

	public Integer getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Integer codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	
	
	public String getCodigoOcCliente() {
		return codigoOcCliente;
	}

	public void setCodigoOcCliente(String codigoOcCliente) {
		this.codigoOcCliente = codigoOcCliente;
	}


	
	public TipoFrete getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(TipoFrete tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	
	
	public String getDataEmissaoFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataEmissao);
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	public String getDataEntregaFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataEntrega);
	}
	
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}


	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


	
	public Colaborador getEntregador() {
		return entregador;
	}

	public void setEntregador(Colaborador entregador) {
		this.entregador = entregador;
	}

	

	public Colaborador getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Colaborador transportadora) {
		this.transportadora = transportadora;
	}
	
	
	
	public List<RomaneioItem> getRomaneioItens() {
		if(this.romaneioItens == null){
			this.romaneioItens = new ArrayList<RomaneioItem>();
		}
		return romaneioItens;
	}
	
	public void setRomaneioItens(List<RomaneioItem> romaneioItens) {
		this.romaneioItens = romaneioItens;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Romaneio other = (Romaneio) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
