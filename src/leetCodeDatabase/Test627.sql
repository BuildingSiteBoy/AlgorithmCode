DROP TABLE
IF
EXISTS salary;
CREATE TABLE salary ( id INT, NAME VARCHAR ( 100 ), sex CHAR ( 1 ), salary INT );
INSERT INTO salary ( id, NAME, sex, salary )
VALUES
( '1', 'A', 'm', '2500' ),
( '2', 'B', 'f', '1500' ),
( '3', 'C', 'm', '5500' ),
( '4', 'D', 'f', '500' );

-- 编写一个 SQL 查询来交换所有的 'f' 和 'm' （即，将所有 'f' 变为 'm' ，反之亦然），
-- 仅使用 单个 update 语句 ，且不产生中间临时表
update salary
set sex = if (sex = 'f', 'm', 'f');
