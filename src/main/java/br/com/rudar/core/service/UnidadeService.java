package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.UnidadeDao;
import br.com.rudar.core.entity.Unidade;
import br.com.rudar.view.util.UtilMensagens;

public class UnidadeService implements GenericService<Unidade> {

	private UnidadeDao unidadeDao;  
	
	
	public UnidadeService() {
		unidadeDao = new UnidadeDao();
	}
	
	
	@Override
	public boolean salvar(Unidade entidate) {
		if (entidate.getId() == null) {
			if (unidadeDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Unidades Inserido com Sucesso");
				return true;
			}
		} else {
			if (unidadeDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Unidades Alterado com Sucesso");
				return true;
			}
		}
		return false;	
	}

	
	@Override
	public void excluir(Unidade entidade) {
		unidadeDao.delete(entidade);
	}

	
	@Override
	public Unidade carregarEntidade(Integer id) {
		return unidadeDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<Unidade> buscarTodos() {
		return unidadeDao.findAll();
	}

}
