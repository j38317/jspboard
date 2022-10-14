DROP SEQUENCE MVCBD_SEQ;
DROP TABLE MVCBOARD;

CREATE SEQUENCE MVCBD_SEQ NOCACHE;

create table MVCBOARD(
	BD_NO NUMBER PRIMARY KEY,
	BD_NAME VARCHAR2(100) NOT NULL,
	BD_TITLE VARCHAR2(200) NOT NULL,
	BD_CONTENT VARCHAR2(4000) NOT NULL,
	BD_DATE DATE NOT NULL
);

INSERT INTO MVCBOARD VALUES(MVCBD_SEQ.NEXTVAL, '이름1', '제목 MVC', '글 내용 MVC 테스트 중', SYSDATE);

SELECT * FROM MVCBOARD;
-------------------------------- 회원관리
DROP SEQUENCE BDNO_SEQ;
DROP TABLE BDMEMBER;

CREATE SEQUENCE BDNO_SEQ NOCACHE;

CREATE TABLE BDMEMBER(
	BM_NO NUMBER NOT NULL,
	BM_ID VARCHAR2(500) NOT NULL,
	BM_PW VARCHAR2(500) NOT NULL,
	BM_NAME VARCHAR2(1000) NOT NULL,
	BM_ADDR VARCHAR2(4000) NOT NULL,
	BM_PHONE VARCHAR2(4000) NOT NULL,
	BM_EMAIL VARCHAR2(100) NOT NULL,
	BM_ENABLED VARCHAR2(2) NOT NULL,
	BM_ROLE VARCHAR2(50) NOT NULL,
	CONSTRAINT BDMEMBER_PK PRIMARY KEY(BM_NO),
	CONSTRAINT BDMEMBER_UQ_ID UNIQUE(BM_ID),
	CONSTRAINT BDMEMBER_UQ_PHONE UNIQUE(BM_PHONE),
	CONSTRAINT BDMEMBER_UQ_EMAIL UNIQUE(BM_EMAIL),
	CONSTRAINT BDMEMBER_ENABLED_CHK CHECK(BM_ENABLED IN('Y','N'))
);

INSERT INTO BDMEMBER VALUES(BDNO_SEQ.NEXTVAL, 'ADMIN', 'ADMIN00', '관리자', '서울시 종로구', '010-1111-1111', 'BD_ADMIN@MEMBER.COM', 'Y', 'ADMIN');

INSERT INTO BDMEMBER VALUES(BDNO_SEQ.NEXTVAL, 'USER1', '1234', '사용자01', '서울시 마포구', '010-7777-8888', 'USER01@MEMBER.COM', 'Y', 'USER');

SELECT * FROM BDMEMBER;