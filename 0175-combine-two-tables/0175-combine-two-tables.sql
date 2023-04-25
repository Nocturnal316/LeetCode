# Write your MySQL query statement below

Select firstName, lastName, city, state 
From Person p left JOIN Address a
On p.personId = a.personId;