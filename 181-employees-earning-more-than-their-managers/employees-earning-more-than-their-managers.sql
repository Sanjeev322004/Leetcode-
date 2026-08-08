# Write your MySQL query statement belo
SELECT e.name AS Employee FROM Employee e JOIN  Employee m ON e.managerId = m.id WHERE e.salary > m.salary;