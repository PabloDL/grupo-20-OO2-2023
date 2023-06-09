package com.UNLa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="parking_sensor")
public class ParkingSensor{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="available")
	private boolean available;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="device_id", nullable=false)
	private Device device;
	
	@Column(name="enabled")
	private boolean enabled;
	

	public ParkingSensor(boolean available) {
		this.available = available;
	}
	
	public ParkingSensor(ParkingSensor parkingSensor) {
		this.available = parkingSensor.available;
		this.enabled = parkingSensor.enabled;
		//this.device = parkingSensor.device;
	}
	
	@Override
	public String toString() {
		return "ParkingSensor [id=" + id + ", available=" + available + ", deviceId=" + device + ", enabled="
				+ enabled + "]";
	}
	
	public ParkingSensor updateFields(ParkingSensor parkingSensor) {
		this.enabled = parkingSensor.enabled;
		this.setDevice(parkingSensor.getDevice());
		return this;
	}
}
