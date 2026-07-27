/* Write your PL/SQL query statement below */
with
occurrences as (
    select num
    from MyNumbers
    group by num
    having count(num) = 1
)
select max(num) as num
from occurrences