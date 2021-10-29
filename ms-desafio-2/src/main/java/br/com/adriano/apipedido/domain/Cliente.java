package br.com.adriano.apipedido.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.adriano.apipedido.domain.dto.request.ClienteRequest;
import br.com.adriano.apipedido.domain.dto.response.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -481777458300032440L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id", nullable = false)
	private Long clienteId;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	public ClienteResponse toResponse() {
		return ClienteResponse.builder().clienteId(this.clienteId).nome(this.nome).cpf(this.cpf).build();
	}

	public static Cliente of(ClienteRequest clienteRequest) {
		return Cliente.builder().nome(clienteRequest.getNome())
				.cpf(clienteRequest.getCpf()).build();
	}

}
