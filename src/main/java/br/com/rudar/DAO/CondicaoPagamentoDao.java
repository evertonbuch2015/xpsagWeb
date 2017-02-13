package br.com.rudar.DAO;

import br.com.rudar.entity.CondicaoPagamento;
import br.com.rudar.util.UtilMensagens;

public class CondicaoPagamentoDao extends GenericDao<CondicaoPagamento> {

	public CondicaoPagamentoDao() {
		super(CondicaoPagamento.class);
	}

	public boolean gravar(CondicaoPagamento condicaoPagamento) {
		if (condicaoPagamento.getId() == null) {
			if (save(condicaoPagamento)) {
				UtilMensagens.mensagemInformacao("Cadastro de Condição de Pagamento Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(condicaoPagamento)) {
				UtilMensagens.mensagemInformacao("Cadastro de Condição de Pagamento Alterado com Sucesso");
				return true;
			}
		}
		return false;		
	}
	
	
	@Override
	public CondicaoPagamento findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
