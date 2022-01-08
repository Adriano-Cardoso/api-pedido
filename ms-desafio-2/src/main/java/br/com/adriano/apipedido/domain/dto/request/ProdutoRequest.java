package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class ProdutoRequest implements Serializable {

	private static final long serialVersionUID = -7871977485544788444L;

	@NotBlank(message = "O valor do campo 'nome' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 1, value = "name", name = "name", dataType = "String", example = "Camisa Lacoste")
	private String name;

	@NotBlank(message = "O valor do campo 'nome' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 2, value = "description", name = "description", dataType = "String", example = "camisa polo")
	private String description;

	@NotBlank(message = "O valor do campo 'price' deve ser informado")
	@NotEmpty(message = "O valor do campo 'price' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'price' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 3, value = "price", name = "price", dataType = "BigDecimal", example = "10.00")
	private BigDecimal price;

	@NotBlank(message = "O valor do campo 'categoryIdome' deve ser informado")
	@NotEmpty(message = "O valor do campo 'categoryId' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'categoryId' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 2, value = "categoryId", name = "categoryId", dataType = "Long", example = "3")
	private Long categoryId;

}
