package com.corejava.jdbc;

import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;

public class BatchTest {
	private static BasicDataSource dataSource;
	
	public static void batchDemo(Connection con)throws Exception{
		try{
			con.setAutoCommit(false);
			Statement stmt=con.createStatement();
			PreparedStatement ps=con.prepareStatement("insert into employee_copy values(?,?)");
			ResultSet rs1 = stmt.executeQuery("select * from employee1");
			int id;
			String name;
			while(rs1.next()){
				id=rs1.getInt("ID");
				name=rs1.getString("NAME");
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.addBatch();
			}
			int []n=ps.executeBatch();
			System.out.println("Number of rows Updated"+n);
		}catch(Exception e){
			con.rollback();
			e.printStackTrace();
		}finally{
			con.setAutoCommit(true);
		}
	}
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
		try (BasicDataSource dataSource = BatchTest.getDataSource();
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from employee_copy");){

			try(ResultSet rs=pstmt.executeQuery();){
				BatchTest.batchDemo(con);
				while(rs.next()){
					System.out.println(rs.getInt("ID") + " - " + rs.getString("NAME"));
				}
			}catch (Exception e){
				con.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}