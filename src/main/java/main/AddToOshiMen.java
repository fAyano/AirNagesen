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
 * Servlet implementation class AddToOshiMen
 */
@WebServlet("/AddToOshiMen")
public class AddToOshiMen extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddToOshiMen() {
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
		//ユーザの推しメンリストに追加する
		for(Oshi oshi : oshiList) {
			if(oshiName.equals(oshi.getName())) {
				oshi.addTotalFans();
				loginUser.addNewOshi(oshi);
			}
		}
		//Main.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
		dispatcher.forward(request, response);
	}

}
