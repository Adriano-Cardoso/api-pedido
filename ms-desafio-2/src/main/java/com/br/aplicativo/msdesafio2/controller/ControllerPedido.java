package com.br.aplicativo.msdesafio2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.aplicativo.msdesafio2.dto.ItemDto;
import com.br.aplicativo.msdesafio2.dto.PedidoDto;
import com.br.aplicativo.msdesafio2.dto.PedidoItemDto;
import com.br.aplicativo.msdesafio2.service.PedidoService;

@RestController
@RequestMapping(value = "v1/aplicativo/pedido")
public class ControllerPedido {

	@Autowired
	private PedidoService service;

	@GetMapping(value = "list")
	public ResponseEntity<List<PedidoDto>> listAllOrders() {
		return ResponseEntity.ok(this.service.listallPedidos());
	}

	@GetMapping(value = "recoveremail")
	public ResponseEntity<PedidoDto> recoverEmail(String email) {
		return ResponseEntity.ok(this.service.toRecoverPedidoEmail(email));
	}

	@GetMapping("/recoverid/{id}")
	public ResponseEntity<List<PedidoDto>> recoverItem(ItemDto dto) {
		return ResponseEntity.ok(this.service.toRecoverPedidoItem(dto));

	}

	@PostMapping(value = "insertpedido")
	public ResponseEntity<PedidoDto> insertPedido(@RequestBody PedidoDto dto) {
		return ResponseEntity.ok(this.service.insertPedido(dto));
	}

	@PatchMapping("/cancela/{id}")
	public ResponseEntity<PedidoDto> cancelledPedido(@PathVariable Integer id) {
		return ResponseEntity.ok(this.service.canceledPedido(id));
	}
	
	@PatchMapping("/concluido/{id}")
	public ResponseEntity<PedidoDto> concluidoPedido(@PathVariable Integer id) {
		return ResponseEntity.ok(this.service.concluidoPedido(id));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<PedidoItemDto> updatePedido(@PathVariable Integer id, @RequestBody PedidoItemDto dto) {
		return ResponseEntity.ok(this.service.updateItemPedido(id, dto));

	}
	@PatchMapping("/additem")
	public ResponseEntity<PedidoDto> addPedido( @RequestBody PedidoDto dto){
		return ResponseEntity.ok(this.service.addItemPedido(dto));
	}
	
	@PutMapping("removeritem")
	public ResponseEntity<PedidoDto> removeItensPedido(@RequestBody PedidoDto dto){
		return ResponseEntity.ok(this.service.removeItem(dto));
	}

}
