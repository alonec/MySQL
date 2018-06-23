package com.alibaba.jdbcinstance;

import java.sql.*;
/**

 * @ClassName: DBUtils

 * @Description: �������ݿ����Ӽ��رղ���

 * @author: alonex

 * @date: 2018��6��23�� ����11:25:03
 */
public class DBUtils {
	// ���ݿ����ӵ�ַ
	private static final String URL= "jdbc:mysql://127.0.0.1:3306/sqltest";
	// �û��� 
	private static final String USER= "root";
	// ����
	private static final String PASSWORD= "123456";
	// ����
	private static final String DRIVER= "com.mysql.jdbc.Driver";
	
	// 1.��������
	static {
		try {
			Class.forName(DRIVER);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. ��ȡ���ݿ������
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	// 3. �ر����ӵķ���
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 4. �ر�Ԥ������
	public static void closePreparedStatement(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 5. �رս�����ķ���
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
