/* Write your PL/SQL query statement below */
select *
from Patients
where regexp_substr(conditions, '(^DIAB1| DIAB1)') is not null;