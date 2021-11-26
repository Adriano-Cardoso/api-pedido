package br.com.adriano.apipedido.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.adriano.apipedido.domain.Categoria;
import br.com.adriano.apipedido.domain.dto.request.CategoriaRequest;
import br.com.adriano.apipedido.domain.dto.response.CategoriaResponse;
import br.com.adriano.apipedido.repository.CategoriaRepository;
import br.com.adriano.apipedido.validations.Message;
import br.com.adriano.apipedido.validations.OnCreate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("CategoriaService")
@Validated
@AllArgsConstructor
@Slf4j
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	@Validated(OnCreate.class)
	public CategoriaResponse create(@Valid CategoriaRequest categoriaRequest) {

		this.categoriaRepository.findByNome(categoriaRequest.getNome()).ifPresent(c -> {
			throw Message.CATEGORY_EXIST.asBusinessException();
		});

		Categoria categoria = Categoria.of(categoriaRequest);

		this.categoriaRepository.save(categoria);
		log.info("method=create categoriaId={} nome={} tipo={}", categoriaRequest.toString());

		return categoria.toResponse();
	}

	public List<CategoriaResponse> listAllCategorias() {
		return this.categoriaRepository.listAllCategorias();
	}

	public Categoria findById(Long categoryId) {
		
		log.info("method=listAllCategorias");

		return categoriaRepository.findById(categoryId)
				.orElseThrow(() -> Message.NOT_FOUND_CATEGORY.asBusinessException());
	}
	
	
	public void deleteCategoria(Long categoryId) {

		Categoria categoria =  this.categoriaRepository.findById(categoryId).orElseThrow(() -> Message.NOT_FOUND_CATEGORY.asBusinessException());
		
		log.info("method=deleteCategoria categoryId={}", categoryId);
		
		this.categoriaRepository.delete(categoria);
	}
	
	
	@Transactional
	public CategoriaResponse updateCategoria(Long categoriaId, @Valid CategoriaRequest categoriaRequest) {
		
		Categoria categoria = this.categoriaRepository.findById(categoriaId).orElseThrow(() -> Message.NOT_FOUND_CATEGORY.asBusinessException());
		
		categoria.update(categoriaRequest);
		
		log.info("method=updateCategoria categoria={} nome={} tipo={}", categoria.getCategoriaId(), categoria.getNome(), categoria.getTipo());
		
		return categoria.toResponse();
	}
	

}
