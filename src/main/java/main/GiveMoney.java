package main;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.*;
import java.util.*;

/**
 * Servlet implementation class GiveMoney
 */
@WebServlet("/GiveMoney")
public class GiveMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public GiveMoney() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力された値が正しいかどうか
		boolean isCollect = true;

		try {			
			//リクエストパラメータから値を取得
			request.setCharacterEncoding("UTF-8");
			String oshiName = request.getParameter("oshiName");
			int money = Integer.valueOf(request.getParameter("money"));
			
			//ユーザをセッションスコープから取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//推しリストをアプリケーションセッションから取得
			ServletContext application = this.getServletContext();
			@SuppressWarnings("unchecked")
			List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList"); 
			
			//ユーザの総貢ぎ額を更新
			loginUser.addTotalMoney(money);
			
			//推しの総貢がれ額を更新
			for(Oshi oshi : oshiList) {
				if(oshiName.equals(oshi.getName())) {
					oshi.addTotalMoney(money);
				}
			}

		} catch (NumberFormatException e) {
			isCollect = false;
		} finally {
			//正しい値かどうかをリクエストスコープに保存
		     request.setAttribute("isCollect", isCollect);
		     
			//Main.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
			dispatcher.forward(request, response);
		}


	}

}

