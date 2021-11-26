package br.com.adriano.apipedido.domain.dto.request;

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
public class PedidoStatusRequest {
	
	@NotBlank(groups = { OnCreate.class }, message = "O campo 'status'  esta invalido")
	@NotNull(groups = { OnCreate.class }, message = "O campo 'status' esta invalido")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'status' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 3, required = false, value = "status do pedido", name = "status", dataType = "enum", example = "AGUARDANDO_CONFIRMACAO")
	private StatusPedido status;

}
