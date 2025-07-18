package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	
	public int removeNoticeAll(int[] ids) {
		
		return 0;
	}
	
	public int pubNoticeAll(int[] oids, int[] cids) {
		
		List<String> oidsList = new ArrayList<>();
		for(int i=0; i<oids.length; i++)
			oidsList.add(String.valueOf(oids[i]));
		
		List<String> cidsList = new ArrayList<>();
		for(int i=0; i<cids.length; i++)
			cidsList.add(String.valueOf(cids[i]));
		
		return pubNoticeAll(oidsList, cidsList);
	}
	
	public int pubNoticeAll(List<String> oids, List<String> cids) {
		String oidsCSVString = String.join(",", oids);
		String cidsCSVString = String.join(",", cids);
		
		return pubNoticeAll(oidsCSVString, cidsCSVString);
	}
	
	
	// 
	public int pubNoticeAll(String oidsCSV, String cidsCSV) {
		
		int result = 0;
		
		String sqlOpen = String.format("UPDATE NOTICE SET PUB=1 WHERE ID IN (%s)", oidsCSV);
		String sqlClose = String.format("UPDATE NOTICE SET PUB=0 WHERE ID IN (%s)", cidsCSV);
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			
			Statement stOpen = con.createStatement();
			result += stOpen.executeUpdate(sqlOpen);

			Statement stClose = con.createStatement();
			result += stClose.executeUpdate(sqlClose);

			stOpen.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		

	}
	
	public int insertNotice(Notice notice) {
		int result = 0;
		
		
		String sql = "INSERT INTO NOTICE(TITLE, CONTENT, WRITER_ID, PUB, FILES) VALUES (?, ?, ?, ?, ?)";
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setBoolean(4, notice.getPub());
			st.setString(5, notice.getFiles());
			
			result = st.executeUpdate();

			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteNotice(int id) {
		
		
		return 0;
	}
	
	public int updateNotice(Notice notice) {
		return 0;
	}
	
	public List<NoticeView> getNoticeNewestList(){
		
		return getNoticeList("title", "", 1);
	}
	
	
	public List<NoticeView> getNoticePubList(String field, String query, int page) {
		List<NoticeView> list = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		String sql =     
				"SELECT * FROM ( " +
			    "   SELECT ROW_NUMBER() OVER (ORDER BY regdate DESC) AS rownum, v.* " +
			    "   FROM notice_view v " +
			    "   WHERE " + field + " LIKE ? " +
			    ") AS ranked " +
			    "WHERE PUB = 1 AND rownum BETWEEN ? AND ?";
		
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
				int cmtCount = rs.getInt("CMT_COUNT");
				Boolean pub = rs.getBoolean("PUB");
					
				
				NoticeView notice = new NoticeView(
							id,
							title,
							writerId,
							regDate,
							hit,
							files,
							pub,
							cmtCount
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
	
	public List<NoticeView> getNoticeList(){
		
		return getNoticeList("title", "", 1);
	}
	
	public List<NoticeView> getNoticeList(int page){
		
		return getNoticeList("title", "", page);
		
	}
	
	public List<NoticeView> getNoticeList(String field, String query, int page){
		List<NoticeView> list = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		String sql =     
				"SELECT * FROM ( " +
			    "   SELECT ROW_NUMBER() OVER (ORDER BY regdate DESC) AS rownum, v.* " +
			    "   FROM notice_view v " +
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
				int cmtCount = rs.getInt("CMT_COUNT");
				Boolean pub = rs.getBoolean("PUB");
					
				
				NoticeView notice = new NoticeView(
							id,
							title,
							writerId,
							regDate,
							hit,
							files,
							pub,
							cmtCount
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
				Boolean pub = rs.getBoolean("PUB");
				
				notice = new Notice(
						nid,
						title,
						writerId,
						regDate,
						hit,
						files,
						content,
						pub
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
				Boolean pub = rs.getBoolean("PUB");
				
				notice = new Notice(
						nid,
						title,
						writerId,
						regDate,
						hit,
						files,
						content,
						pub
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
				Boolean pub = rs.getBoolean("PUB");
				
				notice = new Notice(
						nid,
						title,
						writerId,
						regDate,
						hit,
						files,
						content,
						pub
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

	public void deleteNoticeAll(int[] ids) {
		int result = 0;
		String params = "";
		
		for(int i = 0; i < ids.length; i++) {
			params += ids[i];
			
			if( i < ids.length-1)
				params += ",";
		}
		
		String sql = "DELETE NOTICE WHERE ID IN ("+params+")";
		
		String url = "jdbc:mysql://localhost:3306/newlec?useSSL=false&serverTimezone=UTC";
		String dbId = "root";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, "root", "1234");
			Statement st = con.createStatement();
			
			result = st.executeUpdate(sql);

			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
