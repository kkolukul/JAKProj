package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class NavController extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
			handleRequest(request,response);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
			handleRequest(request,response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		String page = request.getParameter("page");	
		
		if("login".equals(page))
		{
			HttpSession ses = request.getSession();
			if(ses.getAttribute("user")!=null)
			{				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
				rd.forward(request, response);
			}
			else
			{
				ses.invalidate();
				RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
				rd.forward(request, response);				
			}
			
		}
		else if("signup".equals(page))
		{
			HttpSession ses = request.getSession();
			if(ses.getAttribute("user")!=null)
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
				rd.forward(request, response);
			}
			else
			{
				ses.invalidate();
				RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
				rd.forward(request, response);				
			}
			
		}
		else if("changePwd".equals(page))
		{
			HttpSession ses = request.getSession();
			if(ses.getAttribute("user")!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/changePwd.jsp");
				rd.forward(request, response);
			}
			else
			{
				ses.invalidate();
				RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
				rd.forward(request, response);
			}
			
		}
		if("home".equals(page))
		{			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);				
		}
		else if("logout".equals(page))
		{
			HttpSession ses = request.getSession();
			ses.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		}
			
	}



}
