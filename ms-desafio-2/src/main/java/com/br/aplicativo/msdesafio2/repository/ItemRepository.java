package com.br.aplicativo.msdesafio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.aplicativo.msdesafio2.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{

	ItemEntity findByNome(String nome);

	ItemEntity deleteById(ItemEntity item);
	

}
