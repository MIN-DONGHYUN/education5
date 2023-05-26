package com.spring.board.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//===== #32. DAO 선언 =====
@Component
@Repository     
public class BoardDAO implements InterBoardDAO {
	
	   // === #33. 의존객체 주입하기(DI: Dependency Injection) ===
	   // >>> 의존 객체 자동 주입(Automatic Dependency Injection)은
	   //     스프링 컨테이너가 자동적으로 의존 대상 객체를 찾아서 해당 객체에 필요한 의존객체를 주입하는 것을 말한다. 
	   //     단, 의존객체는 스프링 컨테이너속에 bean 으로 등록되어 있어야 한다. 

	   //     의존 객체 자동 주입(Automatic Dependency Injection)방법 3가지 
	   //     1. @Autowired ==> Spring Framework에서 지원하는 어노테이션이다. 
	   //                       스프링 컨테이너에 담겨진 의존객체를 주입할때 타입을 찾아서 연결(의존객체주입)한다.
	   
	   //     2. @Resource  ==> Java 에서 지원하는 어노테이션이다.
	   //                       스프링 컨테이너에 담겨진 의존객체를 주입할때 필드명(이름)을 찾아서 연결(의존객체주입)한다.
	   
	   //     3. @Inject    ==> Java 에서 지원하는 어노테이션이다.
	   //                       스프링 컨테이너에 담겨진 의존객체를 주입할때 타입을 찾아서 연결(의존객체주입)한다.   
	
	/* 
	 	 
		"@Autowired"는 Spring 프레임워크에서 사용되는 어노테이션 중 하나입니다. 이 어노테이션은 객체를 자동으로 주입해주는 기능을 합니다. 스프링 컨테이너가 해당 클래스를 인스턴스화할 때 "@Autowired"가 선언된 필드나 생성자, 메소드 파라미터의 타입과 일치하는 객체를 찾아서 자동으로 해당 필드나 생성자, 메소드 파라미터에 주입해줍니다.

		예를 들어, "@Autowired" 어노테이션이 선언된 필드가 "userService"이고, "UserService" 클래스를 구현한 "UserServiceImpl" 클래스가 스프링 컨테이너에 등록되어 있다면, 스프링 컨테이너가 해당 클래스를 인스턴스화할 때 "UserServiceImpl" 객체를 찾아서 "userService" 필드에 자동으로 주입해줍니다.

		이렇게 "@Autowired" 어노테이션을 사용하면, 코드 작성 시 객체를 직접 생성하거나 의존성을 주입하는 작업을 직접 수행하지 않아도 되므로 코드의 가독성과 유지보수성을 높일 수 있습니다.
	 */
/*	
	@Autowired        // type 에 따라 알아서 자동적으로 Bean 을 주입해준다.   // AUTOWired 는 bean 이 한개일때만 가능하고 bean 이 두개 이상이라면 사용하면 오류가 생긴다.
	private SqlSessionTemplate abc;
	// @Autowired 이게 없다면 null 이 나오고 있다면 null 이 아니다.
	
	// Type 에 따라 Spring 컨테이너가 알아서 root-context.xml 에 생성된 org.mybatis.spring.SqlSessionTemplate 의 bean 을  abc 에 주입시켜준다. 
    // 그러므로 abc 는 null 이 아니다.
*/
	
	@Resource
	private SqlSessionTemplate sqlsession;    //myMVC SQL
 											  // 로컬 DB mymvc_user 에 연결 
	// Type 에 따라 Spring 컨테이너가 알아서 root-context.xml 에 생성된 org.mybatis.spring.SqlSessionTemplate 의  sqlsession bean 을  sqlsession 에 주입시켜준다. 
    // 그러므로 sqlsession 는 null 이 아니다.
	
	@Resource
	private SqlSessionTemplate sqlsession_2;   //hr SQL 
											   // 로컬 DB hr 에 연결 
	// Type 에 따라 Spring 컨테이너가 알아서 root-context.xml 에 생성된 org.mybatis.spring.SqlSessionTemplate 의  sqlsession_2 bean 을  sqlsession_2 에 주입시켜준다. 
    // 그러므로 sqlsession_2 는 null 이 아니다.
	
	
	// myMVC_USER.spring_test 테이블에 insert 하기
	// HR.spring_exam 테이블에 insert 하기
	@Override
	public int test_insert() {
		
		int n_1 = sqlsession.insert("board.test_insert");
		// sql문이 정상이라면 1값 아니라면 0값
		
		int n_2 = sqlsession_2.insert("hr.test_insert");
		// sql문이 정상이라면 1값 아니라면 0값
		
		return n_1 * n_2;    // 1 * 1 은 값이 1이므로 성공 기준 나눌 수 있다.
	}

	
	
	
	// spring_test 테이블에 select 하기
	@Override
	public List<TestVO> test_select() {
		
		List<TestVO> testvoList = sqlsession.selectList("board.test_select");
		
		
		return testvoList;
	}



	// view 단의 form 태그에서 입력받은 값을 spring_test 테이블에 insert 하기
	@Override
	public int test_insert(Map<String, String> paraMap) {
		
		int n = sqlsession.insert("board.test_insert_map", paraMap);
		return n; 
	}



	// view 단의 form 태그에서 입력받은 값을 spring_test 테이블에 insert 하기 (vo 이용)
	@Override
	public int test_insert(TestVO vo) {

		int n = sqlsession.insert("board.test_insert_vo", vo);
		return n; 
	}
	// 기초 끝 
	
	
	//////////////////////////////////////////////////////////////////////////////////


	// === #38. 시작페이지에서 메인 이미지를 보여주는 것  ==== //
	@Override
	public List<String> getImgfilenameList() {
		
		List<String> imgfilenameList = sqlsession.selectList("board.getImgfilenameList");
		
		return imgfilenameList;
	} // end of public List<String> getImgfilenameList()



	// === #46. 로그인 처리하기 === //  
	@Override
	public MemberVO getLoginMember(Map<String, String> paraMap) {
		
		MemberVO loginuser = sqlsession.selectOne("board.getLoginMember", paraMap);   // 한명만 읽어올것이기 때문에 one사용
		
		
		return loginuser;
	}



	// === tbl_member 테이블의 idle 컬럼에 값을 1로 변경하기 === //
	@Override
	public int updateIdle(String userid) {
		int n = sqlsession.update("board.updateIdle",userid);
		
		return n;
	}



	// === #56. 글쓰기( 파일첨부가 없는 글쓰기) === //
	@Override
	public int add(BoardVO boardvo) {
		
		int n = sqlsession.insert("board.add", boardvo);
		
		return n;
	}



	// === #60. 페이징 처리를 안한 검색어가 없는 전체 글목록 보여주기 === // 
	@Override
	public List<BoardVO> boardListNoSearch() {
		
		List<BoardVO> boardList = sqlsession.selectList("board.boardListNoSearch");
		
		return boardList;
	}



	// === #64. 글 1개 조회하기 === //
	@Override
	public BoardVO getView(Map<String, String> paraMap) {
		
		BoardVO boardvo = sqlsession.selectOne("board.getView",paraMap);
		
		return boardvo;
	}
	// === #65. 글 조회수 1 증가하기 (update) === //
	@Override
	public void setAddReadCount(String seq) {
		
		sqlsession.update("board.setAddReadCount",seq);
		
	}


	// === #74. 1개글 수정하기 === // 
	@Override
	public int edit(BoardVO boardvo) {
		
		int n = sqlsession.update("board.edit",boardvo);
		return n;
	}



	// === #79. 1개글 삭제하기 === // 
	@Override
	public int del(Map<String, String> paraMap) {
		
		int n = sqlsession.update("board.del", paraMap);
		
		return n;
	}



    // === #86. 댓들 쓰기(tbl_comment 테이블에  insert) === //
	@Override
	public int addComment(CommentVO commentvo) {
		int n = sqlsession.insert("board.addComment", commentvo);
		return n;
	}



	// === #87.-1 tbl_board 테이블에 commentCount 컬럼이 1증가(update) 하도록 요청한다. === //
	@Override
	public int updateCommentCount(String parentSeq) {
		int n = sqlsession.update("board.updateCommentCount", parentSeq);
		return n;
	}



	// === #87.-2 tbl_member 테이블의 포인트 컬럼의 값을 50점을 증가하도록 한다(update) === //
	@Override
	public int updateMemberPoint(Map<String, String> paraMap) {
		int n = sqlsession.insert("board.updateMemberPoint", paraMap);
		return n;
	}



	// #92. 원게시물에 딸린 댓글들을 조회해오기 === // 
	@Override
	public List<CommentVO> getCommentList(String parentSeq) {
		List<CommentVO> commentList = sqlsession.selectList("board.getCommentList", parentSeq);
		return commentList;
	}



	// === #99. BoardAOP 클래스에서 사용하는 것으로 특정 회원에게 특정 점수만큼 포인트를 증가하기 위한 것 === //
	@Override
	public void pointPlus(Map<String, String> paraMap) {
		
		sqlsession.update("board.pointPlus",paraMap);
	}



	// === #104.페이징 처리를 안한 검색어가 없는 전체 글 목록을 보여주기 === //
	@Override
	public List<BoardVO> boardListSearch(Map<String, String> paraMap) {
		List<BoardVO> boardList = sqlsession.selectList("board.boardListSearch", paraMap);
		return boardList;
	}



	// === #110.  검색어 입력시 자동글 완성하기 5 === //
	@Override
	public List<String> wordSearchShow(Map<String, String> paraMap) {
		List<String> wordList = sqlsession.selectList("board.wordSearchShow", paraMap);
		return wordList;
	}



	// === #116. 총 게시물 건수(totalCount) 구하기 - 검색이 있을때와 검색이 없을때로 나뉜다. === //
	@Override
	public int getTotalCount(Map<String, String> paraMap) {

		int n = sqlsession.selectOne("board.getTotalCount", paraMap);
		
		return n;
	}



	// === #119. 페이징 처리한 글 목록 가져오기(검색이 있든지, 검색이 없든지 모두 다 포함한 것 ) === //
	@Override
	public List<BoardVO> boardListSearchWithPaging(Map<String, String> paraMap) {
		
		List<BoardVO> boardList = sqlsession.selectList("board.boardListSearchWithPaging", paraMap);
		
		return boardList;
	}



	// === #130. 원 게시물에 딸린 댓글들을 페이징 처리 해서 조회해오기 === //
	@Override
	public List<CommentVO> getCommentListPaging(Map<String, String> paraMap) {
		List<CommentVO> commentList = sqlsession.selectList("board.getCommentListPaging", paraMap);
		return commentList;
	}



	// === #134. 원글 글번호에 해당하는 댓글의 totalPage 알아오기 (Ajax로 처리) === //
	@Override
	public int getCommentTotalPage(Map<String, String> paraMap) {
		int totalPage = sqlsession.selectOne("board.getCommentTotalPage", paraMap);
		return totalPage;
	}



	// === #145. tbl_board 테이블에서 groupno 컬럼의 최대값 알아오기 === //
	@Override
	public int getGroupno_max() {
		int maxgroupno = sqlsession.selectOne("board.getGroupno_max");
		return maxgroupno;
	}



	// === #158. 글쓰기( 파일첨부가 있는 경우) === // 
	@Override
	public int add_withFile(BoardVO boardvo) {
		int n = sqlsession.insert("board.add_withFile", boardvo);
		return n;
	}




	// === #173. 파일첨부가 되어진 댓글 1개에서서버에 업로드되어진  파일명과 오리지널 파일명을 조회해주는것  === //
	@Override
	public CommentVO getCommentOne(String seq) {
		CommentVO commentvo = sqlsession.selectOne("board.getCommentOne", seq);
		return commentvo;
	}
	
}
