package com.Response.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Response.Entity.cliente;
import com.Response.Repository.cliente_repository;

@Service
public class cliente_service {
	private final cliente_repository cliente_repository;

	@Autowired
	public cliente_service(cliente_repository cliente_repository ) {
		this.cliente_repository = cliente_repository;
	}

	public List<cliente> getAlcliente(){
		return cliente_repository.findAll();
	}

	public cliente getclienteById(Long id) {
		Optional<cliente> cliente = cliente_repository.findById(id);
		return cliente.orElse(null);
	}

	public cliente 
	salvarvenda(cliente cliente) {
		return cliente_repository.save(cliente);
	}

	public cliente updatecliente(Long id, cliente updatedcliente) {
		Optional<cliente> existingcliente = cliente_repository.findById(id);
		if(existingcliente.isPresent()) {
			updatedcliente.setId(id);
			return cliente_repository.save(updatedcliente);
		}
		return null;
	}

	public boolean deletecliente(Long id) {
		Optional<cliente> existingcliente = cliente_repository.findById(id);
		if(existingcliente.isPresent()) {
			cliente_repository.deleteById(id);
			return true;
		}
		return false;
	}
	}