package com.dialoguespace.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	// 댓글 작성
	@Override
	public int writeComment(CommentDTO commentDto) {
		return sqlsession.insert("commentMapper.writeComment", commentDto);
	}
	
	// 댓글 목록
	@Override
	public List<CommentDTO> cmtListByBoardseq(int boardseq) {
		List<CommentDTO> list = sqlsession.selectList("commentMapper.cmtListByBoardseq", boardseq);
		return list;
	}
	
	// 댓글 삭제
	@Override
	public int deleteCmt(int seq) {
		return sqlsession.delete("commentMapper.deleteCmt", seq);
	}
	
	// 댓글 비밀번호 확인
	@Override
	public int passwordCheck(Map map) {
		return sqlsession.selectOne("commentMapper.passwordCheck", map);
	}
	
	// 댓글 수정
	@Override
	public int editCmt(Map map) {
		return sqlsession.update("commentMapper.editCmt", map);
	}
	
	// rootseq 수정
	@Override
	public int editRootSeq() {
		return sqlsession.update("commentMapper.editRootSeq");
	}

}
