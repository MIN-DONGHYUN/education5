package com.spring.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.board.model.InterBoardDAO;
import com.spring.board.model.TestVO;

// ===== #31. Service 선언 =====
// Service 단은 트랜잭센 처리를 담당하는 곳, 업무를 처리하는 곳,(업무란 DB와 관련된 작업을 말한다), 비지니스(Business)단이라고 부른다.
@Component
@Service
public class BoardService implements InterBoardService {
	//  BoardService 클래스는 클래스명에서 첫글자만 소문자로 된 boardService 이름으로 bean 객체가 생성된다
	
	
	// ===== #34. 의존객체 주입하기(DI : Dependency Injection) ====
	// bean 으로 올라가있기 때문에 InterBoardDAO dao = new BoardDAO 로 안해도 된다. 다만 @Autowired 로 받아옴
	
	@Autowired       // type 에 따라 알아서 자동적으로 Bean 을 주입해준다.
	private InterBoardDAO dao;    
	
	
	@Override
	public int test_insert() {
		
		int n = dao.test_insert();
		
		return n;
	}


	@Override
	public List<TestVO> test_select() {
		
		List<TestVO> testvoList =  dao.test_select();
		
		return testvoList;
	}


	@Override
	public int test_insert(Map<String, String> paraMap) {
		int n = dao.test_insert(paraMap);
		return n;
	}


	@Override
	public int test_insert(TestVO vo) {
		
		int n = dao.test_insert(vo);
		return n;
	}

	
}
