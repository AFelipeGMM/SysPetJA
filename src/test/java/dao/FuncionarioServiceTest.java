package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.util.*;
import models.Funcionario;

public class FuncionarioServiceTest {
	
	private FuncionarioService service = new FuncionarioService(JPAUtil.EMF);
	private Funcionario funcionario1;

	@Before
	public void setUp() throws Exception {
		funcionario1 = new Funcionario();
		funcionario1.setNome("Júnior");
		funcionario1.setCPF(11111111);
		funcionario1.setEmail("email1@gmail.com");
		funcionario1.setSenha("12345");
		funcionario1.setCargo("veterinario");
		funcionario1.setSalario(500.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateFuncionario() {
		//fail("Not yet implemented");
		try{
			assertEquals("1", 0L, funcionario1.getId());
			service.createFuncionario(funcionario1);
			assertNotEquals("2", 0L, funcionario1.getId());
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testDestroy() {
		//fail("Not yet implemented");
		try{
			assertEquals("3", 0L, funcionario1.getId());
			service.createFuncionario(funcionario1);
			assertNotEquals("4", 0L, funcionario1.getId());
			service.destroy(funcionario1.getId());
			//assertNull("5", service.findFuncionario(funcionario1.getId()));
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testFindFuncionarioEntities() {
		//fail("Not yet implemented");
		try{
			service.createFuncionario(funcionario1);
			assertNotNull("6", service.findFuncionarioEntities());
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testPesquisarPorNome() {
		//fail("Not yet implemented");
		try{
			assertEquals("7", 0L, funcionario1.getId());
			service.createFuncionario(funcionario1);
			assertNotEquals("8", 0L, funcionario1.getId());
			assertEquals("9", "Júnior", funcionario1.getNome());
			assertNotNull("10", service.pesquisarPorNome("Júnior"));
			
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

}
