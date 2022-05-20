package org.monkhub.assignment.parkingManagementSystem.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ParkingHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private ParkingSlot parkingSlot;
	
	@ManyToOne
	private Car parkedCar;
	
	@Column(nullable = false)
	private LocalDate parkingTime;
	
	private LocalDate unparkingTime;
	
	public ParkingHistory() {}

	public ParkingHistory(ParkingSlot parkingSlot, Car parkedCar, LocalDate parkingTime, LocalDate unparkingTime) {
		this.parkingSlot = parkingSlot;
		this.parkedCar = parkedCar;
		this.parkingTime = parkingTime;
		this.unparkingTime = unparkingTime;
	}

	public Long getId() {
		return id;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public Car getParkedCar() {
		return parkedCar;
	}

	public LocalDate getParkingTime() {
		return parkingTime;
	}

	public LocalDate getUnparkingTime() {
		return unparkingTime;
	}
	
	public void setUnparkingTime(LocalDate unparkingTime) {
		this.unparkingTime = unparkingTime;
	}

	@Override
	public String toString() {
		return "ParkingHistory [id=" + id + ", parkingSlot=" + parkingSlot + ", parkedCar=" + parkedCar
				+ ", parkingTime=" + parkingTime + ", unparkingTime=" + unparkingTime + "]";
	}
}
