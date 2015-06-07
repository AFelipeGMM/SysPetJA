package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.util.*;
import models.Servico;

public class ServicoServiceTest {

	private ServicoService service = new ServicoService(JPAUtil.EMF);
	private Servico servico1;
	
	@Before
	public void setUp() throws Exception {
		servico1 = new Servico();
		servico1.setTipo("banho");
		servico1.setValor(15.5);
		servico1.setDuracao(30);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateServico() {
		//fail("Not yet implemented");
		try{
			assertEquals("1", 0L, servico1.getId());
			service.createServico(servico1);
			assertNotEquals("2", 0L, servico1.getId());
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testDestroy() {
		//fail("Not yet implemented");
		try{
			assertEquals("3", 0L, servico1.getId());
			service.createServico(servico1);
			assertNotEquals("4", 0L, servico1.getId());
			service.destroy(servico1.getId());
			//assertNull("5", service.findServico(servico1.getId()));
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testFindServicoEntities() {
		//fail("Not yet implemented");
		try{
			service.createServico(servico1);
			assertNotNull("6", service.findServicoEntities());
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testPesquisarPorNome() {
		//fail("Not yet implemented");
		try{
			assertEquals("7", 0L, servico1.getId());
			service.createServico(servico1);
			assertNotEquals("8", 0L, servico1.getId());
			assertEquals("9", "banho", servico1.getTipo());
			assertNotNull("10", service.pesquisarPorNome("banho"));
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

}
