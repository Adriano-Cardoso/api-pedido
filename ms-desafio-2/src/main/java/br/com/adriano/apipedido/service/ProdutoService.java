package br.com.adriano.apipedido.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.adriano.apipedido.domain.Categoria;
import br.com.adriano.apipedido.domain.Produto;
import br.com.adriano.apipedido.domain.dto.request.ProdutoRequest;
import br.com.adriano.apipedido.domain.dto.response.ProdutoResponse;
import br.com.adriano.apipedido.repository.ProdutoRepository;
import br.com.adriano.apipedido.validations.Message;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	private CategoriaService categoriaService;

	public ProdutoResponse create(ProdutoRequest produtoRequest) {

		Categoria categoria = this.categoriaService.findById(produtoRequest.getCategoriaId());
		
		this.produtoRepository.findByNome(produtoRequest.getNome()).ifPresent(n -> {
			throw Message.NOME_EXISTS.asBusinessException();
		});

		Produto produto = Produto.of(produtoRequest);
		
		produto.addCategoria(categoria);
		
		produtoRepository.save(produto);

		return produto.toResponse();

	}
	
	public List<ProdutoResponse> listAllProdutos(){
		
		return this.produtoRepository.listAllProdutos();
	}

}
