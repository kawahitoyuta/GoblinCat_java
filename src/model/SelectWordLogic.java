package model;

import dao.WordDAO;

public class SelectWordLogic {
	public Word getWord(int wordId) {
		WordDAO dao = new WordDAO();
		Word word = dao.findByWord(wordId);
		return word;
	}
}
