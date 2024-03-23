package com.adm.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adm.dslist.models.GameModel;
import com.adm.dslist.projections.GameMinProjection;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
	
	// consulta customizada
	@Query(nativeQuery = true, value = """
			SELECT 
				tb_game.id, 
				tb_game.title, 
				tb_game.game_year AS `year`, 
				tb_game.img_url AS imgUrl,
				tb_game.short_description AS shortDescription, 
				tb_belonging.position
			FROM 
				tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")	
	List<GameMinProjection> searchByList(Long listId);
	
	// nativeQuery = true -> sql comum cujo o retorno tem que ser uma interface que no spring é chamado de Projection
}