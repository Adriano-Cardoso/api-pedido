package com.br.aplicativo.msdesafio2.service;

import java.util.List;

import com.br.aplicativo.msdesafio2.dto.ItemDto;
import com.br.aplicativo.msdesafio2.dto.ItemResponseDto;

public interface ItemService {

	ItemDto createItem (ItemResponseDto dto);
	
	void deleteItemId(Integer id);
	
	List<ItemDto> listAllItem();
}
