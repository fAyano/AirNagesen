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
import model.Oshi;
import model.User;

/**
 * Servlet implementation class CreateNewOshi
 */
@WebServlet("/CreateNewOshi")
public class CreateNewOshi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateNewOshi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CreateNewOshiResult.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String firstMoney =  request.getParameter("firstMoney");
		
		//セッションスコープからloginUserを取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		//入力された値をプロパティに設定
		Oshi oshi = new Oshi(name, Integer.parseInt(firstMoney),loginUser.getName());
		
		//アプリケーションスコープの作成,取得
		ServletContext application = this.getServletContext();
		
		//推しリストをアプリケーションスコープから取得
		@SuppressWarnings("unchecked")
		List<Oshi> oshiList = (List<Oshi>) application.getAttribute("oshiList");
		oshiList.add(oshi);
		
		//推しをoshiMenに追加する
		loginUser.addNewOshi(oshi);
		
		//貢いだ総額
		int totalMoney=Integer.valueOf(firstMoney);
		loginUser.addTotalMoney(totalMoney);
		
		//結果画面に表示する		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CreateNewOshiResult.jsp");
		dispatcher.forward(request, response);
		
	}

}
