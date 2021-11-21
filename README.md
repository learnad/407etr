407etr Toll Calculator

The Toll Calculator is intended for estimating trip costs and distance only.
It determine these by calculating latitude and longitude information from point one to another.
Note: Haversin algorithm is used to measure distance value. 

Design : 

![Toll Calculator Flow](images/tp-design-HLD.png)


Git-repository:

https://github.com/learnad/407etr

How to Use :

Rest GET end-point is exposed with two header parameter point-one and point-two.Based on the valid header values values the GET end-point calculates the distance and produce output.
Please refer "postman" folder inside below Git-repo and play with it.

https://github.com/learnad/407etr/tree/master/postman

GET endpoint: 
local: http://localhost:5000/api/tripcalculator/v1/tripcost


Swagger : 

local:http://localhost:5000/swagger-ui.html


Tech Stack: 

 Apache Camel
 Apache lucene
 Apache commons
 SpringBoot
 Spring Web(REST)
 Swagger2
 Junit(jupiter)