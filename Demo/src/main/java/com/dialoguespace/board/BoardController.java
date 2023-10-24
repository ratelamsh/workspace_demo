package com.dialoguespace.board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dialoguespace.common.CommonService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	HttpSession session;
	
	// 글 쓰기 페이지로 이동
	@GetMapping(value="/toWrite")
	public String toWritePage(HttpServletRequest request, Model model) {
		/*
		 * MemberDTO dto = (MemberDTO) session.getAttribute("loginSession"); String
		 * loginId = dto.getId(); System.out.println("로그인한 ID는 " + loginId + " 입니다.");
		 * model.addAttribute("loginId", loginId);
		 */
		
		return "writeArticle";
	}
	
	// 글 작성 프로세스
	@PostMapping(value="/write.do")
	public String writeAtricle(BoardDTO dto, @RequestParam(value="file", required=false) MultipartFile file, Model model) throws IOException {
		System.out.println("Board Controller 진입");
		System.out.println("BoardDTO : " + dto.toString());
		boardService.writeArticle(dto, file);
		
		
		
		 return "result";
	}
	
	// 글 목록 페이지로 이동
	@GetMapping(value="/toList")
	public String toListPage(Model model) {
		
		return "articleList";
	}
	
	// 썸머노트 테스트
	@ResponseBody
	@PostMapping(value="/summernoteImgSave")
	public String summerNoteTest(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		// 내부 경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String filePath = contextRoot + "resources/summerNoteImg/";
		String tempPath = "D://testFolder";
		
		String orgName = multipartFile.getOriginalFilename();
		String extension = orgName.substring(orgName.lastIndexOf("."));
		String sysName = UUID.randomUUID() + extension;
		
		System.out.println("sysname = " + sysName);
		
		commonService.saveFileOnly(multipartFile, sysName, tempPath, filePath);
		System.out.println("썸머노트 이미지 저장");
		
/*		try {
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(filePath, sysName));			
		} catch(IOException e) {
			FileUtils.deleteQuietly(new File(filePath, sysName));
			e.printStackTrace();
		}*/
		
		String path = "/" + filePath.substring(filePath.lastIndexOf("resources")) + sysName;
		System.out.println("ajax로 넘겨줄 url path : " + path);
		return path;
		
	}

}
