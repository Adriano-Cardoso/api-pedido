package br.com.adriano.apipedido.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.ClienteRequest;
import br.com.adriano.apipedido.domain.dto.response.ClienteResponse;
import br.com.adriano.apipedido.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@ApiOperation(value = "Cria um novo cliente")
	@PostMapping(value = "/insert/cliente")
	public ResponseEntity<ClienteResponse> create(@RequestBody ClienteRequest clienteRequest) {
		return ResponseEntity.ok(this.clienteService.create(clienteRequest));
	}

	@ApiOperation(value = "Lista todos os pedidos")
	@GetMapping(value = "/list")
	public ResponseEntity<List<ClienteResponse>> listAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.listAllClientes());
	}
	
	@ApiOperation(value = "Atualiza o cliente")
	@PatchMapping(value = "/clienteId/{clienteId}")
	public ResponseEntity<ClienteResponse> updateCliente(@Valid @PathVariable("clienteId") Long ClienteId, ClienteRequest clienteRequest){
		return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.updateCliente(ClienteId, clienteRequest));
	}
	
	@ApiOperation(value = "Atualiza o cliente")
	@DeleteMapping(value = "clienteId/{clienteId}")
	public ResponseEntity<ClienteResponse> deleteCliente(@Valid @PathVariable("ClienteId") Long ClienteId){
		this.clienteService.deleteCliente(ClienteId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
