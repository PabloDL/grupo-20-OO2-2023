package com.UNLa.services.implementation;

import java.util.List;
import javax.naming.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.UNLa.entities.Device;
import com.UNLa.repositories.IDeviceRepository;

@Service("deviceService")
public class DeviceService {
//
//	@Autowired
//	@Qualifier("deviceRepository")
//	private IDeviceRepository deviceRepository;
//
//	public Device loadDevicesByName(String name) throws NameNotFoundException {
//		return deviceRepository.findByDeviceName(name);
//	}
//
//	public List<Device> loadAllDevices() throws NameNotFoundException {
//		return (List<Device>) deviceRepository.findAllDevices();
//	}
//
}
