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

	private Long itensId;

	private String name;

	private BigDecimal unitaryValue;

//	private Long pedidoId;

	private Long productId;

	
	

}
