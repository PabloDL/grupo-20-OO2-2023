package com.UNLa.service;

import java.util.List;
import com.UNLa.entity.ParkingSensor;

public interface IParkingSensorService {
	List<ParkingSensor> getAllParkingSensors();

	List<ParkingSensor> getAllUnassignedParkingSensors();
}
