package com.train.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/train";
	private static final String USER = "root";
	private static final String PASS = "root";

	private void getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USER, PASS);
	}

	public int execueUpdate(String sql, Object... values) throws Exception {
		getConnection();
		pstmt = conn.prepareStatement(sql);
		setParameter(values);
		return pstmt.executeUpdate();
	}


	private void setParameter(Object... values) throws Exception {
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				pstmt.setObject(i + 1, values[i]);
			}
		}
	}

	public ResultSet executeQuery(String sql, Object... values) throws Exception {
		getConnection();
		pstmt = conn.prepareStatement(sql);
		setParameter(values);
		rs = pstmt.executeQuery();
		return rs;
	}

	public void close() throws Exception {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
	

}
