package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.entity.PetitDej;

@Repository
public interface PetitDejDao extends JpaRepository<PetitDej, Integer> {

	
}
