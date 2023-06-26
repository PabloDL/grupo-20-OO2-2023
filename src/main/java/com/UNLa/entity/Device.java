package com.UNLa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="device")
public class Device{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="name", nullable=false, length=45)
	private String name;

	@Column(name="enabled")
	private boolean enabled;

	public Device(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", enabled=" + enabled + "]";
	}
	
	
}

