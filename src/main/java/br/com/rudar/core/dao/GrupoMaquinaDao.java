package br.com.rudar.core.dao;

import br.com.rudar.core.entity.GrupoMaquina;

public class GrupoMaquinaDao extends GenericDao<GrupoMaquina> {

	public GrupoMaquinaDao(){
		super(GrupoMaquina.class);
	}

	
	@Override
	public GrupoMaquina findAllAttributesEntity(Integer id) {
		return findById(id);
	}

}
