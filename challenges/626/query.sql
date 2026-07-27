/* Write your PL/SQL query statement below */
with
nseats as (
    select count(id) as c
    from Seat
),
rseat as (
    select (
        case
            when mod(id, 2) = 0 then id - 1
            when id < c then id + 1
            else id
        end
    ) as id, student
    from Seat, nseats
)
select *
from rseat
order by id asc;