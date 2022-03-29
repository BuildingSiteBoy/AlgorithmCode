DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee ( Id INT, NAME VARCHAR ( 255 ), Salary INT, DepartmentId INT );
DROP TABLE IF EXISTS Department;
CREATE TABLE Department ( Id INT, NAME VARCHAR ( 255 ) );
INSERT INTO Employee ( Id, NAME, Salary, DepartmentId )
VALUES
( 1, 'Joe', 70000, 1 ),
( 2, 'Henry', 80000, 2 ),
( 3, 'Sam', 60000, 2 ),
( 4, 'Max', 90000, 1 );
INSERT INTO Department ( Id, NAME )
VALUES
( 1, 'IT' ),
( 2, 'Sales' );

-- 编写SQL查询以查找每个部门中薪资最高的员工
/*
创建一个临时表，包含了部门员工的最大薪资。可以对部门进行分组，然后使用 MAX() 汇总函数取得最大薪资。
之后使用连接找到一个部门中薪资等于临时表中最大薪资的员工.
*/
select d.NAME Department, e.NAME Employee, e.Salary Salaty
from Employee e,
    Department d,
    (select DepartmentId, max(Salary) Salary from Employee group by DepartmentId) m
where
    e.DepartmentId = d.Id
    and e.DepartmentId = m.DepartmentId
    and e.Salary = m.Salary
