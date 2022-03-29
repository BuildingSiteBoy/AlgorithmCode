DROP TABLE
IF
EXISTS Person;
CREATE TABLE Person ( Id INT, Email VARCHAR ( 255 ) );
INSERT INTO Person ( Id, Email )
VALUES
( 1, 'a@b.com' ),
( 2, 'c@d.com' ),
( 3, 'a@b.com' );

-- 编写一个SQL查询来 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件
-- 连接查询
delete p1
from person p1, person p2
where p1.email = p2.email and p1.id > p2.id;

-- 子查询
delete
from Person
where id not in (
    select Id
    from (
        select min(id) as id
        from Person
        group by Email
    ) as m
);
