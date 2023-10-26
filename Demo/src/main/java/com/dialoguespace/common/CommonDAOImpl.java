package com.dialoguespace.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dialoguespace.vo.FileVO;

@Repository
public class CommonDAOImpl implements CommonDAO {
	
	@Autowired
	SqlSession sqlsession;

	
	// 파일 저장
	@Override
	public int saveNewFile(FileVO file) throws Exception {
		System.out.println("CommonDAOImpl saveFile 진입");
		return sqlsession.insert("commonMapper.saveFile", file);
	}

	// 파일 삭제
	@Override
	public int delFile(FileVO file) throws Exception {
		System.out.println("CommonDAOImpl delFile 진입");
		return sqlsession.delete("commonMapper.delFile", file);
	}
	
	// 파일 PK 찾기
	@Override
	public int selectFilePK(FileVO file) throws Exception {
		return sqlsession.selectOne("commonMapper.selectFilePK", file);
	}
	
	// 파일 경로 검색
	@Override
	public String getPath(int seq) throws Exception {
		return sqlsession.selectOne("commonMapper.getPath", seq);
	}
	
	// fileno로 특정 파일 DB정보 삭제
	@Override
	public int delFileDbBySeq(int seq) throws Exception {
		return sqlsession.update("commonMapper.delFileDbBySeq", seq);
	}
	
	// fileno로 특정 파일 DB정보 업데이트
	@Override
	public int updateFileDB(FileVO file) throws Exception {
		return sqlsession.update("commonMapper.updateFileDB", file);
	}
	
	// id와 category로 파일 경로 찾기
	@Override
	public List<String> selFilePathByIdCat(Map map) {
		return sqlsession.selectList("commonMapper.selFilePathByIdCat", map);
	}
	
	// id와 category로 파일 DB 삭제
	@Override
	public int delFileDbByIdCat(Map map) {
		return sqlsession.delete("commonMapper.delFileDbByIdCat", map);
	}
	
	// id와 category로 fileparent update
	@Override
	public int modifyFileparent(Map map) { 
		return sqlsession.update("commonMapper.modifyFileparent", map);
	}
	
	// seq로 File db 찾기
	@Override
	public List<FileVO> SelFileById(String id) {
		return sqlsession.selectList("commonMapper.selFileById", id);
	}
	
	// seq로 File path 찾기
	@Override
	public List<String> SelFilePathById(String id) {
		return sqlsession.selectList("commonMapper.selFilePathById", id);
	}
}
