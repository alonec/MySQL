package com.alibaba.jdbcinstance;

import java.sql.*;

public class StudentDao {
	/*
	 * ��student���������
	 */
	public int addStudent(Student student) {
		int i = 0;
		StringBuffer sql = new StringBuffer();
		// ע�⣺sql�������зֺš�;����? �൱��ռλ��
		sql.append("INSERT INTO student (sname, age, gender) ");
		sql.append("VALUES(?,?,?)");
		
		// 1. �õ����ݿ������
		Connection conn = DBUtils.getConnection();
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			// �����������ֶΡ�����1��2��3����sql����еĵ�һ�����ڶ�����������ռλ��(?)			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setString(3, student.getGender());
			// ����ִ�и��²���
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
	 * ����student�������
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
			
			// �޸����ݿ��״̬������û�����������±���������
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
	 * ɾ��student���е�����
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




