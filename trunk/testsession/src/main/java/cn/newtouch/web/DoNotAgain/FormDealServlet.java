package cn.newtouch.web.DoNotAgain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormDealServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		TokenProcessor tokenProcessor = TokenProcessor.getInstance();
		
		if ( !tokenProcessor.isTokenValid(request,response, out)) {
			
			out.println("重复提交或非法提交!");
			
			return;
		}
		
		String p1 = request.getParameter("p1");
		
		if ( null == p1 || p1.trim().equals("")) {
			
			out.println("请输入内容!");
		
		} else {
		
			out.println("内容正确提交!");
		}
		
		tokenProcessor.resetToken(request);
	}
}
