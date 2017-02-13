package br.com.rudar.mbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.rudar.DAO.ColaboradorDao;
import br.com.rudar.entity.Colaborador;
import br.com.rudar.util.SessionContext;

@ManagedBean
@SessionScoped
public class SelecaoColaboradorBean {
	
	private List<Colaborador> colaboradores;
	private ColaboradorDao colaboradorDao;
	private String filtro;	
	
	
	public SelecaoColaboradorBean() {
		this.colaboradores = new ArrayList<Colaborador>();
		this.colaboradorDao = new ColaboradorDao();
	}
	
	
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
	
	
	
	public void pesquisar(){
		Integer codVendedor = SessionContext.getInstance().getUsuarioLogado().getVendedor().getId();
				
		this.colaboradores = colaboradorDao.findColaboradorByVendedor(codVendedor, filtro);
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
}
