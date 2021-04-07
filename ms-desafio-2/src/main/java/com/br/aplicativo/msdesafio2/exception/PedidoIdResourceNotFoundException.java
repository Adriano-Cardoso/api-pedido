package com.br.aplicativo.msdesafio2.exception;

public class PedidoIdResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PedidoIdResourceNotFoundException(String message) {
		super(message);
	}

}
