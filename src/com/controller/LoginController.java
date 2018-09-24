package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;
import com.to.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=new User();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		LoginDAO dao=new LoginDAO();
		RequestDispatcher rd=null;
		if(dao.isValidUser(u))
		{
			// not sesssion is created only once in the flow true only once. 
			// rest all session will be false otherwise values will be lost. 
			HttpSession session=request.getSession(true);
			session.setAttribute("user", u);
			/*rd=request.getRequestDispatcher("welcome.html");
			//rd.forward(request, response);*/
			//response.sendRedirect("welcome.html");
			PrintWriter out=response.getWriter();
			rd=request.getRequestDispatcher("welcome.html");
			rd.include(request, response);
			ServletContext ctx=getServletContext();  
	        int t=(Integer)ctx.getAttribute("totalusers");  
	        int c=(Integer)ctx.getAttribute("currentusers");  
	        out.print("<br>total users= "+t);  
	        out.print("<br>current users= "+c);  
	        out.print("<br><a href='logout'>logout</a>");  
	        out.close();  
			
		}else
		{
			PrintWriter out=response.getWriter();
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			out.print("<center><span style='color:red;'>Invalid username/password</span></center>");
		}
	}

}
