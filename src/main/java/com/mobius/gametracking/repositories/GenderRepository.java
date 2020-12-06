package com.mobius.gametracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobius.gametracking.entities.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
