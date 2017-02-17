package br.com.rudar.mbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.rudar.DAO.GrupoProdutoDao;
import br.com.rudar.entity.GrupoProduto;
import br.com.rudar.mbeans.GrupoProdutoBean.TipoFiltro;

@ManagedBean
@SessionScoped
public class SelecaoGrupoProdutoBean {
	
	private List<GrupoProduto> grupoProdutos;
	private GrupoProdutoDao grupoProdutoDao ;
	private TipoFiltro filtro;
	protected String valorFiltro;
	
	public SelecaoGrupoProdutoBean() {
		this.grupoProdutos = new ArrayList<GrupoProduto>();
		this.grupoProdutoDao = new GrupoProdutoDao();
	}
	
	
	// =============================METODOS DO USUÀRIO===============================

	public void pesquisar(){				
		this.grupoProdutos = grupoProdutoDao.getByFilterTable(filtro, valorFiltro);
	}
	
	
	public void AbrirDialogGrupoProduto() {		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("modal", true);
        options.put("contentHeight", 500);
        RequestContext.getCurrentInstance().openDialog("/dialogosSelecao/SelecaoGrupoProduto", options, null);
    }
	
	
	public void retornoDialog(GrupoProduto grupoProduto){
		RequestContext.getCurrentInstance().closeDialog(grupoProduto);
	}

	// =============================GET AND SET======================================


	public List<GrupoProduto> getGrupoProdutos() {
		return grupoProdutos;
	}
	
	public void setGrupoProdutos(List<GrupoProduto> grupoProdutos) {
		this.grupoProdutos = grupoProdutos;
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
