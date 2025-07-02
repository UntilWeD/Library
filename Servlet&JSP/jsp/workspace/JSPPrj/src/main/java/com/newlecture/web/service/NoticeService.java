package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
	
	
	public List<Notice> getNoticeList(){
		
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page){
		
		return getNoticeList("title", "", page);
		
	}
	
	public List<Notice> getNoticeList(String field, String query, int page){
		List<Notice> list = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		String sql =     
				"SELECT * FROM ( " +
			    "   SELECT ROW_NUMBER() OVER (ORDER BY regdate DESC) AS rownum, notice.* " +
			    "   FROM notice " +
			    "   WHERE " + field + " LIKE ? " +
			    ") AS ranked " +
			    "WHERE rownum BETWEEN ? AND ?";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page * 10);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("Id");
				String title = rs.getString("TITLE");
				Date regDate =rs.getDate("REGDATE");
				String writerId =rs.getString("WRITER_ID");
				String hit =rs.getString("HIT");
				String files =rs.getString("FILES");
				String content =rs.getString("CONTENT"); 
				
				Notice notice = new Notice(
							id,
							title,
							writerId,
							regDate,
							hit,
							files,
							content
				);
				list.add(notice);
			}
			
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
		
	}
	
	public int getNoticeCount() {
		
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		int count = 0;
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		String sql =     
				"SELECT COUNT(ID) AS COUNT FROM ( " +
			    "   SELECT ROW_NUMBER() OVER (ORDER BY regdate DESC) AS rownum, notice.* " +
			    "   FROM notice " +
			    "   WHERE " + field + " LIKE ? " +
			    ") AS ranked ";
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%" + query + "%");

			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				count = rs.getInt("count");  
			
			
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}
	
	
	
	public Notice getNotice(int id){
		Notice notice = null;
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		String sql = "SELECT * FROM notice WHERE ID = ?";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("TITLE");
				Date regDate =rs.getDate("REGDATE");
				String writerId =rs.getString("WRITER_ID");
				String hit =rs.getString("HIT");
				String files =rs.getString("FILES");
				String content =rs.getString("CONTENT"); 
				
				notice = new Notice(
						nid,
						title,
						writerId,
						regDate,
						hit,
						files,
						content
				);
			}
			
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notice;
	}
	
	public Notice getNextNotice(int id){
		Notice notice = null;
		String sql = "SELECT * FROM notice WHERE ID > ? ORDER BY REGDATE ASC LIMIT 1";
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("TITLE");
				Date regDate =rs.getDate("REGDATE");
				String writerId =rs.getString("WRITER_ID");
				String hit =rs.getString("HIT");
				String files =rs.getString("FILES");
				String content =rs.getString("CONTENT"); 
				
				notice = new Notice(
						nid,
						title,
						writerId,
						regDate,
						hit,
						files,
						content
				);
			}
			
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return notice;
	}
	
	public Notice getPrevNotice(int id){
		Notice notice = null;
		String sql = "SELECT * FROM notice WHERE ID < ? ORDER BY REGDATE DESC LIMIT 1";
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				int nid = rs.getInt("Id");
				String title = rs.getString("TITLE");
				Date regDate =rs.getDate("REGDATE");
				String writerId =rs.getString("WRITER_ID");
				String hit =rs.getString("HIT");
				String files =rs.getString("FILES");
				String content =rs.getString("CONTENT"); 
				
				notice = new Notice(
						nid,
						title,
						writerId,
						regDate,
						hit,
						files,
						content
				);
			}
			
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notice;
	}
	
}
