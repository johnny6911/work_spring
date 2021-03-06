package com.koitt.book.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.koitt.book.model.FileException;
import com.koitt.book.model.Users;
import com.koitt.book.model.UsersException;
import com.koitt.book.service.FileService;
import com.koitt.book.service.UsersService;


@Controller
public class UsersWebController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private FileService<Users> fileService;
	
	// 사용자 목록
	@RequestMapping(value="/users-list.do", method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest req) {
		List<Users> list = null;
		
		try {
			list = usersService.list();
			
		} catch (UsersException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("list", list);
		model.addAttribute("uploadPath", fileService.getUploadPath(req));
		
		return "admin/users-list";
	}
	
	// 가입 화면으로 이동
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	// 사용자 추가 (가입하기 화면에서 전달받은 값으로 사용자 생성)
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(HttpServletRequest req,
			String email,
			String password,
			String name,
			@RequestParam("attachment") MultipartFile attachment) throws UnsupportedEncodingException {
		
		// 클라이언트로 전달받은 값으로 객체 생성
		Users users = new Users(null, email, password, name, null);
		
		try {
			// 프로필 사진 저장
			String filename = fileService.add(req, attachment);
			
			// 프로필 사진
			users.setAttachment(filename);
			
			// 데이터베이스에 사용자 추가
			usersService.add(users);
		
			String encodedName = URLEncoder.encode(users.getName(), "UTF-8");

			// 가입 환영 페이지로 이동
			return "redirect:join-confirm.do?name=" + encodedName;
		
		} catch (FileException e) {
			System.out.println(e.getMessage());
			req.setAttribute("error", "file");
		} catch (UsersException e) {
			System.out.println(e.getMessage());
			req.setAttribute("error", "server");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			req.setAttribute("error", "encoding");
		}
		
		// 가입 시 문제가 발생하면 index.html로 이동
		return "redirect:index.html";
	}
	
	// 가입 확인 페이지
	@RequestMapping(value="/join-confirm.do", method=RequestMethod.GET)
	public String joinConfirm(Model model, String name) {
		model.addAttribute("name", name);
		return "join-confirm";
	}
}







