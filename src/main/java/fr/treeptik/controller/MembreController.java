package fr.treeptik.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.entity.Membre;
import fr.treeptik.service.MembreService;

@Controller
@RequestMapping(value = "/membre")
public class MembreController {
	
	
	@Autowired
	private MembreService membreService;
	
	@RequestMapping(value = "/new.html", method = RequestMethod.GET)
	public ModelAndView add() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("membre");
		modelAndView.addObject("membre", new Membre());
		
		return modelAndView;
	}
	

	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Integer id) {
		try {
			ModelAndView modelAndView = new ModelAndView("membre");
			Membre membre = membreService.findById(id);
			modelAndView.addObject("membre", membre);
			modelAndView.addObject("membres", membreService.findAll());

			return modelAndView;
		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("membre-list");
		try {
			modelAndView.addObject("membres", membreService.findAll());
			} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(Membre membre) throws ServiceException {
		try {
			
			if (membre.getId() == null) {
				membreService.save(membre);
			} else {
				membreService.update(membre);
			}
			ModelAndView modelAndView = new ModelAndView("redirect:list.html");
			return modelAndView;
		} catch (Exception e) {
			ModelAndView modelAndView = edit(membre.getId());
			modelAndView.addObject("error", e.getMessage());
			return modelAndView;
		}

	}

	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public ModelAndView delete(Membre membre) throws ServiceException {

		membreService.deleteMembre(membre);
		ModelAndView modelAndView = new ModelAndView("redirect:list.html");
		modelAndView.addObject("membre", new Membre());
		return modelAndView;
	}
	
}
