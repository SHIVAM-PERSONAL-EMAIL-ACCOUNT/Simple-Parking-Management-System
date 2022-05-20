package org.monkhub.assignment.parkingManagementSystem.model.dto;

import java.time.LocalDate;

public class ParkingHistoryDTO {
	
	private String slotNumber;
	
	private String carNumber;
	
	private LocalDate parkingDate;
	
	private LocalDate unparkingDate;

	public ParkingHistoryDTO(String slotNumber, String carNumber, LocalDate parkingDate, LocalDate unparkingDate) {
		this.slotNumber = slotNumber;
		this.carNumber = carNumber;
		this.parkingDate = parkingDate;
		this.unparkingDate = unparkingDate;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public LocalDate getParkingDate() {
		return parkingDate;
	}

	public void setParkingDate(LocalDate parkingDate) {
		this.parkingDate = parkingDate;
	}

	public LocalDate getUnparkingDate() {
		return unparkingDate;
	}

	public void setUnparkingDate(LocalDate unparkingDate) {
		this.unparkingDate = unparkingDate;
	}

	@Override
	public String toString() {
		return "ParkingHistoryDTO [slotNumber=" + slotNumber + ", carNumber=" + carNumber + ", parkingDate="
				+ parkingDate + ", unparkingDate=" + unparkingDate + "]";
	}
}
