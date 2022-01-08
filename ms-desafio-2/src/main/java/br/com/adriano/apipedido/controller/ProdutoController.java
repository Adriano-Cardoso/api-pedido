package br.com.adriano.apipedido.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.ProdutoRequest;
import br.com.adriano.apipedido.domain.dto.response.ProdutoResponse;
import br.com.adriano.apipedido.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/produto")
public class ProdutoController {
	
	private ProdutoService produtoService;
	
	@PostMapping(value = "/create/product")
	@ApiOperation(value = "Cria um novo produto")
	public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoRequest produtoRequest) {
		return ResponseEntity.ok(this.produtoService.create(produtoRequest));
	}

	@GetMapping(value = "/listAllPedidos")
	@ApiOperation(value = "Realiza busca por todos os produtos")
	public ResponseEntity<List<ProdutoResponse>> listAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.listAllProdutos());
	}
	
	@PatchMapping(value = "/update/productId/{productId}")
	@ApiOperation(value = "Atualizar o nome ou descrição do produto")
	public ResponseEntity<ProdutoResponse> updateProductAndNameAndDescription(
			@Valid @PathVariable ("productId") Long productId, @RequestBody ProdutoRequest produtoRequest){
		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.updateProductAndNameAndDescription(productId, produtoRequest));
	}
	
	@PatchMapping(value = "/update/prices/productId/{productId}")
	@ApiOperation(value = "Atualizar o preço do produto")
	public ResponseEntity<ProdutoResponse> updateProductPrice(
			@Valid @PathVariable ("productId") Long productId, @RequestBody ProdutoRequest produtoRequest){
		return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.updateProductAndNameAndDescription(productId, produtoRequest));
	}
	@DeleteMapping()
	public ResponseEntity<ProdutoResponse> deleteProduct(@Valid @PathVariable ("productId") Long productId){
		this.produtoService.DeleteProduct(productId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
