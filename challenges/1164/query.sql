/* Write your PL/SQL query statement below */
with
cdates as (
    select product_id, new_price, change_date
    from Products
    where change_date <= to_date('2019-08-16', 'yyyy-mm-dd')
),
mdates as (
    select product_id, max(change_date) as change_date, 1 as m
    from cdates
    group by product_id
)
(
    select product_id, new_price as price
    from mdates inner join Products using (product_id, change_date)
)
union
(
    select distinct product_id, 10 as price
    from Products
    where product_id not in (select product_id from mdates)
);