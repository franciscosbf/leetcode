/* Write your PL/SQL query statement below */
with
categorized as (
    select account_id, (
        case
            when income < 20000 then 'Low Salary'
            when income >= 20000 and income <= 50000 then 'Average Salary'
            else 'High Salary'
        end
    ) as category
    from Accounts
),
categories as (
    select category, count(account_id) as accounts_count
    from categorized
    group by category
)
select * from categories
union
(
    select 'Low Salary' as category, 0 as accounts_count
    from dual
    where not exists (
        select * from categories where category = 'Low Salary'
    )
)
union
(
    select 'Average Salary' as category, 0 as accounts_count
    from dual
    where not exists (
        select * from categories where category = 'Average Salary'
    )
)
union
(
    select 'High Salary' as category, 0 as accounts_count
    from dual
    where not exists (
        select * from categories where category = 'High Salary'
    )
);