DROP TABLE
IF
EXISTS World;
CREATE TABLE World ( NAME VARCHAR ( 255 ), continent VARCHAR ( 255 ), area INT, population INT,
gdp INT );
INSERT INTO World ( NAME, continent, area, population, gdp )
VALUES
( 'Afghanistan', 'Asia', '652230', '25500100', '203430000' ),
( 'Albania', 'Europe', '28748', '2831741', '129600000' ),
( 'Algeria', 'Africa', '2381741', '37100000', '1886810000' ),
( 'Andorra', 'Europe', '468', '78115', '37120000' ),
( 'Angola', 'Africa', '1246700', '20609294', '1009900000' );

-- 如果一个国家满足下述两个条件之一，则认为该国是 大国 ：
--
-- 面积至少为 300 平方公里（即，3000000 km2），或者
-- 人口至少为 2500 万（即 25000000）
-- 编写一个 SQL 查询以报告 大国 的国家名称、人口和面积

from World
where population > 25000000 or area > 3000000;
