package com.UNLa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class ParkingSensor extends Device{
//    @JoinColumn(name = "device_id")
//    @MapsId
//	private int id;
//
//	@Column(name="name", nullable=false, length=45)
//	private String name;
//
//	@Column(name="enabled")
//	private boolean enabled;
//
//	
//	private Device device;
//	
//	public ParkingSensor(String name, boolean enabled) {
//		this.name = name;
//		this.enabled = enabled;
//	}
}

