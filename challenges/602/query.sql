/* Write your PL/SQL query statement below */
with
ids as (
    (
        select distinct requester_id as id from RequestAccepted
    )
    union
    (
        select distinct accepter_id as id from RequestAccepted
    )
),
friends as (
    (
        select distinct id, accepter_id as friend
        from ids inner join RequestAccepted on (id = requester_id)
    )
    union
    (
        select distinct id, requester_id as friend
        from ids inner join RequestAccepted on (id = accepter_id)
    )
),
nfriends as (
    select id, count(friend) as num
    from friends
    group by id
    order by num desc
)
select id, num
from nfriends
where rownum = 1;