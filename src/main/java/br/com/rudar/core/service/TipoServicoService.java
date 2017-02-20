package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.TipoServicoDao;
import br.com.rudar.core.entity.TipoServico;
import br.com.rudar.view.managedBean.TipoServicoBean.TipoFiltro;
import br.com.rudar.view.util.UtilMensagens;

public class TipoServicoService implements GenericService<TipoServico> {

	private TipoServicoDao tipoServicoDao;
	
	
	public TipoServicoService() {
		tipoServicoDao = new TipoServicoDao();
	}
	
	@Override
	public boolean salvar(TipoServico entidate) {
		if (entidate.getId() == null) {
			if (tipoServicoDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Tipo de Serviço Realizado com Sucesso");
				return true;
			}
		} else {
			if (tipoServicoDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Tipo de Serviço Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	@Override
	public void excluir(TipoServico entidade) {
		tipoServicoDao.delete(entidade);
	}

	@Override
	public TipoServico carregarEntidade(Integer id) {
		return tipoServicoDao.findAllAttributesEntity(id);
	}

	@Override
	public List<TipoServico> buscarTodos() {
		return tipoServicoDao.findAll();
	}

	
	public List<TipoServico> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<TipoServico> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO_ESTRUTURAL)){
			lista = tipoServicoDao.find("Select t From TipoServico t where t.codigoEstrutural like ?",valorFiltro);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = tipoServicoDao.find("Select t From TipoServico t where t.nome like ?",valorFiltro);
		}
		
		return lista;
	}
}
