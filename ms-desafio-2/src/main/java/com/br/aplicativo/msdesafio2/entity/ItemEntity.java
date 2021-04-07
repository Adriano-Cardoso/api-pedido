package com.br.aplicativo.msdesafio2.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "ITEM")
@Entity
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "VALOR_UNITARIO", nullable = false)
	private BigDecimal valorUnitario;
	

	
}
