package com.adm.dslist.models;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class BelongingModel {
	
	@EmbeddedId
	private BelongingPKModel id = new BelongingPKModel();
	
	private Integer position;
	
	public BelongingModel() {
	}

	public BelongingModel(GameModel game, GameListModel gameListModel, Integer position) {
		super();
		id.setGame(game);
		id.setList(gameListModel);
		this.position = position;
	}

	public BelongingPKModel getId() {
		return id;
	}

	public void setId(BelongingPKModel id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingModel other = (BelongingModel) obj;
		return Objects.equals(id, other.id);
	}	
}
