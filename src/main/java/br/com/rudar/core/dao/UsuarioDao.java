package br.com.rudar.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.rudar.core.entity.Usuario;
import br.com.rudar.view.util.Criptografia;

public class UsuarioDao extends GenericDao<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	
	@Override
	public Usuario findAllAttributesEntity(Integer id) {
		return null;
	}
	
	
	public Usuario existe(String login, String senha) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createQuery(
						"select u from Usuario u where u.nomeUsuario = :pUsuario and u.senha = :pSenha",
						Usuario.class);

		query.setParameter("pUsuario", login.toUpperCase());
		query.setParameter("pSenha", Criptografia.criptografarSha256(senha));

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

	
	public List<String> findSectors(String jpql){
		
		EntityManager em = getEntityManager();
		TypedQuery<String> query = em.createQuery(jpql, String.class);
		
		List<String> lista;
		try {
			lista =  query.getResultList();
			
		} catch (Exception ex) {
			lista = null;
		}finally {
			em.close();
		}
		return lista;
	}
}
