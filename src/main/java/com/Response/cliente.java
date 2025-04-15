package com.Response;

import com.Response.Entity.venda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class cliente {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private long id;
	private String email;
	private String nome;
	private String telefone;
	
	
}
