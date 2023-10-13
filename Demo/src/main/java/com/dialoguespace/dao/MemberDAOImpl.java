package com.dialoguespace.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dialoguespace.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlsession;
	
	// 회원 등록
	@Override
	public int insertMember(MemberDTO memberDto) throws Exception {
		return sqlsession.insert("memberMapper.insertMember", memberDto);
	}
	
	// 전체 회원 셀렉트
	@Override
	public List<MemberDTO> memberListAll() throws Exception {
		List<MemberDTO> list = sqlsession.selectList("memberMapper.memberListAll");
		return list;
	}
	
	// 회원 삭제
	@Override
	public int delMember(String id) throws Exception {
		return sqlsession.delete("memberMapper.delMember", id);
	}
	
	// 선택한 회원 삭제
	@Override
	public int selDelMember(Map<String, Object> map) throws Exception {
		int rs = sqlsession.delete("memberMapper.selDelMember", map);
		System.out.println(rs);
		return rs;
	}
	
	// 회원 수정 페이지로 이동 - 회원 한 명 정보 가져오기
	@Override
	public MemberDTO selectMember(String m_id) throws Exception {
		MemberDTO memberInfo = sqlsession.selectOne("memberMapper.selectMember", m_id);
		System.out.println("선택한 회원 정보 DTO : " + memberInfo.toString());
		return memberInfo;
	}
	
	// 회원 정보 수정
	@Override
	public int editMember(MemberDTO memberDto) throws Exception {
		return sqlsession.update("memberMapper.editMember", memberDto);
	}

}
