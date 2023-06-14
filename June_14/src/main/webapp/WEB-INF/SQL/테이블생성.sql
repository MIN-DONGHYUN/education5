
show user;
-- USER이(가) "JSPBEGIN_USER"입니다.

select * from tab;

----- ==== *** 휴지통 조회하기 *** ==== -----
select * 
from user_recyclebin;

purge recyclebin;  -- 휴지통에 있던 모든 테이블들을 영구히 삭제하는 것이다.
-- Recyclebin이(가) 비워졌습니다.

select *
from user_constraints
where table_name = 'TBL_MEMBER'; 

select *
from user_constraints
where table_name = 'TBL_BOARD';

select *
from user_cons_columns
where table_name = 'TBL_BOARD';

select *
from user_sequences
where sequence_name = 'SEQ_BOARD';

---------------------------------------------------

INSERT INTO tbl_member(userId, userName, userPwd, reg_date) VALUES ('admin', '관리자', 'qwer1234$', DEFAULT);
INSERT INTO tbl_member(userId, userName, userPwd, reg_date) VALUES ('leess', '이순신', 'qwer1234$', DEFAULT);
INSERT INTO tbl_member(userId, userName, userPwd, reg_date) VALUES ('eomjh', '엄정화', 'qwer1234$', DEFAULT); 
COMMIT;


desc tbl_member;
---------------------------------------------------
/* 
CREATE TABLE tbl_member (
    userId    VARCHAR2(50) NOT NULL,
    userName  VARCHAR2(30) NOT NULL,
    userPwd   VARCHAR2(50) NOT NULL,
    reg_date  DATE DEFAULT SYSDATE,
    constraint PK_tbl_member_userId PRIMARY KEY(userId)
);

INSERT INTO tbl_member(userId, userName, userPwd, reg_date) VALUES ('admin', '관리자', 'qwer1234$', DEFAULT);
INSERT INTO tbl_member(userId, userName, userPwd, reg_date) VALUES ('leess', '이순신', 'qwer1234$', DEFAULT);
INSERT INTO tbl_member(userId, userName, userPwd, reg_date) VALUES ('eomjh', '엄정화', 'qwer1234$', DEFAULT); 
COMMIT;

CREATE TABLE tbl_board (
    num        NUMBER NOT NULL,
    fk_userId  VARCHAR2(50) NOT NULL,
    subject    VARCHAR2(200) NOT NULL,
    content    VARCHAR2(4000) NOT NULL,
    readCount  NUMBER  DEFAULT 0,
    reg_date   DATE DEFAULT SYSDATE,
    constraint PK_tbl_board_num PRIMARY KEY(num),
    constraint FK_tbl_board_userId FOREIGN KEY(fk_userId) REFERENCES tbl_member(userId)
);

CREATE SEQUENCE seq_board
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE
NOCACHE;
*/
