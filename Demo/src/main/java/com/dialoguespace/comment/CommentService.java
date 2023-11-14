package com.dialoguespace.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dialoguespace.utils.EncryptionUtils;

@Service
public class CommentService {
	
	@Autowired
	CommentDAO commentDAO;
	
	private EncryptionUtils encryption = new EncryptionUtils();
	
	// 댓글 작성
	public int wrtieComment(CommentDTO commentDto) {
		// 비밀번호 암호화
		commentDto.setPw(encryption.getSHA512(commentDto.getPw()));
		
		return commentDAO.writeComment(commentDto);
	}
	
	// 댓글 목록
	public List<CommentDTO> cmtListByBoardseq(int boardseq) {
		return commentDAO.cmtListByBoardseq(boardseq);
	}
	
	// 댓글 삭제
	public int deleteCmt(int seq) {
		return commentDAO.deleteCmt(seq);
	}
	
	// 댓글 비밀번호 확인
	public int passwordCheck(int seq, String pw) {
		Map map = new HashMap();
		
		// 비밀번호 암호화
		pw = encryption.getSHA512(pw);
		
		map.put("seq", seq);
		map.put("pw", pw);
		
		return commentDAO.passwordCheck(map);
	}
	
	// 댓글 수정
	public int editCmt(int seq, String content) {
		Map map = new HashMap();
		map.put("seq", seq);
		map.put("content", content);
		
		return commentDAO.editCmt(map);
	}

}
