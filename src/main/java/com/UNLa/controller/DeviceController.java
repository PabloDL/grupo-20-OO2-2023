package com.UNLa.controller;

import java.util.List;

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
	private ISpotService spotService;
	
	
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
		List<Spot> parkingSpots = spotService.getAllSpotsWithParkingSensor();
		List<ParkingSensor> parkingSensors = parkingSensorService.getAllParkingSensors();
		
		model.addAttribute("parkingSensors", parkingSensors);
		model.addAttribute("parkingSpots", parkingSpots);
		
		return "parkingSensors";
	}
}
