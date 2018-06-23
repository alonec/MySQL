package com.alibaba.jdbcinstance;

import java.sql.*;

public class StudentDao {
	/*
	 * 向student表插入数据
	 */
	public int addStudent(Student student) {
		int i = 0;
		StringBuffer sql = new StringBuffer();
		// 注意：sql语句后不能有分号“;”。? 相当于占位符
		sql.append("INSERT INTO student (sname, age, gender) ");
		sql.append("VALUES(?,?,?)");
		
		// 1. 拿到数据库的连接
		Connection conn = DBUtils.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			// 按类型设置字段。数字1，2，3代表sql语句中的第一个，第二个，第三个占位符(?)			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getGender());
			// 必须执行更新操作
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closePreparedStatement(ps);
			DBUtils.closeConnection(conn);
		}
		
		return i;
		
	}
	/*
	 * 更新student表的数据
	 */
	public int updateStudent(Student student) {
		int i = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE student set sname= ?,age=?,gender=? ");
		sql.append("WHERE sid = ?");
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = DBUtils.getConnection();
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1,student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getGender());
			ps.setInt(4, student.getSid());
			
			// 修改数据库的状态，插入没有主键，更新必须有主键
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closePreparedStatement(ps);
			DBUtils.closeConnection(conn);
		}
		return i;
	}
	/*
	 * 删除student表中的数据
	 */
	public int delStudent(int sid) {
		int i=0;
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM student WHERE sid = ?");
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql.toString());
			
			ps.setInt(1, sid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closePreparedStatement(ps);
			DBUtils.closeConnection(conn);
		}
		
		return i;
	}
}




