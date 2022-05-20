package org.monkhub.assignment.parkingManagementSystem.repository;

import java.time.LocalDate;
import java.util.Set;

import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingHistory;
import org.monkhub.assignment.parkingManagementSystem.model.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingHistoryRepository extends JpaRepository<ParkingHistory, Long> {

	@Query("SELECT ph FROM ParkingHistory ph WHERE ph.parkedCar = ?1 AND ph.parkingSlot = ?2 AND ph.unparkingTime = null")
	ParkingHistory findParkingHistoryByParkedCarAndParkingSlot(Car carToBeUnparked, ParkingSlot occupiedParkingSlot);

	@Query("SELECT ph FROM ParkingHistory ph WHERE ph.parkingTime >= :date1 AND ph.parkingTime <= :date2")
	Set<ParkingHistory> getParkingInformationByDates(LocalDate date1, LocalDate date2);

}
