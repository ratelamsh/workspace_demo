package com.dialoguespace.demo;

public class ConnectionTest {
	public static void main(String[] args) {
		
//		try {
//			// MySQL DB용 드라이브로드
//			Class.forName("com.mysql.jdbc.Driver");
//			// DB 연결
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo_schema", "root", "1234");
//			System.out.println("mysql db연결 성공");
//			
//			// DB연결해제
//			conn.close();
//			System.out.println("mysql DB 연결 해제 성공");
//			
//			
//		} catch(ClassNotFoundException error) {
//			System.out.println(error);
//			System.out.println("mysql driver 미설치 또는 드라이버 이름 오류");
//		} catch(SQLException error) {
//			System.out.println("DB접속오류");
//		}
		
		int rangeSize	= 5;
		
		int curPage		= 5;
		int listCnt		= 100;
		int pageSize	= 10;
		
		
		int pageCnt	= (listCnt-1)/pageSize +1;
		int rangeCnt	= (pageCnt-1)/rangeSize +1;
		int startPage	= ((curPage-1)/rangeSize)*rangeSize +1;
		int endPage	= startPage + rangeSize -1;
		int curRange	= (startPage-1)/rangeSize +1;
		
		// 마지막 페이지가 총 페이지 수보다 큰 경우 마지막 페이지를 총 페이지 개수에 맞추기
		if(endPage > pageCnt) endPage = pageCnt;
		
		System.out.println("pageCnt : " + pageCnt);	
		System.out.println("rangeCnt : " + rangeCnt);
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("curRange : " + curRange);
	}
}
