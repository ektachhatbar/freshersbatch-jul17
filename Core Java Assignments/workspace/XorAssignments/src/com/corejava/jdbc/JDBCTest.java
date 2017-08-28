package com.corejava.jdbc;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "system"); 
		Statement stmt = con.createStatement(); 
		/*
		stmt.executeQuery("insert into dept1 values(2,'Mary')");
		stmt.executeQuery("update dept1 set name='john' where id=1");*/
		//stmt.executeQuery("delete from dept1 where id=11");
		
		//PreparedStatement pstmt=con.prepareStatement("insert into dept1 values(?,?)");
		//pstmt.setInt(1, 11);
		//pstmt.setString(2, "Tom");
		//int n=pstmt.executeUpdate();
		//int rows = stmt.executeUpdate("create table dept_copy as SELECT * FROM DEPT1");
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT_COPY");
		while(rs.next()) { 
			System.out.println(rs.getInt("ID") + " - " + rs.getString("NAME")); 
		} 
		rs.close(); 
		stmt.close();
		con.close();


	}

}
