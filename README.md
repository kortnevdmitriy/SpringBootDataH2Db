Assignment 1 - Order Analyzer Project: 

Developed by: Jithendra Adoni Babu

Problem:

You are working on an application that is responsible for processing orders data. A customer can place an Order. Order will contain a set or OrderLines. Each OrderLine is a composition of a Product and product quantity. A Product is an entity with a name and price. Your task is to implement two methods in OrdersAnalyzer, Given a set of orders :

1) findThreeMostPopularProducts - which should return, at most, three most popular products. The most popular product is the product that has the most occurrences in given orders (ignoring product quantity). If two products have the same popularity, then the products should be ordered by name

2) findMostValuableCustomer - which should return the most valuable customer, that is the customer that has the highest value of all placed orders. If two customers have the same orders value, then any of them should be returned.

3) findCustomerContacts - which should return a collection of strings containing all customer names and email addresses in the format "Full Customer Name (customer-email@apple.com)"

Solution:

To test the solution we are simulating 50 Orders(configurable in properties file) for 10 products by 10 Customers.

Technology:
1. Spring Boot
2. Spring Data JPA
3. in-memory h2 database (http://www.h2database.com/html/main.html) for data persistance.

From project root folder execute "mvn clean spring-boot:run" command. It will print results as below.

02-05-2016 18:30:05.888 [main] INFO  c.apple.oa.service.SimulatorService - Three Most Popular Product in descending order :
02-05-2016 18:30:05.888 [main] INFO  c.apple.oa.service.SimulatorService - -------------------------------
02-05-2016 18:30:05.926 [main] INFO  c.apple.oa.service.SimulatorService - [product=Product9, occurrences=24]
02-05-2016 18:30:05.926 [main] INFO  c.apple.oa.service.SimulatorService - [product=Product4, occurrences=23]
02-05-2016 18:30:05.926 [main] INFO  c.apple.oa.service.SimulatorService - [product=Product3, occurrences=22]
02-05-2016 18:30:05.926 [main] INFO  c.apple.oa.service.SimulatorService - 
02-05-2016 18:30:05.927 [main] INFO  c.apple.oa.service.SimulatorService - Most Valuable Customer : 
02-05-2016 18:30:05.927 [main] INFO  c.apple.oa.service.SimulatorService - -------------------------------
02-05-2016 18:30:05.972 [main] INFO  c.apple.oa.service.SimulatorService - [Customer =Test4, total purchase value =391000.0]
02-05-2016 18:30:05.973 [main] INFO  c.apple.oa.service.SimulatorService - 
02-05-2016 18:30:05.973 [main] INFO  c.apple.oa.service.SimulatorService - Customers : 
02-05-2016 18:30:05.973 [main] INFO  c.apple.oa.service.SimulatorService - -------------------------------
02-05-2016 18:30:05.998 [main] INFO  c.apple.oa.service.SimulatorService - Test1 (Test1@apple.com)
02-05-2016 18:30:05.998 [main] INFO  c.apple.oa.service.SimulatorService - Test2 (Test2@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test3 (Test3@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test4 (Test4@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test5 (Test5@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test6 (Test6@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test7 (Test7@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test8 (Test8@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test9 (Test9@apple.com)
02-05-2016 18:30:06.001 [main] INFO  c.apple.oa.service.SimulatorService - Test10 (Test10@apple.com)