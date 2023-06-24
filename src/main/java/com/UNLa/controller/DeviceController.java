package com.UNLa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UNLa.entity.Device;
import com.UNLa.service.IDeviceService;

@Controller
public class DeviceController {
	@Autowired
	private IDeviceService deviceService;

	@GetMapping("/dispositivos")
	public String listDevices(Model model) {
		model.addAttribute("devices", deviceService.getAllDevices());
		return "devices";
	}	
	
	@PostMapping("/devices/crud")
	public ResponseEntity<String> handleCrudRequest(@RequestBody Device device) {
		// Aquí puedes procesar los datos recibidos
		
		System.out.println(device.toString());
		
		int id = device.getId();
		boolean enabled = device.isEnabled();
		String name = device.getName();
		
		Device stored = deviceService.createUpdateDevice(device);
		return ResponseEntity.ok("" + stored.getId());
	}
	

	@GetMapping("/sensors")
	public String listSensors(Model model) {
		model.addAttribute("Sensor", SensorService.getAllSensors(long deviceId));
		return "sensors";
	}

	
	
}
