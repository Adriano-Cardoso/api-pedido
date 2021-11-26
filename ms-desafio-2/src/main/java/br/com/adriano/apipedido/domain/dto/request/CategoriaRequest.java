package br.com.adriano.apipedido.domain.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.adriano.apipedido.validations.OnCreate;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest implements Serializable {
	
	private static final long serialVersionUID = 853057643665889515L;

	@NotBlank(groups = {OnCreate.class}, message = "O valor do campo 'nome' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'nome' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'nome' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, value = "nome", name = "nome", dataType = "String", example = "risadinha")
	private String nome;
	
	@NotBlank(groups = {OnCreate.class} ,message = "O valor do campo 'tipo' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'tipo' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 14,  message = "O valor do campo 'tipo' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, value = "tipo", name = "tipo", dataType = "String", example = "iniciante")
	private String tipo;
	
	
	

}
