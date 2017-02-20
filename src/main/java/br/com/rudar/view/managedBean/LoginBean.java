package br.com.rudar.view.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.rudar.core.dao.EmpresaDao;
import br.com.rudar.core.entity.Empresa;
import br.com.rudar.core.entity.Usuario;
import br.com.rudar.core.service.UsuarioService;
import br.com.rudar.view.util.SessionContext;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1444783038549353503L;
	private boolean selecionandoEmpresa; 
	private Usuario usuario;
	private Empresa empresa;
	private UsuarioService usuarioService;
	
	
	public LoginBean() {
		selecionandoEmpresa = false;
		usuario = new Usuario();
		usuarioService = new UsuarioService();
	}
	
	
	// ================Métodos do Usuário============================================
	public void efetuaLogin() {		
		if(usuarioService.logar(this.usuario)){;
			this.usuario = usuarioService.buscarPeloNome(this.usuario);
			selecionandoEmpresa = true;
		}else{
			this.usuario = new Usuario();
		}
		
	}
	

	public String prosseguir(){
		SessionContext.getInstance().setAttribute("usuarioLogado", this.usuario);
		SessionContext.getInstance().setAttribute("empresa", this.empresa);
		
		return "index?faces-redirect=true";
	}
	
		
	public String deslogar() {
		SessionContext.getInstance().deleteAttribute("usuarioLogado");
		SessionContext.getInstance().deleteAttribute("empresa");
	    SessionContext.getInstance().encerrarSessao();
	    
	    return "/Login?faces-redirect=true";
	}
	
	
	public String abrirUsuario(){
		
		Usuario usuarioLogado = SessionContext.getInstance().getUsuarioLogado();
		
		if(usuarioLogado != null) {
			return "editarUsuario?faces-redirect=true&usuarioId=" + usuarioLogado.getIdUsusario();
		}
		return "#";
	}
	
	
	// ================Métodos GET e SET=============================================
	
	public boolean isSelecionandoEmpresa() {
		return selecionandoEmpresa;
	}
		
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	public List<Empresa> getEmpresas(){
		return new EmpresaDao().findAll();
	}
}
