package com.UNLa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entities.Device;
import com.UNLa.repositories.IDeviceRepository;
import com.UNLa.services.IDeviceService;

@Service
public class DeviceServiceImplementation implements IDeviceService{
	private IDeviceRepository deviceRepository;

	public DeviceServiceImplementation(IDeviceRepository deviceRepository) {
		super();
		this.deviceRepository = deviceRepository;
	}

	@Override
	public Device getDevice(Long deviceId) {
		return deviceRepository.findById(deviceId).get();
	}
	
	@Override
	public List<Device> getAllDevices(){
		return deviceRepository.findAll();
	}
	
	@Override
	public Device saveDevice(Device device) {
		return deviceRepository.save(device);
	};
		
	public Device createUpdateDevice(Device device) {
		Device dbDevice;
		if(device.getId() != -1) {
			dbDevice = this.getDevice(Long.valueOf(device.getId()));
			dbDevice.updateFields(device);
		}
		else {
			dbDevice = new Device(device);
		}
		return deviceRepository.save(dbDevice);
	}
	
	
}
