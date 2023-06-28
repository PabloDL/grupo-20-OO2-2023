package com.UNLa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.UNLa.entity.Device;
import com.UNLa.service.IDeviceService;

@Controller
public class HomeController {
	@Autowired
	private IDeviceService deviceService;

	@GetMapping("/")
	public String home(Model model) {
		List<Device> devices = deviceService.getAllDevices();
			model.addAttribute("devices", devices);
			
			for(Device device: devices) {
				System.out.println(device.toString());
			}
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
	
	
	@GetMapping("//buscarEstacionamiento")
	public String findParkingSpots() {
		return "findParking";
	}
	
	
	
}
