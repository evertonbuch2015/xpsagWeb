package br.com.rudar.view.managedBean;

import br.com.rudar.core.entity.TipoServico;
import br.com.rudar.core.service.TipoServicoService;

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
	private TipoServicoService tipoServicoService;  
	
	
	public TipoServicoBean() {
		tipoServicoService = new TipoServicoService();
	}
	
	
	@Override
	public void filtrar() {
		this.entidades = tipoServicoService.filtrarTabela(filtro, valorFiltro);
		
	}

	
	@Override
	public TipoServico criarEntidade() {
		return new TipoServico();
	}

	
	@Override
	public void gravar() {
		if (tipoServicoService.salvar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}

	
	@Override
	public void excluir(TipoServico entidade) {
		tipoServicoService.excluir(entidade);
		refresh();
		mudarBuscar();
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		this.entidades = tipoServicoService.buscarTodos();
	}

	
	@Override
	public void carregaEntidade() {
		this.entidade = tipoServicoService.carregarEntidade(this.entidade.getId());
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
