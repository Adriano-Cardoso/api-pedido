package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest implements Serializable {

	private static final long serialVersionUID = -2044793543385714574L;

	@ApiModelProperty(position = 1, required = false, value = "nome do cliente", name = "nome", dataType = "String", example = "risonho")
	private String nome;
	
	@ApiModelProperty(position = 1, required = false, value = "cpf do cliente", name = "cpf", dataType = "String", example = "12345678981")
	private String cpf;


}
