package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.VendedorDao;
import br.com.rudar.core.entity.Vendedor;
import br.com.rudar.view.util.UtilMensagens;

public class VendedorService implements GenericService<Vendedor> {

	private VendedorDao vendedorDao;
	
	public VendedorService() {
		vendedorDao = new VendedorDao();
	}
	
	
	@Override
	public boolean salvar(Vendedor entidate) {
		if (entidate.getId() == null) {
			if (vendedorDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Vendedor Realizado com Sucesso");
				return true;
			}
		} else {
			if (vendedorDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Cadastro de Vendedor Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(Vendedor entidade) {
		vendedorDao.delete(entidade);
	}
	

	@Override
	public Vendedor carregarEntidade(Integer id) {
		return vendedorDao.findAllAttributesEntity(id);
	}


	@Override
	public List<Vendedor> buscarTodos() {
		return vendedorDao.findAll();
	}

}
