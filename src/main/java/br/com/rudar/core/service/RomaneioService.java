package br.com.rudar.core.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.rudar.core.dao.RomaneioDao;
import br.com.rudar.core.entity.Romaneio;
import br.com.rudar.view.managedBean.RomaneioBean.TipoFiltro;

public class RomaneioService implements GenericService<Romaneio> {
	
	private RomaneioDao romaneioDao;
	
	
	public RomaneioService() {
		romaneioDao = new RomaneioDao();
	}
	
	
	@Override
	public boolean salvar(Romaneio entidate) {
		return romaneioDao.gravar(entidate);
	}

	
	@Override
	public void excluir(Romaneio entidade) {
		romaneioDao.delete(entidade);
	}

	
	@Override
	public Romaneio carregarEntidade(Integer id) {
		return romaneioDao.findOne("SELECT r, c, v, e, t, cc,ii FROM Romaneio r left JOIN FETCH r.condicaoPagamento c left JOIN FETCH r.vendedor v"
				+ " left JOIN FETCH r.entregador e left JOIN FETCH r.transportadora t left JOIN FETCH r.colaborador cc left JOIN FETCH r.romaneioItens ii"
				+ " where r.id = ?1", id);
	}

	
	@Override
	public List<Romaneio> buscarTodos() {
		return null;
	}

	
	public List<Romaneio> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<Romaneio> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO)){
			String jpql = "Select r From Romaneio r where r.codigo in (" + valorFiltro + ")";
			lista = romaneioDao.find(jpql);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME_CLIENTE)){
			lista = 
					romaneioDao.find("Select r From Romaneio r left JOIN FETCH r.colaborador c "
				+ "	where c.fantasia Like ?1 order by r.codigo asc",valorFiltro);
		}
		else if(tipoFiltro.equals(TipoFiltro.DATA_EMISSAO)){
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dt = sdf.parse(valorFiltro);				
				lista = 
						romaneioDao.find("Select r From Romaneio r left JOIN FETCH r.colaborador "
							+ "	where r.dataEmissao = ?1 order by r.codigo asc", dt);
			} catch (Exception e) {

			}
		}
		else if(tipoFiltro.equals(TipoFiltro.DATA_EMISSAO_MAIOR)){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dt = sdf.parse(valorFiltro);				
				lista = 
						romaneioDao.find("Select r From Romaneio r left JOIN FETCH r.colaborador "
							+ "	where r.dataEmissao >= ?1 order by r.codigo asc", dt);
			} catch (Exception e) {

			}
		}
				
		return lista;
	}

	
	public List<Romaneio> buscar(String jpql , Object...params) {
		return romaneioDao.find(jpql,params);
	}
}
