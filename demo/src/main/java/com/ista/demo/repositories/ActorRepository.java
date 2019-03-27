package com.ista.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ista.demo.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
