package br.com.rudar.DAO;

import br.com.rudar.entity.Empresa;
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
}
