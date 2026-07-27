/* Write your PL/SQL query statement below */
with
edeps as (
    select employee_id, count(department_id) as ndeps
    from Employee
    group by employee_id
)
select employee_id, department_id
from edeps inner join Employee using (employee_id)
where primary_flag = 'Y' and ndeps > 1 or
      primary_flag = 'N' and ndeps = 1;