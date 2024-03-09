package com.adm.pharmacy.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.adm.pharmacy.models.RemedyModel;
import com.adm.pharmacy.models.dtos.RemedyDTO;
import com.adm.pharmacy.services.RemedyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/medicine")
public class RemedyController {

	@Autowired
	RemedyService remedyService;
	
	@PostMapping
	public ResponseEntity<RemedyModel> saveRemedy(@RequestBody @Valid RemedyDTO remedyDTO) {
		var remedyModel = this.remedyService.insert(remedyDTO);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(remedyModel.getId()).toUri();		
		
		return ResponseEntity.created(uri).body(remedyModel);
	}
	
	@GetMapping
	public ResponseEntity<List<RemedyModel>> getAllRemedies() {
		List<RemedyModel> remedies = this.remedyService.getAllRemedies();
		
		if(!remedies.isEmpty()) {
			for(RemedyModel remedy : remedies) {
				Long id = remedy.getId();
				remedy.add(linkTo(methodOn(RemedyController.class).getOneRemedy(id)).withSelfRel());
			}
		}		
		
		return ResponseEntity.ok().body(remedies);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RemedyModel> getOneRemedy(@PathVariable(value = "id") Long id) {
		var remedyModel = this.remedyService.findById(id);
		remedyModel.add(linkTo(methodOn(RemedyController.class).getAllRemedies()).withRel("Remedies List"));
		return ResponseEntity.ok().body(remedyModel);
	}
	
}
