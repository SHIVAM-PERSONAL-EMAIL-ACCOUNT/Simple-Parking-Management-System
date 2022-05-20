package org.monkhub.assignment.parkingManagementSystem.service;

import java.time.LocalDate;
import java.util.Set;

import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingHistory;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingSlot;
import org.monkhub.assignment.parkingManagementSystem.repository.ParkingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingHistoryService {

	@Autowired
	private ParkingHistoryRepository parkingHistoryRepository;

	public void createNewParkingHistory(ParkingSlot firstAvailableParkingSlot, Car carToBeParked) {
		ParkingHistory newParkingHistory = new ParkingHistory(firstAvailableParkingSlot, carToBeParked, LocalDate.now(), null);
		parkingHistoryRepository.save(newParkingHistory);
	}

	public void updateParkingHistory(Car carToBeUnparked, ParkingSlot occupiedParkingSlot) {
		ParkingHistory parkingHistory = parkingHistoryRepository.findParkingHistoryByParkedCarAndParkingSlot(carToBeUnparked, occupiedParkingSlot);		
		parkingHistory.setUnparkingTime(LocalDate.now());
		parkingHistoryRepository.save(parkingHistory);
	}

	public Set<ParkingHistory> getParkingInformationByDates(LocalDate date1, LocalDate date2) {
		return parkingHistoryRepository.getParkingInformationByDates(date1, date2);
	}
}
