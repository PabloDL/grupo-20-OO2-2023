package com.UNLa.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entity.Device;
import com.UNLa.repository.IDeviceRepository;
import com.UNLa.service.IDeviceService;

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
