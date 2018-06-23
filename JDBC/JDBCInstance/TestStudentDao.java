package com.alibaba.jdbcinstance;

import org.junit.Test;

public class TestStudentDao {
	// ����д�ܶ�Ĳ��Է�������ÿ�����Է������Զ�������
	// junit 3 ���Է�����Ҫ�� û�з���ֵ  ������������test��ͷ
	// junit 4 ���Է�������ʹ��ע�����������������Բ���test��ͷ Ҳû�з���ֵ
	static StudentDao studentDao = new StudentDao();
	@Test
	public void testadd() {
		// ��student����Ҫinsert���ֶ�
		Student student = new Student();
		student.setName("��");
		student.setAge(18);
		student.setGender("male");
		
		// �������ݷ��ʶ������insert
		studentDao.addStudent(student);
	}
	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setName("��");
		student.setAge(20);
		student.setGender("m");
		student.setSid(7);
		
		studentDao.updateStudent(student);
	}
	@Test
	public void testDelStudent() {
		int i = studentDao.delStudent(1);
		System.out.println(i);
		
	}
}

