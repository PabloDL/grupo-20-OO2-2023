package com.UNLa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.UNLa.entity.Device;
import com.UNLa.entity.Student;
import com.UNLa.service.IDeviceService;
import com.UNLa.service.StudentService;

@Controller
public class HomeController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private IDeviceService deviceService;

	@GetMapping("/index")
	public String home(Model model) {
		List<Device> devices = deviceService.getAllDevices();
			model.addAttribute("devices", devices);
			
			for(Device device: devices) {
				System.out.println(device.toString());
			}
			
		return "index";
	}

//	@GetMapping("/students")
//	public String listStudents(Model model) {
//		model.addAttribute("students", studentService.getAllStudents());
//		return "students";		
//	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_students";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
}
