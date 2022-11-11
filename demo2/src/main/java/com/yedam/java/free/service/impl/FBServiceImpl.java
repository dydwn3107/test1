package com.yedam.java.free.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.free.mapper.FBMapper;
import com.yedam.java.free.service.FBService;
import com.yedam.java.free.service.FBVO;

@Service
public class FBServiceImpl implements FBService {

	@Autowired
	FBMapper fbMapper;
	
	@Override
	public int getBoardNo() {
		//FBVO fbvo = fbMapper.getBoardNo(); 가 반환하는게 클래스다. 그래서 한번 더 꺼내줘야 함.
		// int bnd = fbVO.getBno();
		// return bno;
		// 이 3줄이 아래의 1줄로.
		return fbMapper.getBoardNo().getBno();
	}

	@Override
	public List<FBVO> selectBoardList() {
		return fbMapper.getBoardList();
	}

	@Override
	public FBVO selectBoardInfo(FBVO fbvo) {
		return fbMapper.selectBoard(fbvo);
	}

	@Override
	public Map insertBoardInfo(FBVO fbvo) {
		int count = fbMapper.insertBoard(fbvo);
		return getResult(count, fbvo);
	}

	@Override
	public Map updateBoardInfo(FBVO fbvo) {
		int count = fbMapper.updateBoard(fbvo);
		return getResult(count, fbvo);
	}

	@Override
	public Map deleteBoardInfo(FBVO fbvo) {
		int count = fbMapper.deleteBoard(fbvo.getBno());
		return getResult(count, fbvo);
	}
	
	public Map getResult(int count, FBVO fbvo) {
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("result", count);
		result.put("data", fbvo);
		return result;
	}

}
