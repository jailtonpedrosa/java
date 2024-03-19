package com.adm.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.dslist.dtos.GameRecordDto;
import com.adm.dslist.models.GameModel;
import com.adm.dslist.services.GameService;

@RestController
@RequestMapping(value = "games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameRecordDto> findAll() {
		List<GameRecordDto> result = this.gameService.findAll();
		return result;
	}

}
