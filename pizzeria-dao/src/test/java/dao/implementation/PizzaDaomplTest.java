package dao.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.pizza.model.CategoriePizza;

public class PizzaDaomplTest {

	@Test
	public void testSaveNewPizza() {
		PizzaDaompl pD = new PizzaDaompl();
		assertThat(pD.saveNewPizza("LAL", "lalala", 12.0, CategoriePizza.POISSON)).isEqualTo(pD.findAllPizzas());
	}

	@Test
	public void testDeletePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitiatePizza() {
		fail("Not yet implemented");
	}

}
