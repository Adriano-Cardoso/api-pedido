package br.com.adriano.apipedido.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.adriano.apipedido.domain.Cliente;
import br.com.adriano.apipedido.domain.dto.response.ClienteResponse;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.ClienteResponse("
			+ " c.clientId,"
			+ " c.name,"
			+ " c.cpf)"
			+ "From Cliente c where c.cpf =:cpf")
	Optional<ClienteResponse> findByCpf(String cpf);
	
	@Query("select new br.com.adriano.apipedido.domain.dto.response.ClienteResponse("
			+ " c.clientId,"
			+ " c.name,"
			+ " c.cpf)"
			+ "From Cliente c")
	List<ClienteResponse> listAllClientes();

}
