/* Write your PL/SQL query statement below */
with
vdates as (
    select distinct visited_on as vdate
    from Customer
),
gamounts as (
    select visited_on, sum(amount) as amount
    from Customer
    group by visited_on
)
select
    to_char(vdate, 'yyyy-mm-dd') as visited_on,
    sum(amount) as amount,
    round(avg(amount), 2) as average_amount
from vdates, gamounts
where vdate >= visited_on and vdate - visited_on <= 6
group by vdate
having count(visited_on) = 7
order by vdate asc;

with
collapsed as (
    select visited_on, sum(amount) as amount
    from Customer
    group by visited_on
    order by visited_on asc
),
amounts as (
    select
        to_char(visited_on, 'yyyy-mm-dd') as visited_on,
        sum(amount) over (
            order by visited_on range between interval '6' day preceding and current row
        ) as amount,
        round(avg(amount) over (
            order by visited_on range between interval '6' day preceding and current row
        ), 2) as average_amount, rownum as pos
    from collapsed
)
select visited_on, amount, average_amount
from amounts
where pos > 6;