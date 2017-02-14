package br.com.rudar.DAO;

import java.util.List;
import br.com.rudar.entity.Empresa;
import br.com.rudar.mbeans.EmpresaBean.TipoFiltro;
import br.com.rudar.util.UtilMensagens;

public class EmpresaDao extends GenericDao<Empresa> {

	public EmpresaDao() {
		super(Empresa.class);
	}

	public boolean gravar(Empresa empresa) {
		if (empresa.getIdEmpresa() == null) {
			if (save(empresa)) {
				UtilMensagens.mensagemInformacao("Cadastro de Empresa Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(empresa)) {
				UtilMensagens.mensagemInformacao("Cadastro de Empresa Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
	
	
	@Override
	public Empresa findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Empresa> getByFilterTable(TipoFiltro tipoFiltro , String valorFiltro){
		List<Empresa> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO)){
			String jpql = "Select e From Empresa e where e.codigo in (" + valorFiltro + ")";
			lista = find(jpql);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = find("Select e From Empresa e where e.nomeRazao like ?",valorFiltro);
		}
		
		return lista;
	}
}
