/* Write your PL/SQL query statement below */
select round(nvl(sum(tiv_2016), 0), 2) as tiv_2016
from Insurance i1
where exists (
    select *
    from Insurance i2
    where i2.tiv_2015 = i1.tiv_2015 and i2.pid <> i1.pid
) and not exists (
    select *
    from Insurance i2
    where i2.lat = i1.lat and i2.lon = i1.lon and i2.pid <> i1.pid
);