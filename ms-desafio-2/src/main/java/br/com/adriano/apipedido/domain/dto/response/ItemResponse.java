package br.com.adriano.apipedido.domain.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ItemResponse {
	
//	@ApiModelProperty(position = 1, required = false, value = "id do item", name = "itemId", dataType = "Long", example = "1")
	private Long itemId;
	
//	@ApiModelProperty(position = 2, required = false, value = "nome do item", name = "name", dataType = "String", example = "Camisa")
	private String name;
	
//	@ApiModelProperty(position = 3, required = false, value = "valor unit�rio do item", name = "unitaryValue", dataType = "BigDecimal", example = "10.00")
	private BigDecimal unitaryValue;

	



	

}
