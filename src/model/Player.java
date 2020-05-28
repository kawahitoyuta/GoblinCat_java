package model;

import java.io.Serializable;

public class Player implements Serializable{
	private int id;
	private String name;
	private String image;
	private String word;

	
	public Player(int id) {
		this.id = id;
	}
	public Player(int id, String name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}
	public Player(int id, String name, String image, String word) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.word = word;
	}

	public int getId() {
		return id;
	}

	public String getWord() {
		return word;
	}
	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

}
