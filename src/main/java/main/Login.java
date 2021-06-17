package main;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    //リクエストパラメタの取得
	    String name = request.getParameter("name");
	    String pass = request.getParameter("pass");
	    
	    //Userインスタンスの生成
	    User user = new User(name, pass);
	    
	    //ログイン処理
	    LoginLogic loginLogic = new LoginLogic();
	    boolean isLogin = loginLogic.execute(user);
	    
	    // ログイン成功時、ユーザー情報をセッションスコープに保存
	    if (isLogin) {
	      HttpSession session = request.getSession();
	      session.setAttribute("loginUser", user);
	    }
	    
	    //ログイン完了画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginResult.jsp");
		dispatcher.forward(request, response);
	}
}
