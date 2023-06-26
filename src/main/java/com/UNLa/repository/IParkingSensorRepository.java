package com.UNLa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UNLa.entity.ParkingSensor;

public interface IParkingSensorRepository extends JpaRepository<ParkingSensor, Long> {

}
