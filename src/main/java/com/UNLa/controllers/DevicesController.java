package com.UNLa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.UNLa.helpers.ViewRouteHelper;
import com.UNLa.services.IDeviceService;



@Controller
@RequestMapping("device/")
public class DevicesController {
//@Autowired
//@Qualifier("deviceService")
//private IDeviceService deviceService;
//
//	//GET Example: SERVER/index
//	@GetMapping("/getAllDevices")
//	public ModelAndView getAllDevices() {
//		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.DEVICE_INDEX);
//				
//		modelAndView.addObject("devices", deviceService.getAll());
//		return modelAndView;
//	}
//	
//	
}
