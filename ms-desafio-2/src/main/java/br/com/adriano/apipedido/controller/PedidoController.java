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

	@PostMapping(value = "/create")
	public ResponseEntity<PedidoResponse> create(@RequestBody PedidoRequest pedidoRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoService.create(pedidoRequest));
	}

	@GetMapping(value = "/listAllPedidos")
	public ResponseEntity<List<PedidoResponse>> listAllPedido() {
		return ResponseEntity.status(HttpStatus.OK).body(this.pedidoService.listAllPedidos());
	}

	@PatchMapping(value = "/cancel/{pedidoId}")
	public ResponseEntity<PedidoResponse> cancelledStatusPedido(@PathVariable Long pedidoId) {
		this.pedidoService.cancelledStatusPedido(pedidoId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PatchMapping(value = "close/pedidoId/{pedidoId}")
	public ResponseEntity<PedidoResponse> closePedido(@PathVariable Long pedidoId) {
		this.pedidoService.closePedido(pedidoId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<PedidoResponse> findByEmail(String email) {
		return ResponseEntity.status(HttpStatus.OK).body(this.pedidoService.findByEmail(email));
	}

	@GetMapping("/itensId/{itensId}")
	public ResponseEntity<PedidoResponse> findByItensId(Long itemId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.pedidoService.findByItensId(itemId));
	}

	@PatchMapping("/removeItem/{pedidoId}")
	public ResponseEntity<PedidoResponse> deleteItemPedido(@PathVariable Long pedidoId, @RequestBody PedidoRequest pedidoRequest) {
		return ResponseEntity.ok(this.pedidoService.deleteItemPedido(pedidoId , pedidoRequest));
	}
}
