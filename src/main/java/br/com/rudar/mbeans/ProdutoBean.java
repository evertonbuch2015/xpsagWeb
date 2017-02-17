package br.com.rudar.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.rudar.DAO.ProdutoDao;
import br.com.rudar.entity.GrupoProduto;
import br.com.rudar.entity.Produto;

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
	private ProdutoDao produtoDao;
	
	
	public ProdutoBean() {
		produtoDao = new ProdutoDao();
	}
	
	
	// =======================METODOS DO USUARIO=====================================
	
	@Override
	public void filtrar() {
		this.entidades = produtoDao.getByFilterTable(filtro, valorFiltro);
	}
	
	
	@Override
	public Produto criarEntidade() {
		return new Produto();
	}
	
	
	@Override
	public void gravar() {
		if (produtoDao.gravar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}
	
	
	@Override
	public void excluir(Produto entidade) {
		produtoDao.delete(entidade);
		refresh();
		mudarBuscar();
	}
	
	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		this.entidades = produtoDao.findAll();
	}
	
	
	@Override
	public void carregaEntidade() {
		produtoDao.findAllAttributesEntity(this.entidade.getId());
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