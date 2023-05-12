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
select lag( seq, 1) over(order by seq desc) AS previousseq    
     , lag(subject, 1) over(order by seq desc) AS pervioussubject
     , seq, fk_userid, name, subject, readCount
     , to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') as regdate
     , pw
     , lead (seq,1) over(order by seq desc) AS nextseq
     , lead (subject,1) over(order by seq desc) AS nextsubject
from tbl_board
where status = 1
--order by seq desc;