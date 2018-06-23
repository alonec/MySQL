package com.alibaba.jdbcinstance;

import java.sql.*;
/**

 * @ClassName: DBUtils

 * @Description: 用于数据库连接及关闭操作

 * @author: alonex

 * @date: 2018年6月23日 上午11:25:03
 */
public class DBUtils {
	// 数据库连接地址
	private static final String URL= "jdbc:mysql://127.0.0.1:3306/sqltest";
	// 用户名 
	private static final String USER= "root";
	// 密码
	private static final String PASSWORD= "123456";
	// 驱动
	private static final String DRIVER= "com.mysql.jdbc.Driver";
	
	// 1.加载驱动
	static {
		try {
			Class.forName(DRIVER);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. 获取数据库的连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	// 3. 关闭连接的方法
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 4. 关闭预处理方法
	public static void closePreparedStatement(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 5. 关闭结果集的方法
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
