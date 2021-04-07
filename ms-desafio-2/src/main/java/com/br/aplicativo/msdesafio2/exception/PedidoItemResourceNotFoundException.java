package com.br.aplicativo.msdesafio2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoItemResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PedidoItemResourceNotFoundException (String message) {
		super(message);
	}
}
