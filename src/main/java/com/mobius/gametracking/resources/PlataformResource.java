package com.mobius.gametracking.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mobius.gametracking.entities.Plataform;
import com.mobius.gametracking.services.PlataformService;

@RestController
@RequestMapping(value = "/plataforms")
public class PlataformResource {
	
	@Autowired
	private PlataformService service;
	
	@GetMapping
	public ResponseEntity<List<Plataform>> findAll() {
		List<Plataform> plataforms = service.findAll();
		return ResponseEntity.ok().body(plataforms);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Plataform> findById(@PathVariable Integer id) {
		Plataform obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Plataform> insert(@RequestBody Plataform obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Plataform> update(@PathVariable Integer id, @RequestBody Plataform obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
