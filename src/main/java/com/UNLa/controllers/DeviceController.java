package com.UNLa.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UNLa.entities.Device;
import com.UNLa.entities.ParkingSensor;
import com.UNLa.entities.Spot;
import com.UNLa.helpers.ViewRouteHelper;
import com.UNLa.services.IDeviceService;
import com.UNLa.services.IParkingSensorService;
import com.UNLa.services.ISpotService;

@Controller

public class DeviceController {
	@Autowired
	private IDeviceService deviceService;
	@Autowired
	private IParkingSensorService parkingSensorService;
	@Autowired
	private ISpotService parkingSpotService;
	
	@GetMapping("/dispositivos")
	public String listDevices(Model model) {
		model.addAttribute("devices", deviceService.getAllDevices());
		return "devices";
	}
	
	@PostMapping("/devices/crud")
	public ResponseEntity<String> handleCrudRequest(@RequestBody Device device) {
		System.out.println(device.toString());
		
		Device stored = deviceService.createUpdateDevice(device);
		return ResponseEntity.ok("" + stored.getId());
	}
	
	@GetMapping("/dispositivos/SensorEstacionamiento")
	public String listSensors(Model model) {
		List<Spot> dbParkingSpots = parkingSpotService.getAllSpots();
		List<Spot> dbParkingSpotsSensors = parkingSpotService.getAllSpotsWithParkingSensor();
		List<ParkingSensor> dbParkingSensors = parkingSensorService.getAllParkingSensors();
		Set<Integer> parkingNumbers = new HashSet<Integer>();
		Set<String> parkingSectors = new HashSet<String>();
		List<String> numberSectors = parkingSpotService.getNumberSector();
		for(Spot spot: dbParkingSpots) {
			
			parkingNumbers.add(spot.getNumber());
			parkingSectors.add(spot.getSector());
		}
		List<ParkingSensor> unassignedParkingSensors = parkingSensorService.getAllUnassignedParkingSensors();
		
		for(ParkingSensor sens: unassignedParkingSensors) {
			System.out.println(sens.toString());
		}
		
		//model.addAttribute("parkingSensors", parkingSensors);
		model.addAttribute("parkingSpots", dbParkingSpotsSensors);
		model.addAttribute("parkingNumbers", parkingNumbers);
		model.addAttribute("parkingSectors", parkingSectors);
		model.addAttribute("numberSectors", numberSectors);
		model.addAttribute("parkingSensors", dbParkingSensors);
		model.addAttribute("unassignedParkingSensors", unassignedParkingSensors);
		
		return "parkingSensors";
	}
	
	@PostMapping("/devices/parkingSensor/crud")
	public ResponseEntity<String> handleCrudRequest(@RequestBody Spot parkingSpot) {
		
		Device device = deviceService.getDevice((long) parkingSpot.getParkingSensor().getDevice().getId());
		parkingSpot.getParkingSensor().setDevice(device);
		ParkingSensor storedSensor = parkingSensorService.createUpdateParkingSensor(parkingSpot.getParkingSensor());

		parkingSpotService.assignSpot(parkingSpot);
				
		return ResponseEntity.ok("" + storedSensor.getId() );
	}
	
	
	@GetMapping("/estacionamientos")
	public String listParkingSpots(Model model) {
		List<Spot> dbParkingSpots = parkingSpotService.getAllSpots();

		model.addAttribute("parkingSpots", dbParkingSpots);
		
		return "parkingSpots";
	}
	
	@PostMapping("/parkingSpots/crud")
	public ResponseEntity<String>  parkingSpotsCrudHandler(@RequestBody Spot parkingSpot) {
		Spot storedParkingSpot = parkingSpotService.createUpdateSpot(parkingSpot);

		return ResponseEntity.ok("" + storedParkingSpot.getId());
	}
	
}










































