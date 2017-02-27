package br.com.rudar.view.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.rudar.core.entity.CondicaoPagamento;
import br.com.rudar.core.entity.Orcamento;
import br.com.rudar.core.entity.Vendedor;
import br.com.rudar.core.enumerated.TipoFrete;
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
	private OrcamentoService orcamentoService;
	
	private List<CondicaoPagamento> condicaoPagamentos;

	private Boolean futuroCliente;
	
	public OrcamentoBean() {
		orcamentoService = new OrcamentoService();
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
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void carregaEntidade() {
		// TODO Auto-generated method stub
		
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
