package com.dialoguespace.board;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dialoguespace.common.CommonService;
import com.dialoguespace.member.MemberDTO;
import com.dialoguespace.vo.FileVO;
import com.dialoguespace.vo.PaginationVO;

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
	public String toWritePage(Model model) {
		String loginId = commonService.getLoginId();
		System.out.println("로그인한 ID는 " + loginId + " 입니다.");
		
//		System.out.println("t_filemeta에 있는 저장하지 않은 이미지 파일 DB 삭제");
//		commonService.delFileByIdCat(loginId, "board");
		
		model.addAttribute("loginId", loginId);
		 
		return "/board/writeBoard";
	}
	
	// 게시글 작성
	@PostMapping(value="/write.do")
	public String writeArticle(BoardDTO boardDto, @RequestParam("upfile") MultipartFile[] multipartFiles, Model model, HttpServletRequest request) throws IOException {
		System.out.println("========== BoardController - writeBoard ==========");
		System.out.println("BoardDTO : " + boardDto.toString());
		// board DB 저장
		boardService.writeArticle(boardDto);
		String seq = "" + boardService.getLatestSeq(boardDto.getAuthor());
		
		// 첨부 파일이 있는 경우
		if(boardDto.getAttachfile().contentEquals("y")) {
		//// 파일 디렉토리 변수에 담기
		String contextRoot	= new HttpServletRequestWrapper(request).getRealPath("/");
		String path			= contextRoot + "resources/board/";
		
		List<FileVO> fileList = commonService.setFileList(multipartFiles, seq, "board", path);
		commonService.saveNewFiles(multipartFiles, fileList);
		}
		
		return "redirect:/board/toList";
	}

	
	// 글 목록 페이지로 이동
	@GetMapping(value="/toList")
	public String toListPage(@RequestParam(defaultValue = "free") String category, @RequestParam(defaultValue="0")String searchType
			, @RequestParam(defaultValue = "")String searchKeyword, @RequestParam(defaultValue="10")int pageSize
			, @RequestParam(defaultValue = "1")int curPage, Model model) throws Exception {
		// loginId
		MemberDTO loginDto = (MemberDTO) session.getAttribute("loginSession");
		String loginId = "";
		if(loginDto != null) {
			loginId = loginDto.getId();	  
		}
		
		model.addAttribute("loginId", loginId);
		
		// 검색요건 추가하여 리스트 출력
		Map srchInfo = boardService.makeSrchInfo(category, searchType, searchKeyword);
		int listCnt = boardService.countList(srchInfo);
		srchInfo.put("pagination", new PaginationVO(listCnt,curPage,pageSize));
		// 페이징 내용 추가
		model.addAttribute("list", boardService.selectArticle(srchInfo));
		model.addAttribute("srchInfo", srchInfo);
		
		return "listArticle";
	}
	
	// 글 상세보기
	@GetMapping(value="/viewArticle")
	public String toViewPage(int seq, Model model) {
		System.out.println("========== Board Controller 진입 ==========");
		
		MemberDTO loginDto = (MemberDTO) session.getAttribute("loginSession");
		String loginId = "";
		if(loginDto != null) {
			loginId = loginDto.getId();
			System.out.println("글 번호 : " + seq);			  
		}
		System.out.println("로그인 아이디 : " + loginId);
		 
		
		// model에 dto 객체 담기
		//// 글 정보  
		BoardDTO dto = boardService.selArticleBySeq(seq);
		model.addAttribute("dto", dto);
		model.addAttribute("loginId", loginId);
		
		//// 파일 정보
		if(dto.getAttachfile().contentEquals("y")) {
			// "board"와 seq에 해당하는 파일들 가져오기
			model.addAttribute("files", commonService.SelFilePathById(""+seq));
		}
		
		return "/board/viewBoard";
	}
	

	
	// 게시글 삭제
	@GetMapping(value="/delArticle")
	public String delArticle(int seq, char attachfile) {
		System.out.println("게시글 삭제 : seq - " + seq + " / attachfile - " + attachfile);
		boardService.delArticle(seq, attachfile);
		
		return "redirect:/board/toList";
	}
	
	// 게시글 수정 페이지로 이동
	@GetMapping(value="/editArticle")
	public String toEditPage(int seq, Model model) {
		System.out.println("게시글 수정 페이지 이동 : seq - " + seq);
		
		String loginId = commonService.getLoginId();
		BoardDTO dto = boardService.selArticleBySeq(seq);
		
		model.addAttribute("dto", dto);
		model.addAttribute("loginId", loginId);
		
		// 파일 있는 경우
		if(dto.getAttachfile().contentEquals("y")) {
			// "board"와 seq에 해당하는 파일들 가져오기
			List<FileVO> files = commonService.SelFileById(""+seq, "board");
			int fileCnt = files.size();
			model.addAttribute("files", files);
			model.addAttribute("fileCnt", fileCnt);
		}
		
		return "/board/editBoard";
	}
	
	// 게시글 수정
	@PostMapping(value="/edit.do")
	public String editArticle(BoardDTO dto, int fileCnt, @RequestParam("upfile") MultipartFile[] multipartFiles
			, @RequestParam(value="prevImg", required=false) String[] prevImgs, Model model, HttpServletRequest request) throws Exception {
		System.out.println("========== BoardController - editArticle ==========");
		System.out.println("BoardDTO : " + dto.toString());
		System.out.println("*** 기존 이미지 목록 ***");
		if(prevImgs != null) {
			for(String p : prevImgs) {
				System.out.println("기존 이미지 seq : " + p);
			}			
		}
		
		System.out.println("*** 첨부파일 목록 ***");
		if(multipartFiles != null) {
			for(MultipartFile f : multipartFiles) {
				System.out.println("첨부파일 이름 " + f.getOriginalFilename());
			}			
		}
		
		// 게시글 db 수정
		boardService.editArticle(dto);
		
		// 기존 이미지 삭제
		if(prevImgs != null) {
			// 기존 이미지에서 삭제할 seq 찾기
			List<String> arr = Arrays.asList(prevImgs);
			List<Integer> delSeq = commonService.getDelSeq(""+dto.getSeq(), arr);
			
			System.out.println("삭제할 seq는 " + delSeq.toString());
			
			// 만약 삭제할 이미지가 있다면, 기존 이미지 삭제
			for(int seq : delSeq) {
				commonService.delFilePhs(seq);
				commonService.delFileDbBySeq(seq);
			}
		} else {
			// 기존 이미지 전부 삭제
			commonService.delFileByIdCat(""+dto.getSeq(), "board");
		}
		
		// 이미지를 수정 했다면
		if(dto.getAttachfile().contains("y")) {
			// 새로운 이미지 업로드
			String contextRoot	= new HttpServletRequestWrapper(request).getRealPath("/");
			String path			= contextRoot + "resources/board/";
			commonService.saveNewFiles(multipartFiles, commonService.setFileList(multipartFiles, ""+dto.getSeq(), "board", path));
		}
		
		return "redirect:/board/toList";
	}
	
	/* 
	 * 
	 *썸머노트 글 작성
	@PostMapping(value="/writeSummernote.do")
	public String writeAtricle(BoardDTO dto, Model model) throws IOException {
		System.out.println("========== Board Controller 진입 ==========");
		System.out.println("BoardDTO : " + dto.toString());
		boardService.writeArticle(dto);
		System.out.println("글 저장 완료");
		
		// 파일 DB의 fileparent를 게시글 seq로 변경
		int seq = boardService.getLatestSeq(dto.getAuthor());
		commonService.modifyFileparent(dto.getAuthor(), "board", seq);
		
		 return toListPage(model);
	}
	
		// 썸머노트 이미지 저장
	@ResponseBody
	@PostMapping(value="/summernoteImgSave")
	public String summerNoteTest(@RequestParam("file") MultipartFile[] multipartFiles, String author, HttpServletRequest request) throws IOException{
		// 내부 경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String filePath = contextRoot + "resources/summerNoteImg/";

		List<FileVO> fileList = commonService.setFileList(multipartFiles, author, "board", filePath);
		commonService.saveNewFiles(multipartFiles, fileList);
		

		System.out.println("썸머노트 이미지 저장");
		

		String path = "/" + filePath.substring(filePath.lastIndexOf("resources")) + fileList.get(0).getSysName();
		System.out.println("ajax로 넘겨줄 url path : " + path);
		
		return path;
	}
	*/
	
	
	
	
}
