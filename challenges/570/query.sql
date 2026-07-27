/* Write your PL/SQL query statement below */
select e1.name
from Employee e1 cross join Employee e2
where e1.managerId and e1.id = e2.managerId
group by e1.name
having count(e2.id) >= 5;