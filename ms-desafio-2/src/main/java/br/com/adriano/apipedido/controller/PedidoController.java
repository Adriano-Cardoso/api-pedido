package br.com.adriano.apipedido.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.PedidoRequest;
import br.com.adriano.apipedido.domain.dto.response.PedidoResponse;
import br.com.adriano.apipedido.service.PedidoService;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/pedido")
public class PedidoController {

	private PedidoService pedidoService;

	@PostMapping(value = "/insertpedido")
	public ResponseEntity<PedidoResponse> create(@RequestBody PedidoRequest pedidoRequest) {
		return ResponseEntity.ok(this.pedidoService.create(pedidoRequest));
	}

	@GetMapping(value = "/listAllPedidos")
	public ResponseEntity<List<PedidoResponse>> listAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(this.pedidoService.listAllPedidos());
	}



	@PatchMapping(value = "/cancela/{pedidoId}")
	public ResponseEntity<PedidoResponse> cancelledPedido(@PathVariable Long pedidoId) {
		return ResponseEntity.ok(this.pedidoService.canceledPedido(pedidoId));
	}
	
}
////	
////	@PatchMapping("/concluido/{id}")
////	public ResponseEntity<PedidoResponse> concluidoPedido(@PathVariable Integer id) {
////		return ResponseEntity.ok(this.service.concluidoPedido(id));
////	}
////
////	@PatchMapping("/{id}")
////	public ResponseEntity<PedidoItemDto> updatePedido(@PathVariable Integer id, @RequestBody PedidoItemDto dto) {
////		return ResponseEntity.ok(this.service.updateItemPedido(id, dto));
////
////	}
////	@PatchMapping("/additem")
////	public ResponseEntity<PedidoResponse> addPedido( @RequestBody PedidoResponse dto){
////		return ResponseEntity.ok(this.service.addItemPedido(dto));
////	}
////	
////	@PutMapping("removeritem")
////	public ResponseEntity<PedidoResponse> removeItensPedido(@RequestBody PedidoResponse dto){
////		return ResponseEntity.ok(this.service.removeItem(dto));
////	}
//
//}
