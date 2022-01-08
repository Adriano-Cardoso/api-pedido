package br.com.adriano.apipedido.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.adriano.apipedido.domain.Item;
import br.com.adriano.apipedido.domain.dto.response.ItemResponse;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    @Query("select new br.com.adriano.apipedido.domain.dto.response.ItemResponse(i.itemId,i.name,i.unitaryValue, i.productId) From Item i")
    List<ItemResponse> listAllItem();

	@Query("select new br.com.adriano.apipedido.domain.dto.response.ItemResponse(i.itemId,i.name,i.unitaryValue, i.productId) From Item i where i.name =:name")
	Optional<ItemResponse> findByName(@Param("name") String name);
	

}
