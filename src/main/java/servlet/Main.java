package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Mutter;
import entity.User;
import model.GetMutterListLogic;
import model.PostMutterLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
    }
    
//    public void init(ServletConfig config) throws ServletException{
//    	super.init(config);
//    	
//    	GetMutterListLogic getMutterList = new GetMutterListLogic();
//    	getMutterList.execute();
//    	
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		
		if(loginUser == null) {
			
			response.sendRedirect("/index.jsp");
			
		} else {
			
			GetMutterListLogic getMutterList = new GetMutterListLogic();
			request.setAttribute("mutterList", getMutterList.execute());;
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String inputMutter = request.getParameter("inputMutter");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 9);
        Date date = calendar.getTime();
        Timestamp timestamp = Timestamp.valueOf(sdf.format(date));
		
		Mutter mutter = new Mutter(inputMutter, user, timestamp);
	
		PostMutterLogic postMutter = new PostMutterLogic();
		
		boolean isInsert = postMutter.execute(mutter);
		
		if(isInsert) {
			
			response.sendRedirect("/Main");
			
		} else {
			
			request.setAttribute("errorMsg", "投稿できませんでした");
			response.sendRedirect("/Main");
			
		}
	
	}

}
