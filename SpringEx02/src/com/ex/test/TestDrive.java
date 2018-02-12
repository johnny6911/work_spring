package com.ex.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ex.dao.BoardDao;
import com.ex.model.Board;

public class TestDrive {
	public static void main(String[] args) {
		ApplicationContext context =
				new GenericXmlApplicationContext("/com/ex/config/config.xml");
		
		BoardDao dao1 = context.getBean(BoardDao.class);
		Board board1 = dao1.getBoard(2);
		System.out.println(board1);
		
		BoardDao dao2 = context.getBean(BoardDao.class);
		Board board2 = dao2.getBoard(1);
		System.out.println(board2);
	}
}
