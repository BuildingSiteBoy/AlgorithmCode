DROP TABLE
IF
EXISTS Employee;
CREATE TABLE Employee ( Id INT, Salary INT );
INSERT INTO Employee ( Id, Salary )
VALUES
( 1, 100 ),
( 2, 200 ),
( 3, 300 );

-- 编写一个SQL查询来报告 Employee 表中第 n 高的工资。如果没有第 n 个最高工资，查询应该报告为 null
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N = N - 1;
  RETURN (
--       # Write your MySQL query statement below.
      select (
        select distinct Salary
        from Employee
        order by Salary desc
        limit N, 1
      )
  );
END
