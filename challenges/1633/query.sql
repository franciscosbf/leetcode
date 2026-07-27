/* Write your PL/SQL query statement below */
with tusers as (select count(*) as c from Users)
select contest_id, round((count(user_id) / c) * 100, 2) as percentage
from Register cross join tusers
group by contest_id, c
order by percentage desc, contest_id asc;