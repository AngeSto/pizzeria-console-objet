package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import dao.implementation.IPizzaDao;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

@Service
public class PizzaDaoJPA implements IPizzaDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");

	@Override
	public List<Pizza> findAllPizzas() {
		EntityManager em = entityManagerFactory.createEntityManager();

		List<Pizza> listpizzas = em.createQuery("From Pizza", Pizza.class).getResultList();

		em.close();
		return listpizzas;
	}

	@Override
	public boolean saveNewPizza(String code, String nom, Double prix, CategoriePizza returncategorie)
			throws SavePizzaException {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		Pizza p = new Pizza();
		p.setCode(code);
		p.setNom(nom);
		p.setPrix(prix);
		p.setCategorie(returncategorie);
		em.persist(p);
		
		transaction.commit();

		em.close();
		return false;
	}

	@Override
	public boolean updatePizza(String codeAModifier, String code, String nom, Double prix,
			CategoriePizza returncategorie) throws UpdatePizzaException {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pizza pizzaModifier = em.createQuery("from Pizza where code=:code", Pizza.class)
				.setParameter("code", codeAModifier).getSingleResult();
		pizzaModifier.setCode(code);
		pizzaModifier.setNom(nom);
		pizzaModifier.setPrix(prix);
		pizzaModifier.setCategorie(returncategorie);
		em.merge(pizzaModifier);
		transaction.commit();

		em.close();
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pizza pizzaModifier = em.createQuery("from Pizza where code=:code", Pizza.class)
				.setParameter("code", codePizza).getSingleResult();
		em.remove(pizzaModifier);
		transaction.commit();
		em.close();
		return false;
	}

	@Override
	public boolean initiatePizza() {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("TRUNCATE TABLE PIZZA").executeUpdate();
		em.createNativeQuery("INSERT INTO PIZZA(ID, CODE, NOM, PRIX, CATEGORIE)"
				+ "VALUES('1', 'PEP', 'Pépéroni', '12.50', 'VIANDE'),"
				+ "('2', 'MAR', 'La Margherita', '14.00', 'SANS_VIANDE'), "
				+ "('3', 'REIN', 'La Reine', '11.50', 'VIANDE'), "
				+ "('4', 'FRO', 'La 4 fromage', '12.00', 'SANS_VIANDE'), "
				+ "('5', 'CAN', 'La Cannibale', '12.50', 'VIANDE'), "
				+ "('6', 'SAV', 'La Savoyarde', '13.00', 'VIANDE'), "
				+ "('7', 'ORI', 'L''Orientale', '13.50', 'VIANDE'), "
				+ "('8', 'IND', 'L''Indienne', '14.00', 'VIANDE')").executeUpdate();
		transaction.commit();
		em.close();
		return false;
	}

}
