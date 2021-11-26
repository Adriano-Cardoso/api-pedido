package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.adriano.apipedido.validations.OnCreate;
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

	@NotBlank(groups = {OnCreate.class}, message = "O valor do campo 'nome' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "nome do cliente", name = "nome", dataType = "String", example = "risadas")
	private String nome;
	
	@NotBlank(groups = {OnCreate.class}, message = "O valor do campo 'cpf' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'cpf' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'cpf' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "cpf do cliente", name = "cpf", dataType = "String", example = "12345678981")
	private String cpf;


}
