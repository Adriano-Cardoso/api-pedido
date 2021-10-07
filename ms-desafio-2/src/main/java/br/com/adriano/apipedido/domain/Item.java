package br.com.adriano.apipedido.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	@Column(name = "NOME", nullable = false)
	private String name;

	@Column(name = "VALOR_UNITARIO", nullable = false)
	private BigDecimal unitaryValue;
	
	public ItemResponse toResponse() {
		return ItemResponse.builder().itemId(this.itemId).name(this.name).unitaryValue(this.unitaryValue).build();
	}

    public static Item of(ItemRequest itemRequest) {
		return Item.builder().itemId(itemRequest.getItemId()).name(itemRequest.getName()).unitaryValue(itemRequest.getUnitaryValue()).build();
        
    }
	

	
}
