package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.adriano.apipedido.validations.OnCreate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest implements Serializable {

	private static final long serialVersionUID = -8989146325869729833L;

	@NotBlank(groups = {OnCreate.class}, message = "O valor do campo 'nome' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "nome do item", name = "nome", dataType = "String", example = "risadas")
	private String name;

	@NotBlank(groups = {OnCreate.class}, message = "O valor do campo 'unitaryValue' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'unitaryValue' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'unitaryValue' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "valor unitario", name = "unitaryValue", dataType = "BigDecimal", example = "10.00")
	private BigDecimal unitaryValue;


	@NotBlank(groups = {OnCreate.class}, message = "O valor do campo 'nome' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "id do produto", name = "produtoId", dataType = "Long", example = "1")
	private Long produtoId;

}
