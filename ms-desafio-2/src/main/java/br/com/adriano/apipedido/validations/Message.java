package br.com.adriano.apipedido.validations;

import org.springframework.http.HttpStatus;

import br.com.adriano.apipedido.exception.BusinessException;


public enum Message {
	
	NOT_FOUND_VIDEO("O video nao foi encontrado", HttpStatus.NOT_FOUND),
	VIDEO_EXIST("O video ja existe", HttpStatus.BAD_REQUEST),
	CATEGORY_EXIST("A categoria ja existe", HttpStatus.BAD_REQUEST),
	EMAIL_EXIST("O Email ja existe em nossa base de dados", HttpStatus.BAD_REQUEST),
	ITEM_EXIST("O ITEM ja existe em nossa base de dados", HttpStatus.BAD_REQUEST),
	NOT_FOUND_ID("O id não existe", HttpStatus.NOT_FOUND),
	NOME_EXISTS("O Nome do produto ja existe em nossa base de dados", HttpStatus.BAD_REQUEST),
	CPF_EXISTS("O Nome do Cliente ja existe em nossa base de dados", HttpStatus.BAD_REQUEST), 
	NOT_FOUND_CATEGORY("O id da categoria existe", HttpStatus.NOT_FOUND);
	
	private String value;
	private String description;
	private HttpStatus statusCode;

	private Message(String value, HttpStatus statusCode) {
		this.value = value;
		this.statusCode = statusCode;
	}

	private Message(String value, String description, HttpStatus statusCode) {
		this.value = value;
		this.description = description;
		this.statusCode = statusCode;
	}

	private Message(String value) {
		this.value = value;
	}

	public String getMessage() {
		return this.value;
	}

	public HttpStatus getStatus() {
		return this.statusCode;
	}

	public String getDescription() {
		return description;
	}

	public BusinessException asBusinessException() {
		return BusinessException.builder().httpStatusCode(this.getStatus())
				.code(String.valueOf(this.getStatus().value())).message(this.getMessage())
				.description(this.getDescription()).build();
	}

}
