package com.mobius.gametracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobius.gametracking.entities.User;
import com.mobius.gametracking.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void updateEntity(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setNickname(obj.getNickname());
		entity.setPassword(obj.getPassword());
	}
	
	public User update(Integer id, User obj) {
		User user = repository.getOne(id);
		updateEntity(user, obj);
		return repository.save(user);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
