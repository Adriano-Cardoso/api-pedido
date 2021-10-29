package br.com.adriano.apipedido.domain.dto.response;

import java.math.BigDecimal;

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
public class PedidoResponse {

	@ApiModelProperty(position = 1, required = false, value = "id do pedido", name = "pedidoId", dataType = "Long", example = "1")
	private Long pedidoId;

	@ApiModelProperty(position = 2, required = false, value = "email do solicitante do pedido", name = "email", dataType = "String", example = "teste@teste.com")
	private String email;


	@ApiModelProperty(position = 4, required = false, value = "status do pedido", name = "status", dataType = "Enum", example = "AGUARDANDO_CONFIRMACAO")
	private StatusPedido status;

	@ApiModelProperty(position = 5, required = false, value = "data de cria��o do pedido", name = "amount", dataType = "BigDecimal", example = "10.00")
	private BigDecimal amount;

	@ApiModelProperty(position = 6, required = false, value = "item do pedido", name = "itens", dataType = "List<ItemResponse>", example = "1")
	private Long itensId;

	@ApiModelProperty(position = 7, required = false, value = "cliente responsavel pelo pedido", name = "clienteId", dataType = "ClienteResponse", example = "1")
	private Long clienteId;

	
}
