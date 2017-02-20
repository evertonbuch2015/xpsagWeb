package br.com.rudar.core.dao;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rudar.core.entity.Colaborador;
import br.com.rudar.view.util.UtilErros;
import br.com.rudar.view.util.UtilMensagens;

public class ColaboradorDao extends GenericDao<Colaborador> {

	
	public ColaboradorDao() {
		super(Colaborador.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Colaborador> findColaboradorByVendedor(Integer vendedor,String filtro){
		
		EntityManager em = getEntityManager();
    	em.getTransaction().begin();
        em.clear();
        
        String sqlString = "SELECT * FROM CAD_COLABORADOR C"+
        	" INNER JOIN CAD_COLABORADOR_FATURAMENTO F ON C.COD_CADCOLABORADOR = F.COD_CADCOLABORADOR"+
        	" WHERE F.COD_CADVENDEDOR = ?"+
        	" AND C.FANTASIA LIKE ? ";
        
        
        Query query = em.createNativeQuery(sqlString, Colaborador.class).setHint("org.hibernate.readOnly", true);
        query.setParameter(1, vendedor);
        query.setParameter(2, "%"+filtro+"%");       
        
		List<Colaborador> entities = null;
        
        try {
        	entities = query.getResultList();
            em.getTransaction().commit();
            
		} catch (Exception e) {
			UtilMensagens.mensagemErro("Erro ao Carregar os dados de Colaborador pelo Vendedor " +
					" no método findColaboradorByVendedor(Vendedor vendedor) \nErro: " +
						UtilErros.getMensagemErro(e));
		}finally {
			em.close();
		}
        return entities;
	}

	
	@Override
	public Colaborador findAllAttributesEntity(Integer id) {
		String jpql =
			"Select c From Colaborador c left Join fetch c.pessoa where c.id = ?1";
		return findOne(jpql, id);
	}

	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Colaborador> findByPaged(int maxResults) {  
		
    	Query query = getEntityManager().createQuery("From Colaborador",Colaborador.class)
    			.setHint("org.hibernate.readOnly", true);
        query.setMaxResults(maxResults);
        query.setFirstResult(0);

        return query.getResultList();
    }
	
	
	public Integer getMaxCodigo(){
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("Select max(c.codigo) From Colaborador c", Integer.class);
		
		Integer retorno = (Integer) query.getSingleResult();
		
		em.getTransaction().commit();
		em.close();
		return retorno;
	}

}
