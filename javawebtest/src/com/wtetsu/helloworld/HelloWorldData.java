package com.wtetsu.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloWorldData {

	public List<Map<String, Object>> readCustomerRecords() {
		List<Map<String, Object>> result = null;
		
		try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("/mybatis-config.xml")) {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

            try (SqlSession session = factory.openSession()) {
            	result = session.selectList("sample.mybatis.selectTest");
            }
        } catch (IOException e) {
			throw new RuntimeException(e);
		}
        return result;
	}
	
//	private String readDataByRawJdbc() {
//		try {
//		    Class.forName("com.mysql.jdbc.Driver");
//		} 
//		catch (ClassNotFoundException e) {
//		    e.printStackTrace();
//		} 
//		
//		String name = "";
//		
//		Connection conn = null;
//		try {
//			try {
//				conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=manager");
//				
//				String query = "select * from customer";
//				Statement stmt = conn.createStatement();
//		        ResultSet rs = stmt.executeQuery(query);
//		        while (rs.next()) {
//		        	name += rs.getString("customer_id");
//		        	name += rs.getString("customer_name");
//		        }				
//			} finally {
//				if (conn != null) {
//					conn.close();
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return name;
//	}
}
