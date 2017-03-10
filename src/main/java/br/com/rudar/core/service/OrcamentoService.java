package br.com.rudar.core.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.rudar.core.dao.OrcamentoDao;
import br.com.rudar.core.entity.Orcamento;
import br.com.rudar.view.managedBean.OrcamentoBean.TipoFiltro;
import br.com.rudar.view.util.UtilMensagens;

public class OrcamentoService implements GenericService<Orcamento> {

	private OrcamentoDao orcamentoDao;
	
	
	public OrcamentoService() {
		orcamentoDao = new OrcamentoDao();
	}
	
	
	
	@Override
	public boolean salvar(Orcamento entidate) {
		if (entidate.getId() == null) {			
			if (orcamentoDao.save(entidate)) {
				UtilMensagens.mensagemInformacao("Orçamento Cadastrado com Sucesso");
				return true;
			}
		} else {
			if (orcamentoDao.update(entidate)) {
				UtilMensagens.mensagemInformacao("Orçamento Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public void excluir(Orcamento entidade) {
		orcamentoDao.delete(entidade);
	}

	
	@Override
	public Orcamento carregarEntidade(Integer id) {
		return orcamentoDao.findAllAttributesEntity(id);
	}

	
	@Override
	public List<Orcamento> buscarTodos() {
		return orcamentoDao.findAll();
	}
	
	
	public List<Orcamento> buscar(String jpql , Object...params){
		return orcamentoDao.find(jpql, params);
	}
	
	
	public List<Orcamento> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<Orcamento> lista = null;
		String jpql = "";
		
		switch (tipoFiltro) {
		case CODIGO:
			jpql = 
				"Select o,c From Orcamento o left join fetch o.colaborador c where o.codigo in (" + valorFiltro + ")";
			lista = orcamentoDao.find(jpql);
			break;
		case CODIGO_CLIENTE:
			jpql =
				"Select o,c From Orcamento o left join fetch o.colaborador c where o.colaborador.codigo in (" + valorFiltro + ")";
			lista = orcamentoDao.find(jpql,valorFiltro);
			break;
		case NOME_CLIENTE:
			jpql =
				"Select o,c From Orcamento o left join fetch o.colaborador c where o.colaborador.fantasia like ?";
			lista = orcamentoDao.find(jpql,valorFiltro);
			break;
		case DATA_EMISSAO:			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dt = sdf.parse(valorFiltro);				
				jpql =
						"Select o,c From Orcamento o left join fetch o.colaborador c where o.dataEmissao = ?";
				lista = orcamentoDao.find(jpql,dt);				
			} catch (Exception e) {
				UtilMensagens.mensagemErro("Informe uma Data Válida no formato dd/mm/yyyy!");
			}						
			break;
		case DATA_EMISSAO_MAIOR:
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dt = sdf2.parse(valorFiltro);				
				jpql =
						"Select o,c From Orcamento o left join fetch o.colaborador c where o.dataEmissao >= ?";
				lista = orcamentoDao.find(jpql,dt);				
			} catch (Exception e) {
				UtilMensagens.mensagemErro("Informe uma Data Válida no formato dd/mm/yyyy!");
			}						
			break;
		case DATA_ENTREGA:
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dt = sdf3.parse(valorFiltro);				
				jpql =
						"Select o,c From Orcamento o left join fetch o.colaborador c where o.dataEntrega = ?";
				lista = orcamentoDao.find(jpql,dt);				
			} catch (Exception e) {
				UtilMensagens.mensagemErro("Informe uma Data Válida no formato dd/mm/yyyy!");
			}						
			break;
		case DATA_ENTREGA_MAIOR:
			SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dt = sdf4.parse(valorFiltro);				
				jpql =
						"Select o,c From Orcamento o left join fetch o.colaborador c where o.dataEntrega => ?";
				lista = orcamentoDao.find(jpql,dt);				
			} catch (Exception e) {
				UtilMensagens.mensagemErro("Informe uma Data Válida no formato dd/mm/yyyy!");
			}						
			break;
		default:
			UtilMensagens.mensagemAtencao("Informe um Filtro!");
		}
		
		return lista;
	}

}
