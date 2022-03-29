DROP TABLE
IF
EXISTS Employee;
CREATE TABLE Employee ( Id INT, Salary INT );
INSERT INTO Employee ( Id, Salary )
VALUES
( 1, 100 ),
( 2, 200 ),
( 3, 300 );

-- 编写一个 SQL 查询，获取并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null
-- 为了在没有查找到数据时返回 null，需要在查询结果外面再套一层 SELECT。
select (
    select distinct Salary
    from Employee
    order by Salary desc
    limit 1, 1
) SecondHighestSalary;

/*
limit 与 offset：从下标0开始

     offset X   是跳过X个数据

     limit Y      是选取Y个数据

     limit  X,Y  中X表示跳过X个数据，读取Y个数据

     例如： select * from table limit 2,1;   // 跳过2个数据，读取1个数据
*/
