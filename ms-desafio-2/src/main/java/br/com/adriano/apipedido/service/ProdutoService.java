package br.com.adriano.apipedido.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.adriano.apipedido.domain.Categoria;
import br.com.adriano.apipedido.domain.Produto;
import br.com.adriano.apipedido.domain.dto.request.ProdutoRequest;
import br.com.adriano.apipedido.domain.dto.response.ProdutoResponse;
import br.com.adriano.apipedido.repository.ProdutoRepository;
import br.com.adriano.apipedido.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	private CategoriaService categoriaService;

	public ProdutoResponse create(ProdutoRequest produtoRequest) {

		Categoria categoria = this.categoriaService.findById(produtoRequest.getCategoryId());

		this.produtoRepository.findByNome(produtoRequest.getName()).ifPresent(n -> {
			throw Message.NOME_EXISTS.asBusinessException();
		});

		Produto produto = Produto.of(produtoRequest);

		produto.addCategoria(categoria);

		produtoRepository.save(produto);

		log.info("method=create productId={} name={} description={} price={} dataCadastro={} categoryId={}", produto.toString());
		return produto.toResponse();

	}

	@Transactional
	public ProdutoResponse updateProductAndNameAndDescription(Long productId, ProdutoRequest produtoRequest) {
		Produto produto = this.produtoRepository.findById(productId)
				.orElseThrow(() -> Message.NOT_FOUND_PRODUCT_ID.asBusinessException());

		log.info("method=updateProductAndNameAndDescription productId={}", productId);

		produto.updateProduto(produtoRequest);

		return produto.toResponse();
	}

	@Transactional
	public ProdutoResponse updateProductPrice(Long productId, ProdutoRequest produtoRequest) {
		Produto produto = this.produtoRepository.findById(productId)
				.orElseThrow(() -> Message.NOT_FOUND_PRODUCT_ID.asBusinessException());

		log.info("method=updateProductPrice productId={}", productId);

		produto.updatePrice(produtoRequest);

		return produto.toResponse();
	}
	
	public void DeleteProduct(Long productId) {
		Produto produto =  this.produtoRepository.findById(productId).orElseThrow(() -> Message.NOT_FOUND_PRODUCT_ID.asBusinessException());
		
		log.info("method=DeleteProduct productId={}");
		
		this.produtoRepository.delete(produto);
	}
	

	public List<ProdutoResponse> listAllProdutos() {
		log.info("method=listAllProdutos");
		return this.produtoRepository.listAllProdutos();
	}

	public Produto findById(Long productId) {
		log.info("method=findById productId={}");
		return produtoRepository.findById(productId)
				.orElseThrow(() -> Message.NOT_FOUND_PRODUCT_ID.asBusinessException());

	}

}
