package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.util.*;
import models.Endereco;

public class EnderecoServiceTest {

	private EnderecoService enderecoService = new EnderecoService(JPAUtil.EMF);
	private Endereco endereco1 = null;
	
	@Before
	public void setUp() throws Exception {
		endereco1 = new Endereco();
		
		endereco1.setNumero(10);
		endereco1.setRua("Av. 1");
		endereco1.setBairro("Centro");
		endereco1.setCidade("capital");
		endereco1.setUF("RN");
		endereco1.setPais("Brasil");
		endereco1.setCEP(11111111);
	}

	@After
	public void tearDown() throws Exception {
		try{
			if(enderecoService != null) {
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		endereco1 = null;
	}

	@Test
	public final void testCreateEndereco() {
		//fail("Not yet implemented");
		try{
			assertEquals("1", 0L, endereco1.getId());
			enderecoService.createEndereco(endereco1);
			assertNotEquals("2", 0L, endereco1.getId());
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testDestroy() {
		//fail("Not yet implemented");
		try{
			assertEquals("3", 0L, endereco1.getId());
			enderecoService.createEndereco(endereco1);
			assertNotEquals("4", 0L, endereco1.getId());
			enderecoService.destroy(endereco1.getId());
			//assertNull("5", enderecoService.findEndereco(endereco1.getId()));
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

}
