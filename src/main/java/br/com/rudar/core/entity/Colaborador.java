package br.com.rudar.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.rudar.core.enumerated.TipoColaborador;


@Entity
@Table(name = "CAD_COLABORADOR")
public class Colaborador implements Serializable {
	
	private static final long serialVersionUID = 1231065133504165813L;


	@Id
    @SequenceGenerator(name="G_CAD_COLABORADOR", sequenceName="\"G_CAD_COLABORADOR\"", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="G_CAD_COLABORADOR")
	@Column(name = "COD_CADCOLABORADOR")
	private Integer Id;
	
	
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "CEMP", length = 2)
	private String cemp;
	
	@Column(name = "FANTASIA" , length = 60)
	private String fantasia;
	
	
	@Column(name = "TCLI" , length = 20)
	private String tipoCliente;
	
	
	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST}, 
				fetch = FetchType.LAZY)
    @JoinColumn(name ="CODIGO_PESSOA")
	private Pessoa pessoa;


	//--------------------------------	GETs and SETs------------------------------//
	
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


	
	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	
	
	public String getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
	public List<TipoColaborador> getTipoColaborador(){
		List<TipoColaborador> lista = new ArrayList<>();
		
		if(this.tipoCliente == null){
			this.tipoCliente = "";
		}
		
		if(this.tipoCliente.contains(TipoColaborador.C.name())){
			lista.add(TipoColaborador.C);
		}
		
		if(this.tipoCliente.contains(TipoColaborador.F.name())){
			lista.add(TipoColaborador.F);
		}
		
		if(this.tipoCliente.contains(TipoColaborador.T.name())){
			lista.add(TipoColaborador.T);
		}
		
		if(this.tipoCliente.contains(TipoColaborador.M.name())){
			lista.add(TipoColaborador.M);
		}
		
		if(this.tipoCliente.contains(TipoColaborador.R.name())){
			lista.add(TipoColaborador.R);
		}
		
		return lista;
	}
	
	
	public void setTipoColaborador(List<TipoColaborador> lista){
		
		if(this.tipoCliente == null){
			this.tipoCliente = "";
		}
		
		if(lista.contains(TipoColaborador.C.name())){
			this.tipoCliente = this.tipoCliente + TipoColaborador.C.name();
		}
		
		if(lista.contains(TipoColaborador.F.name())){
			this.tipoCliente = this.tipoCliente +TipoColaborador.F.name();
		}
		
		if(lista.contains(TipoColaborador.T.name())){
			this.tipoCliente = this.tipoCliente + TipoColaborador.T.name();
		}
		
		if(lista.contains(TipoColaborador.M.name())){
			this.tipoCliente = this.tipoCliente +TipoColaborador.M.name();
		}
		
		if(lista.contains(TipoColaborador.R.name())){
			this.tipoCliente = this.tipoCliente + TipoColaborador.R.name();
		}
		
	}
	
	
	public Pessoa getPessoa() {
		if(this.pessoa == null){
			this.pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Colaborador other = (Colaborador) obj;
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
