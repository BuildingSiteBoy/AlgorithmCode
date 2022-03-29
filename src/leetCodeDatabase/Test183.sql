DROP TABLE
IF
EXISTS Customers;
CREATE TABLE Customers ( Id INT, NAME VARCHAR ( 255 ) );
DROP TABLE
IF
EXISTS Orders;
CREATE TABLE Orders ( Id INT, CustomerId INT );
INSERT INTO Customers ( Id, NAME )
VALUES
( 1, 'Joe' ),
( 2, 'Henry' ),
( 3, 'Sam' ),
( 4, 'Max' );
INSERT INTO Orders ( Id, CustomerId )
VALUES
( 1, 3 ),
( 2, 1 );

-- 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户
-- 左外连接
select c.NAME as Customers
from Customers c
left join Orders o
on c.Id = o.CustomerId
where o.CustomerId is null;

-- 子查询
select NAME as Customers
from Customers
where id not in (
    select CustomerId
    from Orders
);
