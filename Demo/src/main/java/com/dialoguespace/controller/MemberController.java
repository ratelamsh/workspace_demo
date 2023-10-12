package com.dialoguespace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dialoguespace.dao.TestDAO;
import com.dialoguespace.dto.MemberDTO;
import com.dialoguespace.service.MemberService;


@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TestDAO testDAO;
	
	@ResponseBody
	@PostMapping(value="/insertMember.do")
	public String insertMember(@RequestBody MemberDTO memberDto, Model model) throws Exception {
		System.out.println("MemberController memberDto : " + memberDto);
		memberService.insertMember(memberDto);
		System.out.println("insert success");
		return "list";
	}
	
	@GetMapping(value="/list")
	public String listPage(Model model) throws Exception {
		listAll(model);
		return "list";
	}
	
	@ResponseBody
	@PostMapping(value="/listAll.do")
	public List<MemberDTO> listAll(Model model) throws Exception {
		List<MemberDTO> list = memberService.listAll();
		System.out.println("list 출력 : " + list);
		model.addAttribute("list", list);
		return list;
	}

}
