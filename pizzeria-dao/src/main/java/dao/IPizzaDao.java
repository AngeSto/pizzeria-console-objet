package dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean saveNewPizza(String code, String nom, Double prix, CategoriePizza returncategorie);
	boolean updatePizza(String codeAModifier, String code, String nom, Double prix, CategoriePizza returncategorie) throws UpdatePizzaException;
	boolean deletePizza(String codePizza) throws DeletePizzaException;

}
