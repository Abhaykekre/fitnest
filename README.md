🏋️ Gym Management System with Attendance Tracking

A Spring Boot + MongoDB application to manage gym members and their daily attendance.
It provides REST APIs for Member Management and Attendance Tracking with features like flexible date formats, cascading deletes, and robust error handling.

🚀 Features

✅ Add, update, view, and delete members

✅ Mark and fetch attendance (supports multiple date formats)

✅ Cascade delete → deleting a member also deletes their attendance

✅ Get attendance history by member or date

✅ Delete individual or all records

✅ Error handling with clear messages

🛠️ Tech Stack

Java 17+

Spring Boot 3

MongoDB

Spring Data MongoDB

Lombok

📂 Project Structure
src/main/java/com/gym/
│── controller/   → REST APIs  
│── model/        → Member & Attendance entities  
│── repository/   → MongoDB repositories  
│── service/      → Business logic  
│── exception/    → Custom exceptions  

🔑 API Endpoints
👤 Members

POST /api/members → Add new member

GET /api/members → Get all members

GET /api/members/{id} → Get member by ID

PUT /api/members/{id} → Update member

DELETE /api/members/{id} → Delete member (+attendance)

DELETE /api/members/all → Delete all members (+attendance)

📝 Attendance

POST /api/attendance/mark/{memberId} → Mark attendance (supports yyyy-MM-dd, dd-MM-yyyy, MM/dd/yyyy, dd/MM/yyyy, yyyy/MM/dd)

GET /api/attendance/member/{memberId} → Get member’s attendance

GET /api/attendance/member/{memberId}/date/{date} → Get attendance by date

DELETE /api/attendance/{id} → Delete attendance

📬 Example (Postman)
Create Member
POST /api/members
{
  "name": "Abhay Kekre",
  "age": 23,
  "gender": "Male",
  "membershipType": "Premium"
}

Mark Attendance
POST /api/attendance/mark/{memberId}?date=27-09-2025

⚡ How to Run

Clone the repo

git clone https://github.com/your-username/gym-management-system.git
cd gym-management-system


Configure MongoDB (local or Atlas) in application.properties

Run the application

mvn spring-boot:run


Test APIs with Postman or browser

📜 License

This project is licensed under the MIT License.
