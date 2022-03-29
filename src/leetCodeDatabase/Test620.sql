DROP TABLE
IF
EXISTS cinema;
CREATE TABLE cinema ( id INT, movie VARCHAR ( 255 ), description VARCHAR ( 255 ),
rating FLOAT ( 2, 1 ) );
INSERT INTO cinema ( id, movie, description, rating )
VALUES
( 1, 'War', 'great 3D', 8.9 ),
( 2, 'Science', 'fiction', 8.5 ),
( 3, 'irish', 'boring', 6.2 ),
( 4, 'Ice song', 'Fantacy', 8.6 ),
( 5, 'House card', 'Interesting', 9.1 );

-- 找出所有影片描述为非 boring (不无聊) 的并且 id 为奇数 的影片，结果请按等级 rating 排列
select id, movie, description, rating
from cinema
where id % 2 = 1 and description != 'boring'
order by rating desc;
