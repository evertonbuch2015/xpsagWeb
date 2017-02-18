package br.com.rudar.mbeans;

import br.com.rudar.DAO.TipoServicoDao;
import br.com.rudar.entity.TipoServico;

public class TipoServicoBean extends GenericBean<TipoServico> {

	public enum TipoFiltro{
		CODIGO_ESTRUTURAL("Código"), NOME("Nome");
		
		private String label;

		TipoFiltro(String label) {
			this.label = label;
		}
		
		public String getLabel(){
			return this.label;
		}
	}
	
	private TipoFiltro filtro;
	private Integer entidadeId;
	private TipoServicoDao tipoServicoDao;  
	
	
	public TipoServicoBean() {
		tipoServicoDao = new TipoServicoDao();
	}
	
	
	@Override
	public void filtrar() {
		this.entidades = tipoServicoDao.getByFilterTable(filtro, valorFiltro);
		
	}

	
	@Override
	public TipoServico criarEntidade() {
		return new TipoServico();
	}

	
	@Override
	public void gravar() {
		if (tipoServicoDao.gravar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}

	
	@Override
	public void excluir(TipoServico entidade) {
		tipoServicoDao.delete(entidade);
		refresh();
		mudarBuscar();
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		this.entidades = tipoServicoDao.findAll();
	}

	
	@Override
	public void carregaEntidade() {
		tipoServicoDao.findAllAttributesEntity(this.entidade.getId());
	}


	// =============================GET AND SET=====================================
	
	
	public Integer getEntidadeId() {
		return entidadeId;
	}
	
	public void setEntidadeId(Integer entidadeId) {
		this.entidadeId = entidadeId;
	}
	
	
	public TipoFiltro[] tipoFiltros(){
		return TipoFiltro.values();
	}
	
	public TipoFiltro getFiltro() {
		return filtro;
	}
	
	public void setFiltro(TipoFiltro filtro) {
		this.filtro = filtro;
	}
}
