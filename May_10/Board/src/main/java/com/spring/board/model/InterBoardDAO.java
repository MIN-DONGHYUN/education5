package com.spring.board.model;

import java.util.List;
import java.util.Map;

public interface InterBoardDAO {

	
	int test_insert();   // myMVC_USER.spring_test 테이블에 insert 하기
						 // HR.spring_exam 테이블에 insert 하기

	List<TestVO> test_select();  // spring_test 테이블에 select 하기

	int test_insert(Map<String, String> paraMap);  // view 단의 form 태그에서 입력받은 값을 spring_test 테이블에 insert 하기

	int test_insert(TestVO vo);  // view 단의 form 태그에서 입력받은 값을 spring_test 테이블에 insert 하기(vo 이용)
	
}
