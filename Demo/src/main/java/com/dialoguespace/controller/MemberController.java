package com.dialoguespace.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dialoguespace.dto.MemberDTO;
import com.dialoguespace.service.CommonService;
import com.dialoguespace.service.MemberService;


@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommonService commonService;
	
	// 회원 등록
	@ResponseBody
	@PostMapping(value="/insertMember.do")
	public String insertMember(@RequestBody MemberDTO memberDto) throws Exception {
		System.out.println("MemberController memberDto : " + memberDto);
		memberService.insertMember(memberDto);
		System.out.println("insert success");
		return "list";
	}
	
	// 리스트 페이지 이동
	@GetMapping(value="/list")
	public String toMemberList(String searchType, String searchKeyword, Integer pageNo, Integer perPage, Model model) throws Exception {
		// 검색 및 페이징 Map에 담기
		System.out.println("searchType : " + searchType + " / searchKeyword : " + searchKeyword + " / pageNo : " + pageNo + " / perPage : " + perPage);
		
		// 검색조건
		Map srchInfo = commonService.makeSrchInfo(searchType, searchKeyword);
		
		// 검색결과 리스트
		List<MemberDTO> list = memberService.toMemberList(srchInfo);
		
		// 페이징 조건
//		Map pagingInfo = commonService(list.size(), pageNo, perPage);
		
		// 검색결과 총 개수 데이터 추가
		list = list.subList((int)srchInfo.get("startPage"), (int)srchInfo.get("endPage"));
		System.out.println("회원 목록 조회 완료");
		
		srchInfo.put("total", listSize);		
		model.addAttribute("srchInfo", srchInfo);
		model.addAttribute("list", list);
		return "list";
	}
	
	// 회원 한명 삭제
	@ResponseBody
	@PostMapping(value="/delMember.do")
	public void delMember(@RequestParam String m_id) throws Exception {
		System.out.println("삭제할 id 값 : " + m_id);
		memberService.delMember(m_id);
		System.out.println("회원 삭제 완료");
	}
	
	// 선택한 회원 삭제
	@ResponseBody
	@PostMapping(value="/selDelMember.do")
	public void selDelMember(@RequestBody String[] selectedMember) throws Exception {
		for(int i=0; i<selectedMember.length; i++) {
			System.out.println(selectedMember[i]);
		}
		System.out.println("삭제할 회원 목록 : " + selectedMember);
		memberService.selDelMember(selectedMember);
		System.out.println("선택한 회원 삭제 완료");
	}
	
	// 회원 수정 페이지로 이동
	@GetMapping(value="/editMember")
	public String toEditMember(String m_id, Model model) throws Exception {
		System.out.println("수정할 회원 ID : " + m_id);
		if(m_id != null) {
			model.addAttribute("map", memberService.toEditMember(m_id));			
			return "memberView";
		} else {
			return "errorPage";
		}
	}
	
	// 회원 정보 수정
	@PostMapping(value="/editMember.do")
	public String editMember(MemberDTO memberDto, Model model) throws Exception {
		System.out.println("수정할 회원 정보 : " + memberDto.toString());
		memberService.editMember(memberDto);
		System.out.println(memberDto.getM_id() + "님 회원정보 수정 완료");
		return toEditMember(memberDto.getM_id(), model);
	}

}
