package it.prova.pizzastore_backend.exception;

public class ElementNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElementNotFoundException(String msg) {
		super(msg);
	}
}
