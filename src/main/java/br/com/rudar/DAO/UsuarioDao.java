package br.com.rudar.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.com.rudar.entity.Usuario;
import br.com.rudar.mbeans.UsuarioBean.TipoFiltro;
import br.com.rudar.util.UtilMensagens;

public class UsuarioDao extends GenericDao<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;


	public UsuarioDao() {
		super(Usuario.class);
	}
	

	public boolean gravar(Usuario usuario) {
		if (usuario.getIdUsusario() == null) {
			if (save(usuario)) {
				UtilMensagens.mensagemInformacao("Usuário Inserido com Sucesso");
				return true;
			}
		} else {
			if (update(usuario)) {
				UtilMensagens.mensagemInformacao("Usuário Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public Usuario findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario existe(Usuario usuario) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createQuery(
						"select u from Usuario u where u.nomeUsuario = :pUsuario and u.senha = :pSenha",
						Usuario.class);

		query.setParameter("pUsuario", usuario.getNomeUsuario().toUpperCase());
		query.setParameter("pSenha", usuario.getSenha());

		Usuario retorno;
		try {
			retorno = (Usuario) query.getSingleResult();
			em.getTransaction().commit();
			em.close();
			
		} catch (NoResultException ex) {
			em.close();
			return null;
		}

		return retorno;
	}

	
	public List<Usuario> getByFilterTable(TipoFiltro tipoFiltro , String valorFiltro){
		List<Usuario> lista= null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO)){
			String jpql = "Select u From Usuario u where u.idUsusario in (" + valorFiltro + ")";
			lista = find(jpql);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = find("Select u From Usuario u where u.nomeUsuario like ?",valorFiltro);
		}
		
		return lista;
	}
}
