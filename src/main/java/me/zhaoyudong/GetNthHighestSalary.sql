CREATE FUNCTION getNthHighestSalary(N INT)
  RETURNS INT
  BEGIN
    RETURN (
      # Write your MySQL query statement below.
      if((SELECT count(DISTINCT (Salary))
          FROM Employee) < N, NULL, (
           SELECT Salary
           FROM (SELECT DISTINCT (Salary)
                 FROM Employee
                 ORDER BY Salary DESC
                 LIMIT N) AS X
           ORDER BY Salary ASC
           LIMIT 1
         ))
    );
  END