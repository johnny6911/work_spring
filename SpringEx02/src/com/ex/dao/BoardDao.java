package com.ex.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.model.Board;


@Repository
public class BoardDao {
	
	@Autowired
	private SqlSessionFactory factory;
	private SqlSession session; // sql세션 객체를 직접가져오기에 닫을 필요가 없음, 해당 방법이 편함
	
	public Board getBoard(Integer no) {
		SqlSession session = factory.openSession();
		Board board = session.selectOne("com.ex.model.Board.select", no);
		session.close();
		return board;
	}
	
	public Board getBoard1(Integer no) {
		 Board board1 = session.selectOne("com.ex.model.Board.select", no);	

		 return board1;
	}
}
