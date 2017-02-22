package br.com.rudar.core.dao;

import br.com.rudar.core.entity.TipoServico;

public class TipoServicoDao extends GenericDao<TipoServico> {

	public TipoServicoDao() {
		super(TipoServico.class);
	}

	
	@Override
	public TipoServico findAllAttributesEntity(Integer id) {
		String jpql =
				"Select t, c, ii From TipoServico t left Join fetch t.planoContas c "
						+ "	left Join fetch t.tipoServicoItens ii where t.id = ?1";
		
		try {
			return findOne(jpql, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;			
		}
	}

}
