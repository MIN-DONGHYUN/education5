package com.jpa.app.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.app.domain.Board;

//Spring Data JPA는 "JpaRepository"라는 기능을 사용하면 매우 간단히 데이터를 입력,수정,삭제,검색을 할 수 있게 해준다.

//JpaRepository 인터페이스는 org.springframework.data.jpa.repository 패키지의 "JpaRepository"라는 인터페이스를 상속하여 만든다. 
//아래와 같이 만든다.
//public interface 인터페이스이름 extends JpaRepository <엔티티클래스명, ID필트타입>

//클래스의 선언 앞에 "@Repository"라는 어노테이션이 붙여져 있다. 
//그러면 이 인터페이스가 JpaRepository임을 나타낸다. 스프링레거시 에서는 반드시 @Repository 어노테이션을 붙여 두어야 한다.
//그런데 스프링부트 에서는 @Repository 를 생략해도 가능하다.
@Repository  
public interface InterBoardRepository extends JpaRepository<Board, Long> { // Long 이라고 쓴 이유는 Board 클래스에 @ID 로 사용되는 num 필트의 타입이 Long 이기 때문이다.  

	// findBy컬럼명으로사용되는필드명() => SQL문의 = 로 사용되어짐.
	// findBy컬럼명으로사용되는필드명Containing() => Containing : SQL문의 LIKE 처럼 사용되어짐.
	// 복수개의 And 조건 :   findByField1AndField2(String field1, String field2)
	// 복수개의 Or 조건 :    findByField1OrField2(String field1, String field2)
	
	// findBy테이블로사용되는필드명_컬럼명으로사용되는필드명() =>  _ 앞은 테이블명 _ 뒤는 컬럼명 으로 인식한다. SQL문의 = 로 사용되어짐.
	// findBy테이블로사용되는필드명_컬럼명으로사용되는필드명Containing() => Containing : SQL문의 LIKE 처럼 사용되어짐.
	
	public List<Board> findBySubjectContainingOrContentContaining(String subject_searchWord, String content_searchWord);
	public List<Board> findBySubjectContaining(String searchWord);
	public List<Board> findByContentContaining(String searchWord);
	
	public List<Board> findByMember_UserNameContaining(String searchWord);
		
	@Transactional	// 필수
	@Modifying		// update, insert 시
	@Query(value = "UPDATE tbl_board SET readcount=readcount+1 WHERE num = :num",
		   nativeQuery = true) // false:JPQL, true:SQL
	public int updateReadCount(@Param("num") long num);
	
}

/*
	작성한 InterMemberRepository 를 이용해 작성된 테이블(tbl_member)에 SQL문장 없이 CRUD 작업이 되어진다. 
	JpaRepository 는 아래와 같은 메소드를 사용하여 CRUD 작업이 되어진다.
	
	- insert 작업 : save(엔티티 객체) 
	- select 작업 : findAll(), findById(키 타입)
	- update 작업 : save(엔티티 객체) 
	- delete 작업 : deleteById(키 타입) 
	특이하게도 insert와 update 작업에는 동일한 메서드인 save()를 이용하는데 
	그 이유는 JPA의 구현체가 메모리상(엔티티들을 관리해주는 Entity Manager 가 메모리에 올라감)에서 
	행이 없다면 insert, 행이 존재한다면 update 를 동작시키는 방식으로 실행되기 때문이다.
*/
