package com.mobius.gametracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobius.gametracking.entities.Plataform;
import com.mobius.gametracking.repositories.PlataformRepository;

@Service
public class PlataformService {
	
	@Autowired
	private PlataformRepository repository;
	
	public List<Plataform> findAll() {
		return repository.findAll();
	}
	
	public Plataform findById(Integer id) {
		Optional<Plataform> obj = repository.findById(id);
		return obj.get();
	}
	
	public Plataform insert(Plataform obj) {
		return repository.save(obj);
	}
	
	public void updateEntity(Plataform entity, Plataform obj) {
		entity.setName(obj.getName());
	}
	
	public Plataform update(Integer id, Plataform obj) {
		Plataform plataform = repository.getOne(id);
		updateEntity(plataform, obj);
		return repository.save(plataform);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
