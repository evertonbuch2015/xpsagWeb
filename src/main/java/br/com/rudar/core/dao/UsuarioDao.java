package br.com.rudar.core.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.rudar.core.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super(Usuario.class);
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

}
