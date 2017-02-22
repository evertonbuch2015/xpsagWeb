package br.com.rudar.core.service;

import java.util.Date;
import java.util.List;

import br.com.rudar.core.dao.ProdutoDao;
import br.com.rudar.core.entity.Produto;
import br.com.rudar.view.managedBean.ProdutoBean.TipoFiltro;
import br.com.rudar.view.util.UtilMensagens;

public class ProdutoService implements GenericService<Produto> {

	private ProdutoDao produtoDao;
	
	
	public ProdutoService() {
		produtoDao = new ProdutoDao();
	}
	
	
	@Override
	public boolean salvar(Produto entidate) {
		if (entidate.getId() == null) {
			entidate.setCodigo(produtoDao.getMaxCodigo()+1);
			
			if (produtoDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Produto Realizado com Sucesso");
				return true;
			}
		} else {
			if (produtoDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Produto Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(Produto entidade) {
		produtoDao.delete(entidade);
	}

	
	@Override
	public Produto carregarEntidade(Integer id) {
		return produtoDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<Produto> buscarTodos() {
		return null;
	}

	
	public Produto buscarProduto(String jpql , Object...params){
		try {
			return produtoDao.findOne(jpql, params);
			
		}catch(javax.persistence.NonUniqueResultException ex){
			ex.printStackTrace();
			UtilMensagens.mensagemAtencao("Existe mais de um Produto para o código fornecido!");
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			UtilMensagens.mensagemAtencao("Produto não encontrado para os parâmetros fornecidos!");
			return null;
		}				
	}
	
	
	public List<Produto> buscar(String jpql , Object...params){
		return produtoDao.find(jpql, params);
	}
	
	
	public List<Produto> buscaPaginada(Integer maxResults){
		return produtoDao.findByPaged(maxResults);
	}
	
	
	public List<Produto> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<Produto> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO)){
			String jpql = 
				"Select p, g From Produto p left join fetch p.grupoProduto g where p.codigo in (" + valorFiltro + ")";
			lista = produtoDao.find(jpql);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			String jpql =
				"Select p, g From Produto p left join fetch p.grupoProduto g where p.nome like ?";
			lista = produtoDao.find(jpql,valorFiltro);
		}
		
		return lista;
	}
	
	
	public Double buscarPreco(Integer produto, Date data, String cemp, Integer condPagamento, Integer cliente){
		return produtoDao.findPrice(produto, data, cemp, condPagamento, cliente);
	}


	/**
	 * Retorna o id,codigo e nome do produto e o id, codigo estrutural e nome do grupo,
	 * usado para preencher a tabela do cadastro de produto.
	 * @return List<Produto>
	 */
	public List<Produto> preencherTabela(){
		String jpql = 
			"SELECT new br.com.rudar.core.entity.Produto(p.id, p.codigo, p.nome,"
			+ " g.id as idGrupo, g.codigoEstrutural, g.nome as nomeGrupo)"
			+ " FROM Produto p "
			+ " left JOIN p.gupoProduto g";
		return produtoDao.find(jpql);
	}

}
