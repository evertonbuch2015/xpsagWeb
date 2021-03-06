package br.com.rudar.view.managedBean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.rudar.core.entity.Colaborador;
import br.com.rudar.core.enumerated.TipoColaborador;
import br.com.rudar.core.enumerated.TipoPessoa;
import br.com.rudar.core.service.ColaboradorService;
import br.com.rudar.view.util.SessionContext;

@ManagedBean
@SessionScoped
public class ColaboradorBean extends GenericBean<Colaborador> {

	public enum TipoFiltro{
		CODIGO("C�digo"), NOME("Nome");
		
		private String label;

		TipoFiltro(String label) {
			this.label = label;
		}
		
		public String getLabel(){
			return this.label;
		}
	}
	
	private TipoFiltro filtro;	
	private ColaboradorService colaboradorService;
	private String mascaraDocumento;
	
	
	public ColaboradorBean() {
		colaboradorService = new ColaboradorService();
		this.mascaraDocumento = "99.999.999/9999-99";
	}
	
	
	// =======================METODOS DO USUARIO=====================================
	
	public void filtrar(){
		this.entidades = colaboradorService.filtrarTabela(filtro,  valorFiltro);
	}
	
	
	@Override
	public void carregaEntidade() {
		this.entidade = colaboradorService.carregarEntidade(this.entidade.getId());		
	}
	
	
	@Override
	public Colaborador criarEntidade() {
		this.entidade = new Colaborador();
		this.entidade.getPessoa().setDataCadastro(new Date());
		this.entidade.getPessoa().setCemp(SessionContext.getInstance().getEmpresaUsuarioLogado().getCodigo());
		this.entidade.setCemp(SessionContext.getInstance().getEmpresaUsuarioLogado().getCodigo());
		
		return new Colaborador();
	}

	
	@Override
	public void gravar() {
		this.entidade.setCodigo(colaboradorService.maxCodigo() +1);
		
		if (colaboradorService.salvar(this.entidade)) {			
			refresh();
			mudarBuscar();
		}	
	}

	
	@Override
	public void excluir(Colaborador entidade) {
		colaboradorService.excluir(entidade);
		refresh();
		mudarBuscar();
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
			
		this.entidades = colaboradorService.buscaPaginada(30);
	}
	

	/**
	 * M�todo respons�vel por trocar a mascara do campo documento.
	 * Acionado no change do combo TipoPessoa.
	 */
	public void trocarMascara(){
		if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.F)){
			this.mascaraDocumento = "999.999.999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.J)){
			this.mascaraDocumento = "99.999.999/9999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.E)){
			this.mascaraDocumento = "99999999999999999999";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.V)){
			this.mascaraDocumento = "99.999.999/9999-99";
		}else if(this.entidade.getPessoa().getTipo().equals(TipoPessoa.C)){
			this.mascaraDocumento = "999999999/99";
		}
	}
	
	
	// =============================GET AND SET======================================
	
	//RETORNA LISTA TIPO DE PESSOA PARA O COMBO
	public TipoPessoa[] getTipoPessoas(){
		return TipoPessoa.values();
	}
	
	
	//RETORNA LISTA TIPO DE PESSOA PARA O COMBO
	public TipoColaborador[] getTipoColaborador(){
		return TipoColaborador.values();
	}
	
	
	public String getMascaraDocumento() {
		return mascaraDocumento;
	}
	
	public void setMascaraDocumento(String mascaraDocumento) {
		this.mascaraDocumento = mascaraDocumento;
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
