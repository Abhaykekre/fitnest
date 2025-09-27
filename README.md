🏋️ Gym Management System (Spring Boot + MongoDB)

A RESTful Gym Management System built with Spring Boot and MongoDB.
It helps manage members and their attendance records, with support for flexible date formats, cascading deletes, and clean error handling.

✨ Features

👤 Member Management → Add, update, view, and delete members

📝 Attendance Tracking → Mark & fetch attendance with multiple date formats

🔄 Cascade Delete → Deleting a member removes all their attendance records

📅 Flexible Dates → Supports yyyy-MM-dd, dd-MM-yyyy, MM/dd/yyyy, dd/MM/yyyy, yyyy/MM/dd

⚡ Robust APIs → Clean error messages & easy integration

🛠️ Tech Stack

Java 17+

Spring Boot 3.x

MongoDB

Spring Data MongoDB

Lombok

📂 Project Structure
src/main/java/com/gym/
│── controller/     # REST Controllers
│── model/          # Member & Attendance Entities
│── repository/     # MongoDB Repositories
│── service/        # Business Logic
│── exception/      # Custom Exceptions

🔑 API Endpoints
👤 Members API
Method	Endpoint	Description
POST	/api/members	Create a new member
GET	/api/members	Get all members
GET	/api/members/{id}	Get member by ID
PUT	/api/members/{id}	Update member
DELETE	/api/members/{id}	Delete member + related attendance
DELETE	/api/members/all	Delete all members + all attendance
📝 Attendance API
Method	Endpoint	Description
POST	/api/attendance/mark/{memberId}?date=dd-MM-yyyy	Mark attendance for a member (custom date optional)
GET	/api/attendance/member/{memberId}	Get all attendance records of a member
GET	/api/attendance/member/{memberId}/date/{date}	Get attendance of a member by date (flexible formats)
DELETE	/api/attendance/{id}	Delete an attendance record
📬 Example API Usage (Postman)
➕ Create Member

Request

POST /api/members
Content-Type: application/json

{
  "name": "Abhay Kekre",
  "age": 23,
  "gender": "Male",
  "membershipType": "Premium"
}


Response

{
  "id": "651e2f1a7e3b4f00123abcd4",
  "name": "Abhay Kekre",
  "age": 23,
  "gender": "Male",
  "membershipType": "Premium"
}

📝 Mark Attendance

Request

POST /api/attendance/mark/651e2f1a7e3b4f00123abcd4?date=27-09-2025


Response

{
  "id": "651e30577e3b4f00123abcd9",
  "member": {
    "id": "651e2f1a7e3b4f00123abcd4",
    "name": "Abhay Kekre",
    "age": 23,
    "gender": "Male",
    "membershipType": "Premium"
  },
  "date": "2025-09-27"
}

⚡ How to Run Locally

Clone the repository

git clone https://github.com/your-username/gym-management-system.git
cd gym-management-system


Configure MongoDB in application.properties
Example:

spring.data.mongodb.uri=mongodb://localhost:27017/gymdb


Build & Run

mvn spring-boot:run


Test APIs using Postman or browser at

http://localhost:8080/api

📜 License

This project is licensed under the MIT License.
