package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Player;
import model.SelectCharcterLogic;
import model.SelectWordLogic;
import model.UpdateScoreLogic;
import model.Word;


@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		int executeCount;
		int wordNum;
		int catNum;
		String pc;
		int playerCount;
		int count;
		List<Player> player;
		int j;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result;
		HttpSession session = request.getSession();
		ArrayList<Player> player = (ArrayList<Player>)session.getAttribute("Nplayer");
		int catId = (int)session.getAttribute("catId");

		String votei = request.getParameter("vote");
		int vote = Integer.parseInt(votei);
		session.setAttribute("player", player);
		//全体のスコアアップ
		UpdateScoreLogic Scorelogic =new UpdateScoreLogic();
		for(Player get : player) {
			boolean b =Scorelogic.changeScore(get.getId());
		}
		System.out.println("投票"+vote);
		System.out.println("猫番"+catNum);

		//猫の勝ち 勝敗の判定のvalueが一つずれているためココでvoteに＋１する

		if(vote != catNum) {

			//test用win
			List<Player> win = new ArrayList<>();
			Player catPlayer = new Player(catId);
			win.add(catPlayer);
			//test用winここまで
			UpdateScoreLogic logic = new UpdateScoreLogic();
			for (Player i : win) {
				boolean b = logic.winCat(i.getId());
				System.out.println(b);}
			result = 1;
		}else {
			List<Player> win = new ArrayList<>();
			win.addAll(player);
			Player catPlayer = new Player(catId);
			win.remove(catNum);
			UpdateScoreLogic logic = new UpdateScoreLogic();
			for(Player i : win) {
				boolean b = logic.winMouse(i.getId());
				System.out.println(b);
			}
			result= 2;
		}

		session.setAttribute("result", result);
		RequestDispatcher d = request.getRequestDispatcher("/6_result.jsp");
		d.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SelectCharcterLogic sel = new SelectCharcterLogic();
		List<Player> player = new ArrayList<>();
		List<Player> Nplayer = new ArrayList<>();
		System.out.println("ここだよ");
		if(executeCount == 0) {
			catNum = 0;
			String[] play = null;
			pc = request.getParameter("participateCount");
			if(pc!= null) {
				  playerCount = Integer.parseInt(pc);
			}
			if(play == null) {
				play = request.getParameterValues("play");
				session.setAttribute("play", play);
			}
			List<Player> playerList = sel.execute();
			int in = 0;
			for(String participate:play) {
				in = Integer.parseInt(participate);
				in--;
				try{
					player.add(playerList.get(in));
				}
				catch( IndexOutOfBoundsException e ){
				e.printStackTrace();
				}
			}
			wordNum = (int) (Math.random()*440)+1;/*ワード最大数440*/
			catNum = (int) (Math.random()*playerCount);
			count = 0;
			for(Player i : player) {
				int id = i.getId();
				String name = i.getName();
				String image = i.getImage();
					SelectWordLogic logic = new SelectWordLogic();
					Word result = logic.getWord(wordNum);
					Player playeR = new Player(id, name, image, result.getWordA());
					Nplayer.add(playeR);
				if(count == catNum) {
					 logic = new SelectWordLogic();
					 result = logic.getWord(wordNum);
					 playeR = new Player(id, name, image, result.getWordB());
					Nplayer.set(catNum,playeR);
					session.setAttribute("catNum", catNum);
					int catId =Nplayer.get(catNum).getId();
					 session.setAttribute("catId",catId);
				}
				count++;
			}
			//session.setAttribute("catNum", catNum);
			session.setAttribute("Nplayer", Nplayer);
		}
		executeCount++;
		session.setAttribute("executeCount", executeCount);
		if(executeCount <= playerCount){
			RequestDispatcher d = request.getRequestDispatcher("/4_nextuser.jsp");
			d.forward(request, response);
		}else {
			executeCount = 0;
			j = (int) (Math.random()*playerCount);
			session.setAttribute("j", j);
			RequestDispatcher d = request.getRequestDispatcher("/5_game.jsp");
			d.forward(request, response);
		}
	}
}
