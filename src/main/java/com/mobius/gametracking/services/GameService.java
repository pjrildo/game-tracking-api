package com.mobius.gametracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobius.gametracking.entities.Game;
import com.mobius.gametracking.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public List<Game> findAll() {
		return repository.findAll();
	}
	
	public Game findById(Integer id) {
		Optional<Game> obj = repository.findById(id);
		return obj.get();
	}
	
	public Game insert(Game obj) {
		return repository.save(obj);
	}
	
	public void updateEntity(Game entity, Game obj) {
		entity.setDescription(obj.getDescription());
		entity.setPublisher(obj.getPublisher());
		entity.setRelease(obj.getRelease());
	}
	
	public Game update(Integer id, Game obj) {
		Game game = repository.getOne(id);
		updateEntity(game, obj);
		return repository.save(game);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
