package com.jpa.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
>>> @Entity <<<
- JPA가 관리하는 클래스로, 해당 클래스를 엔티티라고 부른다.
- 엔티티는 자바에서 객체지향적인 코드를 작성할 때 DB의 테이블과 매핑되는 클래스의 이름이다.
- JPA를 사용하여 테이블과 매핑해야할 클래스는 반드시 @Entity를 선언해야한다.
- 일반적으로 클래스명과 동일한 이름을 사용하기 때문에 엔티티 이름을 변경하지 않는다. 
  만약 엔티티 이름을 변경하고 싶을 때는 @Entity(name="myMember") 와 같은 형식의 어노테이션을 붙이면 된다.
- 속성 
  name : JPA에서 사용할 엔티티 이름을 지정. 일반적으로 기본값인 클래스 이름을 사용하며 생략 가능.
  
- 주의사항
    ㆍ기본 생성자는 필수 (JPA가 엔티티 객체 생성 시 기본 생성자를 사용하기 때문이다)
    ㆍfinal 클래스, enum, interface, inner class 에는 사용할 수 없음.
    ㆍ저장할 필드에 final 사용 불가함.  
*/
@Entity      // 이 클래스가 table로 쓰이는 역할을 할 수 있게 도와준다.
public class Guestbook {  // 클래스명이 Guestbook 이라면 Hibernate : create table guestbook(... ) 
	                      // 클래스명이 GuestBook 이라면 Hibernate : create table guest_book(... ) 
	                      // 클래스명이 Guest_Book 이라면 Hibernate : create table guest_book(... ) 
	                      // 클래스명이 Guest_book 이라면 Hibernate : create table guest_book(... ) 
	                      // 그러므로 엔티티 클래스명을 줄때는 대소문자 혼합 및 _ 없이 첫글자만 대문자 나머지는 모두 소문자로 만드는 것을 권장한다.
/*	@Id  // 엔티티에 기본키(Primary Key)를 매핑 해주는 것이다. 지정 가능한 데이터 타입은 자바의 모든 primitive 타입과 그 래퍼타입을 사용할 수 있다.
	     // @Column 애노테이션을 지정하지 않으면 필드의 이름이 열 이름 으로 되어진다.
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 기본키(Primary Key)를 생성하는 방법을 지정한다. 
	                                                     // 항상 @Id 애노테이션과 같이 선언된다.
	                                                     // GenerationType.IDENTITY 은 기본 키 생성을 데이터베이스에 위임하는 것으로 AUTO_INCREMENT 된다. 
    private long num;
*/
	@Id     // @ID를 쓰면은 primary key로 매핑 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num;
	
/*	
	@Column(length = 500, nullable = false) // @Column 은 엔티티 클래스의 멤버 변수를 DB Table의 Column 에 매핑하는 것이다.
	                                        // length 는 문자 길이를 제한한다. String 타입에만 사용한다. 
	                                        // nullable 은 컬럼 값이 NULL이 될 수 있는지 선택한다.(기본 값 : true)
*/
	@Column(length = 500, nullable = false)
	private String title;
	
/*	
	@Column(columnDefinition = "TEXT", nullable = false) // TEXT 데이터타입은 VARCHAR2 데이터 유형과 동일하며 최대 4000 바이트이다.
	                                                     // columnDefinition 은 직접 column 정보를 작성하는 것이다.
*/
	@Column(columnDefinition = "TEXT", nullable = false) 
	private String content;
	
	@Column(length = 50, nullable = false)
	private String writer;
	 
	
	// 기본 생성자는 필수 (JPA가 엔티티 객체 생성 시 기본 생성자를 사용하기 때문이다)
	public Guestbook() {
	}
	
	public Guestbook(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
