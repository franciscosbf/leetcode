/* Write your PL/SQL query statement below */
with
mdeliveries as (
    select customer_id, min(order_date) as order_date
    from Delivery
    group by customer_id
),
ideliveries as (
    select count(delivery_id) as c
    from Delivery inner join mdeliveries using (customer_id, order_date)
    where order_date = customer_pref_delivery_date
),
sdeliveries as (
    select count(delivery_id) as c
    from Delivery inner join mdeliveries using (customer_id, order_date)
    where order_date <> customer_pref_delivery_date
)
select round((i.c * 100) / (i.c + s.c), 2) as immediate_percentage
from ideliveries i, sdeliveries s;