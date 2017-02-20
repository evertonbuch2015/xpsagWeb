package br.com.rudar.view.managedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.rudar.core.entity.Colaborador;
import br.com.rudar.core.entity.CondicaoPagamento;
import br.com.rudar.core.entity.Empresa;
import br.com.rudar.core.entity.Romaneio;
import br.com.rudar.core.entity.RomaneioItem;
import br.com.rudar.core.enumerated.TipoFrete;
import br.com.rudar.core.service.ColaboradorService;
import br.com.rudar.core.service.CondicaoPagamentoService;
import br.com.rudar.core.service.RomaneioService;
import br.com.rudar.view.util.SessionContext;

@ManagedBean
@SessionScoped
public class RomaneioBean extends GenericBean<Romaneio> {
	
	public enum TipoFiltro{
		CODIGO("Código"), NOME_CLIENTE("Nome Cliente"),
		DATA_EMISSAO("Data Emissão"),DATA_EMISSAO_MAIOR("Data Emissão >=");
		
		private String label;

		TipoFiltro(String label) {
			this.label = label;
		}
		
		public String getLabel(){
			return this.label;
		}
	}
	
	private TipoFiltro filtro;	
	private RomaneioService romaneioService;
	private ColaboradorService colaboradorService;
	private CondicaoPagamentoService condicaoPagamentoService;
		
	private Integer usuarioId;
	private List<Colaborador> transportadoras;
	private List<Colaborador> entregadores;
	private List<CondicaoPagamento> condicaoPagamentos;
	private RomaneioItem romaneioItem;
	
	
	
	public RomaneioBean() {
		this.romaneioService = new RomaneioService();
		this.colaboradorService = new ColaboradorService();
		this.condicaoPagamentoService = new CondicaoPagamentoService();
	}

	
	// =======================METODOS DO USUARIO=====================================	
	
	public void filtrar(){
		this.entidades = romaneioService.filtrarTabela(filtro, valorFiltro);
	}
	
	
	@Override
	public void carregaEntidade() {	
		this.entidade = romaneioService.carregarEntidade(this.entidade.getId());		
	}	

	
	@Override
	public Romaneio criarEntidade() {
		Empresa empresa = SessionContext.getInstance().getEmpresaUsuarioLogado();	
		
		Romaneio romaneio = new Romaneio();
		romaneio.setTipoFrete(TipoFrete.C);
		romaneio.setDataEmissao(new Date());
		romaneio.setVendedor(SessionContext.getInstance().getUsuarioLogado().getVendedor());
		romaneio.setCemp(empresa.getCodigo());	
		romaneio.setFilial(empresa.getFilial());		
		
		return romaneio;
	}


	@Override
	public void gravar() {
		if (romaneioService.salvar(this.entidade)) {									
			refresh();
			mudarBuscar();
		}			
	}
	

	@Override
	public void excluir(Romaneio entidade) {
		romaneioService.excluir(entidade);
		refresh();
		mudarBuscar();
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
			
		Date dt = c.getTime();
			
		this.entidades = romaneioService.buscar("Select r From Romaneio r left JOIN FETCH r.colaborador "
				+ "	where r.dataEmissao >= ?1 order by r.codigo asc", dt);
	}
	
	
	public void excluirItem(RomaneioItem romaneioItem){
		if(this.entidade.getRomaneioItens().contains(romaneioItem)){
			this.entidade.getRomaneioItens().remove(romaneioItem);
		}
	}
	
	
	public void adicionarItem(RomaneioItem romaneioItem){		
		romaneioItem.setRomaneio(this.entidade);
		romaneioItem.setItem(this.entidade.getRomaneioItens().size()+1);	
		this.entidade.getRomaneioItens().add(romaneioItem);
	}
	
	
	public void ItemSelecionado(SelectEvent event){
		RomaneioItem romaneioItem = (RomaneioItem) event.getObject();
		adicionarItem(romaneioItem);
	}

	
	public void colaboradorSelecionado(SelectEvent event){
		Colaborador colaborador = (Colaborador) event.getObject();	
		this.entidade.setColaborador(colaborador);
	}
	
	
	// =============================GET AND SET=====================================
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	public RomaneioItem getRomaneioItem() {
		return romaneioItem;
	}
	
	public void setRomaneioItem(RomaneioItem romaneioItem) {
		this.romaneioItem = romaneioItem;
	}
	
	
	//RETORNA LISTA TIPOS DE FRETE PARA O COMBO
	public TipoFrete[] getTiposFrete(){
		return TipoFrete.values();
	}
		
	
	//RETORNA LISTA ENTREGADORES PARA O COMBO	
	public List<Colaborador> getEntregadores() {
		if(this.entregadores == null){
			this.entregadores = colaboradorService.buscar("From Colaborador u where u.tipoCliente = ?1", "T");
		}
		return entregadores;		
	}
	
	
	//RETORNA LISTA DE TRANSPORTADORAS PARA O COMBO
	public List<Colaborador> getTransportadoras() {
		if(this.transportadoras == null){
			this.transportadoras =  colaboradorService.buscar("From Colaborador u where u.tipoCliente = ?1", "T");
		}
		return transportadoras;	
	}
	
	
	//RETORNA LISTA DE CONDIÇÕES DE PAGAMENTO PARA O COMBO
	public List<CondicaoPagamento> getCondicaoPagamentos() {
		if(this.condicaoPagamentos == null){
			this.condicaoPagamentos = 
					condicaoPagamentoService.buscar("Select c From CondicaoPagamento c where c.tipo in('A','B','C','K')");
		}
		return condicaoPagamentos;
	}
	
	
	//RETORNA LISTA DE FILTROS PARA O COMBO
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
