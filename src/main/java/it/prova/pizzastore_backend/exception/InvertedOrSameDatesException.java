package it.prova.pizzastore_backend.exception;

public class InvertedOrSameDatesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvertedOrSameDatesException(String msg) {
		super(msg);
	}
}
