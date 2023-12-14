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
	
	private final CommentService commentService;
	private final BoardService boardService;
	
	@Autowired
	public CommentController(CommentService commentService, BoardService boardService) {
		this.commentService = commentService;
		this.boardService = boardService;
	}
	
	// 댓글 작성
	@ResponseBody
	@PostMapping(value="/write.do")
	public String writeComment(CommentDTO commentDto, Model model) {
		// 댓글 저장
		int rs = commentService.wrtieComment(commentDto);

		// 게시글 댓글 개수 증가
		if(commentDto.getBoardseq() > 0) {
			boardService.addCommentCnt(commentDto.getBoardseq(), 'n');			
		} else {
			boardService.addCommentCnt(commentDto.getReplyboardseq(), 'y');
		}
		
		return (rs > 0 ? "성공" : "실패");
		
	}
	
	// 댓글 목록 - boardseq별
	@ResponseBody
	@PostMapping(value="/list")
	public List<CommentDTO> cmtListByBoardseq(int boardseq, char replyYn, Model model) {
		List<CommentDTO> list = commentService.cmtListByBoardseq(boardseq, replyYn);
		return list;
	}
	
	// 댓글 목록 - search conditon
	@PostMapping(value="/searchList")
	public List<CommentDTO> cmtListBySearchcondition(Model model) {
		List<CommentDTO> list = commentService.cmtListBySearchcondition();
		return list;
	}
	
	// 댓글 삭제
	@ResponseBody
	@GetMapping(value="/delete.do")
	public int deleteCmt(int seq, int pid, int boardseq, char replyyn) {
		// 게시글 댓글 개수 감소
		boardService.reduceCommentCnt(seq, pid, boardseq, replyyn);
		
		// 댓글 삭제
		int rs = commentService.deleteCmt(seq, pid);
		
		return rs;
	}
	
	// 댓글 비밀번호 확인
	@ResponseBody
	@PostMapping(value="/passwordCheck")
	public int passwordCheck(int seq, int pid, String pw) {
		return commentService.passwordCheck(seq, pid, pw);
	}
	
	// 댓글 비밀번호 입력 창으로 이동
	@GetMapping(value="/toPwCheck")
	public String  toPwCheckPage(Model model) {
		return "/comment/cmtPwCheck";
	}
	
	// 댓글 수정 요청
	@ResponseBody
	@GetMapping(value="/editProc.do")
	public int editCmt(int seq, int pid, String content) {
		return commentService.editCmt(seq, pid, content);
	}
	
	// 대댓글 목록
	@ResponseBody
	@GetMapping(value="/listReply")
	public List<CommentDTO> cmtListByPid(int pid) {
		return commentService.cmtListByPid(pid);
	}
	
	// 선택 댓글 삭제
	@PostMapping(value="/selDelComment")
	public String selDelComment(String[] delList) {
		for(String delInfo : delList) {
			String[] arr = delInfo.split("#");
			boardService.reduceCommentCnt(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), arr[3].charAt(0));
			commentService.deleteCmt(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		}
		return "redirect:/master/toCommentList";
	}
}
