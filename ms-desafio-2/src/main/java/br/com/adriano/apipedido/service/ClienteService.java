package br.com.adriano.apipedido.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.apipedido.domain.Cliente;
import br.com.adriano.apipedido.domain.dto.request.ClienteRequest;
import br.com.adriano.apipedido.domain.dto.response.ClienteResponse;
import br.com.adriano.apipedido.repository.ClienteRepository;
import br.com.adriano.apipedido.validations.Message;
import br.com.adriano.apipedido.validations.OnCreate;
import lombok.AllArgsConstructor;

@Service("ClienteService")
@AllArgsConstructor
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Validated(OnCreate.class)
	public ClienteResponse create(@Valid ClienteRequest clienteRequest) {
		
		this.clienteRepository.findByCpf(clienteRequest.getCpf()).ifPresent(c ->{
			throw Message.CPF_EXISTS.asBusinessException();
		});
		
		Cliente cliente = Cliente.of(clienteRequest);
		
		this.clienteRepository.save(cliente);
		
		return cliente.toResponse();
	}
	
	public List<ClienteResponse> listAllClientes(){
		return this.clienteRepository.listAllClientes();
	}

}
