package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.treeptik.entity.Agenda;

@Repository
public interface AgendaDao extends JpaRepository<Agenda, Integer> {

	
}
