/* Write your PL/SQL query statement below */
with
qquality as (
    select query_name,
        round(sum(rating / position) / count(position), 2) as quality
    from Queries
    group by query_name
),
poor_queries as (
    select query_name, count(rating) as prating
    from Queries
    where rating < 3
    group by query_name
),
qpoor_query_percentage as (
    select query_name,
        round((prating / count(rating)) * 100, 2) as poor_query_percentage
    from Queries inner join poor_queries using (query_name)
    group by query_name, prating
)
select query_name, quality, nvl(poor_query_percentage, 0) as poor_query_percentage
from qquality left join qpoor_query_percentage using (query_name);

select query_name,
       round(avg(rating / position), 2) as quality,
       round((sum(case when rating < 3 then 1 else 0 end) / count(rating)) * 100, 2) as poor_query_percentage
from Queries
group by query_name;