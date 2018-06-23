package com.alibaba.jdbcinstance;

import org.junit.Test;

public class TestStudentDao {
	// 可以写很多的测试方法而且每个测试方法可以独立运行
	// junit 3 测试方法的要求 没有返回值  方法名必须以test开头
	// junit 4 测试方法必须使用注解来标名方法名可以不以test开头 也没有返回值
	static StudentDao studentDao = new StudentDao();
	@Test
	public void testadd() {
		// 给student设置要insert的字段
		Student student = new Student();
		student.setName("陈");
		student.setAge(18);
		student.setGender("male");
		
		// 利用数据访问对象进行insert
		studentDao.addStudent(student);
	}
	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setName("刘");
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

