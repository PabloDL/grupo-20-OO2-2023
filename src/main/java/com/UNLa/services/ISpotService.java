package com.UNLa.services;

import java.util.List;

import com.UNLa.entities.Spot;

public interface ISpotService {
	Spot getParkingSpot(Long spotId);
	
	List<Spot> getAllSpots();
	
	List<Spot> getAllSpotsWithParkingSensor();

	Spot saveSpot(Spot parkingSpot);
	
	Spot createUpdateSpot(Spot parkingSpot);

	List<String> getNumberSector();

	Spot getParkingSpot(int number, String sector);

	Spot assignSpot(Spot parkingSpot);

	List<Spot> getAvailableParkingSpots();

	List<Spot> getRecommendedParkingSpots();

}
