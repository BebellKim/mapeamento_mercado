package com.Response.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Response.Entity.produto;
import com.Response.Repository.produto_repository;

@Service
public class produto_service {

private final produto_repository produto_repository;

@Autowired
public produto_service(produto_repository produto_repository ) {
	this.produto_repository = produto_repository;
}

public List<produto> getAllProdutos(){
	return produto_repository.findAll();
}

public produto getProdutoById(Long id) {
	Optional<produto> produto = produto_repository.findById(id);
	return produto.orElse(null);
}

public produto 
salvarProduto(produto produto) {
	return produto_repository.save(produto);
}

public produto updateProduto(Long id, produto updatedProduto) {
	Optional<produto> existingProduto = produto_repository.findById(id);
	if(existingProduto.isPresent()) {
		updatedProduto.setId(id);
		return produto_repository.save(updatedProduto);
	}
	return null;
}

public boolean deleteProduto(Long id) {
	Optional<produto> existingProduto = produto_repository.findById(id);
	if(existingProduto.isPresent()) {
		produto_repository.deleteById(id);
		return true;
	}
	return false;
}
}

