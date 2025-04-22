package com.Response.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Response.Entity.produto;
import com.Response.Service.produto_service;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/produto")
public class produto_controller {
	
		private final produto_service produto_service;
		
		@Autowired
		public produto_controller(produto_service produto_service) {
			this.produto_service = produto_service;
		}
		
		@GetMapping
		public ResponseEntity<produto> getProductById(@PathVariable Long id){
			produto produto = produto_service.getProdutoById(id);
			if(produto != null) {
				return ResponseEntity.ok(produto);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@GetMapping("/")
		public ResponseEntity<List<produto>> getAllproduto(){
			List<produto> produto = produto_service.getAllProdutos();
			return ResponseEntity.ok(produto);
		}
		
		@PostMapping("/")
		public ResponseEntity<produto> criarproduto(@RequestBody @Valid produto produto){
			produto criarproduto = produto_service.salvarProduto(produto);
			return ResponseEntity.status(HttpStatus.CREATED).body(criarproduto);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity <produto> updateproduto(@PathVariable Long id, @RequestBody @Valid produto produto){
			produto updatedproduto = produto_service.updateProduto(id, produto);
			if(updatedproduto != null) {
				return ResponseEntity.ok(updatedproduto);
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<produto> deleteproduto(@PathVariable Long id){
			boolean deleted = produto_service.deleteProduto(id);
			if(deleted) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
				return ResponseEntity.notFound().build();
				
			}
		}

}