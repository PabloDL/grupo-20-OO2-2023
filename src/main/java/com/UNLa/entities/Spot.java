package com.UNLa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Spot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="number", nullable=false)
	private int number;

	@Column(name="sector", nullable=false, length=1)
	private String sector;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	private User reservedFor;
	
	@Column(name="last-domain", length=10)
	private String lastDomain;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parking-sensor_device_id", nullable=false)
	private Device parkingSensor;

	public Spot(int number, String sector,  Device parkingSensor) {
		super();
		this.number = number;
		this.sector = sector;
		this.parkingSensor = parkingSensor;
	}
	
	
}

