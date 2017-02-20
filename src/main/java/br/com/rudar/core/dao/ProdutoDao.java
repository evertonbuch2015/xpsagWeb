package br.com.rudar.core.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rudar.core.entity.Produto;

public class ProdutoDao extends GenericDao<Produto> {

	public ProdutoDao() {
		super(Produto.class);
	}
	
	
	@Override
	public Produto findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

			
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Produto> findByPaged(int maxResults) {  
		
    	Query query = getEntityManager().createQuery("From Produto",Produto.class)
    			.setHint("org.hibernate.readOnly", true);
        query.setMaxResults(maxResults);
        query.setFirstResult(0);

        return query.getResultList();
    }
	
	
	public Double findPrice(Integer produto, Date data, String cemp, Integer condPagamento, Integer cliente){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNativeQuery(" execute PROCEDURE SP_LISTA_PRECO(?,?,?,?,?)");
		query.setParameter(1, produto);
		query.setParameter(2, data);
		query.setParameter(3, cemp);
		query.setParameter(4, condPagamento);
		query.setParameter(5, cliente);
		
		
		Object[] retorno1 = (Object[]) query.getSingleResult();
		
		Double valor = (Double) retorno1[2];
		
		
		em.getTransaction().commit();
        em.close();
		
        return valor;
	}

}
