package com.yedam.java.free.service;

import java.util.List;
import java.util.Map;

public interface FBService {
	// 입력될 게시글 조회
	public int getBoardNo();
	// 전체조회
	public List<FBVO> selectBoardList();
	// 단건조회
	public FBVO selectBoardInfo(FBVO fbvo);
	// 등록
	public Map insertBoardInfo(FBVO fbvo);
	// 수정
	public Map updateBoardInfo(FBVO fbvo);
	// 삭제
	public Map deleteBoardInfo(FBVO fbvo);
}
