package com.uib.vinApp;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import com.uib.vinApp.Interface.IQuery;
import com.uib.vinApp.model.IDBpedia;
import com.uib.vinApp.model.IVare;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IVare vare;
	
	@Autowired
	private IQuery query;
	
	@Autowired
	private IDBpedia dbPedia;
	
    
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		
		logger.info("Printing homepage");
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("vare", query.finnInfoOmVare(""));
		mav.addObject("divVarer", query.finnVarer(""));
		mav.addObject("artikkel", dbPedia);
		return mav;
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public ModelAndView search(@RequestParam String textfield) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("vare", query.finnInfoOmVare(textfield));
		mav.addObject("divVarer", query.finnVarer(textfield));
		mav.addObject("artikkel", query.finnDBPediaArtikkel(textfield));
		
		return mav;
	}
	
	@RequestMapping(value="mapping/parameter", method=RequestMethod.GET, params="foo")
	public @ResponseBody String bybyParameter() {
		return "Mapped by path + method + prams";
	}
		
	
}
