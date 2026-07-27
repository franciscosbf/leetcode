/* Write your PL/SQL query statement below */
with
end_mp as (
    select machine_id, process_id, Activity.timestamp
    from Activity
    where activity_type = 'end'
),
start_mp as (
    select machine_id, process_id, Activity.timestamp
    from Activity
    where activity_type = 'start'
),
time_mp as (
    select machine_id, process_id, end_mp.timestamp - start_mp.timestamp as ttime
    from end_mp inner join start_mp using (machine_id, process_id)
)
select machine_id, round(sum(ttime) / count(process_id), 3) as processing_time
from time_mp
group by machine_id;