/* Write your PL/SQL query statement below */
select to_char(activity_date) as day, count(distinct user_id) as active_users
from Activity
where activity_date > to_date('2019-06-27', 'yyyy-mm-dd') and
      activity_date <= to_date('2019-07-27', 'yyyy-mm-dd')
group by activity_date;