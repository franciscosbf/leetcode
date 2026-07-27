/* Write your PL/SQL query statement below */
with 
raters as (
    select name, count(movie_id) as rates
    from Users inner join MovieRating using (user_id)
    group by name
),
rater as (
    select name
    from raters
    where rates = (
        select max(r.rates)
        from raters r
    )
    order by name asc
),
ratings as (
    select title, avg(rating) as mrating
    from Movies inner join MovieRating using (movie_id)
    where to_char(created_at, 'yyyy-mm') = '2020-02'
    group by title
),
rating as (
    select title
    from ratings
    where mrating = (
        select max (r.mrating)
        from ratings r
    )
    order by title asc
)
(
    select name as results
    from rater
    where ROWNUM = 1
)
union all
(
    select title as results
    from rating
    where ROWNUM = 1
);