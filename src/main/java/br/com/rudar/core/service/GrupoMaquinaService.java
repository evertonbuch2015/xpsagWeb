package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.GrupoMaquinaDao;
import br.com.rudar.core.entity.GrupoMaquina;
import br.com.rudar.view.util.UtilMensagens;

public class GrupoMaquinaService implements GenericService<GrupoMaquina> {

	private GrupoMaquinaDao grupoMaquinaDao;
	
	
	public GrupoMaquinaService() {
		grupoMaquinaDao = new GrupoMaquinaDao();
	}
	
	
	
	@Override
	public boolean salvar(GrupoMaquina grupoMaquina) {
		if (grupoMaquina.getId() == null) {
			if (grupoMaquinaDao.save(grupoMaquina)) {
				UtilMensagens.mensagemInformacao("Cadastro de Grupo de Maquinas Realizado com Sucesso");
				return true;
			}
		} else {
			if (grupoMaquinaDao.update(grupoMaquina)) {
				UtilMensagens.mensagemInformacao("Cadastro de Grupo de Maquinas Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(GrupoMaquina entidade) {
		grupoMaquinaDao.delete(entidade);
	}

	
	@Override
	public GrupoMaquina carregarEntidade(Integer id) {
		return grupoMaquinaDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<GrupoMaquina> buscarTodos() {
		return grupoMaquinaDao.findAll();
	}
	
	
	public List<GrupoMaquina> buscar(String jpql , Object...params) {
		return grupoMaquinaDao.find(jpql,params);
	}

	
	/**
	 * Retorna somente o ID CODIGO NOME, usado para preencher os selectOneMenu das telas.  
	 * @return
	 */
	public List<GrupoMaquina> preencherSelectOneMenu(){
		String jpql = "Select new GrupoMaquina(g.id, g.codigo, g.nome) From GrupoMaquina g";
		return grupoMaquinaDao.find(jpql);
	}
}
