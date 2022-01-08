package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
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
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'nome' � obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 60,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "nome do item", name = "nome", dataType = "String", example = "risadas")
	private String name;

	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'unitaryValue' � obrigatorio no corpo da requisicao")
	@DecimalMin(groups = {OnCreate.class},  value = "1", message = "O valor do campo 'unitaryValue' '${validatedValue}' deve estar com o valor minimo de {min} caracteres")
	@ApiModelProperty(position = 2, required = false, value = "valor unitario", name = "unitaryValue", dataType = "BigDecimal", example = "10.00")
	private BigDecimal unitaryValue;

	@Min(groups = {OnCreate.class}, value = 1,  message = "O valor do campo 'productId' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 3, required = false, value = "id do produto", name = "produtoId", dataType = "Long", example = "3")
	private Long productId;
	

}
