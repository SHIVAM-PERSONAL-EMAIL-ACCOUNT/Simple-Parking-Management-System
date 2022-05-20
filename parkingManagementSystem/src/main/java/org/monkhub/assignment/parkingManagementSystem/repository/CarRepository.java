package org.monkhub.assignment.parkingManagementSystem.repository;

import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	Car findCarByCarNumber(String carNumber);
}
