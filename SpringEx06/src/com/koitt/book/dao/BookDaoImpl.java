package com.koitt.book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.koitt.book.model.Book;
import com.koitt.book.model.BookException;

@Repository
public class BookDaoImpl implements BookDao{

	private static final String MAPPER_NS = Book.class.getName();
	
	@Autowired
	private SqlSession session;
	
	public BookDaoImpl() {}
	
	@Override
	public void insert(Book book) throws BookException {
		try {
			session.insert(MAPPER_NS + ".insert-book", book);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BookException(e.getMessage());
		}
	}

	@Override
	public Book select(String isbn) throws BookException {
		Book book = null;
		
		try {
			book = session.selectOne(MAPPER_NS + ".select-book", isbn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BookException(e.getMessage());
		}
		
		return book;
	}

	@Override
	public List<Book> selectAll() throws BookException {
		List<Book> list = null;
		
		try {
			list = session.selectList(MAPPER_NS + ".select-all-book");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BookException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public int bookCount() throws BookException {
		Integer result1 = null;
		
		try {
			result1 = session.selectOne(MAPPER_NS + ".select-count-book");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BookException(e.getMessage());
		}
		
		return result1;
	}

	@Override
	public void update(Book book) throws BookException {
		try {
			session.update(MAPPER_NS + ".update-book", book);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BookException(e.getMessage());
		}
	}

	@Override
	public void delete(String isbn) throws BookException {
		try {
			session.delete(MAPPER_NS + ".delete-book", isbn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BookException(e.getMessage());
		}
	}

}
