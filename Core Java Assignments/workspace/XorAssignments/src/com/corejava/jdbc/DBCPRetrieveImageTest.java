package com.corejava.jdbc;

import java.io.*;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPRetrieveImageTest {
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

		try (BasicDataSource dataSource = DBCPRetrieveImageTest.getDataSource();
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from imgtable");){

			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){ 
		            Blob b=rs.getBlob(2); 
					byte barr[]=b.getBytes(1,(int)b.length()); 
					FileOutputStream fout=new FileOutputStream("d:\\img2.jpg");  
					fout.write(barr);  
					fout.close();  
				}
				System.out.println("Image Retrieved");
			}catch (Exception e){
				con.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
