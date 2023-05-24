package com.spring.board.model;

import java.util.List;
import java.util.Map;

public interface InterBoardDAO {

	
	int test_insert();   // myMVC_USER.spring_test 테이블에 insert 하기
						 // HR.spring_exam 테이블에 insert 하기

	List<TestVO> test_select();  // spring_test 테이블에 select 하기

	int test_insert(Map<String, String> paraMap);  // view 단의 form 태그에서 입력받은 값을 spring_test 테이블에 insert 하기

	int test_insert(TestVO vo);  // view 단의 form 태그에서 입력받은 값을 spring_test 테이블에 insert 하기(vo 이용)
    // 기초 끝 
	
	///////////////////////////////////////////////////////////////////
	
	// 시작페이지에서 메인 이미지를 보여주는 것 
	List<String> getImgfilenameList();

	// 로그인 처리하기 
	MemberVO getLoginMember(Map<String, String> paraMap);
	
	// === tbl_member 테이블의 idle 컬럼에 값을 1로 변경하기 === //
	int updateIdle(String string);

	// === 글쓰기( 파일첨부가 없는 글쓰기) === //
	int add(BoardVO boardvo);

	// 페이징 처리를 안한 검색어가 없는 전체 글목록 보여주기 
	List<BoardVO> boardListNoSearch();
	
	// 글 1개 조회하기
	BoardVO getView(Map<String, String> paraMap);
	// 글 조회수 1 증가하기 (update) 
	void setAddReadCount(String seq);

	// 1개글 수정하기 
	int edit(BoardVO boardvo);

	// 1개 글 삭제하기 
	int del(Map<String, String> paraMap);

	////////////////////////////////////////////////////////////////////////////////////////
	//댓들 쓰기(tbl_comment 테이블에  insert)
	int addComment(CommentVO commentvo);
	// tbl_board 테이블에 commentCount 컬럼이 1증가(update) 하도록 요청한다.
	int updateCommentCount(String parentSeq);
	// tbl_member 테이블의 포인트 컬럼의 값을 50점을 증가하도록 한다(update).
	int updateMemberPoint(Map<String, String> paraMap);
	////////////////////////////////////////////////////////////////////////////////////////

	// 원 게시물에 딸린 댓글들을 조회해오기
	List<CommentVO> getCommentList(String parentSeq);
	
	// BoardAOP 클래스에서 사용하는 것으로 특정 회원에게 특정 점수만큼 포인트를 증가하기 위한 것
	void pointPlus(Map<String, String> paraMap);

	// 페이징 처리를 안한 검색어가 없는 전체 글 목록을 보여주기 
	List<BoardVO> boardListSearch(Map<String, String> paraMap);

	// 검색어 입력시 자동글 완성하기
	List<String> wordSearchShow(Map<String, String> paraMap);

	// 총 게시물 건수(totalCount) 구하기 - 검색이 있을때와 검색이 없을때로 나뉜다.
	int getTotalCount(Map<String, String> paraMap);

	// 페이징 처리한 글 목록 가져오기(검색이 있든지, 검색이 없든지 모두 다 포함한 것 )
	List<BoardVO> boardListSearchWithPaging(Map<String, String> paraMap);

	// 원 게시물에 딸린 댓글들을 페이징 처리 해서 조회해오기
	List<CommentVO> getCommentListPaging(Map<String, String> paraMap);

	// 원글 글번호에 해당하는 댓글의 totalPage 알아오기 (Ajax로 처리)
	int getCommentTotalPage(Map<String, String> paraMap);

	//tbl_board 테이블에서 groupno 컬럼의 최대값 알아오기
	int getGroupno_max();
	
	
	
	
	
}
