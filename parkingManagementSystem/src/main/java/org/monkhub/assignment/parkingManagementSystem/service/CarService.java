package org.monkhub.assignment.parkingManagementSystem.service;

import org.monkhub.assignment.parkingManagementSystem.model.entity.Car;
import org.monkhub.assignment.parkingManagementSystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public Car getCar(String carNumber) {
		Car car = carRepository.findCarByCarNumber(carNumber);
		if (car == null)
			car = carRepository.save(new Car(carNumber));
		return car;
	}
	
	public Car getParkedCar(String carNumber) {
		return carRepository.findCarByCarNumber(carNumber);
	}
}
