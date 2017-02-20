package br.com.rudar.view.managedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import br.com.rudar.core.entity.Empresa;
import br.com.rudar.core.entity.Usuario;
import br.com.rudar.core.entity.Vendedor;
import br.com.rudar.core.enumerated.GrupoUsuarios;
import br.com.rudar.core.service.UsuarioService;
import br.com.rudar.core.service.VendedorService;


@ManagedBean
@SessionScoped
public class UsuarioBean extends GenericBean<Usuario> {

	public enum TipoFiltro{
		CODIGO("C�digo"), NOME("Nome Usu�rio");
		
		private String label;

		TipoFiltro(String label) {
			this.label = label;
		}
		
		public String getLabel(){
			return this.label;
		}
	}
	
	private TipoFiltro filtro;	
	private UsuarioService usuarioService;
	private Integer usuarioId;
	
	
	public UsuarioBean() {
		usuarioService = new UsuarioService();
	}
		
	// =======================METODOS DO USUARIO=================================================
	
	public void filtrar(){
		this.entidades = usuarioService.filtrarTabela(filtro, valorFiltro);
	}
	
	
	@Override
	public void carregaEntidade() {
		this.entidade = usuarioService.carregarEntidade(this.entidade.getIdUsusario());				
	}
	
	
	@Override
	public Usuario criarEntidade() {		
		return new Usuario();
	}
	
	
	@Override
	public void refresh() {
		this.entidades = usuarioService.buscarTodos();
	}
	
	
	@Override
	public void gravar() {
		if (usuarioService.salvar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}		
	}

	
	@Override
	public void excluir(Usuario entidade) {
		usuarioService.excluir(entidade);
		refresh();
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
			FacesMessage msg = new FacesMessage("Empresa j� cadastrada para este Usu�rio", "Empresa j� cadastrada para este Usu�rio");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}	
		
	
	public void empresaSelecionada(SelectEvent event){
		Empresa empresa = (Empresa) event.getObject();
		adicionarEmpresa(empresa);
	}
	
	
	// =============================GET AND SET=================================
	
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
		return new VendedorService().buscarTodos();
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
