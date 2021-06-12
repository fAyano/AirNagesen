package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Main() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//推しリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
		
		//もしリストが取得できなかった(nullだった)ら推しリストを新規作成してアプリケーションスコープに保存する
		if(oshiList == null) {
			oshiList = new ArrayList<>();
			application.setAttribute("oshiList", oshiList);
		}
		
		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		//ログインしてない場合はトップ画面にリダイレクト
		if(loginUser == null) {
			response.sendRedirect("/AirNagesen");
		}else {
			//ログインしていたらMain.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
			dispatcher.forward(request, response);
		}

	}

}
