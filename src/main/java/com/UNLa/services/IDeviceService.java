package com.UNLa.services;

import java.util.List;

import com.UNLa.entities.Device;

public interface IDeviceService {

	Device getDevice(Long deviceId);
	
	List<Device> getAllDevices();
	
	Device saveDevice(Device device);
	
	Device createUpdateDevice(Device device);

}
