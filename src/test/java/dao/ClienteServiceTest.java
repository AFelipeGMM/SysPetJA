package dao;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.util.*;
import models.Cliente;
import models.Endereco;

public class ClienteServiceTest {
	
	private ClienteService clienteService = new ClienteService(JPAUtil.EMF);
	
	
	private Cliente cliente1 = null;
	
	private Endereco endereco1 = null;

	@Before
	public void setUp() throws Exception {
		cliente1 = new Cliente();

		cliente1.setNome("José");
		cliente1.setCPF(11111111);
		cliente1.setEndereco(endereco1);
		cliente1.setEmail("emailquefizerampramim@gmail.com");
		cliente1.setSenha("iamgroot");
	}

	@After
	public void tearDown() throws Exception {
		try{
			if(clienteService != null) {
				if(clienteService.findCliente(cliente1.getId()) != null) {
					clienteService.destroy(cliente1.getId());
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		cliente1 = null;
	}

	@Test
	public final void testCreate() {
		//fail("Not yet implemented");
		try{
			assertEquals("1", 0L, cliente1.getId());
			clienteService.create(cliente1);
			assertNotEquals("2", 0L, cliente1.getId());
			assertEquals("3", "José", cliente1.getNome());
			assertNull("4", cliente1.getEndereco());
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testEdit() {
		//fail("Not yet implemented");
		try{
			assertEquals("6", 0L, cliente1.getId());
			clienteService.create(cliente1);
			assertNotEquals("7", 0L, cliente1.getId());
			cliente1.setNome("João");
			clienteService.edit(cliente1);
			assertNotEquals("8", "José", clienteService.findCliente(cliente1.getId()).getNome());
		}catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testDestroy() {
		//fail("Not yet implemented");
		try{
			assertEquals("9", 0L, cliente1.getId());
			clienteService.create(cliente1);
			assertNotEquals("10", 0L, cliente1.getId());
			clienteService.destroy(cliente1.getId());
			assertNull("11", clienteService.findCliente(cliente1.getId()));
		}catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testFindClienteEntities() {
		//fail("Not yet implemented");
		try{
			//assertNull("12", clienteService.findClienteEntities());
			clienteService.create(cliente1);
			assertNotNull("13", clienteService.findClienteEntities());
		}catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testFindClienteLong() {
		//fail("Not yet implemented");
		try{
			assertEquals("14", 0L, cliente1.getId());
			clienteService.create(cliente1);
			assertNotEquals("15", 0L, cliente1.getId());
			assertNotNull("16", clienteService.findCliente(cliente1.getId()));
		}catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testGetClienteCount() {
		//fail("Not yet implemented");
		try{
			assertEquals("17", 0L, cliente1.getId());
			clienteService.create(cliente1);
			assertNotEquals("18", 0L, cliente1.getId());
			assertEquals("19", 1, clienteService.getClienteCount());
		}catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testFindClienteStringString() {
		//fail("Not yet implemented");
		try{
			assertEquals("20", 0L, cliente1.getId());
			clienteService.create(cliente1);
			assertNotEquals("21", 0L, cliente1.getId());
			assertEquals("22", "emailquefizerampramim@gmail.com", cliente1.getEmail());
			assertEquals("23", "iamgroot", cliente1.getSenha());
			cliente1 = clienteService.findCliente("emailquefizerampramim@gmail.com", "iamgroot");
			assertEquals("24", cliente1.getId(), clienteService.findCliente("emailquefizerampramim@gmail.com", "iamgroot").getId());
		}catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

}
