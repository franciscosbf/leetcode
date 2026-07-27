/* Write your PL/SQL query statement below */
with
strans as (
    select
        id,
        (case when country is null then '_' else country end) as country,
        state,
        amount,
        trans_date
    from Transactions
),
cmonths as (
    select distinct
        to_char(trans_date, 'yyyy-mm') as month,
        country,
        trans_date
    from strans
)
select
    month,
    (case when country = '_' then null else country end) as country,
    count(id) as trans_count,
    sum(
        case when state = 'approved'
        then 1 else 0 end
    ) as approved_count,
    sum(amount) as trans_total_amount,
    sum(
        case when state = 'approved'
        then amount else 0 end
    ) as approved_total_amount
from cmonths inner join strans using (country, trans_date)
group by month, country;