package com.spring.board.service;

import java.util.List;
import java.util.Map;

import com.spring.board.model.BoardVO;
import com.spring.board.model.MemberVO;
import com.spring.board.model.TestVO;

public interface InterBoardService {

	int test_insert();

	List<TestVO> test_select();

	int test_insert(Map<String, String> paraMap);

	int test_insert(TestVO vo);
	
	// 기초 끝 
///////////////////////////////////////////////////////////////////////////
	
	// 시작페이지에서 메인 이미지를 보여주는 것 
	List<String> getImgfilenameList();

	// 로그인 처리하기 
	MemberVO getLoginMember(Map<String, String> paraMap);

	// 글쓰기( 파일첨부가 없는 글쓰기)
	int add(BoardVO boardvo);

	// 페이징 처리를 안한 검색어가 없는 전체 글목록 보여주기 
	List<BoardVO> boardListNoSearch();
	
	// 글 조회수 증가와 함깨 글 1개를 조회를 해주는 것
	BoardVO getView(Map<String, String> paraMap);
	
	// 글 조회수 증가는 없고 단순히  글 1개를 조회를 해주는것
	BoardVO getViewWithNoAddCount(Map<String, String> paraMap);
	
	
}
