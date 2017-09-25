package fr.pizzeria.model;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"),SANS_VIANDE("Sans Viande");
	
	private String categorie;
	
	private CategoriePizza (String categorie) {
		this.categorie = categorie;
	}
	
	public String toString()  {
		return categorie; 
	}
	public static CategoriePizza sameLibelle(String scategorie) throws StockageException {
		boolean trouve = false;
		CategoriePizza returnCategorie = null;
		for (CategoriePizza i : CategoriePizza.values()){
			if(i.categorie.equals(scategorie)){
				returnCategorie = i;
				trouve = true;
				
				
			}
		}
		if (trouve == false){
			throw new StockageException("Catégorie inexistante, veuillez écrire une catégorie existante");
		}
		
		return returnCategorie;
	}
	
}
