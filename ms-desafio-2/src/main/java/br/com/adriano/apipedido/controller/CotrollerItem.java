package br.com.adriano.apipedido.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.ItemRequest;
import br.com.adriano.apipedido.domain.dto.response.ItemResponse;
import br.com.adriano.apipedido.service.ItemService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/item/")
public class CotrollerItem {

	private ItemService itemService;

	@GetMapping(value = "list")
	public ResponseEntity<List<ItemResponse>> listAllItens() {
		return ResponseEntity.status(HttpStatus.OK).body(this.itemService.listAllItem());
	}

	@PostMapping(value = "insertitem")
	public ResponseEntity<ItemResponse> insertPedido(@RequestBody ItemRequest itemRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.createItem(itemRequest));
	}

	@DeleteMapping("/{itemId}")
	public ResponseEntity<ItemResponse> deleteItemId(@Valid @PathVariable("itemId") Long itemId) {
		this.itemService.deleteItemId(itemId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
