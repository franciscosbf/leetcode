/* Write your PL/SQL query statement below */
select p.product_id, nvl(round(sum(price * units) / sum(units), 2), 0) as average_price
from Prices p left join UnitsSold u on (
    p.product_id = u.product_id and purchase_date >= start_date and purchase_date <= end_date)
group by p.product_id;