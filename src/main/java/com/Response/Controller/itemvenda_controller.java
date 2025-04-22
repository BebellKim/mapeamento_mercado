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

import com.Response.Entity.itemvenda;
import com.Response.Service.itemvenda_service;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/itemvenda")
public class itemvenda_controller {
		
		private final itemvenda_service itemvenda_service;
		
		@Autowired
		public itemvenda_controller(itemvenda_service itemvenda_service) {
			this.itemvenda_service = itemvenda_service;
		}
		
		@GetMapping
		public ResponseEntity<itemvenda> getProductById(@PathVariable Long id){
			itemvenda itemvenda = itemvenda_service.getitemvendaById(id);
			if(itemvenda != null) {
				return ResponseEntity.ok(itemvenda);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@GetMapping("/")
		public ResponseEntity<List<itemvenda>> getAllItemVendas(){
			List<itemvenda> itemVendas = itemvenda_service.getAllitemvenda();
			return ResponseEntity.ok(itemVendas);
		}
		
		@PostMapping("/")
		public ResponseEntity<itemvenda> criarItemVenda(@RequestBody @Valid itemvenda itemvenda){
			itemvenda criaritemvenda = itemvenda_service.salvaritemvenda(itemvenda);
			return ResponseEntity.status(HttpStatus.CREATED).body(criaritemvenda);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<itemvenda> updateitemvenda(@PathVariable Long id, @RequestBody @Valid itemvenda itemvenda){
			itemvenda updateditemvenda = itemvenda_service.updateitemvenda(id, itemvenda);
			if(updateditemvenda != null) {
				return ResponseEntity.ok(updateditemvenda);
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<itemvenda> deleteitemvenda(@PathVariable Long id){
			boolean deleted = itemvenda_service.deleteitemvenda(id);
			if(deleted) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
				return ResponseEntity.notFound().build();
				
			}
		}
}


