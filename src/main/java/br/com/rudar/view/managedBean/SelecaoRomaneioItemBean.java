package br.com.rudar.view.managedBean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.rudar.core.entity.Empresa;
import br.com.rudar.core.entity.OperacaoSaida;
import br.com.rudar.core.entity.Produto;
import br.com.rudar.core.entity.RomaneioItem;
import br.com.rudar.core.entity.Unidade;
import br.com.rudar.core.service.ProdutoService;
import br.com.rudar.view.util.SessionContext;

@ManagedBean
@SessionScoped
public class SelecaoRomaneioItemBean {

	private RomaneioItem romaneioItem;
	private ProdutoService produtoService;
	
	
	public SelecaoRomaneioItemBean() {
		produtoService = new ProdutoService();
	}
	
	// =============================METODOS DO USU�RIO================================
	
	public List<Produto> completaProduto(String query) { 
        List<Produto> produtos = produtoService.buscar("From Produto p where p.nome like ?1", "%"+ query +"%");         
        return produtos;
    }
	
	
	public void onItemSelect(SelectEvent event) {
		Produto produto = (Produto) event.getObject();
		
		OperacaoSaida operacaoSaida = 
			produtoService.buscarProduto("SELECT u FROM Produto u left JOIN FETCH u.operacaoSaida where u.id = ?1", produto.getId()).getOperacaoSaida();
		
		Unidade unidade = 
			produtoService.buscarProduto("SELECT u FROM Produto u left JOIN FETCH u.unidade where u.id = ?1", produto.getId()).getUnidade();
		
		this.romaneioItem.setUnidade(unidade);
		this.romaneioItem.setOperacaoSaida(operacaoSaida);
		
		
		Empresa empresa = SessionContext.getInstance().getEmpresaUsuarioLogado();
		
		Double valor = produtoService.buscarPreco(produto.getCodigo(), new Date(), empresa.getCodigo(),null, null);
		
		romaneioItem.setValorUnitario(valor);		
	}

	
	public void AbrirDialogProduto() {		
		this.romaneioItem = new RomaneioItem();
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 300);
        RequestContext.getCurrentInstance().openDialog("/dialogosSelecao/SelecaoRomaneioItem", options, null);
    }
	
	
	public void retornoDialog(){
		RequestContext.getCurrentInstance().closeDialog(this.romaneioItem);
	}

	
	// =============================GET AND SET=======================================
	
	public RomaneioItem getRomaneioItem() {
		return romaneioItem;
	}
	
	
	public void setRomaneioItem(RomaneioItem romaneioItem) {
		this.romaneioItem = romaneioItem;
	}	
}
