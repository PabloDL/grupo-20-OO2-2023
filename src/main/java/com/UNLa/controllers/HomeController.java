package com.UNLa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.UNLa.entities.ParkingSensor;
import com.UNLa.entities.Spot;
import com.UNLa.services.IParkingSensorService;
import com.UNLa.services.ISpotService;
import com.UNLa.helpers.ViewRouteHelper;

@Controller
public class HomeController {
	@Autowired
	private IParkingSensorService parkingSensorService;
	@Autowired
	private ISpotService parkingSpotService;


	//GET Example: SERVER/index
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		return modelAndView;
	}
	
	

	@GetMapping("/mapa")
	public String home() {
		return "map";
	}
		
	@GetMapping("/buscarEstacionamiento")
	public String findParkingSpots(Model model) {
		List<Spot> recommendedParkingSpotAndSensors = parkingSpotService.getRecommendedParkingSpots();
		List<Spot> availableParkingSpotAndSensors = parkingSpotService.getAvailableParkingSpots();
		List<Spot> allParkingSpotAndSensors = parkingSpotService.getAllSpotsWithParkingSensor();
		Spot reservedSpot = null;
		
		model.addAttribute("reserved", reservedSpot);
		model.addAttribute("allParkingSensorData", allParkingSpotAndSensors);
		model.addAttribute("availableParkingSensorData", availableParkingSpotAndSensors);
		model.addAttribute("recommendedParkingSensorData", recommendedParkingSpotAndSensors);
		return "findParking";
	}
	
	@PostMapping("/simulateParking")
	public ResponseEntity<String>  simulateParking(@RequestBody ParkingSensor sensorChanges) {
		ParkingSensor storedParkingSensor = parkingSensorService.simulateParking(sensorChanges);

		return ResponseEntity.ok("" + storedParkingSensor.isAvailable());
	}
}
