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
	public List<Spot> getAllSpots() {
		return spotRepository.findAll();
	}
	
	@Override
	public List<Spot> getAllSpotsWithParkingSensor() {
        return spotRepository.findAllSpotsWithParkingSensor();
    }
}
