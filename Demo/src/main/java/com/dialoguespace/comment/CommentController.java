package com.dialoguespace.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dialoguespace.board.BoardService;

@Controller
@RequestMapping(value="/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	BoardService boardService;
	
	
	
	// 댓글 작성
	@ResponseBody
	@PostMapping(value="/write.do")
	public String writeComment(CommentDTO commentDto, Model model) {
		System.out.println("===== CommentController - writeComment =====");
		System.out.println(commentDto);
		
		// 댓글 저장
		int rs = commentService.wrtieComment(commentDto);

		// 게시글 댓글 개수 증가
		if(commentDto.getBoardseq() > 0) {
			boardService.addCommentCnt(commentDto.getBoardseq(), 'n');			
		} else {
			boardService.addCommentCnt(commentDto.getReplyboardseq(), 'y');
		}
		
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
	public List<CommentDTO> cmtListByBoardseq(int boardseq, char replyYn, Model model) {
		System.out.println("===== CommentController - cmtListByBoardseq =====");
		System.out.println("boardseq : " + boardseq);
		
		List<CommentDTO> list = commentService.cmtListByBoardseq(boardseq, replyYn);
		return list;
	}
	
	// 댓글 삭제
	@ResponseBody
	@GetMapping(value="/delete.do")
	public int deleteCmt(int seq, int pid, int boardseq) {
		System.out.println("===== CommentController - deleteCmt =====");
		System.out.println("seq : " + seq + " / pid : " + pid + " / boardseq : " + boardseq);
		
		// 게시글 댓글 개수 감소
		boardService.reduceCommentCnt(seq, pid, boardseq);
		
		// 댓글 삭제
		int rs = commentService.deleteCmt(seq, pid);
		
		return rs;
	}
	
	// 댓글 비밀번호 확인
	@ResponseBody
	@PostMapping(value="/passwordCheck")
	public int passwordCheck(int seq, int pid, String pw) {
		System.out.println("===== CommentController - passwordCheck =====");
		System.out.println("seq : " + seq + " / pid : " + pid + " / pw : " + pw);
		
		return commentService.passwordCheck(seq, pid, pw);
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
	public int editCmt(int seq, int pid, String content) {
		System.out.println("===== CommentController - editCmt =====");
		System.out.println("seq : " + seq + " / pid : " + pid + " / content : " + content);
		
		return commentService.editCmt(seq, pid, content);
	}
	
	// 대댓글 목록
	@ResponseBody
	@GetMapping(value="/listReply")
	public List<CommentDTO> cmtListByPid(int pid) {
		System.out.println("===== CommentController - cmtListByPid =====");
		System.out.println("pid : " + pid);
		
		return commentService.cmtListByPid(pid);
	}
}
