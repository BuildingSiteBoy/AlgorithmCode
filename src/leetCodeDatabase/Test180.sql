DROP TABLE
IF
EXISTS LOGS;
CREATE TABLE LOGS ( Id INT, Num INT );
INSERT INTO LOGS ( Id, Num )
VALUES
( 1, 1 ),
( 2, 1 ),
( 3, 1 ),
( 4, 2 ),
( 5, 1 ),
( 6, 2 ),
( 7, 2 );

-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
select distinct l1.Num ConsecutiveNums
from LOGS l1, LOGS l2, LOGS l3
where
    l1.Id = l2.Id - 1
    and l2.id = l3.Id - 1
    and l1.Num = l2.Num
    and l1.Num = l3.Num;
