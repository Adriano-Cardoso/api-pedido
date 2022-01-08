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
			+ " p.productId,"
			+ " p.name,"
			+ " p.description,"
			+ " p.price,"
			+ " p.categoryId)"
			+ "From Produto p where p.name =:name")
	Optional<ProdutoResponse> findByNome(String name);
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.ProdutoResponse("
			+ " p.productId,"
			+ " p.name,"
			+ " p.description,"
			+ " p.price,"
			+ " p.categoryId)"
			+ "From Produto p")
	List<ProdutoResponse> listAllProdutos();

}
