package br.com.rudar.mbeans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.rudar.DAO.EmpresaDao;
import br.com.rudar.entity.Empresa;
import br.com.rudar.enumerated.RamoAtividade;
import br.com.rudar.enumerated.RegimeTributario;

@ManagedBean
@SessionScoped
public class EmpresaBean extends GenericBean<Empresa> {
	
	private Integer empresaId;
	private EmpresaDao empresaDao;

	
	public EmpresaBean() {
		empresaDao = new EmpresaDao();
	}
	
	
	// =======================METODOS DO USUARIO=================================================
	
	@Override
	public void carregaEntidade() {
		//empresaDao.fecharConexao();		
	}
	
	
	@Override
	public Empresa criarEntidade() {
		this.entidade = new Empresa();
		entidade.setDataCadastro(new Date());
		return entidade;
	}

	
	@Override
	public void refresh() {
		if (this.entidades == null) {
			this.entidades = empresaDao.findAll();
		}				
	}
	
	
	@Override
	public void gravar() {
		if (empresaDao.gravar(this.entidade)) {			
			this.entidades = empresaDao.findAll();
			mudarBuscar();
		}	
	}

	
	@Override
	public void excluir(Empresa entidade) {
		empresaDao.delete(entidade);
		this.entidades = empresaDao.findAll();
		mudarBuscar();
	}

	
	public void AbrirDialogEmpresas() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("contentHeight", 450);				
        RequestContext.getCurrentInstance().openDialog("/dialogosSelecao/SelecaoEmpresa", options, null);
    }
	
	
	public void retornoDialog(Empresa empresa){
		RequestContext.getCurrentInstance().closeDialog(empresa);
	}
		
	// =============================GET AND SET=================================
	
	public EmpresaDao getEmpresaDao() {
		return empresaDao;
	}
	
	
	public Integer getEmpresaId() {
		return empresaId;
	}
	
	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}
	
	
	
	public RegimeTributario[] getRegimes(){
		return RegimeTributario.values();
	}
	
	public RamoAtividade[] getRamoAtividades(){
		return RamoAtividade.values();
	}
}
