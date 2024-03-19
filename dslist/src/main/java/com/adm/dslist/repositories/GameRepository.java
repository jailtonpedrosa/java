package com.adm.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adm.dslist.models.GameModel;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
}