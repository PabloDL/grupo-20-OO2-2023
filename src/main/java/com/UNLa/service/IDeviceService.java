package com.UNLa.service;

import java.util.List;

import com.UNLa.entity.Device;

public interface IDeviceService {

	Device getDevice(Long deviceId);
	
	List<Device> getAllDevices();
	
	Device saveDevice(Device device);
	
	Device createUpdateDevice(Device device);
 
}
