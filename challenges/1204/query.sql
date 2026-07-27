/* Write your PL/SQL query statement below */
with
ordq as (
    select *
    from Queue
    order by turn asc
),
boarded as (
    select q1.person_name as person_name, q1.turn as turn
    from ordq q1
    where 1000 >= (
        select sum (q2.weight)
        from Queue q2
        where q2.turn <= q1.turn
    )
)
select person_name
from boarded
where turn = (
    select max(turn) from boarded
);