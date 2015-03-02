package com.partinex.crm;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.partinex.crm.dao.ClientDAO;
import com.partinex.crm.model.Client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ClientDAO clientDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/")
    public ModelAndView home() {
		
		logger.info("Welcome home!");
		
        List<Client> listClients = clientDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("clientList", listClients);
        return model;
    }
	
	@RequestMapping(value="/new")
	public ModelAndView newClient(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("form");
		model.addObject("client", new Client());
		String referer = request.getHeader("Referer");
		if(referer != null){
			model.addObject("priorUrl", referer);
		}
		return model;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int clientId = Integer.parseInt(request.getParameter("id"));
		Client client = clientDao.get(clientId);
		ModelAndView model = new ModelAndView("form");
		model.addObject("client", client);
		String referer = request.getHeader("Referer");
		if(referer != null){
			model.addObject("priorUrl", referer);
		}
		return model;		
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView clientDetails(HttpServletRequest request) {
		int clientId = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("clientDetails");
		Client client = clientDao.get(clientId);
		model.addObject("client", client);
		return model;
	}
	
	@RequestMapping(value = "/getClientByNIF", method = RequestMethod.GET)
	public ModelAndView getClientByNIF(HttpServletRequest request) {
		int clientNIF = 0;
		try {
			clientNIF = Integer.parseInt(request.getParameter("nif"));
		} catch (Exception e) {
			return clientNotFound();
		}
		ModelAndView model = new ModelAndView("clientDetails");
		Client client = clientDao.getByNIF(clientNIF);
		if(client == null) return clientNotFound();
		model.addObject("client", client);
		return model;
	}
	
	@RequestMapping(value = "/getClientByName", method = RequestMethod.GET)
	public ModelAndView getClientByName(HttpServletRequest request) {
		String clientName = request.getParameter("name");
		ModelAndView model = new ModelAndView("searchList");
		List<Client> listClients = clientDao.getByName(clientName);
		if(listClients == null) return clientNotFound();
        model.addObject("clientList", listClients);
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Client client) {
		clientDao.saveOrUpdate(client);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/cancelAdd", method = RequestMethod.GET)
	public ModelAndView cancelUser(HttpServletRequest request) {
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int clientId = Integer.parseInt(request.getParameter("id"));
		clientDao.delete(clientId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/clientNotFound", method = RequestMethod.POST)
	public ModelAndView clientNotFound() {
		return new ModelAndView("clientNotFound");
	}
	
}
