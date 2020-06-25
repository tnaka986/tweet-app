CREATE DATABASE tweetapp;
use tweetapp;

-- USERテーブルを作成
CREATE TABLE USER(
	user_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL,
	email VARCHAR(32)
);

-- MUTTERテーブルを作成
CREATE TABLE MUTTER(
	mutter_no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(128) NOT NULL,
	user_no INT,
	post_date TIMESTAMP,
	FOREIGN KEY(user_no) REFERENCES USER(user_no)
);

INSERT INTO USER (user_name, password)
	VALUES('tnakagawa','tnakagawa');

INSERT INTO MUTTER (content, user_no, post_date)
	VALUES('初期データです',1,'2020-06-18 12:00:00');