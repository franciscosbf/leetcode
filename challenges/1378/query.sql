/* Write your PL/SQL query statement below */
select unique_id, name
from EmployeeUNI right join Employees on EmployeeUNI.id = Employees.id;