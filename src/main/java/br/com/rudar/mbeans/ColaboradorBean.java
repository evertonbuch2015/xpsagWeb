package br.com.rudar.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.rudar.DAO.ColaboradorDao;
import br.com.rudar.entity.Colaborador;
import br.com.rudar.enumerated.TipoPessoa;

@ManagedBean
@SessionScoped
public class ColaboradorBean extends GenericBean<Colaborador> {

	private ColaboradorDao  colaboradorDao;
	private String mascaraDocumento;
	
	public ColaboradorBean() {
		colaboradorDao = new ColaboradorDao();
		this.mascaraDocumento = "99.999.999/9999-99";
	}
	
	
	
	// =======================METODOS DO USUARIO=================================================
	
	@Override
	public void carregaEntidade() {
		this.entidade = colaboradorDao.findAllAttributesEntity(this.entidade.getId());		
	}
	
	
	@Override
	public Colaborador criarEntidade() {
		return new Colaborador();
	}

	@Override
	public void gravar() {
		if (colaboradorDao.gravar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}

	@Override
	public void excluir(Colaborador entidade) {
		colaboradorDao.delete(entidade);
		refresh();
		mudarBuscar();
	}

	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
			
		this.entidades = colaboradorDao.findByPaged(50);
	}
	
	
	//RETORNA LISTA TIPO DE PESSOA PARA O COMBO
	public TipoPessoa[] getTipoPessoas(){
		return TipoPessoa.values();
	}

	public void trocarMascara(){
		if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.F)){
			this.mascaraDocumento = "999.999.999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.J)){
			this.mascaraDocumento = "999.999.999/9999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.E)){
			this.mascaraDocumento = "99999999999999999999";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.V)){
			this.mascaraDocumento = "999.999.999/9999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.C)){
			this.mascaraDocumento = "999999999/99";
		}
	}
	
	
	
	public String getMascaraDocumento() {
		return mascaraDocumento;
	}
	
	
	public void setMascaraDocumento(String mascaraDocumento) {
		this.mascaraDocumento = mascaraDocumento;
	}
}
