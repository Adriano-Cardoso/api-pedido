package br.com.adriano.apipedido.domain.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProdutoResponse {

	private Long produtoId;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	private Long categoriaId;

	
	

}
