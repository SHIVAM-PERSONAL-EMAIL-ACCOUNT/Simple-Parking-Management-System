package org.monkhub.assignment.parkingManagementSystem.repository;

import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
	
	ParkingSlot findParkingSlotBySlotNumber(String slotNumber);

	@Query(value = "SELECT TOP 1 * FROM PARKING_SLOT PS WHERE PS.OCCUPIED = false ORDER BY PS.ID", nativeQuery = true)
	ParkingSlot getFirstAvailableParkingSlot();

	ParkingSlot findParkingSlotByParkedCar(Car parkedCar); 
}
