package com.adm.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adm.dslist.dtos.GameListRecordDto;
import com.adm.dslist.dtos.GameRecordDto;
import com.adm.dslist.models.GameListModel;
import com.adm.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListRecordDto> findAll() {
		List<GameListModel> gameListModels = gameListRepository.findAll();
		return gameListModels.stream()
				.map(x -> new GameListRecordDto(x.getId(), x.getName())).toList();
	}
}
