package br.com.rudar.mbeans;

import br.com.rudar.DAO.GrupoProdutoDao;
import br.com.rudar.entity.GrupoProduto;

public class GrupoProdutoBean extends GenericBean<GrupoProduto> {

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
	private GrupoProdutoDao grupoProdutoDao; 
	
	
	public GrupoProdutoBean() {
		grupoProdutoDao = new GrupoProdutoDao();
	}
	
	
	// =======================METODOS DO USUARIO=====================================
	
	@Override
	public void filtrar() {
		this.entidades = grupoProdutoDao.getByFilterTable(filtro, valorFiltro);
	}

	
	@Override
	public GrupoProduto criarEntidade() {
		return new GrupoProduto();
	}

	
	@Override
	public void gravar() {
		if (grupoProdutoDao.gravar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}

	
	@Override
	public void excluir(GrupoProduto entidade) {
		grupoProdutoDao.delete(entidade);
		refresh();
		mudarBuscar();
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		this.entidades = grupoProdutoDao.findAll();
	}

	
	@Override
	public void carregaEntidade() {
		grupoProdutoDao.findAllAttributesEntity(this.entidade.getId());
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
