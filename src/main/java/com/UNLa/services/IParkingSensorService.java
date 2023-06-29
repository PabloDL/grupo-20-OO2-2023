package com.UNLa.services;

import java.util.List;

import com.UNLa.entities.ParkingSensor;

public interface IParkingSensorService {
	ParkingSensor getParkingSensor(Long parkingSensorId);
	
	List<ParkingSensor> getAllParkingSensors();

	List<ParkingSensor> getAllUnassignedParkingSensors();
	
	boolean assignSpot();
	
	ParkingSensor createUpdateParkingSensor(ParkingSensor parkingSensor);

	ParkingSensor simulateParking(ParkingSensor sensorChanges);
}
