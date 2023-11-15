package com.dialoguespace.comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
		
		/*
		// 댓글 종류 구분
		int seq		= commentDto.getSeq();
		int rootseq	= commentDto.getRootseq();
		int pid		= commentDto.getPid();
		
		if(rootseq == 0 && pid == 0) {	// 댓글(seq = 0, rootseq = 0, pid = 0)
			
		} else if(rootseq > 0 && pid > 0 && rootseq == pid) {	// 대댓글(seq = 0, rootseq = x, pid = x)
			
		} else if(rootseq > 0 && pid > 0 && rootseq != pid) {	// 대대댓글(seq = 0, rootseq = x, pid = y)
			
		}
		*/
		
		commentDAO.writeComment(commentDto);
		return commentDAO.editRootSeq();
	}
	
	// 댓글 목록
	public List<CommentDTO> cmtListByBoardseq(int boardseq) {
		return commentDAO.cmtListByBoardseq(boardseq);
		
		  // 댓글 정렬
		  
		  // 전체 목록
			//List<CommentDTO> commentList = commentDAO.cmtListByBoardseq(boardseq);
			
			
//			Map<Integer, Map<Integer, List<CommentDTO>>> map = new HashMap<>();
			
//			Map<Integer, List<CommentDTO>> map = new HashMap<>();
//			List<CommentDTO> list = new ArrayList<>();
//		  
			/*
			 * Iterator it = commentList.iterator();
			 * 
			 * while(it.hasNext()) { CommentDTO cmt = (CommentDTO)it.next();
			 * 
			 * if(cmt.getPid() == 0) { // 최상위 댓글일 때
			 * 
			 * map.put(cmt.getRootseq(), )
			 * 
			 * }
			 */
			  
			  
//			  if(cmt.getPid() == 0) {	// 최상위 댓글일 때
//				  
//				  // 하위 댓글이 있는지?
//				  if(cmt.getHasreply() == 'y') {
//					  while(it.hasNext()) {
//						  CommentDTO dto = (CommentDTO)it.next();
//						  // pid가 seq와 같은 것 
//						  for()
//						  while(dto.getHasreply() == 'y') {
//							  
//						  }
//					  }
//					  
//					  
//				  } else {
//					  Map<Integer, List<CommentDTO>> subMap = new HashMap<>();
//					  list.add(cmt);
//					  subMap.put(cmt.getPid(), list);
//					  map.put(cmt.getRootseq(), subMap);
//					  continue;
//				  }
//			  }
			  
//		  }
		 
		
	}
	
	// 하위 댓글 확인
	public int hasReply(Iterator it) {
		return 0;
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
