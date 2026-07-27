/* Write your PL/SQL query statement below */
with
dactivities as (
    select distinct *
    from Activities
)
select
    to_char(sell_date, 'yyyy-mm-dd') as sell_date,
    count(product) as num_sold,
    listagg(product, ',') within group (order by product asc) as products
from dactivities
group by sell_date;