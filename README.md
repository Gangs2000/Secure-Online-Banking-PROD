# Secure-Online-Banking-PROD
Secure online banking Product is a banking application where all account holders can perform necessary banking operation.

It's is kinda web application, Technologies used in this project are Java Spring boot Framework, PostgreSql for storing Data into database, HTML, CSS, Bootstrap, JSP are used for presentation layer. Spring Security has been implemented in this project which enables more security to the application which means only authenticated person is allowed to utilize this product. To ensure password protection all password have been stored into database as **Bcrypt password encoder format** which uses Hashing function so no one can see original password ( Plain Text ), Moreover cracking Bcrypt password is really difficult task. RabbitMq concept has been implemented for sending data across microservices to perform neccessary operation. 

RabbitMq is a message broker communication system, it is responsible to listen the queue frequently once data is avilable in the queue it will start processing its operation by it's queue, exchange and routing key.

In this prodcut two microservices have been developed..

1. **AccountManagement Service** - Where account holders can perform withdraw, deposit, chaning security PIN operations.
2. **EmailNotification Service** - RabbitMq plays major role in this service, For every action an email will be triggered to registerd email ID


**Few glimpse of this Secure Online Banking PROD :**

![Screenshot from 2022-09-10 18-16-24](https://user-images.githubusercontent.com/112934529/189484796-ef889832-421b-455e-b06f-e0a8926e3045.png)
![Screenshot from 2022-09-10 18-16-28](https://user-images.githubusercontent.com/112934529/189484899-0c10cb5d-3002-4fb9-bc95-22b80dd33c84.png)
![Screenshot from 2022-09-10 18-16-32](https://user-images.githubusercontent.com/112934529/189484902-23b6d95f-69a2-48eb-96f1-ac97e3811872.png)
![Screenshot from 2022-09-10 18-16-42](https://user-images.githubusercontent.com/112934529/189484904-80a26ca1-7c14-4daf-a2a0-c358befdfe4d.png)
![Screenshot from 2022-09-10 18-16-45](https://user-images.githubusercontent.com/112934529/189484910-94692822-c0bf-4993-ae32-e123d71daf6b.png)
![Screenshot from 2022-09-10 18-16-47](https://user-images.githubusercontent.com/112934529/189484924-cf68aae0-523c-4cd9-beba-8419dfc7af1c.png)
![Screenshot from 2022-09-10 18-16-50](https://user-images.githubusercontent.com/112934529/189484949-96e6270e-7ad0-47de-bcc3-d75d4c0c84e5.png)
![Screenshot from 2022-09-10 18-16-53](https://user-images.githubusercontent.com/112934529/189484954-5fcfb8f5-dbbf-4f72-a2fa-aa1d96207ac6.png)

**RabbitMq Message Broker console :**

![Screenshot from 2022-09-10 18-17-03](https://user-images.githubusercontent.com/112934529/189484970-610da02c-138a-4afd-971e-a8e9dce3b120.png)

**PostgreSql Database :**

![Screenshot from 2022-09-10 18-17-35](https://user-images.githubusercontent.com/112934529/189484980-1670efd2-edb3-4257-87b5-9dbccd22464d.png)
![Screenshot from 2022-09-10 18-17-41](https://user-images.githubusercontent.com/112934529/189484988-6ab8abd1-2cd8-4202-840a-a7b69300360c.png)
![Screenshot from 2022-09-10 18-17-46](https://user-images.githubusercontent.com/112934529/189484990-0a39ff21-31f1-4c35-836c-730ba3dc5878.png)
 
**Email Notifications :**
 
![Screenshot from 2022-09-10 18-50-29](https://user-images.githubusercontent.com/112934529/189485294-3bcc1662-7da4-44e5-bd90-28fa76369db6.png)
![Screenshot from 2022-09-10 18-51-10](https://user-images.githubusercontent.com/112934529/189485300-176d2f2c-6879-49d5-b364-e9412eab4b73.png)
![Screenshot from 2022-09-10 18-51-37](https://user-images.githubusercontent.com/112934529/189485305-a1f78c93-b75f-4c42-b510-6923055b6d70.png)
![Screenshot from 2022-09-10 18-51-57](https://user-images.githubusercontent.com/112934529/189485308-9e474fc1-1e59-4095-93a1-901eadd7b804.png)


**Future release may expect below points :**

1. Expect to be deployed on any cloud platform ( AWS or AZURE ) to host the product
2. Outh2 Social Networking login will be implemented in this product so that user can create new account by authenticating their google account

**To learn Spring security visit this YouTube link** -> https://www.youtube.com/watch?v=fjkelzWNSuA

