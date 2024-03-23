package com.adm.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adm.dslist.dtos.GameListRecordDto;
import com.adm.dslist.dtos.GameMinRecordDto;
import com.adm.dslist.services.GameListService;
import com.adm.dslist.services.GameService;

@RestController
@RequestMapping(value = "lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameListRecordDto> findAll() {
		List<GameListRecordDto> result = this.gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinRecordDto> findByList(@PathVariable Long listId) {
		List<GameMinRecordDto> result = this.gameService.findByList(listId);
		return result;
	}
}
