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

@WebServlet("/add2")
public class Add2 extends HttpServlet{


	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String[] nums = request.getParameterValues("nums");
		
		int sum = 0;
		for(String str : nums) {
			sum += Integer.parseInt(str);
		}
		
		
		PrintWriter writer = response.getWriter();
		writer.println("답은 " + sum + " 입니다.");
		
		
		
	}

}
