package com.UNLa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.UNLa.entity.Spot;

@Repository
public interface ISpotRepository extends JpaRepository<Spot, Long>{

	@Query("FROM Spot s JOIN FETCH s.parkingSensor ORDER BY s.parkingSensor.id")
    List<Spot> findAllSpotsWithParkingSensor();

	@Query("SELECT CONCAT(s.number, '-', s.sector) AS numberSector FROM Spot s ORDER BY s.sector, s.number")
	List<String> findNumberSector();
	
	@Query("FROM Spot s WHERE s.number = ?1 AND s.sector = ?2")
	Spot findByLocation(int number, String sector);

	@Query("FROM Spot s WHERE s.parkingSensor.id = ?1")
	Spot findBySensorId(int id);

	@Query("FROM Spot s JOIN FETCH s.parkingSensor ps "
			+ "WHERE s.parkingSensor.available = true")
	List<Spot> findAvailableParkingSpots();
	
	@Query("SELECT s FROM Spot s WHERE s.id IN "
	        + "(SELECT MIN(s2.id) "
	        + "FROM Spot s2 JOIN s2.parkingSensor ps "
	        + "WHERE ps.available = true GROUP BY s2.sector)")
	List<Spot> findAvailableSpotsPerSector();
	
//	@Query("FROM Spot s FROM Spot s JOIN FETCH s.parkingSensor WHERE s.reserved = ?1")
//	Spot checkReservedSpot(User user); 
}
