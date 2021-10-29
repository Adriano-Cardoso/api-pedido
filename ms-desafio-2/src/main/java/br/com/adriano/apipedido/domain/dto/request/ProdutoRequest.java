package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class ProdutoRequest implements Serializable {

	private static final long serialVersionUID = -7871977485544788444L;

	@NotBlank(message = "O valor do campo 'nome' deve ser informado")
	@NotEmpty(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@NotNull(message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@ApiModelProperty(position = 1, value = "nome", name = "nome", dataType = "String", example = "risadinha")
	private String nome;

	private String descricao;

	private BigDecimal preco;

	private Long categoriaId;

}
