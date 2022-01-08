package br.com.adriano.apipedido.domain.dto.response;

import br.com.adriano.apipedido.domain.enums.StatusPedido;
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
public class PedidoResponseSatus {

	@ApiModelProperty(position = 1, required = false, value = "id do pedido", name = "pedidoId", dataType = "Long", example = "1")
	private Long pedidoId;

	@ApiModelProperty(position = 2, required = false, value = "status do pedido", name = "status", dataType = "Enum", example = "CANCELADO")
	private StatusPedido status;
}
