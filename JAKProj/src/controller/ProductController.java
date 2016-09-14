package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.CategoryDao;
import dao.ProductDao;
import dao.PurchaseOrderDao;



public class ProductController extends HttpServlet {
       
	ProductDao dao;
	
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
		String action = request.getParameter("action");
		
		if(action != null && action.equals("chooseProduct"))
		{
			int id = Integer.parseInt(request.getParameter("code"));
			dao = new ProductDao();
			Map details = dao.getProductDetails(id);
			
			request.setAttribute("productDetails", details);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/productDetails.jsp");
			rd.forward(request, response);
			
		}		
		else if(action != null && action.equals("buyProduct"))
		{
			
			HttpSession userSes = request.getSession();
			if(userSes.getAttribute("user")!=null)
			{
				int id = Integer.parseInt(request.getParameter("productId"));
				dao = new ProductDao();
				Map details = dao.getProductDetails(id);
				
				request.setAttribute("productDetails", details);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/placeOrder.jsp");
				rd.forward(request, response);
			}
			else
			{				
				String productId = request.getParameter("productId");
				
				HttpSession session = request.getSession();
				session.setAttribute("buyProduct", productId);
				
				request.setAttribute("msg","Login to purchase product.");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
				rd.forward(request, response);
			}			
			
		}
		else if(action != null && action.equals("placeOrder"))
		{
			
			HttpSession userSes = request.getSession();
			User user = (User)userSes.getAttribute("user");
			if(user!=null)
			{
				int productId = Integer.parseInt(request.getParameter("productId"));
				long price = Long.parseLong(request.getParameter("unitPrice"));
				int quantity = Integer.parseInt(request.getParameter("qnty"));
				String shippingAddress = request.getParameter("shipAddress");	
				
				long totalPrice = price * quantity;
				
				String orderInfo = "productId:"+productId+",quantity:"+quantity+",unitPrice:"+price+",totalPrice:"+totalPrice;
				
				int customerId = user.getId();				
				
				PurchaseOrderDao poDao = new PurchaseOrderDao();
				int res = poDao.placeOrder(customerId, orderInfo, totalPrice, shippingAddress);
				
				
				if(res==1)
				{
					HttpSession session = request.getSession();
					session.setAttribute("msg","Ordedr has been placed successfully. Product will be delivered in 2-3 business days.");
				}
				
				
				response.sendRedirect(request.getContextPath()+"/navController?page=home");
				
			}
			else
			{
				request.setAttribute("msg","Login to purchase product.");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
				rd.forward(request, response);
			}			
			
		}
		else
		{
			int code = Integer.parseInt(request.getParameter("code"));
			int parentCode = Integer.parseInt(request.getParameter("parentCode"));
			dao = new ProductDao();
			List products = dao.getProducts(code, parentCode);
			
			request.setAttribute("products", products);
			
			CategoryDao catDao = new CategoryDao();
			List list = catDao.getSubCategories(code, parentCode);
			request.setAttribute("subCategories", list);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/showProducts.jsp");
			rd.forward(request, response);
		}
		
		
	}



}
