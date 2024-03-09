package com.adm.pharmacy.models.dtos;

import java.time.LocalDate;

import com.adm.pharmacy.models.enums.Laboratory;
import com.adm.pharmacy.models.enums.Way;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RemedyDTO(
		@NotBlank 
		@NotNull 
		String name, 
		
		@Enumerated
		Way way, 
		
		@Enumerated 
		Laboratory laboratory,
		
		@NotBlank
		@NotNull 
		String lot,
		
		@NotNull
		Double quantity,
		
		@Future
		LocalDate valid) {
}
