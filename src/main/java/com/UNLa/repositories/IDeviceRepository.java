package com.UNLa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UNLa.entities.Device;

public interface IDeviceRepository extends JpaRepository<Device, Long>{

}
