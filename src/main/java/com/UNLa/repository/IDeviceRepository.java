package com.UNLa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UNLa.entity.Device;

public interface IDeviceRepository extends JpaRepository<Device, Long>{

}
