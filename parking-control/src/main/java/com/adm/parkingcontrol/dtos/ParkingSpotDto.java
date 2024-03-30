package com.adm.parkingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ParkingSpotDto(
		@NotBlank
		String parkingSpotNumber,
		@NotBlank
		@Size(max = 10)
		String licensePlateCar,
		@NotBlank
		String brandCar,
		@NotBlank
		@NotBlank
		String modelCar,
		@NotBlank
		String colorCar,
		@NotBlank 
		String responsibleName,
		@NotBlank
		String apartment,
		@NotBlank
		String block) {
}
