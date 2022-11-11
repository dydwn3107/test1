package com.yedam.java.free.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.free.service.FBService;
import com.yedam.java.free.service.FBVO;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	
	@Autowired
	FBService fbService;
	
	// 등록 - 폼
	@GetMapping("insert")
	public String insertForm(Model model) {
		model.addAttribute("no", fbService.getBoardNo());
		return "freeBoard/insertForm";
	}
	// 등록 - DB insert
	@PostMapping("insert")
	public String insertFreeBoard(FBVO fbvo, RedirectAttributes ratt) {
		Map<String,Object> result = fbService.insertBoardInfo(fbvo);
		ratt.addFlashAttribute("msg", result.get("result") + "건이 등록되었습니다.");
		return "redirect:list";
	}
	// 전체조회
	@GetMapping("list") 							// required = true가 기본값이라 필수로 들어가야 함.
	public String selectFreeBoardList(Model model, @RequestParam(required = false) String msg) {
		model.addAttribute("boardList", fbService.selectBoardList());
		return "freeBoard/boardList";
	}
	// 단건조회
	@GetMapping("info")
	public String selectBoardInfo(FBVO fbvo, Model model) {
		model.addAttribute("board", fbService.selectBoardInfo(fbvo));
		return "freeBoard/boardInfo";
	}
	// 수정 - 폼
	@GetMapping("update")
	public String updateForm(FBVO fbvo, Model model) {
		model.addAttribute("board", fbService.selectBoardInfo(fbvo));
		return "freeBoard/updateForm";
	}
	// 수정 - DB update
	@PostMapping("update")
	public String updateFreeBoard(FBVO fbvo, RedirectAttributes ratt) {
		Map<String,Object> result = fbService.updateBoardInfo(fbvo);
		ratt.addAttribute("msg", result.get("result") + "건이 수정되었습니다.");
		return "redirect:list";
	}
	
	// 삭제
	@GetMapping("delete")
	public String deleteFreeBoard(FBVO fbvo, RedirectAttributes ratt) {
		Map<String,Object> result = fbService.deleteBoardInfo(fbvo);
		ratt.addFlashAttribute("msg", result.get("result") + "건이 삭제되었습니다.");
		return "redirect:list";
	}
	
}
