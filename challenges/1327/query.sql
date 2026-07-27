/* Write your PL/SQL query statement below */
select product_name, sum(unit) as unit
from Products inner join Orders using (product_id)
where to_char(order_date, 'yyyy-mm') = '2020-02'
group by product_name
having sum(unit) >= 100;