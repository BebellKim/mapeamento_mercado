package com.Response.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Response.Entity.itemvenda;
import com.Response.Repository.itemvenda_repository;

@Service
public class itemvenda_service {
	
	private final itemvenda_repository itemvenda_repository;

	@Autowired
	public itemvenda_service(itemvenda_repository itemvenda_repository ) {
		this.itemvenda_repository = itemvenda_repository;
	}

	public List<itemvenda> getAllitemvenda(){
		return itemvenda_repository.findAll();
	}

	public itemvenda getitemvendaById(Long id) {
		Optional<itemvenda> itemvenda = itemvenda_repository.findById(id);
		return itemvenda.orElse(null);
	}

	public itemvenda salvaritemvenda(itemvenda itemvenda) {
		return itemvenda_repository.save(itemvenda);
	}

	public itemvenda updateitemvenda(Long id, itemvenda updateditemvenda) {
		Optional<itemvenda> existingitemvenda = itemvenda_repository.findById(id);
		if(existingitemvenda.isPresent()) {
			return itemvenda_repository.save(updateditemvenda);
		}
		return null;
	}

	public boolean deleteitemvenda(Long id) {
		Optional<itemvenda> existingitemvenda = itemvenda_repository.findById(id);
		if(existingitemvenda.isPresent()) {
			itemvenda_repository.deleteById(id);
			return true;
		}
		return false;
	}
	}

