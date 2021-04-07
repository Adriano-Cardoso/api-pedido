package com.br.aplicativo.msdesafio2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.aplicativo.msdesafio2.dto.ItemDto;
import com.br.aplicativo.msdesafio2.dto.ItemResponseDto;
import com.br.aplicativo.msdesafio2.service.ItemService;

@RestController
@RequestMapping(value = "v1/aplicativo/item")
public class CotrollerItem {

	@Autowired
	private ItemService service;

	@GetMapping(value = "list")
	public ResponseEntity<List<ItemDto>> listAllOrders() {
		return ResponseEntity.ok(this.service.listAllItem());
	}

	@PostMapping(value = "insertitem")
	public ResponseEntity<ItemDto> insertPedido(@RequestBody ItemResponseDto dto) {
		return ResponseEntity.ok(this.service.createItem(dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemDto> removeItensPedido(@PathVariable Integer id) {
		this.service.deleteItemId(id);
		return ResponseEntity.ok().build();
	}
}
