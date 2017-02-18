package xpsagWeb;

import javax.persistence.EntityManager;

import br.com.rudar.DAO.JPAUtil;
import br.com.rudar.DAO.TipoServicoDao;
import br.com.rudar.entity.TipoServico;
import br.com.rudar.entity.TipoServicoItem;

public class Teste {

	public static void main(String[] args) {
		//RomaneioDao dao = new RomaneioDao();
		//UsuarioDao usuarioDao = new UsuarioDao();
		//ColaboradorDao colaboradorDao = new ColaboradorDao();
		
		//Integer i =colaboradorDao.getMaxCodigo();
		
		/*List<TipoColaborador> lista = new ArrayList<>();
		lista.add(TipoColaborador.C);
		lista.add(TipoColaborador.F);
		lista.add(TipoColaborador.T);
		
		Colaborador c = new Colaborador();
		c.setTipoColaborador(lista);
		
		lista.clear();
		
		lista = c.getTipoColaborador();*/
		
			
		try {
			EntityManager em = JPAUtil.GetInstance().getEntityManager();
			TipoServicoDao tipoServicoDao = new TipoServicoDao(); 
			TipoServico tipoServico = new TipoServico();
			
			TipoServico servico = tipoServicoDao.findAllAttributesEntity(92);
			System.out.println(servico);
			
			tipoServico.setCemp("01");
			
			tipoServico.setCodigoEstrutural("04.01");
			
			tipoServico.setNome("Teste");
			tipoServico.setTipo('A');
			
			TipoServicoItem tipoServicoItem = new TipoServicoItem();
			tipoServicoItem.setTipoServico(tipoServico);
			tipoServicoItem.setValor(12.00);
			
			TipoServicoItem tipoServicoItem2 = new TipoServicoItem();
			tipoServicoItem2.setTipoServico(tipoServico);
			tipoServicoItem2.setValor(13.00);
			
			TipoServicoItem tipoServicoItem3 = new TipoServicoItem();
			tipoServicoItem3.setTipoServico(tipoServico);
			tipoServicoItem3.setValor(14.00);
			
			tipoServico.addTipoServicoItem(tipoServicoItem);
			tipoServico.addTipoServicoItem(tipoServicoItem2);
			tipoServico.addTipoServicoItem(tipoServicoItem3);
			
			em.getTransaction().begin();
			em.persist(tipoServico);
			em.getTransaction().commit();
			em.close();
			
			
			
			//em.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
