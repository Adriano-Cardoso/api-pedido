package com.br.aplicativo.msdesafio2.service;

import java.util.List;

import com.br.aplicativo.msdesafio2.dto.ItemDto;
import com.br.aplicativo.msdesafio2.dto.PedidoDto;
import com.br.aplicativo.msdesafio2.dto.PedidoItemDto;

public interface PedidoService {
	
	PedidoDto insertPedido(PedidoDto dto);
	
	PedidoItemDto updateItemPedido(Integer id, PedidoItemDto dto);
	
	PedidoDto canceledPedido(Integer id);
	
	PedidoDto concluidoPedido(Integer id);
	
	PedidoDto toRecoverPedidoEmail(String email);
	
	List<PedidoDto> toRecoverPedidoItem(ItemDto dto);
	
	List<PedidoDto> listallPedidos();
	
	PedidoDto removeItem(PedidoDto dto);
	
	PedidoDto addItemPedido(PedidoDto dto);

	

}
