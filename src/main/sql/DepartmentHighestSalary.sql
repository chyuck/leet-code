-- Solution for https://leetcode.com/problems/department-highest-salary/ problem
WITH maxSalaries AS
(
    SELECT MAX(Salary) AS Salary, e.DepartmentId
    FROM Employee e
    GROUP BY e.DepartmentId
)
SELECT
    d.Name AS Department,
    e.Name AS Employee,
    e.Salary
FROM Employee e
JOIN Department d ON d.Id = e.DepartmentId
WHERE EXISTS
(
    SELECT *
    FROM maxSalaries s
    WHERE s.DepartmentId = e.DepartmentId
        AND s.Salary = e.Salary
)