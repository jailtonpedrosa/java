package com.adm.dslist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.dslist.dtos.GameRecordDto;
import com.adm.dslist.models.GameModel;
import com.adm.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameRecordDto> findAll() {
		List<GameModel> gameModels = this.gameRepository.findAll();
		
		// meu método findAll busca do banco todos os dados mas o método retorna um Dto
		List<GameRecordDto> gameRecordDtos = gameModels
				.stream()
				.map(x -> new GameRecordDto(x.getId(), x.getTitle(), x.getYear(), x.getImgUrl(), x.getShortDescription()))
				.toList();		

		return gameRecordDtos;
	}
}
