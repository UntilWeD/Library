package com.newlecture.web.controller.admin.notice;

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

@WebServlet("/admin/board/notice/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		String cmd = request.getParameter("cmd");
		
		switch (cmd) {
			case "일괄공개": 
				for(String openId : openIds)
					System.out.printf("opend id : %s \n", openId);			
				break;
			case "일괄삭제":
				NoticeService service = new NoticeService();
				int[] ids = new int[delIds.length];
				for(int i=0; i < delIds.length; i++) {
					ids[i] = Integer.parseInt(delIds[i]);
				}
				
				service.deleteNoticeAll(ids);	
				break;
				
		}
		
		response.sendRedirect("list");
		
	}
	
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
		list = noticeService.getNoticeList(field, query, page);
		
		request.setAttribute("list", list);
		request.setAttribute("count", pageCount);
		
		System.out.println("count = " + pageCount);
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp")
		.forward(request, response);
	    
	}

}
