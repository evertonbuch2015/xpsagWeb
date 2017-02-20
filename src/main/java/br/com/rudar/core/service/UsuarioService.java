package br.com.rudar.core.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.rudar.core.dao.UsuarioDao;
import br.com.rudar.core.entity.Usuario;
import br.com.rudar.view.managedBean.UsuarioBean.TipoFiltro;
import br.com.rudar.view.util.UtilMensagens;

public class UsuarioService implements GenericService<Usuario> {

	private UsuarioDao usuarioDao;
	
	
	public UsuarioService() {
		usuarioDao = new UsuarioDao();
	}
	
	
	@Override
	public boolean salvar(Usuario entidate) {
		if (entidate.getIdUsusario() == null) {
			if (usuarioDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Usuário Inserido com Sucesso");
				return true;
			}
		} else {
			if (usuarioDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Usuário Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(Usuario entidade) {
		usuarioDao.delete(entidade);
	}

	
	@Override
	public Usuario carregarEntidade(Integer id) {
		String jpql = "Select u From Usuario u left JOIN FETCH u.empresas where u.idUsusario = ?1";
		return usuarioDao.findOne(jpql, id);
	}

	
	public List<Usuario> buscarTodos(){
		return usuarioDao.findAll();
	}
	
	
	public List<Usuario> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<Usuario> lista= null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO)){
			String jpql = "Select u From Usuario u where u.idUsusario in (" + valorFiltro + ")";
			lista = usuarioDao.find(jpql);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = usuarioDao.find("Select u From Usuario u where u.nomeUsuario like ?",valorFiltro);
		}
		
		return lista;
	}

	
	public boolean logar(Usuario usuario){
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(usuario.getNomeUsuario() != null && usuario.getSenha() != null){
			usuario = usuarioDao.existe(usuario);
		}	    
		
		if(usuario != null){
			context.getExternalContext().getFlash().setKeepMessages(true);
	    	context.addMessage(null, new FacesMessage("Selecione uma Empresa"));
			
	    	return true;
		}    
	    
	    context.getExternalContext().getFlash().setKeepMessages(true);
	    context.addMessage(null, new FacesMessage("Usuário não encontrado"));
	    
		return false;
	}


	public Usuario buscarPeloNome(Usuario usuario) {
		String jpql = "select u from Usuario u where u.nomeUsuario = ?1";
		return usuarioDao.findOne(jpql, usuario.getNomeUsuario());
	}
}
