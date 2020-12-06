package com.mobius.gametracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobius.gametracking.entities.Gender;
import com.mobius.gametracking.repositories.GenderRepository;

@Service
public class GenderService {
	
	@Autowired
	private GenderRepository repository;
	
	public List<Gender> findAll() {
		return repository.findAll();
	}
	
	public Gender findById(Integer id) {
		Optional<Gender> obj = repository.findById(id);
		return obj.get();
	}
	
	public Gender insert(Gender obj) {
		return repository.save(obj);
	}
	
	public void updateEntity(Gender entity, Gender obj) {
		entity.setName(obj.getName());
	}
	
	public Gender update(Integer id, Gender obj) {
		Gender gender = repository.getOne(id);
		updateEntity(gender, obj);
		return repository.save(gender);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
