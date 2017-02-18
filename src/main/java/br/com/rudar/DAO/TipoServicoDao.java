package br.com.rudar.DAO;

import java.util.List;

import br.com.rudar.entity.TipoServico;
import br.com.rudar.mbeans.TipoServicoBean.TipoFiltro;
import br.com.rudar.util.UtilMensagens;

public class TipoServicoDao extends GenericDao<TipoServico> {

	public TipoServicoDao() {
		super(TipoServico.class);
	}

	
	@Override
	public TipoServico findAllAttributesEntity(Integer id) {
		String jpql =
				"Select t, c, ii From TipoServico t left Join fetch t.planoContas c "
						+ "	left Join fetch t.tipoServicoItens ii where t.id = ?1";
		return findOne(jpql, id);
	}

	
	@Override
	public boolean gravar(TipoServico entity) {
		if (entity.getId() == null) {
			if (save(entity)) {
				UtilMensagens.mensagemInformacao("Cadastro de Tipo de Serviço Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(entity)) {
				UtilMensagens.mensagemInformacao("Cadastro de Tipo de Serviço Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	public List<TipoServico> getByFilterTable(TipoFiltro tipoFiltro , String valorFiltro){
		List<TipoServico> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO_ESTRUTURAL)){
			lista = find("Select t From TipoServico t where t.codigoEstrutural like ?",valorFiltro);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = find("Select t From TipoServico t where t.nome like ?",valorFiltro);
		}
		
		return lista;
	}
}
