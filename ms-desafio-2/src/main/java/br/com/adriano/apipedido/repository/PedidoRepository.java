package br.com.adriano.apipedido.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.adriano.apipedido.domain.Pedido;
import br.com.adriano.apipedido.domain.dto.response.PedidoResponse;
import br.com.adriano.apipedido.domain.enums.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	
	Optional<Pedido> findByStatus(StatusPedido status);
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.PedidoResponse("
			+ " p.pedidoId,"
			+ " p.email,"
			+ " p.status,"
			+ " p.amount,"
			+ " p.itensId,"
			+ " p.clientId) "
			+ "From Pedido p where p.email =:email")
	Optional<PedidoResponse> findByEmail(@Param("email") String email);
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.PedidoResponse("
			+ " p.pedidoId,"
			+ " p.email,"
			+ " p.status,"
			+ " p.amount,"
			+ " p.itensId,"
			+ " p.clientId) "
			+ "From Pedido p where p.itensId =:itensId")
	Optional<PedidoResponse> findByItensId(@Param("itensId") Long itensId);
	
	@Query("delete From Pedido p where p.itensId =:itensId")
	void deleteByItensId(@Param("itensId") Long itensId);



	@Query("select new br.com.adriano.apipedido.domain.dto.response.PedidoResponse("
			+ " p.pedidoId,"
			+ " p.email,"
			+ " p.status,"
			+ " p.amount,"
			+ " p.itensId,"
			+ " p.clientId) "
			+ " From Pedido p")
	List<PedidoResponse> listAllPedidos();


}
