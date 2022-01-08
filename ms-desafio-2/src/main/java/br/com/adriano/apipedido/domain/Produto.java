package br.com.adriano.apipedido.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.com.adriano.apipedido.domain.dto.request.ProdutoRequest;
import br.com.adriano.apipedido.domain.dto.response.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@ToString
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = -6641157988060508385L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id", nullable = false)
	private Long productId;

	@Column(name = "nome", nullable = false)
	private String name;

	@Column(name = "descricao", nullable = false)
	private String description;

	@Column(name = "preco", nullable = false)
	private BigDecimal price;

	@Column(name = "data_Cadastro", nullable = false)
	private LocalDate dataCadastro;

	@Column(name = "categoria_id", nullable = true, insertable = false, updatable = false)
	private Long categoryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
	private Categoria category;

	@PrePersist
	public void prePersist() {
		this.dataCadastro = LocalDate.now();
	}

	public static Produto of(ProdutoRequest produtoRequest) {
		return Produto.builder().name(produtoRequest.getName()).description(produtoRequest.getDescription())
				.price(produtoRequest.getPrice()).build();

	}

	public ProdutoResponse toResponse() {
		return ProdutoResponse.builder().productId(this.productId).name(this.name).description(this.description)
				.price(this.price).categoryId(this.category.getCategoriaId()).build();
	}
	
	public void addCategoria(Categoria categoria) {
		this.category = categoria;
		this.categoryId = categoria.getCategoriaId();
	}

	public void updateProduto(ProdutoRequest produtoRequest) {
		this.name = produtoRequest.getName();
		this.description = produtoRequest.getDescription();
			
	}
	
	public void updatePrice(ProdutoRequest produtoRequest) {
		this.price = produtoRequest.getPrice();
	}
}
