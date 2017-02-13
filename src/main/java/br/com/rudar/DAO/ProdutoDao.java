package br.com.rudar.DAO;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rudar.entity.Produto;
import br.com.rudar.util.UtilMensagens;

public class ProdutoDao extends GenericDao<Produto> {

	public ProdutoDao() {
		super(Produto.class);
	}

	public boolean gravar(Produto produto) {
		if (produto.getId() == null) {
			if (save(produto)) {
				UtilMensagens.mensagemInformacao("Cadastro de Produto Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(produto)) {
				UtilMensagens.mensagemInformacao("Cadastro de Produto Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
	
	@Override
	public Produto findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Double buscaPreco(Integer produto, Date data, String cemp, Integer condPagamento, Integer cliente ){


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
		//List<Object[]> result = query.getResultList();
		
		//Object[] retorno = result.get(0);		
		
		/*
		em.getTransaction().begin();
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("SP_LISTA_PRECO",Double.class);
        // set parameters
        storedProcedure.registerStoredProcedureParameter("PRODUTO", Integer.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("DATA", Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("CEMP", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("CONDICAO_PAGAMENTO", Integer.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("COD_CLIENTE", Integer.class, ParameterMode.IN);
        
        storedProcedure.registerStoredProcedureParameter("PAVI", Double.class, ParameterMode.OUT);
        
        storedProcedure.setParameter("PRODUTO", produto);
        storedProcedure.setParameter("DATA", data);
        storedProcedure.setParameter("CEMP", cemp);
        storedProcedure.setParameter("CONDICAO_PAGAMENTO", condPagamento);
        storedProcedure.setParameter("COD_CLIENTE", cliente);
        // execute SP
        storedProcedure.execute();
        // get result
        Double valor = (Double)storedProcedure.getOutputParameterValue("PAVI");
        
        
        em.getTransaction().commit();
        em.close();*/
	}
}
