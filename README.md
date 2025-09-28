# 🏋️ Gym Management System : Member & Attendance Tracker  

This project is a **Gym Management System** built with **Spring Boot** and **MongoDB**.  
It provides REST APIs to manage **members** and their **attendance records**, supporting flexible date formats, cascading deletes, and robust error handling.  

---

## ✨ Features  

1. **Member Management**  
   - Add, update, view, and delete members  
   - Cascade delete → removing a member also deletes their attendance  

2. **Attendance Tracking**  
   - Mark daily attendance (with optional custom date)  
   - Fetch attendance history by member or by date  
   - Supports multiple date formats:  
     `yyyy-MM-dd`, `dd-MM-yyyy`, `MM/dd/yyyy`, `dd/MM/yyyy`, `yyyy/MM/dd`  

3. **CRUD Operations**  
   - Secure and structured APIs  
   - Proper error messages and validations  

4. **Data Cleanup**  
   - Option to delete all members and attendance in one go  

---

## 🛠️ Development Stages  

**Stage 1 → Project Setup, Models, CRUD for Members**  
- Setup Spring Boot project with MongoDB  
- Create `Member` and `Attendance` models  
- Implement CRUD operations for members  

**Stage 2 → Attendance APIs with Date Handling**  
- Mark attendance for a member (default = today)  
- Parse multiple date formats for flexibility  
- Fetch attendance by date and member  

**Stage 3 → Cascade Delete & Cleanup**  
- Delete member → auto delete all related attendance  
- Delete all members → auto cleanup all attendance  

**Stage 4 → Enhancements**  
- Robust exception handling  
- Consistent API responses  
- Ready-to-import Postman Collection for testing  

---

## 🔑 API Endpoints  

### 👤 Members API  
| Method | Endpoint              | Description                              |
|--------|-----------------------|------------------------------------------|
| POST   | `/api/members`        | Create a new member                      |
| GET    | `/api/members`        | Get all members                          |
| GET    | `/api/members/{id}`   | Get member by ID                         |
| PUT    | `/api/members/{id}`   | Update member                            |
| DELETE | `/api/members/{id}`   | Delete member + related attendance       |
| DELETE | `/api/members/all`    | Delete all members + all attendance      |

### 📝 Attendance API  
| Method | Endpoint                                        | Description                              |
|--------|------------------------------------------------|------------------------------------------|
| POST   | `/api/attendance/mark/{memberId}?date=dd-MM-yyyy` | Mark attendance (default today / custom date) |
| GET    | `/api/attendance/member/{memberId}`            | Get all attendance of a member           |
| GET    | `/api/attendance/member/{memberId}/date/{date}` | Get attendance by date (multiple formats)|
| DELETE | `/api/attendance/{id}`                         | Delete attendance record                 |

---


## 🚀 Setup and Installation

### 1. Clone the Repository
```bash
git clone https://github.com/Abhaykekre/fitnest.git


