# Write your MySQL query statement below
SELECT name as Customers
FROM  Customers as c
LEFT JOIN Orders
ON c.id  = Orders.customerId
WHERE Orders.customerId is NULL