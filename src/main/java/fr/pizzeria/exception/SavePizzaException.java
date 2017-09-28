package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2346475209618282430L;

	public SavePizzaException (String msg){
		super(msg);
	}
}
