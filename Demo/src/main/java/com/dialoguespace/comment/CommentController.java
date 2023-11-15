package com.dialoguespace.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	
	
	// 댓글 작성
	@ResponseBody
	@PostMapping(value="/write.do")
	public String writeComment(CommentDTO commentDto, Model model) {
		System.out.println("===== CommentController - writeComment =====");
		System.out.println(commentDto);
		
		int rs = commentService.wrtieComment(commentDto);
		
		switch(rs) {
		case 1:
			return "성공";
		default :
			return "실패";
			
		}
	}
	
	// 댓글 목록
	@ResponseBody
	@PostMapping(value="/list")
	public List<CommentDTO> cmtListByBoardseq(int boardseq, Model model) {
		System.out.println("===== CommentController - cmtListByBoardseq =====");
		System.out.println("boardseq : " + boardseq);
		
		List<CommentDTO> list = commentService.cmtListByBoardseq(boardseq);
		return list;
	}
	
	// 댓글 삭제
	@ResponseBody
	@GetMapping(value="/delete.do")
	public int deleteCmt(int seq) {
		System.out.println("===== CommentController - deleteCmt =====");
		System.out.println("seq : " + seq);
		
		return commentService.deleteCmt(seq);
	}
	
	// 댓글 비밀번호 확인
	@ResponseBody
	@PostMapping(value="/passwordCheck")
	public int passwordCheck(int seq, String pw) {
		System.out.println("===== CommentController - passwordCheck =====");
		System.out.println("seq : " + seq + " / pw : " + pw);
		
		return commentService.passwordCheck(seq, pw);
	}
	
	// 댓글 비밀번호 입력 창으로 이동
	@GetMapping(value="/toPwCheck")
	public String  toPwCheckPage(Model model) {
		System.out.println("===== CommentController - toPwCheckPage =====");
		return "/comment/cmtPwCheck";
	}
	
	// 댓글 수정 요청
	@ResponseBody
	@GetMapping(value="/editProc.do")
	public int editCmt(int seq, String content) {
		System.out.println("===== CommentController - editCmt =====");
		System.out.println("seq : " + seq + " / content : " + content);
		
		return commentService.editCmt(seq, content);
	}
	
	
}
