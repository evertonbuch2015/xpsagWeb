package br.com.rudar.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rudar.entity.Romaneio;
import br.com.rudar.entity.RomaneioItem;
import br.com.rudar.util.UtilErros;
import br.com.rudar.util.UtilMensagens;

public class RomaneioDao extends GenericDao<Romaneio> {

	public RomaneioDao() {
		super(Romaneio.class);
	}

	public boolean gravar(Romaneio romaneio) {
		if (romaneio.getId() == null) {
			romaneio.setCodigo(getMaxCodigo()+1);
			
			EntityManager em = getEntityManager();
	    	
	    	try {
	            em.getTransaction().begin();
	            em.persist(romaneio);
	            em.getTransaction().commit();
	            em.close();
	            UtilMensagens.mensagemInformacao("Romaneio Inserido com Sucesso");	            
	            return true;
	            
	        }catch (Exception e) {
	        	if (em.getTransaction().isActive() == false) {
	                em.getTransaction().begin();
	            }
	        	
	        	em.getTransaction().rollback();
	            em.close();
	        	
	        	if(e.getCause().getMessage().contains("org.hibernate.exception.ConstraintViolationException")){	        		
	        		
	        		romaneio.setId(null);
	        		for (RomaneioItem item : romaneio.getRomaneioItens()) {
						item.setId(null);
					}
	        		
	        		gravar(romaneio);
	        		return true;
	        	}	            
	            
	            UtilMensagens.mensagemErro("Erro ao Salvar os dados da Entidade Romaneio \nErro: " + 
	            							UtilErros.getMensagemErro(e));            
	            return false;
	        }
	    	
		} else {
			if (update(romaneio)) {
				UtilMensagens.mensagemInformacao("Romaneio Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
	
	
	@Override
	public Romaneio findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Integer getMaxCodigo(){
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("Select max(r.codigo) From Romaneio r",Integer.class);
		
		Integer retorno = (Integer) query.getSingleResult();
		
		em.getTransaction().commit();
		em.close();
		return retorno;
	}
}
