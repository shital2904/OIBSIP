# 🚆 Online Reservation System

A desktop-based **Online Reservation System** developed using **Java Swing, JDBC, and MySQL** as part of the **OIBSIP Java Development Internship – Task 1**.

The application allows users to create an account, log in, search for trains, make reservations, generate PNR numbers, retrieve booking details, cancel reservations, and log out through a user-friendly Java Swing interface.

---

## ✨ Features

- 🔐 User login and authentication
- 🆕 Create a new user account
- ⚠️ Access denied handling for invalid login
- 🚆 Train search and selection
- 🎫 Railway reservation
- 👤 Passenger information entry
- 🧾 Automatic PNR generation
- 🔎 Retrieve reservation details using PNR
- ❌ Cancel existing reservations
- ✅ Booking and cancellation confirmation
- 🚪 Logout functionality
- 🗄️ MySQL database integration
- 🔗 JDBC connectivity
- 🔒 Database credentials protected using `.gitignore`

---

## 🛠️ Technologies Used

- **Java**
- **Java Swing**
- **JDBC**
- **MySQL**
- **Maven**
- **IntelliJ IDEA**

---

## 🏗️ Project Architecture

The project follows a simple layered architecture:

```text
Online Reservation System
│
├── UI Layer
│   └── Java Swing
│
├── DAO Layer
│   └── Database Operations
│
├── Service Layer
│   └── PNR Generation
│
├── Model Layer
│   └── Reservation
│
└── Database Layer
    └── JDBC → MySQL
```

### UI Layer

```text
LoginFrame
MainFrame
ReservationPanel
CancellationPanel
```

### DAO Layer

```text
UserDAO
TrainDAO
ReservationDAO
```

### Model Layer

```text
Reservation
```

### Service Layer

```text
PNRGenerator
```

### Database Layer

```text
DBConnection
```

---

## 📂 Project Structure

```text
JavaDev-Task1-OnlineReservationSystem
│
├── database
│   └── schema.sql
│
├── screenshots
│   ├── access-denied.png
│   ├── booking-confirmation-pnr.png
│   ├── cancellation-confirmation.png
│   ├── cancellation-success.png
│   ├── create-account.png
│   ├── fetched-booking-details.png
│   ├── login-screen.png
│   ├── logout.png
│   ├── mysql-database-tables.png
│   ├── mysql-reservations-table.png
│   ├── mysql-trains-table.png
│   ├── mysql-users-table.png
│   └── reservation-booking-form.png
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── shital
│       │           └── reservation
│       │               ├── Main.java
│       │               │
│       │               ├── dao
│       │               │   ├── ReservationDAO.java
│       │               │   ├── TrainDAO.java
│       │               │   └── UserDAO.java
│       │               │
│       │               ├── db
│       │               │   └── DBConnection.java
│       │               │
│       │               ├── model
│       │               │   └── Reservation.java
│       │               │
│       │               ├── service
│       │               │   └── PNRGenerator.java
│       │               │
│       │               └── ui
│       │                   ├── CancellationPanel.java
│       │                   ├── LoginFrame.java
│       │                   ├── MainFrame.java
│       │                   └── ReservationPanel.java
│       │
│       └── resources
│           └── config.example.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## 🔄 Application Workflow

```text
Create Account
      ↓
    Login
      ↓
  Main Menu
      ↓
Reservation Form
      ↓
Enter Passenger Details
      ↓
Select Train
      ↓
Generate PNR
      ↓
Booking Confirmation
      ↓
Fetch Booking Details
      ↓
Cancel Reservation
      ↓
Cancellation Confirmation
      ↓
    Logout
```

---

## 🗄️ Database

The application uses **MySQL** to store users, trains, and reservation information.

### Database Name

```text
reservation_system
```

### Tables

```text
users
trains
reservations
```

### Database Relationship

```text
trains
   │
   │ train_number
   ▼
reservations
```

The `train_number` in the `reservations` table references the `train_number` in the `trains` table using a foreign key.

---

## 🔌 JDBC Configuration

The application connects Java to MySQL using **JDBC**.

The actual database configuration file is:

```text
src/main/resources/config.properties
```

This file is intentionally excluded from Git because it contains the local MySQL password.

A safe example configuration is provided:

```text
src/main/resources/config.example.properties
```

### Example

```properties
db.url=jdbc:mysql://localhost:3306/reservation_system
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

Replace `YOUR_MYSQL_PASSWORD` with your own local MySQL password.

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/shital2904/OIBSIP.git
```

### 2. Open the Project

Open the following folder in **IntelliJ IDEA**:

```text
JavaDev-Task1-OnlineReservationSystem
```

Make sure IntelliJ recognizes it as a **Maven project**.

### 3. Configure MySQL

Start your MySQL server.

Open:

```text
database/schema.sql
```

Run the SQL script in **MySQL Workbench**.

This creates the required:

- Database
- Users table
- Trains table
- Reservations table
- Sample train data

### 4. Configure Database Credentials

Create:

```text
src/main/resources/config.properties
```

Add:

```properties
db.url=jdbc:mysql://localhost:3306/reservation_system
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

Use your own MySQL password.

### 5. Run the Application

Open:

```text
src/main/java/com/shital/reservation/Main.java
```

Run `Main.java`.

The Java Swing login screen will appear.

---

## 🔑 Demo Login

For the internship demonstration, the database contains:

```text
Username: admin
Password: admin123
```

This is intended only for educational/demo purposes.

---


## 📸 Application Screenshots

### 01. 🆕 Create Account

![Create Account](screenshots/create-account.png)

### 02. 🔐 Login

![Login Screen](screenshots/login-screen.png)

### 03. 🎫 Reservation Booking Form

![Reservation Booking Form](screenshots/reservation-booking-form.png)

### 04. 🧾 Booking Confirmation & PNR

![Booking Confirmation & PNR](screenshots/booking-confirmation-pnr.png)

### 05. 🔎 Fetched Booking Details

![Fetched Booking Details](screenshots/fetched-booking-details.png)

### 06. ❌ Cancellation Confirmation

![Cancellation Confirmation](screenshots/cancellation-confirmation.png)

### 07. ✅ Cancellation Success

![Cancellation Success](screenshots/cancellation-success.png)

## 🗄️ MySQL Database Screenshots

### 8. 📊 Database Tables

![MySQL Database Tables](screenshots/mysql-database-tables.png)

### 9. 🚆 Trains Table

![MySQL Trains Table](screenshots/mysql-trains-table.png)

### 10. 🎫 Reservations Table

![MySQL Reservations Table](screenshots/mysql-reservations-table.png)

---

## 🔒 Security

Sensitive database credentials are not committed to the GitHub repository.

The following file is excluded using `.gitignore`:

```text
src/main/resources/config.properties
```

Only the safe example configuration is included:

```text
src/main/resources/config.example.properties
```

### Important

This project is intended for educational and internship purposes.

In a production application:

- User passwords should be securely hashed.
- Database credentials should be stored using environment variables or a secure secrets manager.
- Authentication and authorization should use stronger security practices.

---

## 🎓 Internship

**OIBSIP – Java Development Internship**

**Task 1 – Online Reservation System**
