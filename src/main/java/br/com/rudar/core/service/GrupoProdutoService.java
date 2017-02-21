package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.GrupoProdutoDao;
import br.com.rudar.core.entity.GrupoProduto;
import br.com.rudar.view.managedBean.GrupoProdutoBean.TipoFiltro;
import br.com.rudar.view.util.UtilMensagens;

public class GrupoProdutoService implements GenericService<GrupoProduto> {

	private GrupoProdutoDao grupoProdutoDao;
	
	
	public GrupoProdutoService() {
		grupoProdutoDao = new GrupoProdutoDao();
	}
	
	
	@Override
	public boolean salvar(GrupoProduto entidate) {
		if (entidate.getId() == null) {
			if (grupoProdutoDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Grupo de Produto Realizado com Sucesso");
				return true;
			}
		} else {
			if (grupoProdutoDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Grupo de Produto Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(GrupoProduto entidade) {
		grupoProdutoDao.delete(entidade);
	}

	
	@Override
	public GrupoProduto carregarEntidade(Integer id) {
		return grupoProdutoDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<GrupoProduto> buscarTodos() {
		return grupoProdutoDao.findAll();
	}

	
	public List<GrupoProduto> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<GrupoProduto> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO_ESTRUTURAL)){
			lista = grupoProdutoDao.find("Select g From GrupoProduto g where g.codigoEstrutural like ?",valorFiltro);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = grupoProdutoDao.find("Select g From GrupoProduto g where g.nome like ?",valorFiltro);
		}
		
		return lista;
	}


	public List<GrupoProduto> buscar(String jpql , Object...params){
		return grupoProdutoDao.find(jpql, params);
	}


	public GrupoProduto buscarPeloCodigoEstrutural(String codigo){
		return grupoProdutoDao.findOne("From GrupoProduto g where g.codigoEstrutural = ?1", codigo);
	}
}
