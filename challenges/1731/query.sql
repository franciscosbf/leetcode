/* Write your PL/SQL query statement below */
select m.employee_id, m.name,
       count(s.employee_id) as reports_count,
       round(avg(s.age)) as average_age
from Employees m inner join Employees s on (m.employee_id = s.reports_to)
group by m.employee_id, m.name
order by employee_id;