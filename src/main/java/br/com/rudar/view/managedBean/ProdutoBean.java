package br.com.rudar.view.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.rudar.core.entity.GrupoProduto;
import br.com.rudar.core.entity.Produto;
import br.com.rudar.core.entity.Unidade;
import br.com.rudar.core.service.GrupoProdutoService;
import br.com.rudar.core.service.ProdutoService;
import br.com.rudar.core.service.UnidadeService;

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
	private UnidadeService unidadeService;
	private GrupoProdutoService grupoProdutoService;
	
	private List<Unidade> unidades;
	
	public ProdutoBean() {
		produtoService 		= new ProdutoService();
		unidadeService 		= new UnidadeService();
		grupoProdutoService = new GrupoProdutoService();
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
		this.entidade.setGrupoProduto((GrupoProduto) event.getObject());
		
	}
	
	
	public List<GrupoProduto> completaGrupoProduto(String query){
		return grupoProdutoService.buscar("From GrupoProduto g where g.nome like ?1", "%"+query+"%");
	}
	
	
	public void buscarGrupoProduto(){
		GrupoProduto grupoProduto = grupoProdutoService.buscarPeloCodigoEstrutural(this.entidade.getGrupoProduto().getCodigoEstrutural());
		if(grupoProduto != null){
			this.entidade.setGrupoProduto(grupoProduto);
		}		
	}
	// =============================GET AND SET=====================================
	
	public Integer getEntidadeId() {
		return entidadeId;
	}
	
	public void setEntidadeId(Integer entidadeId) {
		this.entidadeId = entidadeId;
	}
	

	
	//RETORNA LISTA DE UNIDADES PARA O COMBO
	public List<Unidade> getUnidades(){
		if(this.unidades == null){
			this.unidades = unidadeService.buscarTodos();
		}
		return unidades; 
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