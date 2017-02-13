package br.com.rudar.DAO;

import br.com.rudar.entity.Unidade;
import br.com.rudar.util.UtilMensagens;

public class UnidadeDao extends GenericDao<Unidade> {

	public UnidadeDao() {
		super(Unidade.class);
	}

	public boolean gravar(Unidade unidade) {
		if (unidade.getId() == null) {
			if (save(unidade)) {
				UtilMensagens.mensagemInformacao("Cadastro de Unidades Inserido com Sucesso");
				return true;
			}
		} else {
			if (update(unidade)) {
				UtilMensagens.mensagemInformacao("Cadastro de Unidades Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
	
	
	@Override
	public Unidade findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
