package br.com.adriano.apipedido.service;

import java.util.List;

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

@Service("CategoriaService")
@Validated
@AllArgsConstructor
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	@Validated(OnCreate.class)
	public CategoriaResponse create(@Valid CategoriaRequest categoriaRequest) {

		this.categoriaRepository.findByNome(categoriaRequest.getNome()).ifPresent(c -> {
			throw Message.CATEGORY_EXIST.asBusinessException();
		});

		Categoria categoria = Categoria.of(categoriaRequest);

		this.categoriaRepository.save(categoria);

		return categoria.toResponse();
	}

	public List<CategoriaResponse> listAllCategorias() {
		return this.categoriaRepository.listAllCategorias();
	}

	public Categoria findById(Long categoryId) {

		return categoriaRepository.findById(categoryId)
				.orElseThrow(() -> Message.NOT_FOUND_CATEGORY.asBusinessException());
	}

}
