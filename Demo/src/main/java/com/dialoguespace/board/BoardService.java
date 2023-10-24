package com.dialoguespace.board;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	// 글 작성 프로세스
	public int writeArticle(BoardDTO dto, MultipartFile file) throws IOException {
		System.out.println("BoardService 진입");
		
		// 첨부파일이 있다면 attathyn = 'y'
		if(dto.getContent().contains("<img")) {
			dto.setAttchfile("y");
			
			// img가 몇 개인지 파악
		};

		System.out.println("BoardService - writeArticle() - BoardDTO" + dto.toString());
		
		
		
		return 0;
	}

}
