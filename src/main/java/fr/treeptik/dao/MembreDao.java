package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.entity.Membre;

@Repository
public interface MembreDao extends JpaRepository<Membre, Integer> {

	
}
