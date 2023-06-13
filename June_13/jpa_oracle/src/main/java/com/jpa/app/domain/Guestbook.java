package com.jpa.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
    
    
>>> @Table <<<
 - 엔티티와 매핑할 RDBMS 의 테이블명을 지정하는 것이다.
 - @Table(name="tbl_member") 같은 형식의 어노테이션을 붙여서 엔티티와 매핑하는 테이블명을 지정해준다.
 - 속성
   name(String, Optional) : 매핑할 테이블 이름을 지정한다.(기본 값: 엔티티 이름)
   catalog(String, Optional) : 데이터베이스 catalog를 매핑 한다.
   schema(String, Optional) : 데이터베이스 schema를 매핑 한다.
   indexes(Index[], Optional) : 데이터베이스 인덱스를 매핑 한다.
   uniqueConstraints(UniqueConstraint[], Optional) : DDL 생성 시 유니크 제약조건을 생성한다.

   
>>> @SequenceGenerator <<<
  - DB에 생성한 시퀀스를 바탕으로 식별자를 생성하는 시퀀스 생성기를 설정하는 애노테이션
  - 시퀀스는 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트 이다.
  - 주로 Oracle, PostgreSQL, H2 등에서 사용한다.
  - 엔티티를 persist(영속) 하는 시점에 데이터베이스 INSERT SQL 을 보내지 않고, 시퀀스 값만 얻어 영속성 컨텍스트에 저장한 뒤 트랜잭션 커밋시점에 INSERT SQL 을 보낸다.
  - 엔티티 별로 시퀀스를 별도로 관리하고 싶다면 @SequenceGenerator 를 사용해야 한다.
  - 속성
    ㆍname : @GeneratedValue에서 지정할 수 있는 시퀀스 생성기 이름을 등록. 필수
    ㆍsequenceName : 데이터베이스에 생성해둔 시퀀스 이름
    ㆍinitialValue : DDL 생성 하는경우 사용하며, 시퀀스를 생성할 DDL에서 처음 시작하는 값을 지정. 기본값 1
    ㆍallocationSize : JPA에서 가상으로 관리할 시퀀스 할당 범위로 성능 최적화를 위해 값을 수정할 수 있다. 기본값은 50이며, 1로 설정하는 경우 매번 insert시 마다 DB의 시퀀스를 호출  
    ㆍcatalog, schema : DB의 카타로그와 스키마 이름   


>>> @GeneratedValue <<<
 - 기본키(Primary Key)를 생성하는 방법을 지정한다. 
 - @Id 애노테이션과 같이 선언된다.
 - 기본키(Primary Key) 생성 전략
    (1) AUTO
      ㆍ 선택한 데이터베이스에 따라 방식을 자동으로 선택(기본이 AUTO 이다.)
      ㆍ 예 : 오라클 DB는 SEQUENCE, MySQL DB는 IDENTITY 사용함.
    (2) IDENTITY
        기본 키 생성을 데이터베이스에 위임(AUTO_INCREMENT)
    (3) SEQUENCE
      ㆍ데이터베이스 시퀀스를 사용해서 기본 키를 할당함.
      ㆍ데이터베이스 시퀀스에서 식별자 값을 획득한 후 영속성 컨텍스트에 저장함.
      ㆍ유일한 값을 순서대로 생성함(오라클, PostgreSQL, DB2, H2)
    (4) TABLE
      ㆍ키 생성 테이블을 사용
      ㆍ키 생성 전용 테이블 하나를 만들고 여기에 이름과 값으로 사용할 컬럼을 만들어 시퀀스를 흉내 내는 전략
      ㆍ테이블을 사용하므로 모든 데이터베이스에 적용 가능
 - 속성
    (1) generator(String, Optional)
         @SequenceGenerator, @TableGenerator에서 명시된 기본 키 생성기 이름
    (2) strategy(GenerationType, Optional)
         ㆍ스트래터지는 기본 키 생성 전략
         ㆍGenerationType.AUTO
             DB에 따라 나머지 세 가지 전략을 자동으로 지정한다.(기본 값)
         ㆍGenerationType.IDENTITY
             기본 키 생성을 데이터베이스에 위임한다.
             id 값을 null로 하면 DB가 알아서 AUTO_INCREMENT 를 수행한다.
         ㆍGenerationType.SEQUENCE
             데이터베이스 Sequence Object를 사용한다.
             DB Sequence는 유일한 값을 순서대로 생성하는 특별한 데이터베이스 오브젝트
             DB가 자동으로 숫자를 만들어준다. @SequenceGenerator가 필요하다.
         ㆍGenerationType.TABLE
             키 생성 전용 테이블 하나를 만들어 데이터베이스 Sequence 를 흉내 내는 전략.
             @TableGenerator가 필요하다.       
       
*/
@Entity
@Table(name="tbl_guestbook")
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
	@Id
	@Column(columnDefinition = "NUMBER")
	@SequenceGenerator(name = "SEQ_GUESTBOOK_GENERATOR", sequenceName = "SEQ_GUESTBOOK", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GUESTBOOK_GENERATOR")
	private long num;
	
/*	
	@Column(length = 500, nullable = false) // @Column 은 엔티티 클래스의 멤버 변수를 DB Table의 Column 에 매핑하는 것이다.
	                                        // length 는 문자 길이를 제한한다. String 타입에만 사용한다. 
	                                        // nullable 은 컬럼 값이 NULL이 될 수 있는지 선택한다.(기본 값 : true)
*/
	@Column(length = 500, nullable = false)
	private String title;
	

	@Column(length = 4000, nullable = false) 
	private String content;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
/*	
	@Column(columnDefinition = "DATE DEFAULT SYSDATE") // columnDefinition 은 직접 column 정보를 작성하는 것이다.
*/
	
	@Column(columnDefinition = "DATE DEFAULT SYSDATE",
			nullable = false, 
			updatable = false)
	private String reg_date;
	
	// 기본 생성자는 필수 (JPA가 엔티티 객체 생성 시 기본 생성자를 사용하기 때문이다)
	public Guestbook() { }
	
	public Guestbook(String title, String content, String writer, String reg_date) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.reg_date = reg_date;
	}

/*
	@PrePersist 
	 - SQL INSERT 전에 대응된다.
*/
	@PrePersist 
	public void prePersist() {
		this.reg_date = this.reg_date == null ? new java.sql.Date(new java.util.Date().getTime()).toString() : this.reg_date;
	/*	java.sql.Date 클래스는 java.util.Date 클래스를 상속한다
		java.sql.Date 클래스의 사용 목적은 년도, 월, 일을 유지하는 SQL 데이터를 다루기 위함이다.
		다시 말해, java.sql.Date 클래스는 시간 정보가 없이 날짜 정보만 저장하며, JDBC에서 일반적으로 사용된다. 시간 정보는 다루지 않고 0으로 초기화된다.
	*/	
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

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
