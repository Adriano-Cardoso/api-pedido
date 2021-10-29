package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class CategoriaRequest implements Serializable {
	
	private static final long serialVersionUID = 853057643665889515L;

	@NotBlank(message = "O valor do campo 'nome' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 1, value = "nome", name = "nome", dataType = "String", example = "risadinha")
	private String nome;
	
	@NotBlank(message = "O valor do campo 'tipo' deve ser informado")
	@NotEmpty(message = "O valor do campo 'tipo' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'tipo' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 1, value = "tipo", name = "tipo", dataType = "String", example = "iniciante")
	private String tipo;

}
