package com.mobius.gametracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobius.gametracking.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
