package br.com.adriano.apipedido.domain.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {
	
	private Integer id;
	private String nome;
	private BigDecimal valorUnitario;

}
