package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.CustomerDao;



public class AuthController extends HttpServlet {

	CustomerDao dao;       
   
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
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");	
		
		if("login".equals(action))
		{
			HttpSession userSes = request.getSession();
			if(userSes.getAttribute("user")!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
				rd.forward(request, response);
			}
			else
			{
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				dao = new CustomerDao();
				boolean isValidCustomer = dao.isValidCustomer(email, password);
				
				if(isValidCustomer)
				{
					User user = dao.getUser(email);
					if(user != null)
					{
						HttpSession ses = request.getSession();
						ses.setAttribute("user",user);	
						
						String productId = (String) ses.getAttribute("buyProduct");
						
						if(productId!=null)
						{
							response.sendRedirect(request.getContextPath()+"/prodController?action=chooseProduct&code="+productId);
						}
						else
						{
							RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
							rd.forward(request, response);
						}						
						
					}					
				}
				else
				{
					request.setAttribute("result","FAIL");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
					rd.forward(request, response);
				}
				
			}			
			
		}
		else if("signup".equals(action))
		{
			String firstname = request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String email = request.getParameter("email").toLowerCase();
			String password = request.getParameter("password");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phnno = request.getParameter("phnno");
			
			
			User user = new User();
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setEmail(email);
			user.setPassword(password);
			user.setAge(age);
			user.setGender(gender);
			user.setPhone(phnno);
			
			
			dao = new CustomerDao();
			int count=dao.addNewCustomer(user);	
		
			if (count==0)
			{
			   
				User sesUser = dao.getUser(email);
				if(user != null)
				{
					HttpSession ses = request.getSession();
					ses.setAttribute("user",user);			
					RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
					rd.forward(request, response);
				}	
			}
			else
			{
				request.setAttribute("result","FAIL");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
				rd.forward(request, response);
			}
			
		}
		else if("changePwd".equals(action))
		{
			String password = request.getParameter("password");
			String newpwd = request.getParameter("newpwd");
			String cnfpwd = request.getParameter("cnfpwd");	
			
			if(newpwd.equals(cnfpwd))
			{
				HttpSession userSession = request.getSession();
				User user = (User) userSession.getAttribute("user");
				String email = user.getEmail();				
				String sesPwd = user.getPassword();
		
				if(sesPwd.equals(password))
				{
					dao = new CustomerDao();
					dao.changePassword(email, newpwd);
					
					HttpSession session = request.getSession();
					session.setAttribute("msg","Password has been changed successfully.");
					
					response.sendRedirect(request.getContextPath()+"/navController?page=home");
				}
				else
				{
					request.setAttribute("result","FAIL");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/changePwd.jsp");
					rd.forward(request, response);
				}			
				
			}
			else
			{
				request.setAttribute("result","MISMATCH");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/changePwd.jsp");
				rd.forward(request, response);
			}
			
		}
			
	}

}
