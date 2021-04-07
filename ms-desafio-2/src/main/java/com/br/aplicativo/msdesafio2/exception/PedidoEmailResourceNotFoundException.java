package com.br.aplicativo.msdesafio2.exception;

public class PedidoEmailResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PedidoEmailResourceNotFoundException (String  message) {
		super(message);
	}
}
