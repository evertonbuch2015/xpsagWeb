package br.com.rudar.mbeans;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import br.com.rudar.DAO.ColaboradorDao;
import br.com.rudar.DAO.CondicaoPagamentoDao;
import br.com.rudar.DAO.RomaneioDao;
import br.com.rudar.entity.Colaborador;
import br.com.rudar.entity.CondicaoPagamento;
import br.com.rudar.entity.Empresa;
import br.com.rudar.entity.Romaneio;
import br.com.rudar.entity.RomaneioItem;
import br.com.rudar.enumerated.TipoFrete;
import br.com.rudar.util.SessionContext;

@ManagedBean
@SessionScoped
public class RomaneioBean extends GenericBean<Romaneio> {

	
	private RomaneioDao romaneioDao;
	private ColaboradorDao colaboradorDao;
	private CondicaoPagamentoDao condicaoPagamentoDao;
	
	
	private Integer usuarioId;
	
	private List<Colaborador> transportadoras;
	
	private List<Colaborador> entregadores;

	private List<CondicaoPagamento> condicaoPagamentos;
	
	
	private RomaneioItem romaneioItem;
	
	
	public RomaneioBean() {
		this.romaneioDao = new RomaneioDao();
		this.colaboradorDao = new ColaboradorDao();
		this.condicaoPagamentoDao =  new CondicaoPagamentoDao();
	}

	
	// =======================METODOS DO USUARIO=================================================	
	
	
	@Override
	public void carregaEntidade() {	
		this.entidade = romaneioDao.findOne("SELECT r, c, v, e, t, cc,ii FROM Romaneio r left JOIN FETCH r.condicaoPagamento c left JOIN FETCH r.vendedor v"
											+ " left JOIN FETCH r.entregador e left JOIN FETCH r.transportadora t left JOIN FETCH r.colaborador cc left JOIN FETCH r.romaneioItens ii"
											+ " where r.id = ?1", entidade.getId());		
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
		if (romaneioDao.gravar(this.entidade)) {									
			this.entidades.add(this.entidade);
			mudarBuscar();
		}			
	}
	

	@Override
	public void excluir(Romaneio entidade) {
		romaneioDao.delete(entidade);
		this.entidades = romaneioDao.findAll();
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
			
		this.entidades = romaneioDao.find("Select r From Romaneio r left JOIN FETCH r.colaborador "
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
		this.entidade.setColaborador(colaboradorDao.findById(colaborador.getId()));
	}
	
	
	// =============================GET AND SET=================================
	
	public RomaneioDao getRomaneioDao() {
		return romaneioDao;
	}
	
	
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
			this.entregadores = colaboradorDao.find("From Colaborador u where u.tipoCliente = ?1", "T");
		}
		return entregadores;		
	}
	
	//RETORNA LISTA DE TRANSPORTADORAS PARA O COMBO
	public List<Colaborador> getTransportadoras() {
		if(this.transportadoras == null){
			this.transportadoras =  colaboradorDao.find("From Colaborador u where u.tipoCliente = ?1", "T");
		}
		return transportadoras;	
	}
	
	//RETORNA LISTA DE CONDIÇÕES DE PAGAMENTO PARA O COMBO
	public List<CondicaoPagamento> getCondicaoPagamentos() {
		if(this.condicaoPagamentos == null){
			this.condicaoPagamentos = condicaoPagamentoDao.find("Select c From CondicaoPagamento c where c.tipo in('A','B','C','K')");
		}
		return condicaoPagamentos;
	}
}
