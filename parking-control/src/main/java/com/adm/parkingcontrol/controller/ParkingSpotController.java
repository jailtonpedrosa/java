package com.adm.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.parkingcontrol.dtos.ParkingSpotDto;
import com.adm.parkingcontrol.models.ParkingSpotModel;
import com.adm.parkingcontrol.service.ParkingSpotService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	@Autowired
	ParkingSpotService parkingSpotService;
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {

		if(this.parkingSpotService.existsByLicencePlateCar(parkingSpotDto.licensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
		}

		if(this.parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.parkingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
		}

		if(this.parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.apartment(), parkingSpotDto.block())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
		}

		ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.parkingSpotService.save(parkingSpotModel));
	}

	@GetMapping
	public ResponseEntity<Page<ParkingSpotModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(this.parkingSpotService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable UUID id) {
		Optional<ParkingSpotModel> parkingSpotModel = this.parkingSpotService.findById(id);
		
		if(!parkingSpotModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found!");
		}

		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModel.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
		Optional<ParkingSpotModel> parkingSpotModel = this.parkingSpotService.findById(id);
		
		if(!parkingSpotModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found!");
		}

		this.parkingSpotService.delete(id);

		return ResponseEntity.status(HttpStatus.OK).body("Parking spot deleted successfully.");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = this.parkingSpotService.findById(id);
		
		if(!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found!");
		}

		var parkingSpotModel = parkingSpotModelOptional.get();
		parkingSpotModel.setParkingSpotNumber(parkingSpotDto.parkingSpotNumber());
		parkingSpotModel.setLicensePlateCar(parkingSpotDto.licensePlateCar());
		parkingSpotModel.setModelCar(parkingSpotDto.modelCar());
		parkingSpotModel.setBrandCar(parkingSpotDto.brandCar());
		parkingSpotModel.setColorCar(parkingSpotDto.colorCar());
		parkingSpotModel.setResponsibleName(parkingSpotDto.responsibleName());
		parkingSpotModel.setApartment(parkingSpotDto.apartment());
		parkingSpotModel.setBlock(parkingSpotDto.block());

		return ResponseEntity.status(HttpStatus.OK).body(this.parkingSpotService.save(parkingSpotModel));
	}
}
