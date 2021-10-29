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

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = -6641157988060508385L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id", nullable = false)
	private Long produtoId;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "preco", nullable = false)
	private BigDecimal preco;

	@Column(name = "data_Cadastro", nullable = false)
	private LocalDate dataCadastro;

	@Column(name = "categoria_id", nullable = true, insertable = false, updatable = false)
	private Long categoriaId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
	private Categoria categoria;

	@PrePersist
	public void prePersist() {
		this.dataCadastro = LocalDate.now();
	}

	public static Produto of(ProdutoRequest produtoRequest) {
		return Produto.builder().nome(produtoRequest.getNome()).descricao(produtoRequest.getDescricao())
				.preco(produtoRequest.getPreco()).build();

	}

	public ProdutoResponse toResponse() {
		return ProdutoResponse.builder().produtoId(this.produtoId).nome(this.nome).descricao(this.descricao)
				.preco(this.preco).categoriaId(this.categoria.getCategoriaId()).build();
	}
	
	public void addCategoria(Categoria categoria) {
		this.categoria = categoria;
		this.categoriaId = categoria.getCategoriaId();
	}
}
