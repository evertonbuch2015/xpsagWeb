package br.com.rudar.mbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.rudar.DAO.ColaboradorDao;
import br.com.rudar.entity.Colaborador;
import br.com.rudar.enumerated.TipoColaborador;
import br.com.rudar.enumerated.TipoPessoa;
import br.com.rudar.util.SessionContext;

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
		this.entidade = new Colaborador();
		this.entidade.getPessoa().setDataCadastro(new Date());
		this.entidade.getPessoa().setCemp(SessionContext.getInstance().getEmpresaUsuarioLogado().getCodigo());
		this.entidade.setCemp(SessionContext.getInstance().getEmpresaUsuarioLogado().getCodigo());
		
		return new Colaborador();
	}

	
	@Override
	public void gravar() {
		this.entidade.setCodigo(colaboradorDao.getMaxCodigo() +1);
		
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
			
		this.entidades = colaboradorDao.findByPaged(40);
	}
	

	/**
	 * Método responsável por trocar a mascara do campo documento.
	 * Acionado no change do combo TipoPessoa.
	 */
	public void trocarMascara(){
		if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.F)){
			this.mascaraDocumento = "999.999.999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.J)){
			this.mascaraDocumento = "99.999.999/9999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.E)){
			this.mascaraDocumento = "99999999999999999999";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.V)){
			this.mascaraDocumento = "99.999.999/9999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.C)){
			this.mascaraDocumento = "999999999/99";
		}
	}
	
	
	// =============================GET AND SET=================================	
	
	//RETORNA LISTA TIPO DE PESSOA PARA O COMBO
	public TipoPessoa[] getTipoPessoas(){
		return TipoPessoa.values();
	}
	
	
	//RETORNA LISTA TIPO DE PESSOA PARA O COMBO
	public TipoColaborador[] getTipoColaborador(){
		return TipoColaborador.values();
	}
	
	
	public String getMascaraDocumento() {
		return mascaraDocumento;
	}
	
	
	public void setMascaraDocumento(String mascaraDocumento) {
		this.mascaraDocumento = mascaraDocumento;
	}
}
