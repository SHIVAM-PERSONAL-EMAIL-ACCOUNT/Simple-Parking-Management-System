package org.monkhub.assignment.parkingManagementSystem.controller;

import java.time.LocalDate;
import java.util.Set;

import org.monkhub.assignment.parkingManagementSystem.model.dto.ParkingHistoryDTO;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingSlot;
import org.monkhub.assignment.parkingManagementSystem.service.ParkingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parkingApi/v1/")
public class ParkingSystemController {
	
	@Autowired
	private ParkingSystemService parkingSystemService;
	
	@PostMapping("new-slot")
	public String createNewParkingSlot(@RequestParam(name = "number") String newParkingSlotNumber) {
		try {
			return parkingSystemService.createNewParkingSlot(newParkingSlotNumber);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Slot number is already taken");
		}
	}
	
	@GetMapping("check/slot-availability")
	public boolean isParkingSlotAvailable(@RequestParam(name = "number") String parkingSlotNumber) {
		return !parkingSystemService.isParkingSlotAvailable(parkingSlotNumber);
	}
	
	@PostMapping("park/car/")
	public String parkCarInTheParkingSlot(@RequestParam(name = "number") String carNumber) {
		return parkingSystemService.parkCarInTheParkingSlot(carNumber);
	}
	
	@PostMapping("unpark/car/")
	public String unparkCarFromTheParkingSlot(@RequestParam(name = "number") String carNumber) {
		return parkingSystemService.unparkCarFromTheParkingSlot(carNumber);
	}
	
	@GetMapping("car/parking-information")
	public ParkingSlot getParkingInformationOfCar(@RequestParam(name = "number") String carNumber) {
		return parkingSystemService.getParkingInformationOfCar(carNumber);
	}

	@GetMapping("slot/parking-information")
	public ParkingSlot getParkingInformationOfSlot(@RequestParam(name = "number") String slotNumber) {
		return parkingSystemService.getParkingInformationOfSlot(slotNumber);
	}
	
	@GetMapping("parking-history")
	public Set<ParkingHistoryDTO> getParkingInformationByDates(@RequestParam(name = "from") String date1,@RequestParam(name = "to") String date2) {
		return parkingSystemService.getParkingInformationByDates(LocalDate.parse(date1), LocalDate.parse(date2));
	}
}