package br.com.adriano.apipedido.domain.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.adriano.apipedido.domain.enums.StatusPedido;
import br.com.adriano.apipedido.validations.OnCreate;
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
public class PedidoRequest {

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'email'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'email' esta invalido")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'email' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "email que criou o pedido", name = "email", dataType = "String", example = "teste@teste.com")
	private String email;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'creationDate'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'creationDate' esta invalido")
	@ApiModelProperty(position = 2, required = false, value = "data que o pedido foi criado", name = "creationDate", dataType = "String", example = "")
	private LocalDateTime creationDate;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'status'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'status' esta invalido")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'status' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 3, required = false, value = "status do pedido", name = "status", dataType = "enum", example = "AGUARDANDO_CONFIRMACAO")
	private StatusPedido status;

	@NotBlank(groups = { OnCreate.class }, message = "O campo 'amount'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'amount' esta invalido")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'amount' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 4, required = false, value = "valor total do pedido", name = "amount", dataType = "BigDecimal", example = "10")
	private BigDecimal amount;

	@ApiModelProperty(position = 5, required = false, value = "item do pedido", name = "itens", dataType = "ItemRequest", example = "1")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	private Long itensId;
	
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'clienteId' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 6, required = false, value = "Cliente que solicitou pedido", name = "pedidoId", dataType = "Long", example = "1")
	private Long clienteId;

}
