package fr.treeptik.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PetitDejDao;
import fr.treeptik.entity.PetitDej;

@Service
@Scope(value = "singleton")
public class PetitDejService {
	
	private Logger logger = Logger.getLogger(PetitDejService.class);

	@Autowired
	private PetitDejDao petitDejDao;

	@Transactional()
	public PetitDej save(PetitDej petitDej) throws ServiceException {
		logger.debug("appel de la methode save petit dej " + petitDej.getNom());

		try {
			return petitDejDao.save(petitDej);
		} catch (PersistenceException e) {
			logger.error("erreur save personne " + e.getMessage());
			throw new ServiceException("erreur save petit dej", e);
		}
	}

	@Transactional
	public PetitDej update(PetitDej petitDej) throws ServiceException {
		logger.debug("appel de la methode update petit dej " + petitDej.getNom());
		try {
			return petitDejDao.save(petitDej);
		} catch (PersistenceException e) {
			logger.error("erreur update petit deg " + e.getMessage());
			throw new ServiceException("erreur update petit dej", e);
		}
	}

	public List<PetitDej> findAll() throws ServiceException {
		try {
			return petitDejDao.findAll();
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findAll petit dej", e);
		}
	}

	public PetitDej findById(Integer id) throws ServiceException {
		try {
			return petitDejDao.findOne(id);
		} catch (PersistenceException e) {
			throw new ServiceException("erreur findById petit dej", e);
		}
	}

	@Transactional
	public void deletePetitDej(PetitDej petitDej) throws ServiceException {
		try {
			petitDejDao.delete(petitDej.getId());
		} catch (PersistenceException e) {
			throw new ServiceException("erreur save petit dej", e);
		}
	}

	
	 
	public PetitDejDao getPetitDejDao() {
		return petitDejDao;
	}

	public void setPetitDejDao(PetitDejDao petitDejDao) {
		this.petitDejDao = petitDejDao;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}


}
