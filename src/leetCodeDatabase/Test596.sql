DROP TABLE
IF
EXISTS courses;
CREATE TABLE courses ( student VARCHAR ( 255 ), class VARCHAR ( 255 ) );
INSERT INTO courses ( student, class )
VALUES
( 'A', 'Math' ),
( 'B', 'English' ),
( 'C', 'Math' ),
( 'D', 'Biology' ),
( 'E', 'Math' ),
( 'F', 'Computer' ),
( 'G', 'Math' ),
( 'H', 'Math' ),
( 'I', 'Math' );

-- 编写一个SQL查询来报告 至少有5个学生 的所有类
select class
from courses
group by class
having count(distinct student) >= 5;
