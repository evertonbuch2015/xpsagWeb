package br.com.rudar.core.service;

import java.util.List;

import br.com.rudar.core.dao.ColaboradorDao;
import br.com.rudar.core.entity.Colaborador;
import br.com.rudar.view.managedBean.ColaboradorBean.TipoFiltro;
import br.com.rudar.view.util.UtilMensagens;

public class ColaboradorService implements GenericService<Colaborador>{
	
	private ColaboradorDao colaboradorDao;
	
	
	public ColaboradorService() {
		colaboradorDao = new ColaboradorDao();
	}
	
	
	public boolean salvar(Colaborador colaborador) {
		if (colaborador.getId() == null) {						
			if (colaboradorDao.save(colaborador)) {
				UtilMensagens.mensagemInformacao("Cadastro de Colaborador Realizado com Sucesso");
				return true;
			}
		} else {
			if (colaboradorDao.update(colaborador)) {
				UtilMensagens.mensagemInformacao("Cadastro de Colaborador Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
	
	
	public void excluir(Colaborador entidade) {
		colaboradorDao.delete(entidade);		
	}
	
	
	public Integer maxCodigo(){
		return colaboradorDao.getMaxCodigo();
	}
	
	
	public Colaborador carregarEntidade(Integer id){
		return colaboradorDao.findAllAttributesEntity(id);
	}
		
	
	public List<Colaborador> buscarTodos(){
		return colaboradorDao.findAll();
	}
		
	
	public List<Colaborador> buscarColaboradoresPeloVendedor(Integer vendedor,String filtro){
		return colaboradorDao.findColaboradorByVendedor(vendedor, filtro);
	}
		
	
	public List<Colaborador> filtrarTabela(TipoFiltro tipoFiltro , String valorFiltro){
		List<Colaborador> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO)){			
			String jpql = "Select c From Colaborador c where c.codigo in (" + valorFiltro + ")";
			lista = colaboradorDao.find(jpql);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = colaboradorDao.find("Select c From Colaborador c where c.fantasia like ?",valorFiltro);
		}
		
		return lista;
	}
	
	
	public List<Colaborador> buscaPaginada(Integer maxResults){
		return colaboradorDao.findByPaged(maxResults);
	}

	
	public Colaborador buscarPeloId(Integer id) {
		return colaboradorDao.findById(id);
	}
	
	
	public List<Colaborador> buscar(String jpql , Object...params) {
		return colaboradorDao.find(jpql,params);
	}

	
	public Colaborador buscarPeloCodigo(Integer codigo){
		try {
			Integer.parseInt(codigo.toString());
		} catch (Exception e) {
			UtilMensagens.mensagemErro("Código do colaborador deve ser numérico");
		}
		
		String jpql = "Select c From Colaborador c where c.codigo = ?1";
		return colaboradorDao.findOne(jpql, codigo);
	}
}
