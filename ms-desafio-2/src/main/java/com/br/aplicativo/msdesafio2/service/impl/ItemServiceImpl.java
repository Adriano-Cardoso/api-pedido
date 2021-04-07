package com.br.aplicativo.msdesafio2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aplicativo.msdesafio2.dto.ItemDto;
import com.br.aplicativo.msdesafio2.dto.ItemResponseDto;
import com.br.aplicativo.msdesafio2.entity.ItemEntity;
import com.br.aplicativo.msdesafio2.exception.ItemIdResourceNotFoundException;
import com.br.aplicativo.msdesafio2.exception.ItemNomeResourceAccessException;
import com.br.aplicativo.msdesafio2.repository.ItemRepository;
import com.br.aplicativo.msdesafio2.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;


	@Autowired
	private ModelMapper mapper;

	@Override
	public ItemDto createItem(ItemResponseDto dto) {
		ItemEntity entity = this.repository.findByNome(dto.getNome());
		if (entity != null) {
			throw new ItemNomeResourceAccessException("Nome do produto já existente!");
		}
		ItemEntity entityRequest = this.repository.save(this.mapper.map(dto, ItemEntity.class));
		return this.mapper.map(entityRequest, ItemDto.class);
	}

	@Override
	public void deleteItemId(Integer id) {

		Optional<ItemEntity> item = this.repository.findById(id);
		
		if (!item.isPresent()) {
			throw new ItemIdResourceNotFoundException("Id não encontrado!");
		}
		List<ItemEntity> entity = new ArrayList<>();
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(id);
		
		entity.remove(itemEntity);
		
		this.repository.deleteById(id);

	}

	@Override
	public List<ItemDto> listAllItem() {

		return this.repository.findAll().stream().map(entity -> this.mapper.map(entity, ItemDto.class))
				.collect(Collectors.toList());
	}

}
