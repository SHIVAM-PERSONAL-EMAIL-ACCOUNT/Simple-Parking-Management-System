package org.monkhub.assignment.parkingManagementSystem.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.monkhub.assignment.parkingManagementSystem.controllerAdvice.exceptions.EntryNotFoundException;
import org.monkhub.assignment.parkingManagementSystem.model.dto.ParkingHistoryDTO;
import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingHistory;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSystemService {
	
	@Autowired
	private ParkingSlotService parkingSlotService;
	@Autowired
	private ParkingHistoryService parkingHistoryService;
	@Autowired
	private CarService carService;
	
	public String createNewParkingSlot(String newParkingSlotNumber) {
		parkingSlotService.createNewParkingSlot(newParkingSlotNumber);
		return "Created new Parking Slot: " + newParkingSlotNumber;
	}
	
	public boolean isParkingSlotAvailable(String parkingSlotNumber) {
		return parkingSlotService.isParkingSlotAvailable(parkingSlotNumber);
	}
	
	public String parkCarInTheParkingSlot(String carNumber) {
		Car carToBeParked = carService.getCar(carNumber);
		ParkingSlot firstAvailableParkingSlot = parkingSlotService.getFirstAvailableParkingSlot();
		
		if (firstAvailableParkingSlot == null)
			return "All the parking slots are currently full";
		
		firstAvailableParkingSlot.setParkedCar(carToBeParked);
		firstAvailableParkingSlot.setOccupied(true);
		parkingSlotService.updateParkingSlotInformation(firstAvailableParkingSlot);
		
		parkingHistoryService.createNewParkingHistory(firstAvailableParkingSlot, carToBeParked);
		
		return "Car " + carNumber + " parked at slot " + firstAvailableParkingSlot.getSlotNumber();
	}
	
	public String unparkCarFromTheParkingSlot(String carNumber) {
		Car carToBeUnparked = carService.getParkedCar(carNumber);	
		
		if (carToBeUnparked == null)
			throw new EntryNotFoundException("Car with given number is not present");
		
		ParkingSlot occupiedParkingSlot = parkingSlotService.findParkingSlotByParkedCar(carToBeUnparked);
		occupiedParkingSlot.setParkedCar(null);
		occupiedParkingSlot.setOccupied(false);
		parkingSlotService.updateParkingSlotInformation(occupiedParkingSlot);
		
		parkingHistoryService.updateParkingHistory(carToBeUnparked, occupiedParkingSlot);
		
		return "Car " + carNumber + " unparked from slot " + occupiedParkingSlot.getSlotNumber();
	}
	
	public ParkingSlot getParkingInformationOfCar(String carNumber) {
		Car parkedCar = carService.getParkedCar(carNumber);
		
		if (parkedCar == null)
			throw new EntryNotFoundException("Car with given number is not present");
		
		ParkingSlot parkingSlot = parkingSlotService.findParkingSlotByParkedCar(parkedCar);
		return parkingSlot;
	}
	
	public ParkingSlot getParkingInformationOfSlot(String slotNumber) {
		return parkingSlotService.findParkingSlotBySlotNumber(slotNumber);
	}

	public Set<ParkingHistoryDTO> getParkingInformationByDates(LocalDate date1, LocalDate date2) {
		Set<ParkingHistory> parkingHistories = parkingHistoryService.getParkingInformationByDates(date1, date2);
		
		Set<ParkingHistoryDTO> parkingHistoryDTOs = new HashSet<>();
		for (ParkingHistory parkingHistory : parkingHistories)
			parkingHistoryDTOs.add(new ParkingHistoryDTO(parkingHistory.getParkingSlot().getSlotNumber(), 
														 parkingHistory.getParkedCar().getCarNumber(), 
														 date1, 
														 date2));
		
		return parkingHistoryDTOs;
	}
}
