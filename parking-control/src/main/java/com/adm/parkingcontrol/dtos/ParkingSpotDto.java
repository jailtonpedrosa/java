package com.adm.parkingcontrol.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public record ParkingSpotDto(String parkingSpotNumber, String licensePlateCar, String brandCar, String modelCar,
		String colorCar, LocalDateTime registrationDate, String responsibleName, String apartment, String block) {
}
