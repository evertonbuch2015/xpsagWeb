package br.com.rudar.DAO;

import br.com.rudar.entity.Vendedor;
import br.com.rudar.util.UtilMensagens;

public class VendedorDao extends GenericDao<Vendedor> {

	public VendedorDao() {
		super(Vendedor.class);
	}

	public boolean gravar(Vendedor vendedor) {
		if (vendedor.getId() == null) {
			if (save(vendedor)) {
				UtilMensagens.mensagemInformacao("Cadastro de Vendedor Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(vendedor)) {
				UtilMensagens.mensagemInformacao("Cadastro de Vendedor Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
		
	
	@Override
	public Vendedor findAllAttributesEntity() {
		// TODO Auto-generated method stub
		return null;
	}
}
