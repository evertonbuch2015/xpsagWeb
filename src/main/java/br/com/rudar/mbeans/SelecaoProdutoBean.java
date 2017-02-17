package br.com.rudar.mbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.rudar.DAO.ProdutoDao;
import br.com.rudar.entity.Produto;
import br.com.rudar.mbeans.ProdutoBean.TipoFiltro;

@ManagedBean
@SessionScoped
public class SelecaoProdutoBean {
	
	private List<Produto> produtos;
	private ProdutoDao produtoDao ;
	private TipoFiltro filtro;
	protected String valorFiltro;
	
	public SelecaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produtoDao = new ProdutoDao();
	}
	
	
	// =============================METODOS DO USUÀRIO===============================

	public void pesquisar(){				
		this.produtos = produtoDao.getByFilterTable(filtro, valorFiltro);
	}
	
	
	public void AbrirDialogGrupoProduto() {		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("modal", true);
        options.put("contentHeight", 500);
        RequestContext.getCurrentInstance().openDialog("/dialogosSelecao/SelecaoProduto", options, null);
    }
	
	
	public void retornoDialog(Produto produto){
		RequestContext.getCurrentInstance().closeDialog(produto);
	}

	// =============================GET AND SET======================================


	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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


	public String getValorFiltro() {
		return valorFiltro;
	}
	
	public void setValorFiltro(String valorFiltro) {
		this.valorFiltro = valorFiltro;
	}

}
