package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	// db Test 파일을 사용하겠디
	private final String DB_ID = "root";
	private final String DB_PWD = "admin";
	
//	public ConnectionTest() {
//		// Class를 읽고 메모리에 올리는 역할을 한다. 
//		try {
//			Class.forName(DRIVER);
//			System.out.println("드라이버 로딩 성공!!");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//	} => JDK 1.6 이상 , JDBC 4 이상 -> 드라이버 안써도 가능 
	
	private void connect() {
		try {
			Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
			System.out.println("DB 연결 선공!!");
			// Connection 객체를 만들어내는 방법 
			// getConnection -> SQL Exception을 만들어 냄 => Compile Error -> try catch
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}
}
