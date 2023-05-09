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



