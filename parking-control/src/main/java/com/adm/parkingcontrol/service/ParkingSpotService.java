package com.adm.parkingcontrol.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.parkingcontrol.models.ParkingSpotModel;
import com.adm.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {
	
	@Autowired
	ParkingSpotRepository parkingSpotRepository;

	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {		
		return this.parkingSpotRepository.save(parkingSpotModel);
	}

	public boolean existsByLicencePlateCar(String licensePlateCar) {
		return this.parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return this.parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return this.parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	public List<ParkingSpotModel> findAll() {
		return this.parkingSpotRepository.findAll();
	}

	public Optional<ParkingSpotModel> findById(UUID id) {		
		return this.parkingSpotRepository.findById(id);
	}

	@Transactional
	public void delete(UUID id) {
		this.parkingSpotRepository.deleteById(id);
	}
}
