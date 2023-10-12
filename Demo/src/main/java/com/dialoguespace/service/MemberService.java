package com.dialoguespace.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dialoguespace.dao.MemberDAO;
import com.dialoguespace.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Transactional
	public int insertMember(MemberDTO memberDto) throws Exception {
		memberDto.setM_regdate(new Timestamp(System.currentTimeMillis()));
		return memberDAO.insertMember(memberDto);
	}
	
	public List<MemberDTO> listAll() throws Exception {
		List<MemberDTO> list = memberDAO.listAll();
		System.out.println(list);
		return list;
	}
}
