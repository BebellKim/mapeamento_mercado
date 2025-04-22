package com.Response.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Response.Entity.venda;
import com.Response.Repository.venda_repository;

@Service
public class venda_service {
	private final venda_repository venda_repository;

	@Autowired
	public venda_service(venda_repository venda_repository ) {
		this.venda_repository = venda_repository;
	}

	public List<venda> getAlvenda(){
		return venda_repository.findAll();
	}

	public venda getAllVendasById(Long id) {
		Optional<venda> venda = venda_repository.findById(id);
		return venda.orElse(null);
	}

	public venda 
	salvarvenda(venda venda) {
		return venda_repository.save(venda);
	}

	public venda updatevenda(Long id, venda updatedvenda) {
		Optional<venda> existingvenda = venda_repository.findById(id);
		if(existingvenda.isPresent()) {
			updatedvenda.setId(id);
			return venda_repository.save(updatedvenda);
		}
		return null;
	}

	public boolean deletevenda(Long id) {
		Optional<venda> existingvenda = venda_repository.findById(id);
		if(existingvenda.isPresent()) {
			venda_repository.deleteById(id);
			return true;
		}
		return false;
	
	}
	}