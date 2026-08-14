# Online Reservation System

A Java Swing + JDBC + MySQL internship project.

## Features
- Login with username and password
- Train number -> automatic train name lookup
- Reservation form
- Unique PNR generation
- Booking confirmation dialog
- Cancellation by PNR
- Fetch booking details before cancellation
- Confirmation before deleting a booking
- Basic input validation
- PreparedStatement for database operations

## Requirements
- JDK 17+
- IntelliJ IDEA
- MySQL Server
- Maven (IntelliJ can import the Maven project automatically)

## Default login
Username: admin
Password: admin123

## Database setup
1. Start MySQL.
2. Open `database/schema.sql` in MySQL Workbench.
3. Run the complete script.
4. Edit `src/main/resources/config.properties` with your MySQL username/password.
5. Open the project in IntelliJ as a Maven project.
6. Run `Main.java`.

## Important
The default password is for a college/internship demo only. A production application should store password hashes and use environment variables/secrets for database credentials.
