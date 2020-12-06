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

import com.mobius.gametracking.entities.Gender;
import com.mobius.gametracking.services.GenderService;

@RestController
@RequestMapping(value = "/genders")
public class GenderResource {
	
	@Autowired
	private GenderService service;
	
	@GetMapping
	public ResponseEntity<List<Gender>> findAll() {
		List<Gender> gender = service.findAll();
		return ResponseEntity.ok().body(gender);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Gender> findById(@PathVariable Integer id) {
		Gender obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Gender> insert(@RequestBody Gender obj){
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
	public ResponseEntity<Gender> update(@PathVariable Integer id, @RequestBody Gender obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
