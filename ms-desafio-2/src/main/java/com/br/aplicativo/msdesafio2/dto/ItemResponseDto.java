package com.br.aplicativo.msdesafio2.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemResponseDto {
	
	private Integer id;
	private String nome;
	private BigDecimal valorUnitario;

}
