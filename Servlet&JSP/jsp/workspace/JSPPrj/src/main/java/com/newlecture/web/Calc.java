package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/calc")
public class Calc extends HttpServlet{


	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		int num1 = Integer.parseInt(request.getParameter("x"));
		int num2 = Integer.parseInt(request.getParameter("y"));
		int sum = 0;
		
		String operator = request.getParameter("operator");
		
		if(operator.equals("덧셈"))
			sum = num1+num2;
		else {
			sum = num1 - num2;
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("답은 " + sum + " 입니다.");
		
		
		
	}

}
