package fr.pizza.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testConcat() {
		assertThat(StringUtils.concat("Je ", "suis ", "sympa")).isEqualTo("Je suis sympa");
	}
	@Test
	public void testConcatNull() {
	
		assertThat(StringUtils.concat(null, null, null)).isEqualTo("nullnullnull");
	}
	
	@Test
	public void testConvert() {
		Pizza pizza = new Pizza("LAL","lalalala",15,CategoriePizza.POISSON);
		assertThat(StringUtils.convert(pizza)).isEqualTo("LAL -> lalalala (15.0€) Poisson");
		
	}
	@Test
	public void testConvertNonValide() {
		Pizza pizza = new Pizza(null,null,12,null);
		assertThat(StringUtils.convert(pizza)).isEqualTo("NULL -> null (12.0€) null");
		
	}
}
