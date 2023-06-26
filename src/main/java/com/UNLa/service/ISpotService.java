package com.UNLa.service;

import java.util.List;
import com.UNLa.entity.Spot;

public interface ISpotService {
	List<Spot> getAllSpots();
	
	List<Spot> getAllSpotsWithParkingSensor();

}
