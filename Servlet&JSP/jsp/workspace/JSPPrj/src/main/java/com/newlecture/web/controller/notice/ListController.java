package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "title";
		if(field_ != null && !field_.equals(""))
			field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		

		
		NoticeService noticeService = new NoticeService();
		
		List<NoticeView> list = new ArrayList<>();
		int pageCount = noticeService.getNoticeCount();
		list = noticeService.getNoticePubList(field, query, page);
		
		request.setAttribute("list", list);
		request.setAttribute("count", pageCount);
		
		System.out.println("count = " + pageCount);
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
		.forward(request, response);
	    
	}

}
