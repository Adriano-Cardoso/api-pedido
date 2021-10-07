package br.com.adriano.apipedido.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adriano.apipedido.domain.dto.response.ItemResponse;
import br.com.adriano.apipedido.domain.enums.StatusPedido;
import br.com.adriano.apipedido.validations.OnCreate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'email'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'email' esta invalido")
	@NotEmpty(groups = { OnCreate.class }, message = "O campo 'email' esta invalido")
	@ApiModelProperty(position = 1, required = false, value = "email que criou o pedido", name = "email", dataType = "String", example = "teste@teste.com")
	private String email;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'creationDate'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'creationDate' esta invalido")
	@NotEmpty(groups = { OnCreate.class }, message = "O campo 'creationDate' esta invalido")
	@ApiModelProperty(position = 2, required = false, value = "data que o pedido foi criado", name = "creationDate", dataType = "String", example = "")
	private LocalDateTime creationDate;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'status'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'status' esta invalido")
	@NotEmpty(groups = { OnCreate.class }, message = "O campo 'status' esta invalido")
	@ApiModelProperty(position = 3, required = false, value = "status do pedido", name = "status", dataType = "enum", example = "AGUARDANDO_CONFIRMACAO")
	private StatusPedido status;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'amount'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'amount' esta invalido")
	@NotEmpty(groups = { OnCreate.class }, message = "O campo 'amount' esta invalido")
	@ApiModelProperty(position = 4, required = false, value = "valor total do pedido", name = "amount", dataType = "BigDecimal", example = "10")
	private BigDecimal amount;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'itens'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'itens' esta invalido")
	@NotEmpty(groups = { OnCreate.class }, message = "O campo 'itens' esta invalido")
	@ApiModelProperty(position = 5, required = false, value = "item do pedido", name = "itens", dataType = "ItemRequest", example = "1")
	private Long itens;

}
