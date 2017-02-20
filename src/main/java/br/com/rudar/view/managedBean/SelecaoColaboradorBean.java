package br.com.rudar.view.managedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.rudar.core.entity.Colaborador;
import br.com.rudar.core.service.ColaboradorService;
import br.com.rudar.view.util.SessionContext;

@ManagedBean
@SessionScoped
public class SelecaoColaboradorBean {
	
	private List<Colaborador> colaboradores;
	private ColaboradorService colaboradorService;
	private String filtro;	
	
	
	public SelecaoColaboradorBean() {
		this.colaboradores = new ArrayList<Colaborador>();
		this.colaboradorService = new ColaboradorService();
	}
	
	
	// =============================METODOS DO USUÀRIO===============================

	public void pesquisar(){
		Integer codVendedor = SessionContext.getInstance().getUsuarioLogado().getVendedor().getId();
				
		this.colaboradores = colaboradorService.buscarColaboradoresPeloVendedor(codVendedor, filtro);
	}
	
	
	public void AbrirDialogProduto() {		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("modal", true);
        options.put("contentHeight", 500);
        RequestContext.getCurrentInstance().openDialog("/dialogosSelecao/SelecaoColaborador", options, null);
    }
	
	
	public void retornoDialog(Colaborador colaborador){
		RequestContext.getCurrentInstance().closeDialog(colaborador);
	}

	// =============================GET AND SET======================================
	
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	
	public String getFiltro() {
		return filtro;
	}
	
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
