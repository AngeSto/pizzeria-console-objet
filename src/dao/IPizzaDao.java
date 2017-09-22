package dao;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	boolean saveNewPizza(String code, String nom, Double prix);
	boolean updatePizza(String codeAModifier, String code, String nom, Double prix);
	boolean deletePizza(String codePizza);

}
