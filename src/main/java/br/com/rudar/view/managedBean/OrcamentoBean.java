package br.com.rudar.view.managedBean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.rudar.core.entity.Colaborador;
import br.com.rudar.core.entity.CondicaoPagamento;
import br.com.rudar.core.entity.Orcamento;
import br.com.rudar.core.entity.Vendedor;
import br.com.rudar.core.enumerated.TipoFrete;
import br.com.rudar.core.service.ColaboradorService;
import br.com.rudar.core.service.CondicaoPagamentoService;
import br.com.rudar.core.service.OrcamentoService;
import br.com.rudar.core.service.VendedorService;

@SessionScoped
@ManagedBean
public class OrcamentoBean extends GenericBean<Orcamento> {

	public enum TipoFiltro{
		CODIGO("Código"),
		CODIGO_CLIENTE("Código Cliente"),
		NOME_CLIENTE("Nome Cliente"),
		DATA_EMISSAO("Data Emissão"),
		DATA_EMISSAO_MAIOR("Data Emissão >="),
		DATA_ENTREGA("Data Entrega"),
		DATA_ENTREGA_MAIOR("Data Entrega >=");
		
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
	private Boolean futuroCliente;
	
	private OrcamentoService orcamentoService;
	private ColaboradorService colaboradorService;

	private List<CondicaoPagamento> condicaoPagamentos;

	
	
	
	
	public OrcamentoBean() {
		orcamentoService = new OrcamentoService();
		colaboradorService = new ColaboradorService();
	}
	
	
	// =======================METODOS DO USUARIO=====================================
		
	@Override
	public void filtrar() {
		this.entidades = orcamentoService.filtrarTabela(filtro, valorFiltro);
	}

	
	@Override
	public Orcamento criarEntidade() {
		Orcamento orcamento = new Orcamento();
		return orcamento;
	}

	
	@Override
	public void gravar() {
		
	}

	
	@Override
	public void excluir(Orcamento entidade) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void refresh() {
		if(this.entidades != null){
			this.entidades.clear();
		}
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
			
		Date dt = c.getTime();
			
		this.entidades = orcamentoService.buscar("Select o From Orcamento o left JOIN FETCH o.colaborador "
				+ "	where o.dataEmissao >= ?1 order by o.codigo asc", dt);
	}

	
	@Override
	public void carregaEntidade() {
		this.entidade = orcamentoService.carregarEntidade(this.entidade.getId());		
	}

	
	public List<Colaborador> completaColaborador(String query) { 
        List<Colaborador> colaboradores = colaboradorService.buscar("From Colaborador c where c.fantasia like ?1", "%"+ query +"%");         
        return colaboradores;
    }
	
	
	public void onColaboradorSelect(SelectEvent event) {
		Colaborador colaborador = colaboradorService.carregarEntidade(((Colaborador) event.getObject()).getId());
		
		this.entidade.setEmail(colaborador.getPessoa().getEmail());
		this.entidade.setDocumentoRef(colaborador.getPessoa().getDocumento());
		this.entidade.setContato(colaborador.getPessoa().getContato());
	}

	
	// =============================GET AND SET=====================================


	//RETORNA LISTA TIPOS DE FRETE PARA O COMBO
	public TipoFrete[] getTiposFrete(){
		return TipoFrete.values();
	}
		
	
	//RETORNA LISTA DE VENDEDORES PARA O COMBO
	public List<Vendedor> getVendedores(){
		return new VendedorService().buscarTodos();
	}
	

	//RETORNA LISTA DE CONDIÇÕES DE PAGAMENTO PARA O COMBO
	public List<CondicaoPagamento> getCondicaoPagamentos() {
		if(this.condicaoPagamentos == null){
			this.condicaoPagamentos = 
					new CondicaoPagamentoService().buscar("Select c From CondicaoPagamento c where c.tipo in('A','B','C','K')");
		}
		return condicaoPagamentos;
	}
		
	

	public Boolean getFuturoCliente() {
		return futuroCliente;
	}
	
	
	public void setFuturoCliente(Boolean futuroCliente) {
		this.futuroCliente = futuroCliente;
	}
	
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
