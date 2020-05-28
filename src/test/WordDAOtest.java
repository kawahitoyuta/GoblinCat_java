package test;

import model.SelectWordLogic;
import model.Word;


public class WordDAOtest {

		public static void main(String[] args) {
			testExecute();
		}

		public static void testExecute() {
			SelectWordLogic logic = new SelectWordLogic();
			Word result = logic.getWord(5);
			System.out.println(result.getId());
			System.out.println(result.getWordA());
			System.out.println(result.getWordB());
		}

}