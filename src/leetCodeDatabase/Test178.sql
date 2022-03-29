DROP TABLE
IF
EXISTS Scores;
CREATE TABLE Scores ( Id INT, Score DECIMAL ( 3, 2 ) );
INSERT INTO Scores ( Id, Score )
VALUES
( 1, 3.5 ),
( 2, 3.65 ),
( 3, 4.0 ),
( 4, 3.85 ),
( 5, 4.0 ),
( 6, 3.65 );

/*
编写 SQL 查询对分数进行排序。排名按以下规则计算:

分数应按从高到低排列。
如果两个分数相等，那么两个分数的排名应该相同。
在排名相同的分数后，排名数应该是下一个连续的整数。换句话说，排名之间不应该有空缺的数字。
*/
select s1.Score, count (distinct s2.Score) 'Rank'
from Scores s1
    inner join Scores s2
    on s1.Score <= s2.Score
group by s1.Id
order by s1.Score desc;


select s1.score,count(distinct s2.score) as 'rank'
from scores as s1,scores as s2
where s1.score<=s2.score
group by s1.id
order by s1.score desc;
