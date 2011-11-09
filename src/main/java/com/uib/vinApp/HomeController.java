package com.uib.vinApp;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import com.uib.vinApp.Interface.IDBpedia;
import com.uib.vinApp.Interface.IVare;
import com.uib.vinApp.model.IQuery;

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
	
	
	
}
