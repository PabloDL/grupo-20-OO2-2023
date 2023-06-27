package com.UNLa.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entity.Spot;
import com.UNLa.repository.ISpotRepository;
import com.UNLa.service.ISpotService;

@Service
public class SpotServiceImplementation implements ISpotService{
	private ISpotRepository spotRepository;
	
	public SpotServiceImplementation(ISpotRepository spotRepository) {
		super();
		this.spotRepository = spotRepository;
	}
	@Override
	public Spot getParkingSpot(Long spotId) {
		return spotRepository.findById(spotId).get();
	}
	
	@Override
	public Spot getParkingSpot(int number, String sector) {
		return spotRepository.findByLocation(number, sector);
	}
	
	@Override
	public List<Spot> getAllSpots() {
		return spotRepository.findAll();
	}
	
	@Override
	public List<Spot> getAllSpotsWithParkingSensor() {
        return spotRepository.findAllSpotsWithParkingSensor();
    }
	
	@Override
	public List<String> getNumberSector(){
		return spotRepository.findNumberSector();
	}
	
	@Override
	public Spot saveSpot(Spot parkingSpot) {
		return spotRepository.save(parkingSpot);
	};
	
	@Override
	public Spot assignSpot(Spot parkingSpot) {
		Spot dbNewSpot = null;
		Spot dbOldSpot = spotRepository.findBySensorId(parkingSpot.getParkingSensor().getId());
		if(parkingSpot.getNumber() != 0) {
			//selecciono asignar
			dbNewSpot = spotRepository.findByLocation(parkingSpot.getNumber(), parkingSpot.getSector());
			dbNewSpot.setParkingSensor(parkingSpot.getParkingSensor());
		}
		else {
			//selecciono desasignar
			dbOldSpot.setParkingSensor(null);
		}
		
		if (dbOldSpot != null) {
			spotRepository.save(dbOldSpot);
		}
		if (dbNewSpot != null) {
			spotRepository.save(dbNewSpot);
		}
		
		return dbNewSpot;
	}
	
	@Override
	public Spot createUpdateSpot(Spot parkingSpot) {
		Spot dbSpot;
		if(parkingSpot.getId() != -1) {
			dbSpot = this.getParkingSpot(Long.valueOf(parkingSpot.getId()));
		}
		else {
			dbSpot = new Spot(parkingSpot);
		}
		dbSpot.updateFields(parkingSpot);
		
		return spotRepository.save(dbSpot);
	}
	
	
}
