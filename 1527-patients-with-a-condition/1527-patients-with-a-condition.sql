# Write your MySQL query statement below
SELECT * FROM Patients 
WHERE  Patients.conditions LIKE 'DIAB1%' OR
Patients.conditions LIKE '% DIAB1%'
