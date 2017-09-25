package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -205480846048285884L;

	public DeletePizzaException (String msg){
		super(msg);
	}
}
