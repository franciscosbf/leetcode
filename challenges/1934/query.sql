/* Write your PL/SQL query statement below */
with
tconf as (
    select user_id, count(action) as c
    from Confirmations
    group by user_id
),
cconf as (
    select user_id, count(action) as c
    from Confirmations
    where action = 'confirmed'
    group by user_id
)
select user_id, round(nvl(cconf.c, 0) / nvl(tconf.c, 1), 2) as confirmation_rate
from Signups left join tconf using (user_id)
             left join cconf using (user_id);