package br.com.rudar.core.dao;

import br.com.rudar.core.entity.ClasFiscal;

public class ClasFiscalDao extends GenericDao<ClasFiscal> {

	public ClasFiscalDao() {
		super(ClasFiscal.class);
	}

	
	@Override
	public ClasFiscal findAllAttributesEntity(Integer id) {
		String jpql = "Select c From ClasFiscal c left join fetch c.clasFiscalItems where c.id = ?1";
		return findOne(jpql, id);
	}
}
