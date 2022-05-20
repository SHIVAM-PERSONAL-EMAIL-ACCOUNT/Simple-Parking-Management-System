package org.monkhub.assignment.parkingManagementSystem.service;

import org.monkhub.assignment.parkingManagementSystem.controllerAdvice.exceptions.EntryNotFoundException;
import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingSlot;
import org.monkhub.assignment.parkingManagementSystem.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSlotService {

	@Autowired
	private ParkingSlotRepository parkingSlotRepository;
	
	public void createNewParkingSlot(String newParkingSlotNumber) {
		ParkingSlot newParkingSlot = new ParkingSlot(newParkingSlotNumber);
		parkingSlotRepository.save(newParkingSlot);
	}
	
	public boolean isParkingSlotAvailable(String parkingSlotNumber) {
		ParkingSlot parkingSlot = parkingSlotRepository.findParkingSlotBySlotNumber(parkingSlotNumber);
		if (parkingSlot == null)
			throw new EntryNotFoundException("Parking Slot with given number is not present");
		return parkingSlot.isOccupied();
	}

	public ParkingSlot getFirstAvailableParkingSlot() {
		return parkingSlotRepository.getFirstAvailableParkingSlot();
	}

	public void updateParkingSlotInformation(ParkingSlot parkingSlot) {
		parkingSlotRepository.save(parkingSlot);		
	}

	public ParkingSlot findParkingSlotByParkedCar(Car parkedCar) {
		return parkingSlotRepository.findParkingSlotByParkedCar(parkedCar);
	}

	public ParkingSlot findParkingSlotBySlotNumber(String slotNumber) {
		return parkingSlotRepository.findParkingSlotBySlotNumber(slotNumber);
	}
}
