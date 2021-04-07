package com.br.aplicativo.msdesafio2.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.br.aplicativo.msdesafio2.entity.enuns.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

	private Integer id;
	private String email;
	private Date dataDeCriacao;
	private StatusPedido status;
	private BigDecimal valorTotal;
	private List<ItemDto> itens;

}
