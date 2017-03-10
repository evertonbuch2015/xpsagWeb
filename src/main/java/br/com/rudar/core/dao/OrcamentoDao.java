package br.com.rudar.core.dao;

import br.com.rudar.core.entity.Orcamento;

public class OrcamentoDao extends GenericDao<Orcamento> {

	public OrcamentoDao() {
		super(Orcamento.class);

	}

	@Override
	public Orcamento findAllAttributesEntity(Integer id) {
		String jpql = " Select o, c, v From Orcamento o left join fetch o.condicaoPagamento c "
					+ " left join fetch o.vendedor v where o.id = ?1";
		try {
			return findOne(jpql, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;			
		}
	}

}
