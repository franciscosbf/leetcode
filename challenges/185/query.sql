/* Write your PL/SQL query statement below */
with
osalaries as (
    select distinct departmentid, salary
    from Employee
    order by departmentid, salary desc
),
nsalaries as (
    select departmentid, salary, rownum as pos
    from osalaries
),
hsalaries as (
    select departmentid, pos
    from nsalaries n
    where salary = (
        select max(o.salary)
        from osalaries o
        where n.departmentid = o.departmentid
    )
),
rsalaries as (
    select departmentid, n.salary as salary
    from nsalaries n inner join hsalaries h using (departmentid)
    where n.pos - h.pos < 3 
)
select d.name as Department, e.name as Employee, salary as Salary
from rsalaries inner join Employee e using (departmentid, salary)
               inner join Department d on (d.id = departmentid);

with ranked as (
    select
        d.name as Department,
        e.name as Employee, 
        salary as Salary,
        dense_rank() over (partition by d.name order by salary desc) as pos
    from Employee e inner join Department d on (e.departmentid = d.id)
)
select Department, Employee, Salary
from ranked
where pos <= 3;