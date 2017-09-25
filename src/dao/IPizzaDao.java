package dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean saveNewPizza(String code, String nom, Double prix);
	boolean updatePizza(String codeAModifier, String code, String nom, Double prix);
	boolean deletePizza(String codePizza, boolean trouve);

}
