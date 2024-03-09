package com.adm.pharmacy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.pharmacy.models.RemedyModel;
import com.adm.pharmacy.models.dtos.RemedyDTO;
import com.adm.pharmacy.repositories.RemedyRepository;
import com.adm.pharmacy.services.exceptions.ResourceNotFoundException;

@Service
public class RemedyService {

	@Autowired
	private RemedyRepository remedyRepository;
	
	public RemedyModel insert(RemedyDTO remedyDTO) {
		var remedyModel = new RemedyModel();
		BeanUtils.copyProperties(remedyDTO, remedyModel);
		this.remedyRepository.save(remedyModel);
		return remedyModel;
	}
	
	public List<RemedyModel> getAllRemedies() {
		List<RemedyModel> remedies = this.remedyRepository.findAll();
		return remedies;
	}
	
	public RemedyModel findById(Long id) {
		Optional<RemedyModel> remedy = this.remedyRepository.findById(id);
		return remedy.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
