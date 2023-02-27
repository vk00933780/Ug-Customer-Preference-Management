# Ug-Customer-Preference-Management
This is a sample spring boot version 3 application for Unified Guest which will capture the Neom customer preference data from Neom source systems and store in Unified Guest DB

# Project Architecture

![Neom Unified Guest - Understanding chart (2)](https://user-images.githubusercontent.com/124668010/220737014-8d7f2693-a88e-4ddf-a7e0-546c8bdfee6a.png)

# Pre-Requisite
1. Java Development Kit 17 or above
2. Java IDE Eclipse/STS/IntelliJ Idea
3. Maven 3.x verison or above
4. Postman to test the API

# Steps to Setup
1. Clone the application

     ```bash
    https://github.com/vk00933780/Ug-Customer-Preference-Management.git
    ```

2. Import the code in IDE of your choice (Eclipse/STS/IntelliJ Idea) and run below command for building the project:
    
   ```bash
    mvn clean install
   ```

3. Run below maven command to create package
    
    ```bash
    mvn package java -jar target/Customer-Preference-Management-0.0.1-SNAPSHOT.jar
    ```
The app will start running at <http://localhost:8180>.
  
# Explore Rest APIs

### CustomerPerferenceManagement (cpm)

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| POST    | /api/v1/cpm | add customer data for Neom website and Booking platform | [JSON](#customerInfo) |
| PUT    | /api/v1/cpm/{customerId} | update customer data for a customer with provided customerId | |
| GET    | /api/v1/cpm | get all customer data which includes preference, booking, personality trait data | |
| GET    | /api/v1/cpm/{customerId} | get customer data with provided customerId | |

## Sample Valid JSON Request Bodys

##### <a id="customerInfo">Add Customer Preference Data -> /api/v1/cpm</a>
```json
{
    "customerId": 0,
    "customerFirstName": null,
    "customerLastName": null,
    "customerMiddleName": null,
    "preferredName": null,
    "primaryContactNumber": null,
    "secondaryContactNumner": null,
    "address": null,
    "emailId": null,
    "age": 0,
    "dateOfBirth": null,
    "gender": null,
    "race": null,
    "religion": null,
    "maritalStatus": null,
    "ethnicity": null,
    "hobbies": null,
    "customerType": null,
    "primaryGuestId": 0,
    "primaryGuestRelationship": null,
    "createdDate": null,
    "updatedDated": null
  }
```

