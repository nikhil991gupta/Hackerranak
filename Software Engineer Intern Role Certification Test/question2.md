


2. Relative Pay
A company maintains an EMPLOYEE table with information for each of their employees. Write a query to produce a list containing two columns.  The first column should include the name of an employee who earns less than some other employee.  The second column should contain the name of a higher earning employee.  All combinations of lesser and greater earning employees should be included.  Sort ascending, first by the lower earning employee's ID, then by the higher earning employee's SALARY.  

 
Schema
EMPLOYEE
Name	Type	Description
ID	Integer	The ID of the employee. This is a primary key.
NAME	String	Employee name, 1 - 20 characters.
AGE	Integer	Employee age in years.
ADDRESS	String	Employee address, 1 - 25 characters.
SALARY	Integer	Employee salary.
Sample Data Tables
EMPLOYEE
ID	NAME	AGE	ADDRESS	SALARY
1	Chris	27	Paris	74635
2	Sam	30	Sydney	72167
3	Pat	29	Paris	75299
 

Sample Output

Chris Pat
Sam Chris
Sam Pat
 

Explanation

Chris with ID 1 earns a salary of 74635.
Sam with ID 2 earns a salary of 72167.
Pat with ID 3 earns a salary of 75299.
Chris has the lowest ID and there is at least one other with a higher salary, so Chris is included in the list first. Only Pat earns more.

Sam has the next lowest ID and there is at least one other with a higher salary, so Sam is included next. Chris and Pat earn more than Sam. Chris earns less than Pat, so Chris is listed first.

Soluttion.


SELECT e1.NAME, e2.NAME
FROM EMPLOYEE e1
JOIN EMPLOYEE e2 ON e1.SALARY < e2.SALARY
ORDER BY e1.ID ASC, e2.SALARY ASC;
