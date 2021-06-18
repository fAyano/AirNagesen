package main;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Oshi;
import model.User;

/**
 * Servlet implementation class DeleteOshiMen
 */
@WebServlet("/DeleteOshiMen")
public class DeleteOshiMen extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteOshiMen() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータから値を取得
		String oshiName = request.getParameter("oshiName");
		//ユーザをセッションスコープから取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		//推しリストをアプリケーションセッションから取得
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList"); 
		//ユーザの推しメンリストから除外する
		List<Oshi> oshiMen = (List<Oshi>) loginUser.getOshiMen();
		int index = 0;
		for(Oshi oshi : oshiMen) {
			if(oshiName.equals(oshi.getName())) {
				oshi.decreaseTotalFans();
				loginUser.removeOshi(index);
				break;
			}
			index++;
		}
		request.setAttribute("isSuccessfulDeleteOshi", true);
		//Main.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
