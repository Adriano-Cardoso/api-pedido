package br.com.adriano.apipedido.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.ProdutoRequest;
import br.com.adriano.apipedido.domain.dto.response.ProdutoResponse;
import br.com.adriano.apipedido.service.ProdutoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/produto")
public class ProdutoController {
	
	private ProdutoService produtoService;
	
	@PostMapping(value = "/insert/produto")
	public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequest produtoRequest) {
		return ResponseEntity.ok(this.produtoService.create(produtoRequest));
	}

	@GetMapping(value = "/listAllPedidos")
	public ResponseEntity<List<ProdutoResponse>> listAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.listAllProdutos());
	}

}
