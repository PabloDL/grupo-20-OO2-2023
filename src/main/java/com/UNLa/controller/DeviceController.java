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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		// Aquí puedes procesar los datos recibidos
		
		System.out.println(device.toString());
		
		int id = device.getId();
		boolean enabled = device.isEnabled();
		String name = device.getName();
		
		Device stored = deviceService.createUpdateDevice(device);
		return ResponseEntity.ok("" + stored.getId());
	}
	
//	@GetMapping("/sensors{id}")
//	public String listSensors(@PathVariable("id") Long deviceId,Model model) {
//		model.addAttribute("Sensor", sensorService.getAllSensors(long deviceId));
//		return "sensors";
//	}
}
