/* Write your PL/SQL query statement below */
with
minyear as (
    select product_id, min(year) as year
    from Sales
    group by product_id
)
select product_id, year as first_year, quantity, price
from minyear inner join Sales using (product_id, year);