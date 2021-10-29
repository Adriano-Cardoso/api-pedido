package br.com.adriano.apipedido.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.adriano.apipedido.domain.dto.request.CategoriaRequest;
import br.com.adriano.apipedido.domain.dto.response.CategoriaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = -8505541714618159915L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id", nullable = false)
	private Long categoriaId;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;

	
	public CategoriaResponse toResponse() {
		return CategoriaResponse.builder().categoriaId(this.categoriaId).nome(this.nome).tipo(this.tipo).build();
	}
	
	public static Categoria of(CategoriaRequest categoriaRequest) {
		return Categoria.builder().nome(categoriaRequest.getNome()).tipo(categoriaRequest.getTipo()).build();
	}
}
