/* Write your PL/SQL query statement below */
delete from Person p1
where p1.id <> (
    select min(p2.id)
    from Person p2
    where p1.email = p2.email
    group by p2.email
) and (
    select count(p3.id)
    from Person p3
    where p1.email = p3.email
    group by p3.email
) > 1;