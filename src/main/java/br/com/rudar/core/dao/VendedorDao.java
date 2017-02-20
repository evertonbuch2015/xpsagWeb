package br.com.rudar.core.dao;

import br.com.rudar.core.entity.Vendedor;

public class VendedorDao extends GenericDao<Vendedor> {

	
	public VendedorDao() {
		super(Vendedor.class);
	}
	
	
	@Override
	public Vendedor findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
