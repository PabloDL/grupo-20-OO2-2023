package com.UNLa.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entity.ParkingSensor;
import com.UNLa.repository.IParkingSensorRepository;
import com.UNLa.service.IParkingSensorService;

@Service
public class ParkingSensorServiceImplementation implements IParkingSensorService {
	private IParkingSensorRepository parkingSensorRepository;
		
	public ParkingSensorServiceImplementation(IParkingSensorRepository parkingSensorRepository) {
		super();
		this.parkingSensorRepository = parkingSensorRepository;
	}

	@Override
	public List<ParkingSensor> getAllParkingSensors(){
		return parkingSensorRepository.findAll();
	}

	
}
