#DDL (Data Definition Language)
DROP TABLE book;
DROP TABLE users;

CREATE TABLE users (
	no			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(255) NOT NULL,
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	attachment	VARCHAR(255),
	UNIQUE (email)
	
);

INSERT INTO users (email, password, name, attachment)
	VALUES ('teachertophoon@gmail.com', '1234', '정상훈', NULL);
	
INSERT INTO users (email, password, name, attachment)
	VALUES ('gildong@gmail.com', '5678', '홍길동', NULL);
	
INSERT INTO users (email, password, name, attachment)
	VALUES ('younghee@gmail.com', '7788', '김영희', NULL);


CREATE TABLE book (
	isbn INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(30) NOT NULL,
	author VARCHAR(30) NOT NULL,
	publisher VARCHAR(30) NOT NULL,
	user_no INT NOT NULL,
	price INT NOT NULL,
	description VARCHAR(255) NULL,
	FOREIGN KEY (user_no) REFERENCES users(no)
);
INSERT INTO book (user_no, title, author, publisher, price, description)
	VALUES (1, '드래곤볼', '토리야마', '반다이', 20000, '찾아라 드래곤볼ㅋ');

INSERT INTO book (user_no,title, author, publisher, price, description)
	VALUES (2, '나루토', '일본', '반다이', 10000, '닌자와 여행');

INSERT INTO book (user_no,title, author, publisher, price, description)
	VALUES (3, '원피스', '일본', '반다이', 18000, '보물을 찾아서');
#DQL
SELECT * FROM book;