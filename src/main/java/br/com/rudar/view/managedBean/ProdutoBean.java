package br.com.rudar.view.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.rudar.core.entity.GrupoProduto;
import br.com.rudar.core.entity.Produto;
import br.com.rudar.core.service.ProdutoService;

@ManagedBean
@SessionScoped
public class ProdutoBean extends GenericBean<Produto> {

	public enum TipoFiltro{
		CODIGO("Código"), NOME("Nome");
		
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
	private ProdutoService produtoService;
	
	
	public ProdutoBean() {
		produtoService = new ProdutoService();
	}
	
	
	// =======================METODOS DO USUARIO=====================================
	
	@Override
	public void filtrar() {
		this.entidades = produtoService.filtrarTabela(filtro, valorFiltro);
	}
	
	
	@Override
	public Produto criarEntidade() {
		return new Produto();
	}
	
	
	@Override
	public void gravar() {
		if (produtoService.salvar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}
	
	
	@Override
	public void excluir(Produto entidade) {
		produtoService.excluir(entidade);
		refresh();
		mudarBuscar();
	}
	
	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		this.entidades = produtoService.buscaPaginada(30);
	}
	
	
	@Override
	public void carregaEntidade() {
		this.entidade = produtoService.carregarEntidade(this.entidade.getId());
	}  
	
	
	public void grupoProdutoSelecionado(SelectEvent event){
		this.entidade.setGupoProduto((GrupoProduto) event.getObject());
		
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