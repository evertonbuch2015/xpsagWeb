package br.com.rudar.mbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.rudar.DAO.UsuarioDao;
import br.com.rudar.DAO.VendedorDao;
import br.com.rudar.entity.Empresa;
import br.com.rudar.entity.Usuario;
import br.com.rudar.entity.Vendedor;
import br.com.rudar.enumerated.GrupoUsuarios;


@ManagedBean
@SessionScoped
public class UsuarioBean extends GenericBean<Usuario> {

	public enum TipoFiltro{
		CODIGO("Código"), NOME("Nome Usuário");
		
		private String label;

		TipoFiltro(String label) {
			this.label = label;
		}
		
		public String getLabel(){
			return this.label;
		}
	}
	
	private TipoFiltro filtro;		
	private UsuarioDao usuarioDao;	
	private Integer usuarioId;
	
	
	public UsuarioBean() {
		usuarioDao = new UsuarioDao();
	}
		
	// =======================METODOS DO USUARIO=================================================
	
	public void filtrar(){
		this.entidades = usuarioDao.getByFilterTable(filtro, valorFiltro);
	}
	
	
	@Override
	public void carregaEntidade() {
		this.entidade =
				usuarioDao.findOne("Select u From Usuario u left JOIN FETCH u.empresas where u.idUsusario = ?1 ", this.entidade.getIdUsusario());
	}
	
	
	@Override
	public Usuario criarEntidade() {		
		return new Usuario();
	}
	
	
	@Override
	public void refresh() {
		if (this.entidades == null) {
			this.entidades = usuarioDao.findAll();
		}		
	}
	
	
	@Override
	public void gravar() {
		if (usuarioDao.gravar(this.entidade)) {			
			this.entidades = usuarioDao.findAll();
			mudarBuscar();
		}		
	}

	
	@Override
	public void excluir(Usuario entidade) {
		usuarioDao.delete(entidade);
		this.entidades = usuarioDao.findAll();
		mudarBuscar();
	}
	
	
	public void excluirEmpresa(Empresa empresa){
		if(this.entidade.getEmpresas().contains(empresa)){
			this.entidade.getEmpresas().remove(empresa);
		}
	}
		
	
	public void adicionarEmpresa(Empresa empresa){		
		if(!this.entidade.getEmpresas().contains(empresa)){
			this.entidade.getEmpresas().add(empresa);
		}else{
			FacesMessage msg = new FacesMessage("Empresa já cadastrada para este Usuário", "Empresa já cadastrada para este Usuário");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}	
		
	
	public void empresaSelecionada(SelectEvent event){
		Empresa empresa = (Empresa) event.getObject();
		adicionarEmpresa(empresa);
	}
	
	// =============================GET AND SET=================================
	
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}


	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

		
	public GrupoUsuarios[] getGrupoUsuarios(){
		return GrupoUsuarios.values();
	}	
		
	public List<Vendedor> getVendedores(){
		return new VendedorDao().findAll();
	}

	
	//RETORNA LISTA DE FILTROS PARA O COMBO
	public TipoFiltro[] tipoFiltros(){
		return TipoFiltro.values();
	}
		
	public TipoFiltro getFiltro() {
		return filtro;
	}
		
	public void setFiltro(TipoFiltro filtro) {
		this.filtro = filtro;
	}
}
