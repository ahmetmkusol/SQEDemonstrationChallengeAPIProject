## API Demo Challenge

#### Project Setup
1. Clone this project.
2. Setup the project in your IDE.
3. From command line run mvn clean install -U -DskipTests
5. Make sure you can run the DemoTest

#### Expectations
We will be evaluating
1. Quality of test cases
2. Variety  of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity


#### Exercise
1. Review the spec in the root directory, PizzaAPIReferenceDoc.  API endpoints for this exercise can be found here
   https://my-json-server.typicode.com/sa2225/demo/
2. In the Read me file, write up all of the test cases you think are necessary to test the endpoints defined in the provided spec.
3. Code up a few examples of 
  - order get call including response validation
  - order post call
4. When complete please check your code into a public git repo

#### Test Cases
1)	GET => Get list of all toppings => 
   -	Validate response status code – 200 Success Code
   -	Validate content type – application/json; charset=utf-8
   -	Validate response body – Body should include all toppings
   -	Validate response time
2)	POST => Add new toppings =>
   - 	Validate response status code – 204 No Content
   -  Validate content type – application/json; charset=utf-8
   -	Validate response body – No response body
   -	Validate response time  
3)	POST => Add new toppings and check for duplicate topping
   -  Validate response status code – 405 Method Not Allowed
   -  Validate content type – application/json; charset=utf-8
   -	Validate response body – Duplicate topping message
   -	Validate response time
4)	POST => Add new toppings without payload
   -	Validate response status code – 4xx Client Error
   -	Validate content type – application/json; charset=utf-8
   -	Validate response body – No response body
   - 	Validate response time
5)	DELETE =>  Delete Topping with valid id
-	Validate response status code – 204 No Content
-	Validate content type – application/json; charset=utf-8
-	Validate response body – No response body
-	Validate response time  
6)	DELETE =>  Delete Topping with invalid id
-	Validate response status code – 4xx Client Error
-	Validate content type – application/json; charset=utf-8
-	Validate response body – No response body
-	Validate response time  
7)	GET => List of pizzas
-	Validate response status code – 200 Success Code
-	Validate content type – application/json; charset=utf-8
-	Validate response body – List of pizzas with ‘id’ number
-	Validate response time 
8)	GET => List of orders
-	Validate response status code – 200 Success Code
-	Validate content type – application/json; charset=utf-8
-	Validate response body – List of orders with ‘id’ number
-	Validate response time 

9)	GET => List single order valid id
-	Validate response status code – 200 Success Code
-	Validate content type – application/json; charset=utf-8
-	Validate response body – Order with ‘id’ number
-	Validate response time 
10)	GET => List single order invalid id
-	Validate response status code – 4xx Client Error
-	Validate content type – application/json; charset=utf-8
-	Validate response body – No response body
-	Validate response time 
11)	POST => Create a new order with valid payload
-	Validate response status code – 201 Created 
-	Validate content type – application/json; charset=utf-8
-	Validate response body – New order (with returns ‘id’ number) 
-	Validate response time
12)	POST => Create a new order with invalid payload (Incorrect number of toppings)
-	Validate response status code – 406 Not Acceptable
-	Validate content type – application/json; charset=utf-8
-	Validate response body – New order with incorrect number of toppings
-	Validate response time
13)	POST => Create a new order with invalid payload (Invalid pizza type)
-	Validate response status code – 407 Proxy Authentication Required
-	Validate content type – application/json; charset=utf-8
-	Validate response body – New order with invalid pizza type
-	Validate response time
14)	POST => Create a new order with invalid payload (Pizza not specified)
-	Validate response status code – 408 Request Timeout
-	Validate content type – application/json; charset=utf-8
-	Validate response body – New order without specifying pizza type
-	Validate response time


#### Project Structure 

Implemented 3 new packages 
   - Base => Setting up Logger configurations
   - Tests => Test Case implementation
   - Utils => Constants and HelperMethods for straightforward and clean structure, Listeners class for reporting.
Logs folder
   - restAPI.logs => Storing all logs.
 
Reports
   - Extent-Report.html => Readable reports.
   
Test-output
   - All reports.
 


