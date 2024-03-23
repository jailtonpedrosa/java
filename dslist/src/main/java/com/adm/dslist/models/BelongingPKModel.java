package com.adm.dslist.models;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPKModel {
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private GameModel game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameListModel list;
	
	public BelongingPKModel() {
	}

	public BelongingPKModel(GameModel game, GameListModel list) {
		super();
		this.game = game;
		this.list = list;
	}

	public GameModel getGame() {
		return game;
	}

	public void setGame(GameModel game) {
		this.game = game;
	}

	public GameListModel getList() {
		return list;
	}

	public void setList(GameListModel list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPKModel other = (BelongingPKModel) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
}
