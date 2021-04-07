package com.br.aplicativo.msdesafio2.exception;

public class ItemNomeResourceAccessException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public ItemNomeResourceAccessException (String message) {
		super(message);
	}
}
