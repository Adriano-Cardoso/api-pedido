package br.com.adriano.apipedido.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adriano.apipedido.domain.dto.request.CategoriaRequest;
import br.com.adriano.apipedido.domain.dto.response.CategoriaResponse;
import br.com.adriano.apipedido.service.CategoriaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/aplicativo/categoria")
public class CategoriaController {
	
	private CategoriaService categoriaService;
	
	@PostMapping(value = "/insert/categoria")
	public ResponseEntity<CategoriaResponse> create(@Valid @RequestBody CategoriaRequest categoriaRequest) {
		return ResponseEntity.ok(this.categoriaService.create(categoriaRequest));
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<CategoriaResponse>> listAllPedido(){
		return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.listAllCategorias());
	}
	
	@DeleteMapping("/{categoriaId}")
	public ResponseEntity<CategoriaResponse> deleteCategoria(@Valid @PathVariable("categoriaId") Long categoriaId){
		this.categoriaService.deleteCategoria(categoriaId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/update/{categoriaId}")
	public ResponseEntity<CategoriaResponse> updateCategoria(@Valid @PathVariable("categoriaId") Long categoriaId, CategoriaRequest categoriaRequest){
		return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.updateCategoria(categoriaId, categoriaRequest));
	}
	

}
