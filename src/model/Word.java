package model;

public class Word {
	private int id;
	private String wordA;
	private String wordB;

	public Word(int id, String wordA,String wordB) {
		this.id = id;
		this.wordA = wordA;
		this.wordB = wordB;
	}

	public int getId() {
		return id;
	}

	public String getWordA() {
		return wordA;
	}

	public String getWordB() {
		return wordB;
	}
}