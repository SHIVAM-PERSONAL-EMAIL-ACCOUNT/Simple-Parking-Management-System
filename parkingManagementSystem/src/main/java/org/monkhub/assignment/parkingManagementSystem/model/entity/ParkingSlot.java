package org.monkhub.assignment.parkingManagementSystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSlot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String slotNumber;
	
	private boolean occupied;
	
	@OneToOne
	private Car parkedCar;
	
	public ParkingSlot() {}

	public ParkingSlot(String slotNumber) {
		this.slotNumber = slotNumber;
		this.occupied = false;
		this.parkedCar = null;
	}

	public Long getId() {
		return id;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Car getParkedCar() {
		return parkedCar;
	}

	public void setParkedCar(Car parkedCar) {
		this.parkedCar = parkedCar;
	}

	@Override
	public String toString() {
		return "ParkingSlot [id=" + id + ", slotNumber=" + slotNumber + ", occupied=" + occupied + ", parkedCar="
				+ parkedCar + "]";
	}
}
