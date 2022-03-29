DROP TABLE
IF
EXISTS seat;
CREATE TABLE seat ( id INT, student VARCHAR ( 255 ) );
INSERT INTO seat ( id, student )
VALUES
( '1', 'Abbot' ),
( '2', 'Doris' ),
( '3', 'Emerson' ),
( '4', 'Green' ),
( '5', 'Jeames' );

-- 编写SQL查询来交换每两个连续的学生的座位号。如果学生的数量是奇数，则最后一个学生的id不交换
select s1.id - 1 as id, s1.student
from seat s1
where s1.id mod 2 = 0 union
select s2.id + 1 as id, s2.student
from seat s2
where s2.id mod 2 = 1
    and s2.id != (select max(s3.id) from seat s3) union
select s4.id as id, s4.student
from seat s4
where s4.id mod 2 = 1
    and s4.id = (select max(s5.id) from seat s5)
order by id;
