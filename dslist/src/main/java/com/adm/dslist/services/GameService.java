package com.adm.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adm.dslist.dtos.GameMinRecordDto;
import com.adm.dslist.dtos.GameRecordDto;
import com.adm.dslist.models.GameModel;
import com.adm.dslist.projections.GameMinProjection;
import com.adm.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameRecordDto findById(Long id) {
		GameModel game = gameRepository.findById(id).get();

		GameRecordDto gameDto = new GameRecordDto(game.getId(), game.getTitle(), game.getYear(), game.getGenre(),
				game.getPlatforms(), game.getScore(), game.getImgUrl(), game.getShortDescription(),
				game.getLongDescription());

		return gameDto;
	}

	@Transactional(readOnly = true)
	public List<GameMinRecordDto> findAll() {
		List<GameModel> gameModels = this.gameRepository.findAll();

		// meu método findAll busca do banco todos os dados mas o método retorna um Dto
		List<GameMinRecordDto> gameRecordDtos = gameModels.stream().map(
				x -> new GameMinRecordDto(x.getId(), x.getTitle(), x.getYear(), x.getImgUrl(), x.getShortDescription()))
				.toList();

		return gameRecordDtos;
	}

	@Transactional(readOnly = true)
	public List<GameMinRecordDto> findByList(Long listId) {
		List<GameMinProjection> gameModels = this.gameRepository.searchByList(listId);

		return gameModels.stream().map(
				x -> new GameMinRecordDto(x.getId(), x.getTitle(), x.getYear(), x.getImgUrl(), x.getShortDescription()))
				.toList();
	}
}
