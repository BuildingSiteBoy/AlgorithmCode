DROP TABLE
IF
EXISTS Person;
CREATE TABLE Person ( Id INT, Email VARCHAR ( 255 ) );
INSERT INTO Person ( Id, Email )
VALUES
( 1, 'a@b.com' ),
( 2, 'c@d.com' ),
( 3, 'a@b.com' );

-- 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱
select Email
from Person
group by Email
having count (*) >= 2;
