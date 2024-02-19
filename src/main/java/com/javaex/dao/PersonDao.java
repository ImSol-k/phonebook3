package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.PersonVo;

public class PersonDao {

	PersonVo personVo = new PersonVo();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void getConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");			
			String url = "jdbc:mysql://localhost:3306/phone_db";
			conn = DriverManager.getConnection(url, "phone", "phone");
			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}
	
	public void personSelect() {
		getConnection();
		
		List<PersonVo> personList = new ArrayList<PersonVo>();
		
		try {
			
			String query = "";
			query += " select person_id, name, ph, company";
			query += " from person";
			
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int getPsId = rs.getInt("person_id");
				String getPsName = rs.getString("name");
				String getPsPh = rs.getString("ph");
				String getPsCompany = rs.getString("company");
				
				PersonVo personVo = new PersonVo(getPsId, getPsName, getPsPh, getPsCompany);
				//System.out.println(personVo);
			}
			
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	public void personInsert(PersonVo vo) {
		getConnection();
		
		try {
			
			String query = "";
			query += " insert into person ";
			query += " values (null, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPh());
			pstmt.setString(3, vo.getCompany());
			
			pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

}
