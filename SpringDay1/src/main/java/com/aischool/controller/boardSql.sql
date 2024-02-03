-- 게시판 테이블 생성
CREATE TABLE BOARD(
	IDX INT NOT NULL AUTO_INCREMENT, -- 게시글 번호 -- 
	TITLE VARCHAR(100) NOT NULL, -- 게시글 제목--
	CONTENT VARCHAR(2000) NOT NULL, -- 게시글 내용 --
	WRITER VARCHAR(30) NOT NULL, -- 작성자 --
	INDATE DATETIME DEFAULT NOW(), -- 게시글 작성 시간 --
	COUNT INT DEFAULT 0, -- 조회수 --
	IMGPATH VARCHAR(500), -- 이미지 --
	PRIMARY KEY(IDX) -- 기본키 설정 --
);

INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('어제 한국 VS 호주 경기 본 사람?', '손흥민 너무 멋있었음', '클린스만');

INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('오늘 점심 뭐 먹을래요?', '오랜만에 kt 가고싶은데', '황해도');

INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('저는 마라탕을 제일 먹고싶어요', '인기에 예민하죠', '선영표');

INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('배드민턴 내가 ', '동네 할아버지 다', '임승환');

INSERT INTO BOARD(TITLE, CONTENT, WRITER)
VALUES('IOT 키트 사진?', '아 셀카 보내지말라고', '손동연');

SELECT * FROM BOARD;