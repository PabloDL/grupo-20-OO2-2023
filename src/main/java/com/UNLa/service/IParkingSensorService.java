package com.UNLa.service;

import java.util.List;
import com.UNLa.entity.ParkingSensor;

public interface IParkingSensorService {
	ParkingSensor getParkingSensor(Long parkingSensorId);
	
	List<ParkingSensor> getAllParkingSensors();

	List<ParkingSensor> getAllUnassignedParkingSensors();
	
	boolean assignSpot();
	
	ParkingSensor createUpdateParkingSensor(ParkingSensor parkingSensor);

	ParkingSensor simulateParking(ParkingSensor sensorChanges);
}
