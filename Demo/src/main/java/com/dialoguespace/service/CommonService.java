package com.dialoguespace.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dialoguespace.dao.CommonDAO;

@Service
public class CommonService {
	
	@Autowired
	CommonDAO commonDAO;

	// 검색 조건 Map에 담기
	public Map makeSrchInfo(String searchType, String searchKeyword) throws Exception {
		// Null 체크
		if(searchType == null) {
			searchType = "0";
		}
		if(searchKeyword == null) {
			searchKeyword = "";
		}
		
		Map srchInfo = new HashMap();
		srchInfo.put("searchType", searchType);
		srchInfo.put("searchKeyword", searchKeyword);
		
		return srchInfo;
	}
	
	// 페이징 정보 Map에 담기
//	public Map makePagingInfo(int totalCnt, Integer pageNo, Integer perPage) throws Exception {
//		// Null 체크
//		if(pageNo == null) {
//			pageNo = 1;
//		}
//		if(perPage == null) {
//			perPage = 10;
//		}
//		
//		// 시작 포인트
//		
//		
//		Map pagingInfo = new HashMap();
//		pagingInfo.put("startPage", (pageNo-1)*perPage);
//		
//		
//	}
	
}
