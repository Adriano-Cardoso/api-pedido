package br.com.adriano.apipedido.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.adriano.apipedido.domain.dto.request.PedidoRequest;
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
@Table(name = "TB_PEDIDO")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -8647912595506212502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id", nullable = false)
	private Long pedidoId;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "DATA_DE_CRIACAO", nullable = false)
	@JsonFormat(pattern = "dd/mm/yyyy")
	private LocalDate creationDate;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@Column(name = "VALOR_TOTAL")
	private BigDecimal amount;

	@Column(name = "itens_id", nullable = true, insertable = false, updatable = false)
	private Long itensId;

	@Column(name = "cliente_id", nullable = true, insertable = false, updatable = false)
	private Long clienteId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
	private Cliente cliente;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "itens_id", referencedColumnName = "itens_id")
	private List<Item> itens;

	@PrePersist
	public void prePersist() {
		this.creationDate = LocalDate.now();
	}

	public static Pedido of(PedidoRequest pedidoRequest) {
		Pedido pedido = Pedido.builder().email(pedidoRequest.getEmail()).status(pedidoRequest.getStatus())
				.amount(pedidoRequest.getAmount()).clienteId(pedidoRequest.getClienteId()).itens(new ArrayList<Item>()).build();

		return pedido;
	}

	public PedidoResponse toResponse() {
		return PedidoResponse.builder().pedidoId(this.pedidoId).email(this.email).status(this.status)
				.amount(this.amount).clienteId(this.cliente.getClienteId()).build();

	}
	
	public void addCliente(Cliente cliente) {
		this.cliente = cliente;
		this.clienteId = cliente.getClienteId();
	}

	public void registerItem(List<Long> item) {
		this.itens = new ArrayList<>();
		this.itensId = this.getItensId();
	}

	public void addItem(Item item) {
		this.itens = new ArrayList<Item>();
		this.itensId = this.getItensId();
	}

}
