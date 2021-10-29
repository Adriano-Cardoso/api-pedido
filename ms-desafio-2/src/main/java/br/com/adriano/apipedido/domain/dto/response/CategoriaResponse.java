package br.com.adriano.apipedido.domain.dto.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoriaResponse implements Serializable {


	private static final long serialVersionUID = -1926023495649559508L;

	@ApiModelProperty(position = 1, required = false, value = "id da categoria", name = "categoriaId", dataType = "Long", example = "1")
	private Long categoriaId;
	
	@ApiModelProperty(position = 2, required = false, value = "nome da categoria", name = "nome", dataType = "String", example = "Risadinha123")
	private String nome;
	
	@ApiModelProperty(position = 3, required = false, value = "tipo da categoria", name = "tipo", dataType = "String", example = "iniciante")
	private String tipo;
}
