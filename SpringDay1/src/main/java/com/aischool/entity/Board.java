package com.aischool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

	// 게시글 정보를 하나로 묶어줄 수 있는 클래스 (자료형)
	
	private int idx;
	private String title;
	private String content;
	private String writer;
	private String indate;
	private int count;
	private String imgpath;
	
	
	
}
