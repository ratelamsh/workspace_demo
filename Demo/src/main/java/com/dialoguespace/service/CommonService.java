package com.dialoguespace.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dialoguespace.dao.CommonDAO;

@Service
public class CommonService {

	// 검색 조건 Map에 담기
	public Map makeSrchInfo(String searchType, String searchKeyword) throws Exception {
		Map srchInfo = new HashMap();
		srchInfo.put("searchType", searchType);
		srchInfo.put("searchKeyword", searchKeyword);
		
		return srchInfo;
	}

	
}
