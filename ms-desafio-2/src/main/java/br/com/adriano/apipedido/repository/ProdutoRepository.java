package br.com.adriano.apipedido.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adriano.apipedido.domain.Produto;
import br.com.adriano.apipedido.domain.dto.response.ProdutoResponse;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.ProdutoResponse("
			+ " p.produtoId,"
			+ " p.nome,"
			+ " p.descricao,"
			+ " p.preco,"
			+ " p.categoriaId)"
			+ "From Produto p where p.nome =:nome")
	Optional<ProdutoResponse> findByNome(String nome);
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.ProdutoResponse("
			+ " p.produtoId,"
			+ " p.nome,"
			+ " p.descricao,"
			+ " p.preco,"
			+ " p.categoriaId)"
			+ "From Produto p")
	List<ProdutoResponse> listAllProdutos();

}
