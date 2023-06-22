package com.UNLa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.UNLa.entity.Device;
import com.UNLa.service.IDeviceService;

@Controller
public class DeviceController {
	@Autowired
	private IDeviceService deviceService;

	@GetMapping("/devices")
	public String listDevices(Model model) {
		model.addAttribute("devices", deviceService.getAllDevices());
		return "devices";
	}

	@GetMapping("/devices/new")
	public String createDeviceForm(Model model) {
		Device device = new Device();
		model.addAttribute("device", device);
		return "create_devices";
	}

	@PostMapping("/devices")
	public String saveDevice(@ModelAttribute("device") Device device) {
		deviceService.saveDevice(device);
		return "redirect:/device";
	}
}
