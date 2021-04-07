package com.br.aplicativo.msdesafio2.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aplicativo.msdesafio2.dto.ItemDto;
import com.br.aplicativo.msdesafio2.dto.PedidoDto;
import com.br.aplicativo.msdesafio2.dto.PedidoItemDto;
import com.br.aplicativo.msdesafio2.entity.ItemEntity;
import com.br.aplicativo.msdesafio2.entity.PedidoEntity;
import com.br.aplicativo.msdesafio2.entity.enuns.StatusPedido;
import com.br.aplicativo.msdesafio2.exception.PedidoEmailResourceAccessException;
import com.br.aplicativo.msdesafio2.exception.PedidoEmailResourceNotFoundException;
import com.br.aplicativo.msdesafio2.exception.PedidoIdResourceNotFoundException;
import com.br.aplicativo.msdesafio2.exception.PedidoItemResourceNotFoundException;
import com.br.aplicativo.msdesafio2.exception.PedidoStatusCanceledResourceAccessException;
import com.br.aplicativo.msdesafio2.repository.ItemRepository;
import com.br.aplicativo.msdesafio2.repository.PedidoRepository;
import com.br.aplicativo.msdesafio2.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ItemRepository repositoryItem;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PedidoDto insertPedido(PedidoDto dto) {
		PedidoEntity entityEmail = this.repository.findByEmail(dto.getEmail());

		Optional<PedidoEntity> entityStatusConcluido = this.repository.findByStatus(StatusPedido.CONCLUIDO);

		Optional<PedidoEntity> entityStatusCancelado = this.repository.findByStatus(StatusPedido.CANCELADO);

		if (entityStatusConcluido.isPresent() || entityStatusCancelado.isPresent()) {
			throw new PedidoEmailResourceAccessException("Já existe um pedido vinculado a esse e-mail.");
		}

		if (entityEmail != null) {
			throw new PedidoEmailResourceAccessException("Já existe um pedido vinculado a esse e-mail.");
		}

		PedidoEntity entity = this.repository.save(this.mapper.map(dto, PedidoEntity.class));
		return this.mapper.map(entity, PedidoDto.class);

	}

	@Override
	public PedidoItemDto updateItemPedido(Integer id, PedidoItemDto dto) {
		Optional<PedidoEntity> pedidoId = this.repository.findById(id);

		if (pedidoId.isPresent()) {
			PedidoEntity requestEntity = pedidoId.get();
			if (dto.getItens() != null || !dto.getItens().isEmpty()) {
				requestEntity.setItens(dto.getItens());
			}
			PedidoEntity entidade = this.repository.save(requestEntity);
			return this.mapper.map(entidade, PedidoItemDto.class);
		}
		throw new PedidoIdResourceNotFoundException("Id do pedido não encontrado");

	}

	@Override
	public PedidoDto canceledPedido(Integer id) {
		Optional<PedidoEntity> optional = this.repository.findById(id);
		if (!optional.isPresent()) {
			throw new PedidoStatusCanceledResourceAccessException("O Status do pedido já está como cancelado!");
		}
		PedidoEntity requestEntity = optional.get();
		requestEntity.setStatus(StatusPedido.CANCELADO);

		PedidoEntity entity = this.repository.save(requestEntity);
		return this.mapper.map(entity, PedidoDto.class);
	}

	@Override
	public PedidoDto concluidoPedido(Integer id) {
		Optional<PedidoEntity> optional = this.repository.findById(id);
		if (!optional.isPresent()) {
			throw new PedidoStatusCanceledResourceAccessException("O Status do pedido já está como cancelado!");
		}
		PedidoEntity requestEntity = optional.get();
		requestEntity.setStatus(StatusPedido.CONCLUIDO);

		PedidoEntity entity = this.repository.save(requestEntity);
		return this.mapper.map(entity, PedidoDto.class);
	}

	@Override
	public PedidoDto toRecoverPedidoEmail(String email) {
		PedidoEntity entity = this.repository.findByEmail(email);
		if (entity == null) {
			throw new PedidoEmailResourceNotFoundException("Email não encontrado");

		}
		return this.mapper.map(entity, PedidoDto.class);
	}

	@Override
	public List<PedidoDto> toRecoverPedidoItem(ItemDto dto) {

		ItemEntity item = new ItemEntity();
		item.setId(dto.getId());
		List<PedidoEntity> entity = this.repository.findByItens(item);

		if (entity == null) {
			throw new PedidoItemResourceNotFoundException("Item não encontrado");
		}
		return entity.stream().map(l -> this.mapper.map(l, PedidoDto.class)).collect(Collectors.toList());

	}

	@Override
	public List<PedidoDto> listallPedidos() {
		return this.repository.findAll().stream().map(entity -> this.mapper.map(entity, PedidoDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PedidoDto removeItem(PedidoDto dto) {
		PedidoEntity entity = this.repository.getOne(dto.getId());
		if (entity != null) {

			for (ItemDto p : dto.getItens()) {
				ItemEntity item = this.repositoryItem.getOne(p.getId());
				entity.getItens().remove(item);

			}
			this.repository.save(entity);
			return dto;
		}
		throw new PedidoItemResourceNotFoundException("Item não encontrado");

	}

	@Override
	public PedidoDto addItemPedido(PedidoDto dto) {
		PedidoEntity entity = this.repository.getOne(dto.getId());
		if (entity != null) {
			for (ItemDto p : dto.getItens()) {
				ItemEntity item = this.repositoryItem.getOne(p.getId());
				entity.getItens().add(item);

			}
			this.repository.save(entity);
			return dto;
		}
		throw new PedidoItemResourceNotFoundException("Item não encontrado");
	}

}
