package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.OperacaoSaidaDao;
import br.com.rudar.core.entity.OperacaoSaida;
import br.com.rudar.view.util.UtilMensagens;

public class OperacaoSaidaService implements GenericService<OperacaoSaida> {

	private OperacaoSaidaDao operacaoSaidaDao; 
	
	
	public OperacaoSaidaService() {
		operacaoSaidaDao = new OperacaoSaidaDao();
	}
	
	
	@Override
	public boolean salvar(OperacaoSaida entidate) {
		if (entidate.getId() == null) {
			if (operacaoSaidaDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Operação de Saida Realizado com Sucesso");
				return true;
			}
		} else {
			if (operacaoSaidaDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Operação de Saida Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(OperacaoSaida entidade) {
		operacaoSaidaDao.delete(entidade);
	}

	
	@Override
	public OperacaoSaida carregarEntidade(Integer id) {
		return operacaoSaidaDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<OperacaoSaida> buscarTodos() {
		return operacaoSaidaDao.findAll();
	}

	
}
