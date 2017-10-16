package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.implementation.IPizzaDao;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;
import fr.pizza.model.StringUtils;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class IPizzaDaoJDBC implements IPizzaDao {
	private static final Logger LOG = LoggerFactory.getLogger(IPizzaDaoJDBC.class);

	public IPizzaDaoJDBC() {
		try {
			Class.forName(ResourceBundle.getBundle("jdbc").getString("jdbc.driverClassName"));
		} catch (ClassNotFoundException e) {
			LOG.error(e.getMessage());
		}
	}

	private Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("jdbc.url"),
					ResourceBundle.getBundle("jdbc").getString("jdbc.username"),
					ResourceBundle.getBundle("jdbc").getString("jdbc.password"));
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		if (connect != null) {
			return connect;
		} else {
			throw new NullPointerException();
		}

	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> listpizzas = new ArrayList<>();
		Connection myConnection = getConnection();
		Statement statement = null;
		ResultSet resultats = null;

		try {
			statement = myConnection.createStatement();
			resultats = statement.executeQuery("SELECT * FROM PIZZA");
			while (resultats.next()) {
				String code = resultats.getString("CODE");
				String name = resultats.getString("NOM");
				double prix = resultats.getDouble("PRIX");
				String categorie = resultats.getString("CATEGORIE");
				listpizzas.add(new Pizza(code, name, prix, CategoriePizza.findByLibelle(categorie)));
			}

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (resultats != null) {
					resultats.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
			try {
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		}

		return listpizzas;
	}

	@Override
	public boolean saveNewPizza(String code, String nom, Double prix, CategoriePizza returncategorie) {
		Connection myConnection = getConnection();
		PreparedStatement newStatement = null;
		try {
			newStatement = myConnection.prepareStatement("INSERT INTO PIZZA(CODE, NOM, PRIX, CATEGORIE) VALUES(?, ?, ?, ?)");
			newStatement.setString(1, code);
			newStatement.setString(2, nom);
			newStatement.setDouble(3, prix);
			newStatement.setString(4, returncategorie.toString());
			newStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (newStatement != null) {
					newStatement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
			try {
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		}

		return false;
	}

	@Override
	public boolean updatePizza(String codeAModifier, String code, String nom, Double prix,
		CategoriePizza returncategorie) throws UpdatePizzaException {
		Connection myConnection = getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = myConnection.prepareStatement("UPDATE PIZZA SET CODE = ?, NOM = ?, PRIX = ?, CATEGORIE = ? WHERE PIZZA.CODE = ?");
			updateStatement.setString(1, code);
			updateStatement.setString(2, nom);
			updateStatement.setDouble(3, prix);
			updateStatement.setString(4, returncategorie.toString());
			updateStatement.setString(5, codeAModifier);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (updateStatement != null) {
					updateStatement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
			try {
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		Connection myConnection = getConnection();
		Statement statement = null;
		try {
			statement = myConnection.createStatement();
			String concat = StringUtils.concat("'",codePizza,"'");
			statement.executeUpdate("DELETE FROM PIZZA WHERE PIZZA.CODE ="+concat);
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
			try {
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		}
		return false;
	}

	@Override
	public boolean initiatePizza() {
		Connection myConnection = getConnection();
		Statement statement = null;
		try {
			statement = myConnection.createStatement();
			statement.executeUpdate("TRUNCATE PIZZA");
			statement.executeUpdate("INSERT INTO PIZZA(ID, CODE, NOM, PRIX, CATEGORIE)"
					+ "VALUES('1', 'PEP', 'Pépéroni', '12.50', 'Viande'),"
					+ "('2', 'MAR', 'La Margherita', '14.00', 'Sans Viande'), "
					+ "('3', 'REIN', 'La Reine', '11.50', 'Viande'), "
					+ "('4', 'FRO', 'La 4 fromage', '12.00', 'Sans Viande'), "
					+ "('5', 'CAN', 'La Cannibale', '12.50', 'Viande'), "
					+ "('6', 'SAV', 'La Savoyarde', '13.00', 'Viande'), "
					+ "('7', 'ORI', 'L\\'Orientale', '13.50', 'Viande'), "
					+ "('8', 'IND', 'L\\'Indienne', '14.00', 'Viande')");

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
			try {
				myConnection.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage());
			}
		}

		return false;
	}

}
