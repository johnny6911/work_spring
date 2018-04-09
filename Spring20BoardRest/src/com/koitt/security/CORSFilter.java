package com.koitt.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("corsFilter")
public class CORSFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CORSFilter ���� ... ");
		HttpServletResponse resp = (HttpServletResponse) response;
		/*
		 * �Ʒ��� Header ���� ������ �ٸ� Ŭ���̾�Ʈ�� ������ ��û�� ��
		 * ����ϴ� ������ �����ϴ� �����̴�
		 */
		
		// ����� Ŭ���̾�Ʈ�� IP �ּҸ� �ۼ�, * ���� ��� Ŭ���̾�Ʈ�� ������ �Ͽ��Ѵٴ� ��
		resp.setHeader("Access-Control-Allow-Origin", "*"); // �ش� Ŭ���̾�Ʈ�� �츮������ ���� ����ϰڴٴ� ��
		
		// Credemtial�� ID�� ��й�ȣ ���� Base64 ���ڵ��� ���� �ǹ�, ����� ���̱� ������ true
 		resp.setHeader("Access-Control-Allow-Credentials", "true");
 		
 		// HTTP Method�� �� ����� HTTP Method�� �ۼ�, �� ����Ʈ ǲ ����Ʈ�� ����Ѵٴ°� �ɼ����
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		
		// 1�ð����� ��û�� ��ȿ�� ������ ����
		resp.setHeader("Access-Control-Max-Age", "3600");
		
		// ����ϴ� ����� ����� �ۼ�
		resp.setHeader("Access-Control-Allow-Headers", 
				"X-Requested-With, Content-Type, Authorization, "
				+ "Origin, Accept, Access-Control-Request-Method, "
				+ "Access-Control-Request-Headers");
		chain.doFilter(request, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
