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
