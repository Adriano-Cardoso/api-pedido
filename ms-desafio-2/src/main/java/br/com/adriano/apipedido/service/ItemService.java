package br.com.adriano.apipedido.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.apipedido.domain.Item;
import br.com.adriano.apipedido.domain.Produto;
import br.com.adriano.apipedido.domain.dto.request.ItemRequest;
import br.com.adriano.apipedido.domain.dto.response.ItemResponse;
import br.com.adriano.apipedido.repository.ItemRepository;
import br.com.adriano.apipedido.validations.Message;
import br.com.adriano.apipedido.validations.OnCreate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ItemService {

	private ItemRepository itemRepository;

	private ProdutoService produtoService;

	@Validated(OnCreate.class)
	public ItemResponse createItem(@Valid ItemRequest itemRequest) {
		
		Produto produto = this.produtoService.findById(itemRequest.getProductId());

		this.itemRepository.findByName(itemRequest.getName()).ifPresent(n -> {
			throw Message.ITEM_EXIST.asBusinessException();
		});

		Item item = Item.of(itemRequest);

		item.addProduto(produto);

		this.itemRepository.save(item);

		log.info("method=create itemId={} name={} unitaryValue={} productId={} ",
				item.getItemId(), item.getName(), item.getUnitaryValue(), item.getProductId());
		return item.toResponse();

	}

	public void deleteItemId(Long itemId) {
         
		Item item = this.itemRepository.findById(itemId).orElseThrow(Message.NOT_FOUND_ID::asBusinessException);
		log.info("method=deleteItemId itemId={}");
		this.itemRepository.delete(item);

	}

	public List<ItemResponse> listAllItem() {

		return this.itemRepository.listAllItem();
	}

	public Item findById(Long itensId) {
		log.info("method=findById itemId ={}");
		return itemRepository.findById(itensId).orElseThrow(() -> Message.NOT_FOUND_ITEM_ID.asBusinessException());
	}

}
