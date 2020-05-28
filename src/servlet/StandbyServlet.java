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


@WebServlet("/StandbyServlet")
public class StandbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelectCharcterLogic sel = new SelectCharcterLogic();
		List<Player> playerList = sel.execute();
		request.setAttribute("playerList", playerList);
		RequestDispatcher d = request.getRequestDispatcher("/2_standby.jsp");
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String[] play = null;
		play = request.getParameterValues("play");
		session.setAttribute("play[]", play);
		SelectCharcterLogic sel = new SelectCharcterLogic();
		List<Player> playerList = sel.execute();
		List<Player> participateList = new ArrayList<>();
		int i =0;
		for(String participate:play) {
			i = Integer.parseInt(participate);
			i--;
			try{
				participateList.add(playerList.get(i));
			}
		        catch( IndexOutOfBoundsException e ){
		        	e.printStackTrace();
		        }
		}
		request.setAttribute("participateList", participateList);
		RequestDispatcher d = request.getRequestDispatcher("/3_standbyok.jsp");
		d.forward(request, response);
	}
}
