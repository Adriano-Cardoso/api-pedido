package com.br.aplicativo.msdesafio2.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.br.aplicativo.msdesafio2.entity.enuns.StatusPedido;

import lombok.Data;

@Data
@Table(name = "PEDIDO")
@Entity
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "DATA_DE_CRIACAO", nullable = false)
	private Date dataDeCriacao;

	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@Column(name = "VALOR_TOTAL")
	private BigDecimal valorTotal;
	
	@ManyToMany
	@JoinColumn(name = "itens_id")
	private List<ItemEntity> itens;


}
