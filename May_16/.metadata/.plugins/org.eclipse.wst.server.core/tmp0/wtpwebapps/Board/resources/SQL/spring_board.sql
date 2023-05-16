------ ***** spring 기초 ***** -----

show user;
-- USER이(가) "MYMVC_USER"입니다.

create table spring_test
(no         number
,name       varchar2(100)
,writeday   date default sysdate
);
-- Table SPRING_TEST이(가) 생성되었습니다.


select no, name, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday
from spring_test
order by writeday desc;


delete from spring_test
where NO = 601;

commit;


---------------------------------------------------------------------------
select * from tab;

select * 
from TBL_MAIN_IMAGE;

select imgfilename
from TBL_MAIN_IMAGE
order by imgno desc;

-- 모든 맴버 조회 비밀번호는 암호화가 되어 있다.
select * 
from tbl_member;

select * 
from tbl_member
where idle = 1;

select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender,
       birthyyyy , birthmm, birthdd, coin, point, registerday, idle 
       pwdchangegap ,  
       NVL(lastlogingap, trunc(months_Between(sysdate, registerday)))  AS lastlogingap 
from 
( 
    select userid, name, email, mobile, postcode, address, detailaddress, extraaddress, gender
         , substr(birthday, 1 , 4) AS birthyyyy , substr(birthday, 6 , 2) AS birthmm , substr(birthday, 9) AS birthdd 
		 , coin, point, to_char(registerday, 'yyyy-mm-dd') AS registerday , idle 
		 , trunc(months_between(sysdate, lastpwdchangedate), 0) AS pwdchangegap  
    from tbl_member
	where status = 1 and userid = 'mdh2057' and pwd = '9695b88a59a1610320897fa84cb7e144cc51f2984520efb77111d94b402a8382'
) M  
CROSS JOIN 
( 
    select trunc(months_Between(sysdate, max(logindate)),0) AS lastlogingap 
    from tbl_loginhistory 
    where fk_userid = 'mdh2057'
) H ;


select * 
from tbl_member
where userid= 'iyou1';

select * 
from tbl_loginhistory
where fk_userid = 'iyou1';

update tbl_member set registerday = add_months(registerday, -12), lastpwdchangedate = add_months(lastpwdchangedate, -12) 
where userid= 'iyou1';
-- 1 행 이(가) 업데이트되었습니다.

commit;

    ------- **** spring 게시판(답변글쓰기가 없고, 파일첨부도 없는) 글쓰기 **** -------

show user;
-- USER이(가) "MYMVC_USER"입니다.    
    
    
desc tbl_member;

create table tbl_board
(seq         number                not null    -- 글번호
,fk_userid   varchar2(20)          not null    -- 사용자ID
,name        varchar2(20)          not null    -- 글쓴이 
,subject     Nvarchar2(200)        not null    -- 글제목
,content     Nvarchar2(2000)       not null    -- 글내용   -- clob (최대 4GB까지 허용) 
,pw          varchar2(20)          not null    -- 글암호
,readCount   number default 0      not null    -- 글조회수
,regDate     date default sysdate  not null    -- 글쓴시간
,status      number(1) default 1   not null    -- 글삭제여부   1:사용가능한 글,  0:삭제된글
,constraint PK_tbl_board_seq primary key(seq)
,constraint FK_tbl_board_fk_userid foreign key(fk_userid) references tbl_member(userid)
,constraint CK_tbl_board_status check( status in(0,1) )
);

create sequence boardSeq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

select *
from tbl_board
order by seq desc;

select seq, fk_userid, name, subject, readCount, to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') as regdate
from tbl_board
where status = 1
order by seq desc;


-- 게시판 이전글, 다음글을 볼 수 있는 것이다.
--1 은 올라가는 개수 lag는 나보다 먼저 쓴 글을 말함 , lead는 나보다 뒤에 쓴 글을 말함 (최신)
select previousseq, pervioussubject
     , seq, fk_userid, name, subject, readCount
     , regdate , pw , nextseq , nextsubject
from
    (
    select lag( seq, 1) over(order by seq desc) AS previousseq    
         , lag(subject, 1) over(order by seq desc) AS pervioussubject
         , seq, fk_userid, name, subject, readCount
         , to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') as regdate
         , pw
         , lead (seq,1) over(order by seq desc) AS nextseq
         , lead (subject,1) over(order by seq desc) AS nextsubject
    from tbl_board
    where status = 1
) V
where V.seq = 4;
--order by seq desc;

-- 업데이트 할 때 비밀번호가 틀리면 업데이트가 되지 않는다.
update tbl_board set subject = '호호호', content = '하하하 헤헤헤' 
where seq = 3 and pw = 'asdsa';   


-------------------------------------------------------------------------------------

    ------ ***** 댓글 게시판 ***** ---------

/*
    댓글쓰기(tbl_comment 테이블)를 성공하면 원게시물(tbl_board 테이블)에 
    댓글의 개수(1씩 증가)를 알려주는 컬럼 commentCount 을 추가하겠다.
*/

drop table tbl_board purge;

create table tbl_board
(seq           number                not null    -- 글번호
,fk_userid     varchar2(20)          not null    -- 사용자ID
,name          varchar2(20)          not null    -- 글쓴이 
,subject       Nvarchar2(200)        not null    -- 글제목
,content       Nvarchar2(2000)       not null    -- 글내용   -- clob (최대 4GB까지 허용) 
,pw            varchar2(20)          not null    -- 글암호
,readCount     number default 0      not null    -- 글조회수
,regDate       date default sysdate  not null    -- 글쓴시간
,status        number(1) default 1   not null    -- 글삭제여부   1:사용가능한 글,  0:삭제된글
,commentCount  number default 0      not null    -- 댓글의 개수
,constraint PK_tbl_board_seq primary key(seq)
,constraint FK_tbl_board_fk_userid foreign key(fk_userid) references tbl_member(userid)
,constraint CK_tbl_board_status check( status in(0,1) )
);

drop sequence boardSeq;

create sequence boardSeq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

----- **** 댓글 테이블 생성 **** -----
create table tbl_comment
(seq           number               not null   -- 댓글번호
,fk_userid     varchar2(20)         not null   -- 사용자ID
,name          varchar2(20)         not null   -- 성명
,content       varchar2(1000)       not null   -- 댓글내용
,regDate       date default sysdate not null   -- 작성일자
,parentSeq     number               not null   -- 원게시물 글번호
,status        number(1) default 1  not null   -- 글삭제여부
                                               -- 1 : 사용가능한 글,  0 : 삭제된 글
                                               -- 댓글은 원글이 삭제되면 자동적으로 삭제되어야 한다.
,constraint PK_tbl_comment_seq primary key(seq)
,constraint FK_tbl_comment_userid foreign key(fk_userid) references tbl_member(userid)
,constraint FK_tbl_comment_parentSeq foreign key(parentSeq) references tbl_board(seq) on delete cascade
,constraint CK_tbl_comment_status check( status in(1,0) ) 
);

create sequence commentSeq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

select *
from tbl_comment
order by seq desc;

select *
from tbl_board
order by seq desc;



-- ==== Transaction 처리를 위한 시나리오 만들기 ==== --
---- 회원들이 게시판에 글쓰기를 하면 글작성 1건당 POINT 를 100점을 준다.
---- 회원들이 게시판에서 댓글쓰기를 하면 댓글작성 1건당 POINT 를 50점을 준다.
---- 그런데 데이터베이스 오류 발생시 스프링에서 롤백해주는 Transaction 처리를 알아보려고 일부러 POINT 는 300을 초과할 수 없다고 하겠다.

select * 
from tbl_member;
 
update tbl_member set point = 0;

commit;

-- tbl_member 테이블에 POINT 컬럼에 check 제약을 추가한다
alter table tbl_member 
add constraint Ck_tbl_member_point check( point between 0 and 300);
-- Table TBL_MEMBER이(가) 변경되었습니다.

-- check 제약 확인하기 
update tbl_member set point = 301
where userid = 'mdh2057';
--update tbl_member set point = 301
--where userid = 'mdh2057'
--오류 보고 -
--ORA-02290: 체크 제약조건(MYMVC_USER.CK_TBL_MEMBER_POINT)이 위배되었습니다

update tbl_member set point = 200
where userid = 'mdh2057';
-- 1 행 이(가) 업데이트되었습니다.


-- 커밋 OR 롤백
commit;
-- 커밋 완료.
rollback;
-- 롤백 완료.

-- 현재 포인트 상황 
select userid, point
from tbl_member
where userid = 'mdh2057';



select *
from tbl_comment
order by seq desc;

select *
from tbl_board
order by seq desc;


select name, content, to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') AS regdate 
from tbl_comment
where status = 1 and parentseq = 3;



--- *** transaction 처리를 위해서 일부러 만들어 두었던 포인트 체크제약을 없애겠다. *** ---
--- *** tbl_member 테이블에 존재하는 제약조건 조회하기 *** ---
select *
from user_constraints
where table_name = 'TBL_MEMBER';

alter table tbl_member
drop constraint CK_TBL_MEMBER_POINT;
-- Table TBL_MEMBER이(가) 변경되었습니다.


-- distinct 는 한번만 나오게 하는 것이다. 
-- distinct 는 order by 가 있으면 오류가 난다. (select 에 표시하는것은 상관없다.)
/* select 문에서 distinct 와 order by 절을 함께 사용할때는 조심해야 한다.
           order by 절에는 select 문에서 사용된 컬럼만 들어올 수가 있다.
               또는 order by 절을 사용하지 않아야 한다.
*/

-- 오류
select distinct name
from tbl_board
where status = 1 and lower(name) like '%' || lower('정화') || '%'
order by commentcount desc, seq desc;

-- 오류 안남 

-- 가능 select 절에 있는 컬럼만 order by 가능
select distinct name
from tbl_board
where status = 1 and lower(name) like '%' || lower('정화') || '%'
order by name asc;

insert into tbl_board(seq, fk_userid, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, 'mdh2057', '민동현', 'JSP 가 뭔가요?', '웹페이지를 작성하려고 합니다.', '1234', default, default, default);

insert into tbl_board(seq, fk_userid, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, 'eomjh', '김정화', 'Korea VS Japan 라이벌 축구대결', '많은 시청 바랍니다.', '1234', default, default, default);

insert into tbl_board(seq, fk_userid, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, 'eomjh', '엄정화', 'java가 재미 있나요?', '궁금합니다. JAVA가 뭔지요?', '1234', default, default, default);

commit;
-- 커밋완료


