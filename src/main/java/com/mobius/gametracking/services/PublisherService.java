package com.mobius.gametracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobius.gametracking.entities.Publisher;
import com.mobius.gametracking.repositories.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository repository;
	
	public List<Publisher> findAll() {
		return repository.findAll();
	}
	
	public Publisher findById(Integer id) {
		Optional<Publisher> obj = repository.findById(id);
		return obj.get();
	}
	
	public Publisher insert(Publisher obj) {
		return repository.save(obj);
	}
	
	public void updateEntity(Publisher entity, Publisher obj) {
		entity.setName(obj.getName());
	}
	
	public Publisher update(Integer id, Publisher obj) {
		Publisher publisher = repository.getOne(id);
		updateEntity(publisher, obj);
		return repository.save(publisher);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
