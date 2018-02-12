package com.koitt.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koitt.model.Employee;

@Repository // 임플로이다오에서 빈(bean)객체를 이제 만들수가 있음
public class EmployeeDao {

	@Autowired // 기존의 만든 빈(bean)이랑 필드랑 연결시키고 싶을때는 오토와이어드를 넣어줌
	private SqlSessionFactory factory;
	
	public Employee getEmployee(int empno) {
		SqlSession session = factory.openSession();
		Employee emp = session.selectOne("com.koitt.model.Employee.select", empno);
		session.close();
		
		return emp;
	}
}
