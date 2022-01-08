package br.com.adriano.apipedido.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.apipedido.domain.Cliente;
import br.com.adriano.apipedido.domain.Item;
import br.com.adriano.apipedido.domain.Pedido;
import br.com.adriano.apipedido.domain.dto.request.PedidoRequest;
import br.com.adriano.apipedido.domain.dto.request.PedidoUpdateRequest;
import br.com.adriano.apipedido.domain.dto.response.PedidoResponse;
import br.com.adriano.apipedido.domain.enums.StatusPedido;
import br.com.adriano.apipedido.repository.PedidoRepository;
import br.com.adriano.apipedido.validations.Message;
import br.com.adriano.apipedido.validations.OnCreate;
import br.com.adriano.apipedido.validations.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class PedidoService {

	private PedidoRepository pedidoRepository;

	private ItemService itemService;
	
	private ClienteService clienteService;

	@Validated(OnCreate.class)
	public PedidoResponse create(@Valid PedidoRequest pedidoRequest) {

		Item item = this.itemService.findById(pedidoRequest.getItensId());

		Cliente cliente = this.clienteService.findById(pedidoRequest.getClienteId());
		
		this.pedidoRepository.findByEmail(pedidoRequest.getEmail()).ifPresent(e -> {
			throw Message.EMAIL_EXIST.asBusinessException();
		});

		Pedido pedido = Pedido.of(pedidoRequest);
		
		pedido.addCliente(cliente);

		pedido.addItem(item);

		pedidoRepository.save(pedido);

		log.info("method=create pedidoId={} email={} creationDate={} status={} amount={} itensId={} clienteId={}",
				pedido.getPedidoId(), pedido.getEmail(), pedido.getCreationDate(), pedido.getStatus(),
				pedido.getAmount(), pedido.getItensId(), pedido.getClientId());

		return pedido.toResponse();

	}

	public List<PedidoResponse> listAllPedidos() {
		return this.pedidoRepository.listAllPedidos();
	}

	@Validated(OnUpdate.class)
	@Transactional
	public PedidoResponse updateItemPedido(Long pedidoId, @Valid PedidoUpdateRequest pedidoUpdateRequest) {
		Pedido pedido = this.pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> Message.NOT_FOUND_PEDIDO.asBusinessException());

		pedido.updateItemPedido(pedidoUpdateRequest);

		log.info("method=update pedidoId={} itensId={}", pedidoId, pedido.getItensId());

		return pedido.toResponse();
	}

	public void cancelledStatusPedido(Long pedidoId) {
		Pedido pedido = this.pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());

		pedido.alterStatus(StatusPedido.CANCELADO);

		pedidoRepository.save(pedido);

	}

	public void closePedido(Long pedidoId) {
		Pedido pedido = this.pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());

		pedido.alterStatus(StatusPedido.CONCLUIDO);

		pedidoRepository.save(pedido);
	}

	public PedidoResponse findByEmail(String email) {
		log.info("method=findByEmail email={}", email);

		return this.pedidoRepository.findByEmail(email).orElseThrow(() -> Message.EMAIL_EXIST.asBusinessException());

	}

	public PedidoResponse findByItensId(Long itemId) {
		log.info("method=findByItensId ItensId={}", itemId);
		return this.pedidoRepository.findByItensId(itemId)
				.orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());
	}

	public PedidoResponse deleteItemPedido(Long pedidoId, PedidoRequest pedidoRequest) {
		Pedido pedido = this.pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> Message.NOT_FOUND_PEDIDO.asBusinessException());

		this.pedidoRepository.findByItensId(pedidoRequest.getItensId())
				.orElseThrow(() -> Message.NOT_FOUND_ID.asBusinessException());

		this.itemService.deleteItemId(pedidoRequest.getItensId());

		this.pedidoRepository.save(pedido);

		return pedido.toResponse();
	}

	public Pedido findById(Long pedidoId) {
		log.info("method=findById");
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> Message.NOT_FOUND_PEDIDO_ID.asBusinessException());
	}


}
