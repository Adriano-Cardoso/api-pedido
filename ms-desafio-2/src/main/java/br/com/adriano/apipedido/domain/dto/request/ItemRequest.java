package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

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

	private String name;

	private BigDecimal unitaryValue;

//	private Long pedidoId;

	private Long produtoId;

}
