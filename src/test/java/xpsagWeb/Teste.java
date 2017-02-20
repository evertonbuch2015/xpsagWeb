package xpsagWeb;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.rudar.core.dao.JPAUtil;
import br.com.rudar.core.dao.TipoServicoDao;
import br.com.rudar.core.entity.EpiOrcamento;
import br.com.rudar.core.entity.EpiOrcamentoItem;
import br.com.rudar.core.entity.EpiOrcamentoItemInsumo;
import br.com.rudar.core.entity.EpiOrcamentoItemMp;
import br.com.rudar.core.entity.EpiOrcamentoItemProcesso;
import br.com.rudar.core.entity.GrupoMaquina;
import br.com.rudar.core.entity.TipoServico;
import br.com.rudar.core.entity.TipoServicoItem;

public class Teste {

	public static void main(String[] args) {	
		testeOrcamento();
	}
	
	public static void testeTipoServico(){
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
	
	
	public static void testeOrcamento(){
		try {
			EntityManager em = JPAUtil.GetInstance().getEntityManager();
			
			EpiOrcamento epiOrcamento = new EpiOrcamento(); 
			epiOrcamento.setCodigo(130);
			epiOrcamento.setNomeColaborador("teste3");
			epiOrcamento.setCemp("01");
			epiOrcamento.setFilial("01");
			
			
			EpiOrcamentoItem epiOrcamentoItem = new EpiOrcamentoItem();
			epiOrcamentoItem.setItem(1);
			epiOrcamentoItem.setSituacao("N");
			epiOrcamentoItem.setTipo("N");
			epiOrcamentoItem.setNomeProduto("teste3");
			epiOrcamentoItem.setPercComissao(2.00);
			epiOrcamentoItem.setValorFrete(new BigDecimal("50.00"));
			
			
			
			EpiOrcamentoItemInsumo epiOrcamentoItemInsumo = new EpiOrcamentoItemInsumo();
			epiOrcamentoItemInsumo.setItem(1);
			epiOrcamentoItemInsumo.setNomeProduto("teste3");
			epiOrcamentoItemInsumo.setQuantidade(new BigDecimal("2"));
			epiOrcamentoItemInsumo.setValorUnitario(new BigDecimal("2.50"));
			
			EpiOrcamentoItemMp orcamentoItemMp = new EpiOrcamentoItemMp();
			orcamentoItemMp.setItem(1);
			orcamentoItemMp.setNomeProduto("teste3");
			orcamentoItemMp.setQuantidade(new BigDecimal("2"));
			orcamentoItemMp.setValorUnitario(new BigDecimal("2.50"));
			
			GrupoMaquina grupoMaquina = new GrupoMaquina();
			grupoMaquina.setId(2);
			
			EpiOrcamentoItemProcesso epiOrcamentoItemProcesso = new EpiOrcamentoItemProcesso();
			epiOrcamentoItemProcesso.setItem(1);
			epiOrcamentoItemProcesso.setDescricao("teste3");
			epiOrcamentoItemProcesso.setTempoExecucao(new BigDecimal("2"));
			epiOrcamentoItemProcesso.setCustoMinuto(new BigDecimal("1.50"));
			epiOrcamentoItemProcesso.setGrupoMaquina(grupoMaquina);
			
			
			
			epiOrcamentoItem.addEpiOrcamentoItemInsumo(epiOrcamentoItemInsumo);
			epiOrcamentoItem.addEpiOrcamentoItemMp(orcamentoItemMp);
			epiOrcamentoItem.addEpiOrcamentoItemProcesso(epiOrcamentoItemProcesso);
			
			epiOrcamento.addEpiOrcamentoItem(epiOrcamentoItem);
			
			
			em.getTransaction().begin();
			em.persist(epiOrcamento);
			em.getTransaction().commit();
			em.close();
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
