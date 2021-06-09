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

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Logout() {
		
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	request.logout();
    	//ログアウト完了画面にフォワード
        RequestDispatcher dispatch = request.getRequestDispatcher("/LogoutResult.jsp");
    	dispatch.forward(request, response);
    }
}
