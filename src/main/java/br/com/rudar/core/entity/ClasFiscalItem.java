package br.com.rudar.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the CAD_CLAS_FISCAL_ITEM database table.
 * 
 */
@Entity
@IdClass(ClassFiscalItemPK.class)
@Table(name="CAD_CLAS_FISCAL_ITEM")
public class ClasFiscalItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	//clasFiscal e estado são as chaves primarias, e também clasFiscal é chave estrangeira.	
	@Id
	@ManyToOne
	@JoinColumn(name= "COD_CADCLASFISCAL")
	private ClasFiscal clasFiscal;

	@Id
	@Column(name="ESTADO")
	private String estado;

	
	@Column(name="ALIQ_ICMS")
	private double aliqIcms;

	@Column(name="ALIQ_ICMS_ALT")
	private double aliqIcmsAlt;

	@Column(name="PERC_MARGEM_VALOR_AGREGADO")
	private double percMargemValorAgregado;

	@Column(name="PERC_MARGEM_VALOR_AGREGADO_AJU")
	private double percMargemValorAgregadoAju;

	@Column(name="PERC_TRIBUTACAO_ICM")
	private double percTributacaoIcm;

	
	//--------------------------------	GETs and SETs------------------------------//
	
	public ClasFiscal getClasFiscal() {
		return clasFiscal;
	}
	
	public void setClasFiscal(ClasFiscal clasFiscal) {
		this.clasFiscal = clasFiscal;
	}
	
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	public double getAliqIcms() {
		return this.aliqIcms;
	}

	public void setAliqIcms(double aliqIcms) {
		this.aliqIcms = aliqIcms;
	}

	
	public double getAliqIcmsAlt() {
		return this.aliqIcmsAlt;
	}

	public void setAliqIcmsAlt(double aliqIcmsAlt) {
		this.aliqIcmsAlt = aliqIcmsAlt;
	}

	
	public double getPercMargemValorAgregado() {
		return this.percMargemValorAgregado;
	}

	public void setPercMargemValorAgregado(double percMargemValorAgregado) {
		this.percMargemValorAgregado = percMargemValorAgregado;
	}

	
	public double getPercMargemValorAgregadoAju() {
		return this.percMargemValorAgregadoAju;
	}

	public void setPercMargemValorAgregadoAju(double percMargemValorAgregadoAju) {
		this.percMargemValorAgregadoAju = percMargemValorAgregadoAju;
	}

	
	public double getPercTributacaoIcm() {
		return this.percTributacaoIcm;
	}

	public void setPercTributacaoIcm(double percTributacaoIcm) {
		this.percTributacaoIcm = percTributacaoIcm;
	}

	
	
	//--------------------------------	Métodos Auxiliares------------------------------//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clasFiscal == null) ? 0 : clasFiscal.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		ClasFiscalItem other = (ClasFiscalItem) obj;
		if (clasFiscal == null) {
			if (other.clasFiscal != null)
				return false;
		} else if (!clasFiscal.equals(other.clasFiscal))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}	
}