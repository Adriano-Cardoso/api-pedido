package br.com.adriano.apipedido.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.adriano.apipedido.domain.Item;
import br.com.adriano.apipedido.domain.Pedido;
import br.com.adriano.apipedido.domain.dto.request.PedidoRequest;
import br.com.adriano.apipedido.domain.dto.response.PedidoResponse;
import br.com.adriano.apipedido.repository.PedidoRepository;
import br.com.adriano.apipedido.validations.Message;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService {

	private PedidoRepository pedidoRepository;



	public PedidoResponse create(PedidoRequest pedidoRequest) {
		
		Item item = new Item();
		
		this.pedidoRepository.findByEmail(pedidoRequest.getEmail()).ifPresent(e -> {
			throw Message.EMAIL_EXIST.asBusinessException();
		});
		
		Pedido pedido = Pedido.of(pedidoRequest);
		
		pedido.addItem(item);
		
		return pedido.toResponse();

	}

	public List<PedidoResponse> listAllPedidos(){
		return this.pedidoRepository.listAllPedidos();
	}

//	@Override
//	public PedidoItemDto updateItemPedido(Integer id, PedidoItemDto dto) {
//		Optional<Pedido> pedidoId = this.repository.findById(id);
//
//		if (pedidoId.isPresent()) {
//			Pedido requestEntity = pedidoId.get();
//			if (dto.getItens() != null || !dto.getItens().isEmpty()) {
//				requestEntity.setItens(dto.getItens());
//			}
//			Pedido entidade = this.repository.save(requestEntity);
//			return this.mapper.map(entidade, PedidoItemDto.class);
//		}
//		throw new PedidoIdResourceNotFoundException("Id do pedido não encontrado");
//
//	}
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
