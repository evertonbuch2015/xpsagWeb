package br.com.rudar.DAO;

import br.com.rudar.entity.OperacaoSaida;
import br.com.rudar.util.UtilMensagens;

public class OperacaoSaidaDao extends GenericDao<OperacaoSaida> {

	public OperacaoSaidaDao() {
		super(OperacaoSaida.class);
	}

	public boolean gravar(OperacaoSaida operacaoSaida) {
		if (operacaoSaida.getId() == null) {
			if (save(operacaoSaida)) {
				UtilMensagens.mensagemInformacao("Cadastro de Operação de Saida Realizado com Sucesso");
				return true;
			}
		} else {
			if (update(operacaoSaida)) {
				UtilMensagens.mensagemInformacao("Cadastro de Operação de Saida Alterado com Sucesso");
				return true;
			}
		}
		return false;
	}

	
	@Override
	public OperacaoSaida findAllAttributesEntity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
