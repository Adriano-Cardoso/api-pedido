package br.com.adriano.apipedido.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.apipedido.domain.Item;
import br.com.adriano.apipedido.domain.dto.request.ItemRequest;
import br.com.adriano.apipedido.domain.dto.response.ItemResponse;
import br.com.adriano.apipedido.repository.ItemRepository;
import br.com.adriano.apipedido.validations.Message;
import br.com.adriano.apipedido.validations.OnCreate;
import lombok.AllArgsConstructor;


@Validated
@Service("ItemService")
@AllArgsConstructor
public class ItemService {

	private ItemRepository itemRepository;

	@Validated(OnCreate.class)
	public ItemResponse createItem(@Valid ItemRequest itemRequest) {
		this.itemRepository.findByName(itemRequest.getName()).ifPresent(n ->{
			throw Message.ITEM_EXIST.asBusinessException();              
		});

		Item item = Item.of(itemRequest);

		this.itemRepository.save(item);

		return item.toResponse();

		}

	public void deleteItemId(Long itemId) {

		Item item = this.itemRepository.findById(itemId).orElseThrow(Message.NOT_FOUND_ID::asBusinessException);
		
		this.itemRepository.delete(item);

	}

	public List<ItemResponse> listAllItem() {

		return this.itemRepository.listAllItem();
	}

}
