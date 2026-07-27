/* Write your PL/SQL query statement below */
with
first_login as (
    select player_id, min(event_date) as event_date
    from Activity
    group by player_id
),
total_first_login as (
    select count(*) as c
    from first_login inner join Activity using (player_id)
    where Activity.event_date - first_login.event_date = 1
),
total_players as (
    select count(distinct player_id) as c
    from Activity
)
select round(total_first_login.c / total_players.c, 2) as fraction
from total_first_login, total_players;