SET @num := 0, @type := '', @salary = 0;

SELECT
  Department,
  Employee,
  Salary
FROM (

       SELECT
         Department,
         Employee,
         Salary,
         @num := if(@type = Department, (if(@salary = Salary, @num, @num + 1)), 1) AS row_number,
         @type := Department                                                       AS dummy,
         @salary := if(@type = Department, Salary, 0)                              AS d2

       FROM (
              SELECT
                Department.Name AS Department,
                Employee.Name   AS Employee,
                Employee.Salary
              FROM Employee
                INNER JOIN Department ON Employee.DepartmentId = Department.Id
              ORDER BY Department.Name, Employee.Salary DESC
            ) AS Y
     ) AS X

WHERE X.row_number <= 3;
