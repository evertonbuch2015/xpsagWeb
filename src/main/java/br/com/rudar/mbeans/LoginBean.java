package br.com.rudar.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.rudar.DAO.EmpresaDao;
import br.com.rudar.DAO.UsuarioDao;
import br.com.rudar.entity.Empresa;
import br.com.rudar.entity.Usuario;
import br.com.rudar.util.SessionContext;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1444783038549353503L;
	private boolean selecionandoEmpresa; 
	private Usuario usuario;
	private Empresa empresa;
	private UsuarioDao usuarioDao;
	
	public LoginBean() {
		
		selecionandoEmpresa = false;
		usuario = new Usuario();
		usuarioDao = new UsuarioDao();
	}
	
	
	public String efetuaLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(this.usuario.getIdUsusario() == null){
			this.usuario = usuarioDao.existe(this.usuario);
			
		}	    
		
		
		if(this.usuario != null && !selecionandoEmpresa){
			
			context.getExternalContext().getFlash().setKeepMessages(true);
	    	context.addMessage(null, new FacesMessage("Selecione uma Empresa"));
			selecionandoEmpresa = true;
			
	    	return "index?faces-redirect=true";
		}    
	    
	    context.getExternalContext().getFlash().setKeepMessages(true);
	    context.addMessage(null, new FacesMessage("Usuário não encontrado"));
	    
	    usuario = new Usuario();
	    
	    return "index?faces-redirect=true";
	}
	
	
	public String prosseguir(){
		if (this.usuario.getIdUsusario() != null && selecionandoEmpresa) {
			SessionContext.getInstance().setAttribute("usuarioLogado", this.usuario);
			SessionContext.getInstance().setAttribute("empresa", this.empresa);
	    }
		
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
