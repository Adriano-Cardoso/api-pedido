package br.com.adriano.apipedido.domain.dto.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProdutoResponse {

	@ApiModelProperty(position = 1, required = false, value = "id do produto", name = "productId", dataType = "Long", example = "1")
	private Long productId;

	@ApiModelProperty(position = 2, required = false, value = "nome do produto", name = "name", dataType = "String", example = "camisa")
	private String name;

	@ApiModelProperty(position = 3, required = false, value = "descricao do produto", name = "description", dataType = "String", example = "Camisa polo da lacoste")
	private String description;

	@ApiModelProperty(position = 4, required = false, value = "id do produto", name = "productId", dataType = "Long", example = "10.00")
	private BigDecimal price;

	@ApiModelProperty(position = 5, required = false, value = "categoria do produto", name = "productId", dataType = "Long", example = "1")
	private Long categoryId;

	
	

}
