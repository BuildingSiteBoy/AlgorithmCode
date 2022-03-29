DROP TABLE
IF
EXISTS Employee;
CREATE TABLE Employee ( Id INT, NAME VARCHAR ( 255 ), Salary INT, ManagerId INT );
INSERT INTO Employee ( Id, NAME, Salary, ManagerId )
VALUES
( 1, 'Joe', 70000, 3 ),
( 2, 'Henry', 80000, 4 ),
( 3, 'Sam', 60000, NULL ),
( 4, 'Max', 90000, NULL );

-- 编写一个SQL查询来查找收入比经理高的员工
select e1.NAME as Employee
from Employee e1
inner join Employee e2
on e1.ManagerId = e2.ManagerId and e1.Salary > e2.Salary;
