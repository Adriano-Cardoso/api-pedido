package com.br.aplicativo.msdesafio2.exception;

public class PedidoStatusCanceledResourceAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PedidoStatusCanceledResourceAccessException (String message) {
		super(message);
	}

}
