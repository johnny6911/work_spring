package com.koitt.test;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class Example {

	private MessageSource messages; //메세지소스의 객체에서 가져옴

	public void setMessages(MessageSource messages) {
		this.messages =messages;
	}

	public void execute() {
		String message01 = 
				this.messages.getMessage("greeting", null, "Hello", Locale.KOREAN); // 
		
		String message02 =
				this.messages.getMessage("argument.required", new Object[]{"Apple"},// 해당하는 값이 없으면(아규먼트 리콰이어드)가 없으면 banana를 출력함
						"Banana", Locale.KOREAN);
		System.out.println(message01);
		System.out.println(message02);
	}
}
