package com.mobius.gametracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobius.gametracking.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
