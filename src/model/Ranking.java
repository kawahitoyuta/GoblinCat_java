package model;

import java.io.Serializable;

public class Ranking implements Serializable {
	private int id;
	private String name;
	private int score;
	private int winper;
	private int playCount;
	private int winCount;

	public Ranking(int id,String name,int score,int winper,int playCount,int winCount) {
		this.id=id;
		this.name=name;
		this.score=score;
		this.winper=winper;
		this.playCount=playCount;
		this.winCount=winCount;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public int getWinper() {
		return winper;
	}

	public int getPlayCount() {
		return playCount;
	}

	public int getWinCount() {
		return winCount;
	}

}
