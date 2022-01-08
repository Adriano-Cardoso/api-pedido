package br.com.adriano.apipedido.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ClienteResponse {

	@ApiModelProperty(position = 1, required = false, value = "id do cliente", name = "clienteId", dataType = "Long", example = "1")
	private Long clientId;

	@ApiModelProperty(position = 1, required = false, value = "nome do cliente", name = "nome", dataType = "String", example = "risonho")
	private String name;

	@ApiModelProperty(position = 1, required = false, value = "cpf do cliente", name = "cpf", dataType = "String", example = "12345678981")
	private String cpf;

}
