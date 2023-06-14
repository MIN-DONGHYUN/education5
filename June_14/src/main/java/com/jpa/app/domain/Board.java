package com.jpa.app.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_board")
public class Board {

	@Id
	@Column(name = "num", columnDefinition = "NUMBER")
	@SequenceGenerator(name="SEQ_BOARD_GENERATOR", sequenceName = "seq_board", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD_GENERATOR")
	private long num;
	
	@Column(name="fk_userid", nullable = false, length = 50, updatable = false)
	private String fk_userId;
	
	@Column(nullable = false, length = 500)
	private String subject;
	
	@Column(nullable = false, length = 4000)
	private String content;
	
	// 컬럼명에 _가 있는 경우 findBy~ 등으로 검색이 불가능하므로 비록 DB 컬럼명에는 _ 가 있더라도 아래와 같이 자바 필드명에는 _를 넣지 않도록 설정해야 한다.
	// 필드명에 _가 들어가 있는 경우 JpaRepository 상속 받는 인터페이스에서 findBy~ 을 사용하여 검색하는 메소드 작성시 _ 앞은 테이블명 _ 뒤는 컬럼명 으로 인식하기 때문에 이상하게 꼬여지기 때문에 _ 를 넣지 않도록 설정해야 한다.
	@Column(name = "reg_date", nullable = false, columnDefinition = "DATE DEFAULT SYSDATE", 
			updatable = false)  // 이 필드는 UPDATE 제외
	private LocalDateTime regdate;
	
	@Column(name = "readcount", nullable = false, columnDefinition = "NUMBER DEFAULT 0",
			insertable = false, updatable = false) // 이 필드는 INSERT, UPDATE 제외
	private int readCount; // readCount 는 read_count 로 인식되므로 name 속성이 필요 

	// 연관관계 정의
	@ManyToOne // name = "외래키컬럼명", referencedColumnName = "참조당하는컬럼명" 이다. // insertable = false, updatable = false 으로 설정해야만 한다. !!! 중요 !!!   
	@JoinColumn(name = "fk_userid", referencedColumnName = "userid", insertable = false, updatable = false) // Board 엔티티의 fk_userid 컬럼을 Member 엔티티의 userid 컬럼을 참조하는 foreign key 키로 설정함.     
	private Member member;
	
	
	@PrePersist // INSERT 전에 호출한다. 
	public void prePersist() {
		this.regdate = this.regdate == null ? 
				LocalDateTime.now() : this.regdate;
	}
	
	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getFk_userId() {
		return fk_userId;
	}

	public void setFk_userId(String fk_userId) {
		this.fk_userId = fk_userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}
