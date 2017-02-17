package br.com.rudar.DAO;

import java.util.List;

import br.com.rudar.entity.GrupoProduto;
import br.com.rudar.mbeans.GrupoProdutoBean.TipoFiltro;
import br.com.rudar.util.UtilMensagens;

public class GrupoProdutoDao extends GenericDao<GrupoProduto> {

	public GrupoProdutoDao() {
		super(GrupoProduto.class);
	}

	
	public boolean gravar(GrupoProduto grupoProduto) {
		if (grupoProduto.getId() == null) {
			if (save(grupoProduto)) {
				UtilMensagens.mensagemInformacao("Cadastro de Grupo de Produto Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(grupoProduto)) {
				UtilMensagens.mensagemInformacao("Cadastro de Grupo de Produto Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}

	
	@Override
	public GrupoProduto findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<GrupoProduto> getByFilterTable(TipoFiltro tipoFiltro , String valorFiltro){
		List<GrupoProduto> lista = null;
		
		if(tipoFiltro.equals(TipoFiltro.CODIGO_ESTRUTURAL)){
			lista = find("Select g From GrupoProduto g where g.codigoEstrutural like ?",valorFiltro);
		}
		else if(tipoFiltro.equals(TipoFiltro.NOME)){
			lista = find("Select g From GrupoProduto g where g.nome like ?",valorFiltro);
		}
		
		return lista;
	}
}
