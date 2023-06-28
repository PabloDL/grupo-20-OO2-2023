package com.UNLa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UNLa.entity.ParkingSensor;
import com.UNLa.entity.Spot;
import com.UNLa.service.IParkingSensorService;
import com.UNLa.service.ISpotService;

@Controller
public class HomeController {
	@Autowired
	private IParkingSensorService parkingSensorService;
	@Autowired
	private ISpotService parkingSpotService;

	@GetMapping("/")
	public String home(Model model) {
		
		return "index";
	}

	@GetMapping("/mapa")
	public String home() {
		return "map";
	}
	
	@GetMapping("/monitoreo")
	public String monitorDevices() {
		return "monitoring";
	}
	
	@PostMapping("/monitoreo")
	public String handleRequestMonitorDevices() {
		return "monitoring";
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
	
//	@PostMapping("/simulateParking")
//	public ResponseEntity<String>  simulateParking(@RequestBody Spot parkingSpot) {
//		ParkingSensor changes = parkingSpot.getParkingSensor();
//		Spot storedParkingSpot = parkingSpotService.getParkingSpot((long) parkingSpot.getId());
//		ParkingSensor storedParkingSensor = storedParkingSpot.getParkingSensor().updateFields(changes);
//		//parkingSensorService.(parkingSensor);
//
//		return ResponseEntity.ok("" + storedParkingSensor.isAvailable());
//	}
	
	@PostMapping("/simulateParking")
	public ResponseEntity<String>  simulateParking(@RequestBody ParkingSensor sensorChanges) {
		ParkingSensor storedParkingSensor = parkingSensorService.simulateParking(sensorChanges);

		return ResponseEntity.ok("" + storedParkingSensor.isAvailable());
	}
}
