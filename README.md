# Secure-Online-Banking-PROD
Secure online banking Product is a banking application where all account holders can perform necessary banking operation.

It's is kinda web application, Technologies used in this project are Java Spring boot Framework, PostgreSql for storing Data into database, HTML, CSS, Bootstrap, JSP are used for presentation layer. Spring Security has been implemented in this project which enables more security to the application which means only authenticated person is allowed to utilize this product. To ensure password protection all password have been stored into database as Bcrypt password encoder format which uses Hashing function so no one can see original password ( Plain Text ), Moreover cracking Bcrypt password is really difficult task. RabbitMq concept has been implemented for sending data across microservices to perform neccessary operation. 

RabbitMq is a message broker communication system, it is responsible to listen the queue frequently once data is avilable in the queue it will start processing its operation by it's queue, exchange and routing key.

In this prodcut two microservices have been developed..

1. AccountManagement Service - Where account holders can perform withdraw, deposit, chaning security PIN operations.
2. EmailNotification Service - RabbitMq plays major role in this service, For every action an email will be triggered to registerd email ID

Few glimpse of this Secure Online Banking PROD :

![Screenshot from 2022-09-10 18-16-24](https://user-images.githubusercontent.com/112934529/189484796-ef889832-421b-455e-b06f-e0a8926e3045.png)


Futute plans : 

1. Expect to be deployed on any cloud platform ( AWS or AZURE ) to host the product
2. Outh2 Social Networking login will be implemented in this product so that user can create new account by authenticating their google account

To learn Spring security visit this YouTube link -> https://www.youtube.com/watch?v=fjkelzWNSuA
