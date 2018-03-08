package com.koitt.service;

import com.koitt.model.Users;

public interface MailService {
	public void sendEmail(final Users user); // final은 있어도되고 없어도됨, final은 안에있는 내용을 바꾸면 안되는다는것을 표기해주기위해
	
}
