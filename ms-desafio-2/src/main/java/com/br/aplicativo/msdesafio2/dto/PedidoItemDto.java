package com.br.aplicativo.msdesafio2.dto;

import java.util.List;

import com.br.aplicativo.msdesafio2.entity.ItemEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoItemDto {
	
	private Integer id;
	private List<ItemEntity> itens;

}
