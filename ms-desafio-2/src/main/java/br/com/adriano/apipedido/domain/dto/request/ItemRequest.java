package br.com.adriano.apipedido.domain.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
	
	private Long itemId;
	
	private String name;
	
	private BigDecimal unitaryValue;

}
