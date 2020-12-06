package com.mobius.gametracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobius.gametracking.entities.Plataform;

@Repository
public interface PlataformRepository extends JpaRepository<Plataform, Integer> {

}
