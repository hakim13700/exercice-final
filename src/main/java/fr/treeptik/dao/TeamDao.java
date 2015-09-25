package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.entity.Team;

@Repository
public interface TeamDao extends JpaRepository<Team, Integer> {

	
}
