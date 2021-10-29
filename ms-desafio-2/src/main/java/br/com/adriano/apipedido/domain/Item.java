package br.com.adriano.apipedido.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.adriano.apipedido.domain.dto.request.ItemRequest;
import br.com.adriano.apipedido.domain.dto.response.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 592140737629584527L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itens_id", nullable = false)
	private Long itemId;

	@Column(name = "NOME", nullable = false)
	private String name;

	@Column(name = "VALOR_UNITARIO", nullable = false)
	private BigDecimal unitaryValue;

	@Column(name = "pedido_id", nullable = true, insertable = false, updatable = false)
	private Long pedidoId;

	@Column(name = "produto_id", nullable = true, insertable = false, updatable = false)
	private Long produtoId;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "pedido_id", referencedColumnName = "pedido_id")
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
	private Produto produto;

	public ItemResponse toResponse() {
		return ItemResponse.builder().itensId(this.itemId).name(this.name).unitaryValue(this.unitaryValue)
				.produtoId(this.produtoId).build();
	}

	public static Item of(ItemRequest itemRequest) {
		return Item.builder().name(itemRequest.getName()).unitaryValue(itemRequest.getUnitaryValue())
				.produtoId(itemRequest.getProdutoId()).build();

	}

}
