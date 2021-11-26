package br.com.adriano.apipedido.domain.dto.request;

import javax.validation.constraints.Size;

import br.com.adriano.apipedido.validations.OnUpdate;
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
public class PedidoUpdateRequest {
	

	@ApiModelProperty(position = 5, required = false, value = "item do pedido", name = "itens", dataType = "ItemRequest", example = "1")
	@Size(groups = {OnUpdate.class}, min = 1,  max = 14,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	private Long itensId;
	

}
