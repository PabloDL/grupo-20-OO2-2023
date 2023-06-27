package com.UNLa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UNLa.entity.ParkingSensor;

public interface IParkingSensorRepository extends JpaRepository<ParkingSensor, Long> {
	@Query("FROM ParkingSensor AS ps "
			+ "LEFT JOIN FETCH Spot AS s "
			+ "ON ps.id = s.parkingSensor.id WHERE s.parkingSensor IS NULL")
		List<ParkingSensor> findAllUnassigned();
	
		
} 
