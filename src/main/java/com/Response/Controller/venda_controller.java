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

import com.Response.Entity.venda;
import com.Response.Service.venda_service;

@RestController
@RequestMapping ("/Venda")

public class venda_controller {

	 private final venda_service venda_service;

	    @Autowired
	    public venda_controller(venda_service venda_service) {
	        this.venda_service = venda_service;
	    }

	    @PostMapping("/")
	    public ResponseEntity<venda> criarVenda(@RequestBody venda venda) {
	        venda novaVenda = venda_service.salvarvenda(venda);
	        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
	    }

	    @GetMapping("/")
	    public ResponseEntity<List<venda>> getAllVendas() {
	        List<venda> vendas = venda_service.getAllvenda();
	        return ResponseEntity.ok(vendas);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<venda> getVendasById(@PathVariable Long id) {
	        venda venda = venda_service.getAllVendasById(id);
	        if (venda != null) {
	            return ResponseEntity.ok(venda);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<venda> atualizarVenda(@PathVariable Long id, @RequestBody venda venda) {
	        venda atualizada = venda_service.updatevenda(id, venda);
	        if (atualizada != null) {
	            return ResponseEntity.ok(atualizada);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVenda(@PathVariable Long id) {
	        boolean deletada = venda_service.deletevenda(id);
	        if (deletada) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}