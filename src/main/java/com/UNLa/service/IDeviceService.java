package com.UNLa.service;

import java.util.List;

import com.UNLa.entity.Device;

public interface IDeviceService {
	List<Device> getAllDevices();
	
	Device saveDevice(Device device);
	
}
