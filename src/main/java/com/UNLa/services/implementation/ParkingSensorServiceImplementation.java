package com.UNLa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entities.ParkingSensor;
import com.UNLa.repositories.IParkingSensorRepository;
import com.UNLa.services.IParkingSensorService;

@Service
public class ParkingSensorServiceImplementation implements IParkingSensorService {
	private IParkingSensorRepository parkingSensorRepository;
	
	public ParkingSensorServiceImplementation(IParkingSensorRepository parkingSensorRepository) {
		super();
		this.parkingSensorRepository = parkingSensorRepository;
	}

	@Override
	public ParkingSensor getParkingSensor(Long parkingSensorId){
		return parkingSensorRepository.findById(parkingSensorId).get();
	}
	
	@Override
	public List<ParkingSensor> getAllParkingSensors(){
		return parkingSensorRepository.findAll();
	}

	@Override
	public List<ParkingSensor> getAllUnassignedParkingSensors(){
		return parkingSensorRepository.findAllUnassigned();
	}

	@Override
	public boolean assignSpot() {
		return false;
	}

	@Override
	public ParkingSensor createUpdateParkingSensor(ParkingSensor parkingSensor) {
		ParkingSensor dbParkingSensor;
		if(parkingSensor.getId() != -1) {
			dbParkingSensor = this.getParkingSensor(Long.valueOf(parkingSensor.getId()));
		}
		else {
			dbParkingSensor = new ParkingSensor(parkingSensor);
		}
		dbParkingSensor.updateFields(parkingSensor);
		return parkingSensorRepository.save(dbParkingSensor);
	}

	@Override
	public ParkingSensor simulateParking(ParkingSensor parkingSensor) {
			ParkingSensor dbParkingSensor = this.getParkingSensor((long) parkingSensor.getId());
			dbParkingSensor.setAvailable(!parkingSensor.isAvailable());
		return parkingSensorRepository.save(dbParkingSensor);
	}
}
