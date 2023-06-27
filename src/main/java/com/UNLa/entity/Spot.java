package com.UNLa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="spot")
public class Spot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="number")
	private int	number;
	
	@Column(name="sector", length=30)
	private String sector;
//	
//	@OneToOne(fetch = FetchType.LAZY)
//	@Column(name="reserved", nullable=true)
//	private User reserved;
	
	@Column(name="last-domain", length=8)
	private String lastDomain;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parking_sensor_id")
	private ParkingSensor parkingSensor;
	
	@Column(name="enabled")
	private boolean enabled;
	
	public Spot(int number, String sector, boolean enabled) {
		super();
		this.number = number;
		this.sector = sector;
		this.enabled = enabled;
	}
	
	public Spot(int number, String sector, /*int reserved,*/ String lastDomain, ParkingSensor parkingSensor, boolean enabled) {
		super();
		this.number = number;
		this.sector = sector;
//		this.reserved = reserved;
		this.lastDomain = lastDomain;
		this.parkingSensor = parkingSensor;
		this.enabled = enabled;
	}
	
	public Spot(Spot parkingSpot) {
		super();
		this.number = parkingSpot.number;
		this.sector = parkingSpot.sector;
//		this.reserved = parkingSpot.reserved;
		this.lastDomain = parkingSpot.lastDomain;
		this.parkingSensor = parkingSpot.parkingSensor;
		this.enabled = parkingSpot.enabled;
	}
	
	public Spot updateFields(Spot parkingSpot) {
		this.enabled = parkingSpot.enabled;
		this.sector = parkingSpot.sector;
		this.number = parkingSpot.number;
		this.parkingSensor.updateFields(parkingSpot.getParkingSensor());
		return this;
	}
}
