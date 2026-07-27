/* Write your PL/SQL query statement below */
with
sranks as (
    select distinct salary, dense_rank() over (order by salary desc) as srank
    from Employee
)
(
    select salary as SecondHighestSalary
    from sranks
    where srank = 2
)
union
(
    select null as SecondHighestSalary
    from dual
    where (select count(*) from sranks) < 2
);

select max(salary) as SecondHighestSalary
from Employee
where salary < (
    select max(salary)
    from Employee
);