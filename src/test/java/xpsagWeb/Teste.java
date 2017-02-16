package xpsagWeb;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rudar.DAO.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		//RomaneioDao dao = new RomaneioDao();
		//UsuarioDao usuarioDao = new UsuarioDao();
		//ColaboradorDao colaboradorDao = new ColaboradorDao();
		EntityManager em = JPAUtil.GetInstance().getEntityManager();
		//Integer i =colaboradorDao.getMaxCodigo();
		
		/*List<TipoColaborador> lista = new ArrayList<>();
		lista.add(TipoColaborador.C);
		lista.add(TipoColaborador.F);
		lista.add(TipoColaborador.T);
		
		Colaborador c = new Colaborador();
		c.setTipoColaborador(lista);
		
		lista.clear();
		
		lista = c.getTipoColaborador();*/
		
		
//		Usuario t = usuarioDao.findOne("From Usuario c where c.idUsusario > ?1", 1);
			
		try {
			
			em.getTransaction().begin();
			/*
			ClasFiscal clasFiscal = new ClasFiscal();
			
			ClasFiscalItem clasFiscalItem = new ClasFiscalItem();
			clasFiscalItem.setClasFiscal(clasFiscal);
			clasFiscalItem.setEstado("AA");
			
			ClasFiscalItem clasFiscalItem2 = new ClasFiscalItem();
			clasFiscalItem2.setClasFiscal(clasFiscal);
			clasFiscalItem2.setEstado("BB");
			
			ClasFiscalItem clasFiscalItem3 = new ClasFiscalItem();
			clasFiscalItem3.setClasFiscal(clasFiscal);
			clasFiscalItem3.setEstado("CC");
			
			ClasFiscalItem clasFiscalItem4 = new ClasFiscalItem();
			clasFiscalItem4.setClasFiscal(clasFiscal);
			clasFiscalItem4.setEstado("DD");
			
			clasFiscal.getClasFiscalItems().add(clasFiscalItem);
			clasFiscal.getClasFiscalItems().add(clasFiscalItem2);
			clasFiscal.getClasFiscalItems().add(clasFiscalItem3);
			clasFiscal.getClasFiscalItems().add(clasFiscalItem4);
			
			
			em.persist(clasFiscal);
			em.getTransaction().commit();*/
			
			//ClasFiscal clasFiscal = em.find(ClasFiscal.class, 32450);
			
			//Query query = em.createQuery("Select c From ClasFiscalItem c where c.clasFiscal = 32450");
			//Query query = em.createQuery("Select e From Endereco e where e.codigoCepnumero = 1",Endereco.class);
			//Endereco endereco = (Endereco) query.getSingleResult();
			
			Query query = em.createQuery("Select e From ClasFiscalItem c where c.clasFiscal = 32450");
			
			
			//System.out.println(endereco);
			
			em.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
