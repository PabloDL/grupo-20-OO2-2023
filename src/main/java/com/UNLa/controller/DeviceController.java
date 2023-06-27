package com.UNLa.controller;

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

import com.UNLa.entity.Device;
import com.UNLa.entity.ParkingSensor;
import com.UNLa.entity.Spot;
import com.UNLa.service.IDeviceService;
import com.UNLa.service.IParkingSensorService;
import com.UNLa.service.ISpotService;

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
//
//	@GetMapping("/dispositivos/crear")
//	public String createDeviceForm(Model model) {
//		Device device = new Device();
//		model.addAttribute("device", device);
//		return "deviceCreate";
//	}
//	
//	@PostMapping("/dispositivos/crear")
//	public String saveDevice(@ModelAttribute("device") Device device) {
//		deviceService.saveDevice(device);
//		return "redirect:/dispositivos";
//	}
//
//	@GetMapping("/dispositivos/actualizar/{id}")
//	public String editDeviceForm(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("devices", deviceService.getDevice(id));
//		return "deviceUpdate";
//	}
//	
//	@PostMapping("/dispositivos/actualizar")
//	public String editDeviceForm(@PathVariable Long deviceId, 
//			@ModelAttribute("device") Device device, Model model) {
//		
//		//Device updateDevice = deviceService.createUpdateDevice(device);
//		Device updateDevice = deviceService.getDevice(deviceId);
//		updateDevice.setName(device.getName());
//		updateDevice.setEnabled(device.isEnabled());
//		
//		deviceService.saveDevice(updateDevice);
//		return "redirect:/dispositivo";
//	}
	
	
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
		model.addAttribute("parkingSensors", dbParkingSensors);
		model.addAttribute("unassignedParkingSensors", unassignedParkingSensors);
		
		return "parkingSensors";
	}
	
	@PostMapping("/devices/parkingSensor/crud")
	public ResponseEntity<String> handleCrudRequest(@RequestBody Spot parkingSpot) {
		Device device = deviceService.getDevice((long) parkingSpot.getParkingSensor().getDevice().getId());
		parkingSpot.getParkingSensor().setDevice(device);
		ParkingSensor storedSensor = parkingSensorService.createUpdateParkingSensor(parkingSpot.getParkingSensor());
		Spot assignedSpot = parkingSpotService.createUpdateSpot(parkingSpot);
		
		System.out.println(storedSensor.toString());
		System.out.println(assignedSpot.toString());
		
		return ResponseEntity.ok("" + assignedSpot.getId() );
	}
	
}










































