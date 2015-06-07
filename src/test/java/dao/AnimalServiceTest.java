package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.util.*;
import models.Animal;

public class AnimalServiceTest {
	
	public AnimalService animalService = new AnimalService(JPAUtil.EMF);
	public Animal animal1;

	@Before
	public void setUp() throws Exception {
		animal1 = new Animal();
		
		animal1.setCor("preto");
		animal1.setEspecie("cachorro");
		animal1.setNome("Matias");
		animal1.setPeso(5.5);
		animal1.setPorte("pequeno");
		animal1.setRaca("poodle");
		animal1.setSexo("Masculino");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCreateAnimal() {
		//fail("Not yet implemented");
		try{
			assertEquals("1", 0L, animal1.getId());
			animalService.createAnimal(animal1);
			assertNotEquals("2", 0L, animal1.getId());
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testDestroy() {
		//fail("Not yet implemented");
		try{
			assertEquals("3", 0L, animal1.getId());
			animalService.createAnimal(animal1);
			assertNotEquals("4", 0L, animal1.getId());
			animalService.destroy(animal1.getId());
			//assertNull("5", animalService.findAnimal(animal1.getId()));
		} catch(Exception e) {
			fail();
			e.printStackTrace();;
		}
	}

	@Test
	public final void testFindAnimalEntities() {
		//fail("Not yet implemented");
		try{
			animalService.createAnimal(animal1);
			assertNotNull("5", animalService.findAnimalEntities());
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

	@Test
	public final void testPesquisarPorNome() {
		//fail("Not yet implemented");
		try{
			assertEquals("6", "Matias", animal1.getNome());
			assertEquals("7", 0L, animal1.getId());
			animalService.createAnimal(animal1);
			assertNotEquals("8", 0L, animal1.getId());
			assertNotNull("9", animalService.pesquisarPorNome("Matias"));
		} catch(Exception e){
			fail();
			e.printStackTrace();
		}
	}

}
