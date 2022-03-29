DROP TABLE
IF
EXISTS Person;
CREATE TABLE Person ( PersonId INT, FirstName VARCHAR ( 255 ), LastName VARCHAR ( 255 )
);
DROP TABLE
IF
EXISTS Address;
CREATE TABLE Address ( AddressId INT, PersonId INT, City VARCHAR ( 255 ), State VARCHAR
( 255 ) );
INSERT INTO Person ( PersonId, LastName, FirstName )
VALUES
( 1, 'Wang', 'Allen' );
INSERT INTO Address ( AddressId, PersonId, City, State )
VALUES
( 1, 2, 'New York City', 'New York' );

-- 编写一个SQL查询来报告 Person 表中每个人的姓、名、城市和状态。如果 personId 的地址不在 Address 表中，则报告为空  null
-- 使用左外连接
select FirstName, LastName, City, State
from Person P
left join Address A
on P.PersonId = A.PersonId;

-- 使用右外连接
select FirstName, LastName, City, State
from Address a
right join Person p
on a.PersonId = p.PersonId;

/*
left join（左联结）:返回左表中的所有记录，和右表中联结字段相等的记录
right join(右联结):同理
inner join(等值联结):只返回两表中联结字段相等的行
*/
