package com.Response.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itemvenda")
public class itemvenda {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private long id;
	private int quantidade;
	private double valor_unitario;
	
	@ManyToOne
	@JoinColumn( name = "id_venda", nullable = false)
	private venda venda;
	
	@ManyToOne
	@JoinColumn( name = "id_produto", nullable = false)
	private produto produto;
	
	

	
}
