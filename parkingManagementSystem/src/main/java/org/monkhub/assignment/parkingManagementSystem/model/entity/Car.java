package org.monkhub.assignment.parkingManagementSystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String carNumber;

	public Car() {}
	
	public Car(String carNumber) {
		this.carNumber = carNumber;
	}

	public Long getId() {
		return id;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carNumber=" + carNumber + "]";
	}
}
