# Write your MySQL query statement below
-- select w1.id from weather w1 join weather w2 on w1.recorddate=date_sub(w2.recorddate, interval 1 day) and w1.temperature>w2.temperature;
SELECT w1.id 
FROM weather w1 
JOIN weather w2 
ON w1.recorddate = DATE_ADD(w2.recorddate, INTERVAL 1 DAY) 
AND w1.temperature > w2.temperature;
