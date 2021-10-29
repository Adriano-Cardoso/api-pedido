package br.com.adriano.apipedido.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.adriano.apipedido.domain.Categoria;
import br.com.adriano.apipedido.domain.dto.response.CategoriaResponse;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.CategoriaResponse("
			+ " c.categoriaId,"
			+ " c.nome,"
			+ " c.tipo)"
			+ " From Categoria c where c.nome =:nome")
	Optional<CategoriaResponse> findByNome(@Param("nome") String nome);
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.CategoriaResponse("
			+ " c.categoriaId,"
			+ " c.nome,"
			+ " c.tipo)"
			+ " From Categoria c")
	List<CategoriaResponse> listAllCategorias();

}
