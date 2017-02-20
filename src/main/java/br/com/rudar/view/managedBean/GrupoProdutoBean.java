package br.com.rudar.view.managedBean;

import br.com.rudar.core.entity.GrupoProduto;
import br.com.rudar.core.service.GrupoProdutoService;

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
	private GrupoProdutoService grupoProdutoService; 
	
	
	public GrupoProdutoBean() {
		grupoProdutoService = new GrupoProdutoService();
	}
	
	
	// =======================METODOS DO USUARIO=====================================
	
	@Override
	public void filtrar() {
		this.entidades = grupoProdutoService.filtrarTabela(filtro, valorFiltro);
	}

	
	@Override
	public GrupoProduto criarEntidade() {
		return new GrupoProduto();
	}

	
	@Override
	public void gravar() {
		if (grupoProdutoService.salvar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}

	
	@Override
	public void excluir(GrupoProduto entidade) {
		grupoProdutoService.excluir(entidade);
		refresh();
		mudarBuscar();
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		this.entidades = grupoProdutoService.buscarTodos();
	}

	
	@Override
	public void carregaEntidade() {
		this.entidade = grupoProdutoService.carregarEntidade(this.entidade.getId());
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
