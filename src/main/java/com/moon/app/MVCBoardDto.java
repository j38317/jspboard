package com.moon.app;

import java.sql.Date;

public class MVCBoardDto {
	/*
	create table MVCBOARD(
	BD_NO NUMBER PRIMARY KEY,
	BD_NAME VARCHAR2(100) NOT NULL,
	BD_TITLE VARCHAR2(200) NOT NULL,
	BD_CONTENT VARCHAR2(4000) NOT NULL,
	BD_DATE DATE NOT NULL
	);
	 */
	
	private int bd_no;
	private String bd_name;
	private String bd_title;
	private String bd_content;
	private Date bd_date;
	
//	// 생성자
//	public MVCBoardDto() {
//		super();
//	}
//	
//	// 매개변수 생성자
//	public MVCBoardDto(int bd_no, String bd_name, String bd_title, String bd_content, Date bd_date) {
//		super();
//		this.bd_no = bd_no;
//		this.bd_name = bd_name;
//		this.bd_title = bd_title;
//		this.bd_content = bd_content;
//		this.bd_date = bd_date;
//	}
	

	
	
	
	
	
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public String getBd_name() {
		return bd_name;
	}
	public void setBd_name(String bd_name) {
		this.bd_name = bd_name;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getBd_content() {
		return bd_content;
	}
	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}
	public Date getBd_date() {
		return bd_date;
	}
	public void setBd_date(Date bd_date) {
		this.bd_date = bd_date;
	}
	@Override
	public String toString() {
		return "MVCBoardDto [bd_no=" + bd_no + ", bd_name=" + bd_name + ", bd_title=" + bd_title + ", bd_content="
				+ bd_content + ", bd_date=" + bd_date + "]";
	}
	
	
	
}
