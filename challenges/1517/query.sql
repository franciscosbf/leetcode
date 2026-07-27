/* Write your PL/SQL query statement below */
select *
from Users
where regexp_substr(mail, '^[a-zA-Z]{1}[a-zA-Z0-9_\.-]*@leetcode\.com$') is not null;