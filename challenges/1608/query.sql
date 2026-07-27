/* Write your PL/SQL query statement below */
select product_name, year, price
from Sales inner join Product using (product_id);