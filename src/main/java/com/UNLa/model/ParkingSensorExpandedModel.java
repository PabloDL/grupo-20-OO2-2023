package com.UNLa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ParkingSensorExpandedModel {
	private int id;
	private boolean available;
	private boolean enabled;

	private String spotLastDomain;
	private int spotNumber;
	private String spotSector;
	
	public ParkingSensorExpandedModel(int id, boolean available, boolean enabled, String spotLastDomain, int spotNumber,
			String spotSector) {
		super();
		this.id = id;
		this.available = available;
		this.enabled = enabled;
		this.spotLastDomain = spotLastDomain;
		this.spotNumber = spotNumber;
		this.spotSector = spotSector;
	}
		
}
