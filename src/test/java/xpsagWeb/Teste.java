package xpsagWeb;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.rudar.core.dao.JPAUtil;
import br.com.rudar.core.dao.TipoServicoDao;
import br.com.rudar.core.entity.GrupoMaquina;
import br.com.rudar.core.entity.Orcamento;
import br.com.rudar.core.entity.OrcamentoItem;
import br.com.rudar.core.entity.OrcamentoItemInsumo;
import br.com.rudar.core.entity.OrcamentoItemMp;
import br.com.rudar.core.entity.OrcamentoItemProcesso;
import br.com.rudar.core.entity.Produto;
import br.com.rudar.core.entity.TipoServico;
import br.com.rudar.core.entity.TipoServicoItem;
import br.com.rudar.core.service.ProdutoService;
import br.com.rudar.core.service.UsuarioService;

public class Teste {

	public static void main(String[] args) {
		// testeOrcamento();
		// testeProduto();

		//String nomeUsuario 	= "XPSAG";
		//String senha 		= Criptografia.criptografarSha256("ADMIN");
		UsuarioService usuarioService = new UsuarioService();
		
		List<String> lista = usuarioService.buscarSetores();
		System.out.println(lista);
		///Query query = em.createQuery("From Usuario u where u.nomeUsuario = ?1 and u.senha = ?2");
		///query.setParameter(1, nomeUsuario);
		//query.setParameter(2, senha);
		
		//Usuario usuario = (Usuario) query.getSingleResult();
	}

	public static void testeProduto() {
		try {
			//EntityManager em = JPAUtil.GetInstance().getEntityManager();
			ProdutoService produtoService = new ProdutoService();
			// List<Produto> lista = produtoService.preencherTabela();

			Produto p2 = produtoService.carregarEntidade(13);// em.find(Produto.class,
																// 13);
			System.out.println(p2);
			/*
			 * Produto p = new Produto();//em.find(Produto.class, 2);
			 * p.setClasFiscal(em.find(ClasFiscal.class, 35));
			 * p.setCodigo(12345689); p.setNome("teste 12345");
			 * p.setCodigoNcm(123456.33); p.setSituacao(true);
			 * p.setOrigemMercadoria('0');
			 * 
			 * 
			 * ProdutoInd produtoInd = new ProdutoInd();
			 * p.setProdutoInd(produtoInd);
			 * 
			 * 
			 * 
			 * ProdutoIndMetal produtoIndMetal = new ProdutoIndMetal();
			 * produtoInd.setProdutoIndMetal(produtoIndMetal);
			 * 
			 * 
			 * ProdutoIndText produtoIndText = new ProdutoIndText();
			 * produtoInd.setProdutoIndText(produtoIndText);
			 * 
			 * em.getTransaction().begin(); em.persist(p);
			 * em.getTransaction().commit(); em.close();
			 */

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testeTipoServico() {
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

			// em.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testeOrcamento() {
		try {
			EntityManager em = JPAUtil.GetInstance().getEntityManager();

			Orcamento epiOrcamento = new Orcamento();
			epiOrcamento.setCodigo(130);
			epiOrcamento.setNomeColaborador("teste3");
			epiOrcamento.setCemp("01");
			epiOrcamento.setFilial("01");

			OrcamentoItem epiOrcamentoItem = new OrcamentoItem();
			epiOrcamentoItem.setItem(1);
			epiOrcamentoItem.setSituacao("N");
			epiOrcamentoItem.setTipo("N");
			epiOrcamentoItem.setNomeProduto("teste3");
			epiOrcamentoItem.setPercComissao(2.00);
			epiOrcamentoItem.setValorFrete(new BigDecimal("50.00"));

			OrcamentoItemInsumo epiOrcamentoItemInsumo = new OrcamentoItemInsumo();
			epiOrcamentoItemInsumo.setItem(1);
			epiOrcamentoItemInsumo.setNomeProduto("teste3");
			epiOrcamentoItemInsumo.setQuantidade(new BigDecimal("2"));
			epiOrcamentoItemInsumo.setValorUnitario(new BigDecimal("2.50"));

			OrcamentoItemMp orcamentoItemMp = new OrcamentoItemMp();
			orcamentoItemMp.setItem(1);
			orcamentoItemMp.setNomeProduto("teste3");
			orcamentoItemMp.setQuantidade(new BigDecimal("2"));
			orcamentoItemMp.setValorUnitario(new BigDecimal("2.50"));

			GrupoMaquina grupoMaquina = new GrupoMaquina();
			grupoMaquina.setId(2);

			OrcamentoItemProcesso epiOrcamentoItemProcesso = new OrcamentoItemProcesso();
			epiOrcamentoItemProcesso.setItem(1);
			epiOrcamentoItemProcesso.setDescricao("teste3");
			epiOrcamentoItemProcesso.setTempoExecucao(new BigDecimal("2"));
			epiOrcamentoItemProcesso.setCustoMinuto(new BigDecimal("1.50"));
			epiOrcamentoItemProcesso.setGrupoMaquina(grupoMaquina);

			epiOrcamentoItem.addOrcamentoItemInsumo(epiOrcamentoItemInsumo);
			epiOrcamentoItem.addOrcamentoItemMp(orcamentoItemMp);
			epiOrcamentoItem.addOrcamentoItemProcesso(epiOrcamentoItemProcesso);

			epiOrcamento.addOrcamentoItem(epiOrcamentoItem);

			em.getTransaction().begin();
			em.persist(epiOrcamento);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
