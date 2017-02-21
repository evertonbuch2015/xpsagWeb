package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.ClasFiscalDao;
import br.com.rudar.core.entity.ClasFiscal;
import br.com.rudar.view.util.UtilMensagens;

public class ClasFiscalService implements GenericService<ClasFiscal> {

	private ClasFiscalDao clasFiscalDao;
	
	
	public ClasFiscalService() {
		clasFiscalDao = new ClasFiscalDao();
	}
	
	
	@Override
	public boolean salvar(ClasFiscal entidate) {
		if (entidate.getId() == null) {						
			if (clasFiscalDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Classifica��o Fiscal Realizado com Sucesso");
				return true;
			}
		} else {
			if (clasFiscalDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Classifica��o Fiscal Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(ClasFiscal entidade) {
		clasFiscalDao.delete(entidade);
	}

	
	@Override
	public ClasFiscal carregarEntidade(Integer id) {
		return clasFiscalDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<ClasFiscal> buscarTodos() {
		return clasFiscalDao.findAll();
	}

}
