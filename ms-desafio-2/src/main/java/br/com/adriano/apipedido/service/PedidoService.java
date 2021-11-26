package br.com.adriano.apipedido.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

	@Validated(OnCreate.class)
	public PedidoResponse create(@Valid PedidoRequest pedidoRequest) {

		Item item = new Item();

		this.pedidoRepository.findByEmail(pedidoRequest.getEmail()).ifPresent(e -> {
			throw Message.EMAIL_EXIST.asBusinessException();
		});

		Pedido pedido = Pedido.of(pedidoRequest);

		pedido.addItem(item);

		pedidoRepository.save(pedido);

		log.info("method=create pedidoId={} email={} creationDate={} status={} amount={} itensId={} clienteId={}",
				pedido.getPedidoId(), pedido.getEmail(), pedido.getCreationDate(), pedido.getStatus(),
				pedido.getAmount(), pedido.getItensId(), pedido.getClienteId());

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

	public PedidoResponse canceledPedido(Long pedidoId) {
		Pedido pedido = this.pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> Message.NOT_FOUND_STATUS_CANCELADO.asBusinessException());


		StatusPedido statusPedido = StatusPedido.CANCELADO;
		pedido = Pedido.canceledPedido(statusPedido);

		return pedido.toResponse();
	}

	public PedidoResponse findByEmail(String email) {
		log.info("method=findByEmail email={}", email);
		
		return this.pedidoRepository.findByEmail(email).orElseThrow(() -> Message.EMAIL_EXIST.asBusinessException());

	}

//
//	@Override
//	public PedidoResponse canceledPedido(Integer id) {
//		Optional<Pedido> optional = this.repository.findById(id);
//		if (!optional.isPresent()) {
//			throw new PedidoStatusCanceledResourceAccessException("O Status do pedido já está como cancelado!");
//		}
//		Pedido requestEntity = optional.get();
//		requestEntity.setStatus(StatusPedido.CANCELADO);
//
//		Pedido entity = this.repository.save(requestEntity);
//		return this.mapper.map(entity, PedidoResponse.class);
//	}
//
//	@Override
//	public PedidoResponse concluidoPedido(Integer id) {
//		Optional<Pedido> optional = this.repository.findById(id);
//		if (!optional.isPresent()) {
//			throw new PedidoStatusCanceledResourceAccessException("O Status do pedido já está como cancelado!");
//		}
//		Pedido requestEntity = optional.get();
//		requestEntity.setStatus(StatusPedido.CONCLUIDO);
//
//		Pedido entity = this.repository.save(requestEntity);
//		return this.mapper.map(entity, PedidoResponse.class);
//	}
//
//	@Override
//	public PedidoResponse toRecoverPedidoEmail(String email) {
//		Pedido entity = this.repository.findByEmail(email);
//		if (entity == null) {
//			throw new PedidoEmailResourceNotFoundException("Email não encontrado");
//
//		}
//		return this.mapper.map(entity, PedidoResponse.class);
//	}
//
//	@Override
//	public List<PedidoResponse> toRecoverPedidoItem(ItemDto dto) {
//
//		Item item = new Item();
//		item.setId(dto.getId());
//		List<Pedido> entity = this.repository.findByItens(item);
//
//		if (entity == null) {
//			throw new PedidoItemResourceNotFoundException("Item não encontrado");
//		}
//		return entity.stream().map(l -> this.mapper.map(l, PedidoResponse.class)).collect(Collectors.toList());
//
//	}
//
//	@Override
//	public List<PedidoResponse> listallPedidos() {
//		return this.repository.findAll().stream().map(entity -> this.mapper.map(entity, PedidoResponse.class))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public PedidoResponse removeItem(PedidoResponse dto) {
//		Pedido entity = this.repository.getOne(dto.getId());
//		if (entity != null) {
//
//			for (ItemDto p : dto.getItens()) {
//				Item item = this.repositoryItem.getOne(p.getId());
//				entity.getItens().remove(item);
//
//			}
//			this.repository.save(entity);
//			return dto;
//		}
//		throw new PedidoItemResourceNotFoundException("Item não encontrado");
//
//	}
//
//	@Override
//	public PedidoResponse addItemPedido(PedidoResponse dto) {
//		Pedido entity = this.repository.getOne(dto.getId());
//		if (entity != null) {
//			for (ItemDto p : dto.getItens()) {
//				Item item = this.repositoryItem.getOne(p.getId());
//				entity.getItens().add(item);
//
//			}
//			this.repository.save(entity);
//			return dto;
//		}
//		throw new PedidoItemResourceNotFoundException("Item não encontrado");
//	}

}
