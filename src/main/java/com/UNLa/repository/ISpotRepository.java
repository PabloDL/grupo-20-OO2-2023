package com.UNLa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.UNLa.entity.Spot;

@Repository
public interface ISpotRepository extends JpaRepository<Spot, Long>{

	@Query("FROM Spot s JOIN FETCH s.parkingSensorId")
    List<Spot> findAllSpotsWithParkingSensor();
}
