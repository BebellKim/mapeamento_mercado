package com.Response.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Response.Entity.cliente;
import com.Response.Service.cliente_service;

@RestController
@RequestMapping ("/Cliente")

	public class cliente_controller {
		private final cliente_service cliente_service;
		@Autowired
		public cliente_controller(cliente_service cliente_service ) {
		this.cliente_service = cliente_service;
		}
		@PostMapping
		public cliente createcliente(@RequestBody cliente cliente) {
		return cliente_service.savecliente(cliente);
		}
		@GetMapping("/{id}")
		public cliente getcliente(@PathVariable Long id) {
		return cliente_service.getclienteById(id);
		}
		@GetMapping
		public List<cliente> getAllcliente(){
		return cliente_service.getAllcliente();
		}
		@DeleteMapping("/{id}")
		public void deletecliente(@PathVariable Long id) {
			cliente_service.deletecliente(id);
		}

}
