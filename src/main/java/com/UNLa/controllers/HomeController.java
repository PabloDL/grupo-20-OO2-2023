package com.UNLa.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.UNLa.helpers.ViewRouteHelper;

//import services.IPersonService;

@Controller
@RequestMapping("/")
public class HomeController {

//	@Autowired
//	@Qualifier("personService")
//	private IPersonService personService;

	@PreAuthorize("hasRole('user')")
	//GET Example: SERVER/index
	@GetMapping("/unla")
	public String index() {
//		ModelAndView modelAndView = new ModelAndView("/unla"); //ViewRouteHelper.INDEX);
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		modelAndView.addObject("username", user.getUsername());
////		modelAndView.addObject("persons", personService.getAll());
//		return modelAndView;
		return "";
	}

	//GET Example: SERVER/hello?name=someName
	@GetMapping("/hello")
	public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}

	//GET Example: SERVER/hello/someName
	@GetMapping("/hello/{name}")
	public ModelAndView helloParams2(@PathVariable("name") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE);
	}
	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(@ModelAttribute("user")com.UNLa.models.User user) {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		
		
		return modelAndView;
	}
	
}
