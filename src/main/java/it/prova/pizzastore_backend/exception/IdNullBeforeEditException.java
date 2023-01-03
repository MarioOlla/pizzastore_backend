package it.prova.pizzastore_backend.exception;

public class IdNullBeforeEditException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNullBeforeEditException(String msg) {
		super(msg);
	}
}
