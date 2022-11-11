package com.yedam.java.free.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class FBVO {
	private int bno;		// 게시판 번호
	private String title;	// 게시판 제목
	private String contents;// 게시판 내용
	private String writer;	// 게시판 작성자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;	// 게시판 등록일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;// 게시판 수정일
	private String image;	// 게시판 첨부파일
}
