package com.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.spring.board.model.BoardVO;
import com.spring.board.model.CommentVO;
import com.spring.board.model.MemberVO;
import com.spring.board.model.TestVO;

public interface InterBoardService {

	int test_insert();

	List<TestVO> test_select();

	int test_insert(Map<String, String> paraMap);

	int test_insert(TestVO vo);
	
	//////////////////////////////////////////////////////
	ModelAndView index(ModelAndView mav);
	ModelAndView loginEnd(ModelAndView mav, HttpServletRequest request, Map<String, String> paraMap);
	//////////////////////////////////////////////////////
	
	
	
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

	// 1개글 수정하기 
	int edit(BoardVO boardvo);

	// 1개글 삭제하기 
	int del(Map<String, String> paraMap);

	// 댓글쓰기 (transaction 처리)
	int addComment(CommentVO commentvo) throws Throwable;

	// 원 게시물에 딸린 댓글들을 조회해오기
	List<CommentVO> getCommentList(String parentSeq);

	// BoardAOP 클래스에서 사용하는 것으로 특정 회원에게 특정 점수만큼 포인트를 증가하기 위한 것
	void pointPlus(Map<String, String> paraMap);

	// 페이징 처리를 안한 검색어가 있는 전체 글목록 보여주기
	List<BoardVO> boardListSearch(Map<String, String> paraMap);

	// 검색어 입력시 자동글 완성하기
//	List<String> wordSearchShow(Map<String, String> paraMap);
	// 또는 
	String wordSearchShow(Map<String, String> paraMap);

	// 총 게시물 건수(totalCount) 구하기 - 검색이 있을때와 검색이 없을때로 나뉜다.
	int getTotalCount(Map<String, String> paraMap);

	// 페이징 처리한 글 목록 가져오기(검색이 있든지, 검색이 없든지 모두 다 포함한 것 )
	List<BoardVO> boardListSearchWithPaging(Map<String, String> paraMap);

	// 원 게시물에 딸린 댓글들을 페이징 처리 해서 조회해오기
	List<CommentVO> commentListPaging(Map<String, String> paraMap);

	// 원글 글번호에 해당하는 댓글의 totalPage 알아오기 (Ajax로 처리)
	String getCommentTotalPage(Map<String, String> paraMap);

	// 글쓰기( 파일첨부가 있는 글쓰기)
	int add_withFile(BoardVO boardvo);

	// 파일첨부가 되어진 댓글 1개에서서버에 업로드되어진  파일명과 오리지널 파일명을 조회해주는것 
	CommentVO getCommentOne(String seq);


	
	
}
