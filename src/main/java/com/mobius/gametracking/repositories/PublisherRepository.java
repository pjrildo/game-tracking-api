package com.mobius.gametracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobius.gametracking.entities.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
