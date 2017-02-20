package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.CondicaoPagamentoDao;
import br.com.rudar.core.entity.CondicaoPagamento;
import br.com.rudar.view.util.UtilMensagens;

public class CondicaoPagamentoService implements GenericService<CondicaoPagamento> {

	private CondicaoPagamentoDao condicaoPagamentoDao;
	
	
	public CondicaoPagamentoService() {
		condicaoPagamentoDao = new CondicaoPagamentoDao();
	}
	
	
	
	@Override
	public boolean salvar(CondicaoPagamento entidate) {
		if (entidate.getId() == null) {
			if (condicaoPagamentoDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Condição de Pagamento Realizado com Sucesso");
				return true;
			}
		} else {
			if (condicaoPagamentoDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Condição de Pagamento Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(CondicaoPagamento entidade) {
		condicaoPagamentoDao.delete(entidade);
	}

	
	@Override
	public CondicaoPagamento carregarEntidade(Integer id) {
		return condicaoPagamentoDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<CondicaoPagamento> buscarTodos() {
		return condicaoPagamentoDao.findAll();
	}
	
	
	public List<CondicaoPagamento> buscar(String jpql , Object...params) {
		return condicaoPagamentoDao.find(jpql,params);
	}

	
	/**
	 * Retorna somente o ID NOME TIPO, usado para preencher os selectOneMenu das telas.  
	 * @return
	 */
	public List<CondicaoPagamento> preencherSelectOneMenu(){
		String jpql = "Select new CondicaoPagamento(c.id, c.nome, c.tipo) From CondicaoPagamento c";
		return condicaoPagamentoDao.find(jpql);
	}
}
