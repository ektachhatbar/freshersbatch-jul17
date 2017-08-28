package com.corejava.jdbc;

import java.io.*;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPStoreImageTest {
	private static BasicDataSource dataSource;

	private static BasicDataSource getDataSource() {
		if (dataSource == null) {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUsername("system");
			ds.setPassword("system");
			ds.setMaxIdle(10);
			dataSource = ds;
		}
		return dataSource;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (BasicDataSource dataSource = DBCPStoreImageTest.getDataSource();
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into imgtable values(?,?)");) {

			try{
				pstmt.setString(1,"Image1");
				File file=new File("img1.png");
				FileInputStream fis=new FileInputStream(file);
				pstmt.setBinaryStream(2,fis,file.length());;
				int i=pstmt.executeUpdate();  
				System.out.println(i+" Image Stored");
			}catch (Exception e){
				con.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
