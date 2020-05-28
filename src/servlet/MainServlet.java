package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RankingDAO;
import model.Ranking;
import model.SelectScoreLogic;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//requestからセッションを取得する
		HttpSession sess = request.getSession();

		//セッションにある全ての要素名を取得する
		Enumeration vals = sess.getAttributeNames();

		//取得した要素名をループ処理で全て削除する
		while(vals.hasMoreElements()){
		  String nm = (String)vals.nextElement();
		  System.out.println(nm);
		  sess.removeAttribute(nm);
		}


		RequestDispatcher d = request.getRequestDispatcher("/1_main.jsp");
		d.forward(request, response);
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isClea = request.getParameter("hidden");
		if(!(isClea.equals("no"))) {
			RankingDAO dao = new RankingDAO();
			dao.resetRanking();
		}
		SelectScoreLogic sel = new SelectScoreLogic();
		List<Ranking> rankList = sel.execute();
		request.setAttribute("rankList", rankList);
		RequestDispatcher d = request.getRequestDispatcher("/ranking.jsp");
		d.forward(request, response);
	}
}
