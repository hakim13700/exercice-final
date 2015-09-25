package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.entity.Responsable;

@Repository
public interface ResponsableDao extends JpaRepository<Responsable, Integer> {

	
}
