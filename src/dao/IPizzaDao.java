package dao;

import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean saveNewPizza(String code, String nom, Double prix, CategoriePizza returncategorie);
	boolean updatePizza(String codeAModifier, String code, String nom, Double prix, CategoriePizza returncategorie);
	boolean deletePizza(String codePizza, boolean trouve);

}
