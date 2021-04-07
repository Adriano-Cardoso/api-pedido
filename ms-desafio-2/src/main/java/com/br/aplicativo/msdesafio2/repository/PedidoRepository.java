package com.br.aplicativo.msdesafio2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.aplicativo.msdesafio2.entity.ItemEntity;
import com.br.aplicativo.msdesafio2.entity.PedidoEntity;
import com.br.aplicativo.msdesafio2.entity.enuns.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>{

	Optional<PedidoEntity> findByStatus(StatusPedido status);
	
	
	PedidoEntity findByEmail(String email);


	List<PedidoEntity> findByItens(ItemEntity item);






	
	

	
	
	
	

}
