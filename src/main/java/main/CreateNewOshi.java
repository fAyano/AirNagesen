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
		String userName=request.getParameter("userName");
		//
		String pass=request.getParameter("pass");
		
		//入力された値をプロパティに設定
		Oshi oshi = new Oshi(name, Integer.parseInt(firstMoney),userName);
		
		//リクエストスコープに保存
		request.setAttribute("oshi", oshi);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CreateNewOshiResult.jsp");
		dispatcher.forward(request, response);
		
		//アプリケーションスコープの作成,取得
		ServletContext application = this.getServletContext();
		
		//入力された値をプロパティに設定
		User user = new User(name, pass);
		
		List<Oshi> oshiList = null;
		
		//初回ログインの場合
		if(application.getAttribute("oshi")==null) {
			oshiList = (List<Oshi>) application.getAttribute("oshiList");
			oshiList.add(oshi);
			//アプリケーションコープに保存
			application.setAttribute("oshiList", oshiList);
			//推しをoshiMenに追加する
			
			//貢いだ総額
			int totalMoney=Integer.valueOf(firstMoney);
			user.addTotalMoney(totalMoney);
		}else {
			//２回目以降のログイン
			oshiList.add(oshi);
			//アプリケーションコープに保存
			application.setAttribute("oshiList", oshiList);
			//２回目以降のログイン
			Oshi nextOshi = (Oshi)application.getAttribute("oshi");
			//推しをoshiMenに追加する
			
			//貢いだ総額
			int totalMoney= nextOshi.getTotalMoney() + Integer.valueOf(firstMoney);
			user.addTotalMoney(totalMoney);
		}
		
		//アプリケーションコープに保存
		application.setAttribute("oshi", oshi);
		
		//結果画面に表示する
		
		
		
	}

}
