package br.com.adriano.apipedido.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.ClienteRequest;
import br.com.adriano.apipedido.domain.dto.response.ClienteResponse;
import br.com.adriano.apipedido.service.ClienteService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@PostMapping(value = "/insert/cliente")
	public ResponseEntity<ClienteResponse> create(@RequestBody ClienteRequest clienteRequest) {
		return ResponseEntity.ok(this.clienteService.create(clienteRequest));
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<ClienteResponse>> listAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.listAllClientes());
	}

}
