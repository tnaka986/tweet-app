package servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import model.RegisterUserLogic;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String passConfirm = request.getParameter("passConfrim");
		
		// パスワード確認が誤ってないかチェック
		if(!pass.equals(passConfirm)) {
			
			request.setAttribute("errorMsg", "パスワードが一致しません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
			dispatcher.forward(request, response);
			
		}
		
		User user = new User(userName, pass);
		RegisterUserLogic registerUser = new RegisterUserLogic();
		
		// ユーザが既に存在していないかチェック：存在する場合TRUE
		boolean userExistFlg = registerUser.userExistCheck(user);
		if(userExistFlg) {
			
			request.setAttribute("errorMsg", "同じユーザ名が既に存在します");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
			dispatcher.forward(request, response);
			return;
			
		}
		
		// ユーザ登録
		boolean registerFlg = registerUser.execute(user);
		if(registerFlg) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			response.sendRedirect("/index.jsp");
			
		} else {
			
			request.setAttribute("errorMsg", "登録できませんでした");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerUser.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}
