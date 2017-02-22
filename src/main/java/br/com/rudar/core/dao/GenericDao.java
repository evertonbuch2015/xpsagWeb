package br.com.rudar.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import br.com.rudar.view.util.UtilErros;
import br.com.rudar.view.util.UtilMensagens;


/**
 *
 * @author Everton de Souza
 * @param <T>
 */
public abstract class GenericDao<T extends Serializable> {
    
    private final Class<T> aClass;     
    
    
    /**
     * Cria o construtor da classe GenericDao identificando a Entidade que ser� usada.
     * @param aClass 
     */
    protected GenericDao(Class<T> aClass){
        this.aClass = aClass;
    }
    
    
    
    /**
     * Implementar este metodo nas classes especificas para trazer todos
     * os atributos da Entity.
     */
    public abstract T findAllAttributesEntity(Integer id);
      
    
    
    
    /**
     * Retorna um novo Entity Manager.
     * @return 
     */
    protected EntityManager getEntityManager(){
    	return JPAUtil.GetInstance().getEntityManager();
    }
    
    
    
    /**
     * Realiza o RoolBack da transa��o e fecha a mesma.
     * @param EntityManager em
     * @return 
     */
    public void doRollback(EntityManager em) {
    	if (em.getTransaction().isActive() == false) {
            em.getTransaction().begin();
        }
        em.getTransaction().rollback();
        em.close();
	}
    
    
    
    
    /**
     * Retornar apenas uma Entidade conforme os parametros recebidos.
     * Entidades estar�o com o estado DATACHED.
     * @param jpql
     * @param params
    */
    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public T findOne(String jpql , Object...params)throws Exception{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery(jpql);
        
        for(int i=0 ; i < params.length ; i++){
            query.setParameter(i+1, params[i]);
        }
        
        T entity = null;
        
        try {
        	entity = (T) query.getSingleResult();
        	em.getTransaction().commit();
		
		}finally {
			em.close();
		}		
        
        return entity;
    }
    
    
   /**
    * Retornar apenas uma Entidade conforme os parametros recebidos.
    * Deve comitar e encerrar o EntityManager manualmente.
    * Entidades estar�o com o estado MANAGED.
    * @param EntityManager em
    * @param jpql
    * @param params
   */
   @SuppressWarnings("unchecked")
   public T findOne(EntityManager em,String jpql , Object...params)throws Exception{
       em.getTransaction().begin();
       
       Query query = em.createQuery(jpql);
       
       for(int i=0 ; i < params.length ; i++){
           query.setParameter(i+1, params[i]);
       }
       
       T entity = null;
       entity = (T) query.getSingleResult();		
       
       return entity;
   }
    
   
   
   
   
    /**
     * Retornar uma Lista de Entidades conforme os parametros recebidos.
     * Entidades estar�o com o estado DATACHED.
     * @param jpql
     * @param params
     * @return 
     */
    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> find(String jpql , Object...params){
    	EntityManager em = getEntityManager();
    	em.getTransaction().begin();
        em.clear();
        
        Query query = em.createQuery(jpql).setHint("org.hibernate.readOnly", true);
        
        for(int i=0 ; i < params.length ; i++){
            query.setParameter(i+1, params[i]);
        }
        
		List<T> entities = null;
        
        try {
        	entities = query.getResultList();
            
            em.getTransaction().commit();
            em.close();
            
		} catch (Exception e) {
			UtilMensagens.mensagemErro("Erro ao Carregar os dados da Entidade " + aClass.getName() +
					" no m�todo find(String jpql , Object...params) \nErro: " +	UtilErros.getMensagemErro(e));
		}
        return entities;
    }
    
    
    /**
     * Retornar uma Lista de Entidades conforme os parametros recebidos.
     * Deve comitar e encerrar o EntityManager manualmente.
     * Entidades estar�o com o estado MANAGED.
     * @param EntityManager em
     * @param jpql
     * @param params
     * @return 
     */
    @SuppressWarnings("unchecked")
	public List<T> find(EntityManager em,String jpql , Object...params)throws Exception{
    	em.getTransaction().begin();
        em.clear();
        
        Query query = em.createQuery(jpql).setHint("org.hibernate.readOnly", true);
        
        for(int i=0 ; i < params.length ; i++){
            query.setParameter(i+1, params[i]);
        }
        
		List<T> entities = null;        
        entities = query.getResultList();

        return entities;
    }
    
    
    
    
    /**
     * Recupera uma Entidade apenas.
     * Entidade estar� com o estado DATACHED.
     * @param EntityManager em
     * @param id
     * @return 
     */
    public T findById(Integer id){        
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        T entity = null;
        try {           
            entity = (T) em.find(aClass, id);
            em.getTransaction().commit();
            em.close();
            
        } catch (Exception e) {
        	UtilMensagens.mensagemErro("Erro ao Carregar os dados da Entidade " + aClass.getName() + " no m�todo findById\nErro: " + 
					UtilErros.getMensagemErro(e));
        }                
        return entity;
    }
    
    
    /**
    * Recupera uma Entidade apenas.
    * Entidade estar� com o estado MANAGED.
    * @param EntityManager em
    * @param id
    * @return 
    */
   public T findById(EntityManager em,Integer id)throws Exception{       
       em.getTransaction().begin();
       
       T entity = null;
       entity = (T) em.find(aClass, id);           
       return entity;
   }
    
    
    
   
    /**
     * Metodo para retornar todas as Entidades do banco de dados.
     * Entidades estar�o com o estado DATACHED.
     * @return 
     */
    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<T> findAll(){
    	EntityManager em = getEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createQuery("From " + aClass.getSimpleName()).setHint("org.hibernate.readOnly", true);
        
        List<T> entities = null;
        
        try {
        	entities = query.getResultList();
        	
        	em.getTransaction().commit();
        	em.close();
        	
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            em.close();
			UtilMensagens.mensagemErro("Erro ao Carregar os dados da Entidade " + aClass.getName() + " no m�todo findAll \nErro: " + 
					UtilErros.getMensagemErro(e));
		}
	            
        return entities; 
    }

    
    
    
    /**
    *Metodo para realizar o save do Objeto Entidade
     * @param entity
    */
    public boolean save(T entity){
    	EntityManager em = getEntityManager();
    	
    	try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            em.close();
            
            return true;
        } catch (Exception e) {
        	if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            em.close();
            
            UtilMensagens.mensagemErro("Erro ao Salvar os dados da Entidade " + aClass.getName() + " \nErro: " + 
            							UtilErros.getMensagemErro(e));            
            return false;
        }
    }
    
    
    
    /**
    *Metodo para realizar o update do Objeto Entidade
     * @param entity
    */
    public boolean update(T entity){
    	EntityManager em = getEntityManager();
    	
    	try{
            em.getTransaction().begin();            
            em.merge(entity);
            em.getTransaction().commit();
            em.close();
            
            return true;
        }catch(Exception e){
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            em.close();
            
            UtilMensagens.mensagemErro("Erro ao Atualizar os dados da Entidade " + aClass.getName() + " \nErro: " + 
            							UtilErros.getMensagemErro(e));
            return false;
        }
    }
    
    
    
    /**
    *Remover um objeto do banco recebendo o id da entidade.
     * @param id
    */
    public void delete(Long id){
    	EntityManager em = getEntityManager();
    	
    	try {
            em.getTransaction().begin();
            em.remove(em.find(aClass, id));
            em.getTransaction().commit();
            em.close();
            
            UtilMensagens.mensagemInformacao("Exclus�o Realizada com Sucesso");            
        } catch (EntityNotFoundException enfe) {            
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            em.close();
            
            UtilMensagens.mensagemErro("The Item with id " + id + " no longer exists." + " \nErro: " + 
					UtilErros.getMensagemErro(enfe));
        }
    }
    

    
    /**
    *Remover um objeto do banco recebendo uma Entidade
     * @param entity
    */
    public void delete(T entity){        
    	EntityManager em = getEntityManager();
    	
    	try {
            em.getTransaction().begin();
            T c = em.merge(entity);     //faz um merge por que entidade est� em datached.
            em.remove(c);
            em.getTransaction().commit();
            em.close();
            
            UtilMensagens.mensagemInformacao("Exclus�o Realizada com Sucesso");   
        } catch (Exception ex) {        	            
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            em.close();
            
            UtilMensagens.mensagemErro("Erro ao Excluir os dados da Entidade " + aClass.getName() + " \nErro: " + 
            							UtilErros.getMensagemErro(ex));
        }
    }
    
    
    
    /**
     * Recupera a quantidade de registros da Entidade no banco de dados 
     * @return 
     */
    public Long count() throws Exception{
    	EntityManager em = getEntityManager();
    	em.getTransaction().begin();
        
        Query query = em.createQuery("select count(c) from " + aClass.getSimpleName()+" c ");
        Long count = (Long) query.getSingleResult();
        
        em.getTransaction().commit();       
        em.close();
        
        return count;
    }
}

