package com.koitt.board.service;

import java.util.List;

import com.koitt.board.model.Authority;
import com.koitt.board.model.Users;
import com.koitt.board.model.UsersException;

public interface UsersService {
	
	public List<Users> list() throws UsersException;
	
	public Users detail(Integer no) throws UsersException;
	
	public void add(Users users) throws UsersException;
	
	public String remove(Integer no, String password) throws UsersException;
	
	public String modify(Users users) throws UsersException;
	
	// 이메일로 사용자의 모든 정보 가져오기
	public Users detailByEmail(String email) throws UsersException;
	
	// 사용자 권한 가져오기
	public Authority getAuthority(Integer id) throws UsersException; 
}
