package com.adm.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.dslist.models.GameListModel;

public interface GameListRepository extends JpaRepository<GameListModel, Long>{

}
