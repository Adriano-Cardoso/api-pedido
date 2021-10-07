package br.com.adriano.apipedido.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.adriano.apipedido.domain.dto.request.PedidoRequest;
import br.com.adriano.apipedido.domain.dto.response.ItemResponse;
import br.com.adriano.apipedido.domain.dto.response.PedidoResponse;
import br.com.adriano.apipedido.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pedidoId;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "DATA_DE_CRIACAO", nullable = false)
	private LocalDateTime creationDate;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@Column(name = "VALOR_TOTAL")
	private BigDecimal amount;

	@Column(name = "itens_id", nullable = true, insertable = false, updatable = false)
	private Long itensId;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "itens_id", referencedColumnName = "itens_id")
	private List<Item> itens;

	public static Pedido of(PedidoRequest pedidoRequest) {
		Pedido pedido = Pedido.builder()
				.email(pedidoRequest.getEmail())
				.creationDate(pedidoRequest.getCreationDate())
				.status(pedidoRequest.getStatus())
				.amount(pedidoRequest.getAmount()).itensId(pedidoRequest.getItens())
				.build();


		return pedido;
	}

	// private void registerItem(Item item) {
	// 	if (this.itens == null) {
	// 		this.itens = new ArrayList<>();
	// 	}
	// 	this.itens.add(item);

	// }

	public PedidoResponse toResponse() {
		return PedidoResponse.builder().pedidoId(this.pedidoId).email(this.email).creationDate(this.creationDate)
				.status(this.status).amount(this.amount).itensId(ItemResponse.builder().name(this.)).build();

	}

    public void addItem(Item item) {
		this.itens = new ArrayList<Item>();
		this.itensId = this.getItensId();
    }


}
