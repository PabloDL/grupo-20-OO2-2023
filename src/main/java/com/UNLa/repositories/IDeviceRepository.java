package com.UNLa.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.UNLa.entities.Device;

@Repository("deviceRepository")
public interface IDeviceRepository extends JpaRepository<Device, Serializable> {
//
//	@Query("SELECT d.name FROM device d WHERE d.name = (:name) ORDER BY d.name")
//	Device findByDeviceName(@Param("name") String name);
//	
//	@Query("SELECT d.name FROM device ORDER BY d.name")
//	List<Device> findAllDevices();	
//	
//	//TODO: servicio que traiga los dispositivps que sean de tipo sensor de estacionamiento y sus datos
//	
//	
}
