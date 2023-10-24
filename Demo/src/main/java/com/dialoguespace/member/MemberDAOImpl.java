package com.dialoguespace.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlsession;
	
	// 회원 등록
	@Override
	public int insertMember(MemberDTO memberDto) throws Exception {
		return sqlsession.insert("memberMapper.insertMember", memberDto);
	}
	
	// 회원 목록
	@Override
	public List<MemberDTO> memberList(Map srchInfo) throws Exception {
		List<MemberDTO> list = sqlsession.selectList("memberMapper.memberList", srchInfo);
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
	public MemberDTO selectMember(String id) throws Exception {
		MemberDTO memberInfo = sqlsession.selectOne("memberMapper.selectMember", id);
		System.out.println("선택한 회원 정보 DTO : " + memberInfo.toString());
		return memberInfo;
	}
	
	// 회원 정보 수정
	@Override
	public int editMember(MemberDTO memberDto) throws Exception {
		return sqlsession.update("memberMapper.editMember", memberDto);
	}
	
	// 데이터 개수
	@Override
	public int totalCnt(Map srchInfo) throws Exception {
		return sqlsession.selectOne("memberMapper.totalCnt", srchInfo);
	}
	
	// 조건에 맞는 회원 카운팅
	@Override
	public int countList(Map srchInfo) throws Exception {
		return sqlsession.selectOne("memberMapper.countList", srchInfo);
	}
	
	// 프로필 사진 PK 등록
	@Override
	public int addFileNo(Map map) throws Exception {
		return sqlsession.update("memberMapper.addFileNo", map);
	}
	
	// 회원의 프로필 사진 PK 찾기
	@Override
	public int selFileNo(String id) throws Exception {
		System.out.println("memberDAOImpl selFileNo 진입");
		System.out.println("id : " + id);
		return sqlsession.selectOne("memberMapper.selFileNo", id);
	}
	
	// ID 중복검사
	@Override
	public int checkId(String id) throws Exception {
		return sqlsession.selectOne("memberMapper.checkId", id);
	}
	
	// 로그인 - ID, PW로 회원 선택
	@Override
	public MemberDTO selMemberByIdPw(MemberDTO memberDto) throws Exception {
		return sqlsession.selectOne("memberMapper.selMemberByIdPw", memberDto);
	}

}
