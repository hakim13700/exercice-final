package fr.treeptik.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.entity.PetitDej;
import fr.treeptik.service.MembreService;
import fr.treeptik.service.PetitDejService;

@Controller
public class AcceuilController {
	
	@Autowired
	private PetitDejService petitDejService;
	
	@Autowired
	private MembreService membreService;
	
	@RequestMapping(value = "/acceuil.html", method = RequestMethod.GET)
	public ModelAndView add() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("petitDej");
		modelAndView.addObject("petitdej", new PetitDej());
		modelAndView.addObject("membres", membreService.findAll());


		return modelAndView;
	}
	

	@RequestMapping(value = "/edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("id") Integer id) {
		try {
			ModelAndView modelAndView = new ModelAndView("petitDej-list");
			

			return modelAndView;
		} catch (Exception e) {
			return list();
		}
	}

	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("petitDej-list");
		try {
			modelAndView.addObject("petitdejs", petitDejService.findAll());
		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/save.html", method = RequestMethod.POST)
	public ModelAndView save(PetitDej petitDej) throws ServiceException {
		try {
			
			if (petitDej.getId() == null) {
				petitDejService.save(petitDej);
			} else {
				petitDejService.update(petitDej);
			}
			ModelAndView modelAndView = new ModelAndView("redirect:list.html");
			return modelAndView;
		} catch (Exception e) {
			ModelAndView modelAndView = edit(petitDej.getId());
			modelAndView.addObject("error", e.getMessage());
			return modelAndView;
		}

	}

	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public ModelAndView delete(PetitDej petitDej) throws ServiceException {

		petitDejService.deletePetitDej(petitDej);
		ModelAndView modelAndView = new ModelAndView("redirect:list.html");
		modelAndView.addObject("petitdej", new PetitDej());
		return modelAndView;
	}

}
