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

##### <a id="customerInfo">1. Add Customer Preference Data -> /api/v1/cpm</a>
```json
[
    {
        "customerId": 101,
        "customerFirstName": "John",
        "customerLastName": "Doe",
        "customerMiddleName": M,
        "preferredName": Johny,
        "primaryContactNumber": "112345678",
        "secondaryContactNumner": null,
        "address": "CA, USA",
        "emailId": "John_Doe@gmail.com",
        "age": 45,
        "dateOfBirth": "1980-05-02",
        "gender": "male",
        "race": "white",
        "religion": "christianity",
        "maritalStatus": "married",
        "ethnicity": "Non Hispanic",
        "hobbies": "Music Listening",
        "customerType": "Family",
        "primaryGuestId": 103,
        "primaryGuestRelationship": "wife",
        "createdDate": "2023-02-27 12:41:04",
        "updatedDated": null,
        "personalityTraits": {
            "customerId": 101,
            "personality": "An interovert person",
            "habits": "drawing, cooking",
            "emotions": "Lives far from kids"
        },
        "preferences": [
            {
                "preferenceId": 2,
                "customerId": 101,
                "preferenceType": "Lifestyle",
                "preferenceName": "Long Walks",
                "preferenceCreatedDate": null,
                "preferenceUpdatedDate": null,
                "active": false,
                "like": false
            },
            {
                "preferenceId": 1,
                "customerId": 101,
                "preferenceType": "Adventure Sport",
                "preferenceName": "Bungee Jumping",
                "preferenceCreatedDate": null,
                "preferenceUpdatedDate": null,
                "active": false,
                "like": false
            }
        ],
        "bookingHistory": [
            {
                "bookingId": 1002,
                "customerId": 101,
                "arrivalDate": "2021-03-05",
                "arrivalTime": "13:30:40",
                "departureDate": "2021-03-15",
                "departureTime": "10:30:10"
            },
            {
                "bookingId": 1001,
                "customerId": 101,
                "arrivalDate": "2022-10-02",
                "arrivalTime": "22:00:30",
                "departureDate": "2022-10-10",
                "departureTime": "08:30:20"
            }
        ]
    },
    {
        "customerId": 102,
        "customerFirstName": "Mike",
        "customerLastName": "James",
        "customerMiddleName": "K",
        "preferredName": "Micky J",
        "primaryContactNumber": "2485753838",
        "secondaryContactNumner": "6767584933",
        "address": "NY, USA",
        "emailId": "Mike_James@gmail.com",
        "age": 35,
        "dateOfBirth": "1967-11-03",
        "gender": "male",
        "race": "African American",
        "religion": "Muslim",
        "maritalStatus": "married",
        "ethnicity": "Latino",
        "hobbies": "Gardening",
        "customerType": "Friends",
        "primaryGuestId": 0,
        "primaryGuestRelationship": null,
        "createdDate": "2023-02-27 19:03:09",
        "updatedDated": null,
        "personalityTraits": {
            "customerId": 102,
            "personality": "Social Person",
            "habits": "Party, Reading",
            "emotions": "Emotionally Strong"
        },
        "preferences": [
            {
                "preferenceId": 3,
                "customerId": 102,
                "preferenceType": "Food",
                "preferenceName": "Thai Cuisine",
                "preferenceCreatedDate": null,
                "preferenceUpdatedDate": null,
                "active": false,
                "like": false
            }
        ],
        "bookingHistory": [
            {
                "bookingId": 1003,
                "customerId": 102,
                "arrivalDate": "2022-08-10",
                "arrivalTime": "10:40:40",
                "departureDate": "2022-08-25",
                "departureTime": "01:30:10"
            }
        ]
    }
]
```

