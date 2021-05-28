package main;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Oshi;

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
		String name = request.getParameter("name");
		String firstMoney =  request.getParameter("firstMoney");
		
		//入力された値をプロパティに設定
		Oshi oshi = new Oshi();
		oshi.setName(name);
		oshi.addTotalMoney(Integer.parseInt(firstMoney));
		
		//リクエストスコープに保存
		request.setAttribute("oshi", oshi);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CreateNewOshiResult.jsp");
		dispatcher.forward(request, response);
		
	}

}
