package com.dialoguespace.dao;

import java.util.List;

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
	
	// 전체 멤버 셀렉트
	@Override
	public List<MemberDTO> listAll() throws Exception {
		List<MemberDTO> list = sqlsession.selectList("memberMapper.listAll");
		System.out.println(list);
		return list;
	}

}
