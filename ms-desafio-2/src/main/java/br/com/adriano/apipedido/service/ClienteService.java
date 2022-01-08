package br.com.adriano.apipedido.service;

import java.util.List;

import javax.transaction.Transactional;
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
import lombok.extern.slf4j.Slf4j;

@Service("ClienteService")
@AllArgsConstructor
@Slf4j
public class ClienteService {

	private ClienteRepository clienteRepository;

	@Validated(OnCreate.class)
	public ClienteResponse create(@Valid ClienteRequest clienteRequest) {

		this.clienteRepository.findByCpf(clienteRequest.getCpf()).ifPresent(c -> {
			throw Message.CPF_EXISTS.asBusinessException();
		});

		Cliente cliente = Cliente.of(clienteRequest);

		this.clienteRepository.save(cliente);

		return cliente.toResponse();
	}

	public List<ClienteResponse> listAllClientes() {
		log.info("method=listAllClientes");
		return this.clienteRepository.listAllClientes();
	}

	public Cliente findById(Long clienteId) {
		log.info("method=findById clienteId ={}");
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> Message.NOT_FOUND_CLIENTE_ID.asBusinessException());
	}

	@Transactional
	public ClienteResponse updateCliente(@Valid Long clienteId, ClienteRequest clienteRequest) {

		Cliente cliente = this.clienteRepository.findById(clienteId)
				.orElseThrow(() -> Message.NOT_FOUND_CLIENTE_ID.asBusinessException());

		cliente.updateCliente(clienteRequest);
		
		log.info("method=updateCliente clienteId ={}");
		
		return cliente.toResponse();
	}
	
	public void deleteCliente(@Valid Long clienteId) {
		Cliente cliente = this.clienteRepository.findById(clienteId)
				.orElseThrow(() -> Message.NOT_FOUND_CLIENTE_ID.asBusinessException());
		
		log.info("method=deleteCliente clienteId ={}");
		this.clienteRepository.delete(cliente);

	}

}
