package fr.treeptik.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.MembreDao;
import fr.treeptik.dao.PetitDejDao;
import fr.treeptik.entity.Membre;
import fr.treeptik.entity.PetitDej;

@Service
@Scope(value = "singleton")
public class MembreService {
	
	private Logger logger = Logger.getLogger(MembreService.class);

	@Autowired
	private MembreDao membreDao;

	@Transactional()
	public Membre save(Membre membre) throws ServiceException {
		logger.debug("appel de la methode save membre " + membre.getFirstName());

		try {
			return membreDao.save(membre);
		} catch (PersistenceException e) {
			logger.error("erreur save membre " + e.getMessage());
			throw new ServiceException("erreur save membre", e);
		}
	}

	@Transactional
	public Membre update(Membre membre) throws ServiceException {
		logger.debug("appel de la methode update membre " + membre.getFirstName());
		try {
			return membreDao.save(membre);
		} catch (PersistenceException e) {
			logger.error("erreur update petit deg " + e.getMessage());
			throw new ServiceException("erreur update membre", e);
		}
	}

	public List<Membre> findAll() throws ServiceException {
		try {
			return membreDao.findAll();
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAll membre", e);
		}
	}

	public Membre findById(Integer id) throws ServiceException {
		try {
			return membreDao.findOne(id);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findById membre", e);
		}
	}

	@Transactional
	public void deleteMembre(Membre petitDej) throws ServiceException {
		try {
			membreDao.delete(petitDej.getId());
		} catch (PersistenceException e) {
			throw new ServiceException("erreur save membre", e);
		}
	}


	public MembreDao getMembreDao() {
		return membreDao;
	}

	public void setMembreDao(MembreDao membreDao) {
		this.membreDao = membreDao;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}


}
