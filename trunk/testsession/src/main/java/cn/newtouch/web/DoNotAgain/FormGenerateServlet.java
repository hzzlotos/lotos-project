package cn.newtouch.web.DoNotAgain;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormGenerateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html;charset=UTF-8");
		
		TokenProcessor.getInstance().saveToken(request);
		
		RequestDispatcher rd = request.getRequestDispatcher("donotagain/login.jsp");
		
		rd.forward(request, response);
	}
}
