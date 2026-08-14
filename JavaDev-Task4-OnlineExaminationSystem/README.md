# 📝 Online Examination System

A desktop-based **Online Examination System** developed using **Java Swing** as part of the **OIBSIP Java Development Internship – Task 4**.

The application provides a simple platform for students to create an account, log in, update their profile, select an examination subject, answer multiple-choice questions, and view their final examination results through a user-friendly Java Swing interface.

---

## ✨ Features

- 🔐 Secure user login
- 🆕 Create a new student account
- 👤 Update profile information
- 📚 Subject selection
- 💻 Java examination
- 🗄️ DBMS examination
- 🌳 Data Structures examination
- ⚙️ Operating Systems examination
- 🌐 Computer Networks examination
- ❓ Multiple-choice questions with four options
- 🔢 25 questions for each subject
- ⏱️ 30-minute examination timer
- 📊 Progress bar and answered-question counter
- ◀️ Previous and ▶️ Next question navigation
- 📤 Manual examination submission
- 🤖 Automatic submission when the timer expires
- 🏆 Final result with score details
- ⌛ Displays time taken to complete the examination
- ⚠️ Confirmation before quitting or submitting
- 🚪 Logout functionality

---

## 🛠️ Technologies & Tools

| Technology | Purpose |
|------------|---------|
| **Java** | Core application development |
| **Java Swing** | Graphical User Interface |
| **AWT** | GUI components and event handling |
| **Collections Framework** | Managing questions and user data |
| **`javax.swing.Timer`** | Examination countdown timer |
| **IntelliJ IDEA** | Development environment |

---

## 🏗️ Project Architecture

The project follows a simple object-oriented application structure.

### Application Layer

```text
Main
ExamApplication
```

### Model Layer

```text
Question
User
```

### Question Management

```text
QuestionBank
```

### User Management

```text
UserStore
```

### GUI Layer

```text
Java Swing + AWT
```

---

## 📂 Project Structure

```text
JavaDev-Task4-OnlineExaminationSystem
│
├── src
│   ├── Main.java
│   ├── ExamApplication.java
│   ├── Question.java
│   ├── QuestionBank.java
│   ├── User.java
│   └── UserStore.java
│
├── screenshots
│   ├── login.png
│   ├── createaccount.png
│   ├── Updateprofile.png
│   ├── selectsubj.png
│   ├── examination.png
│   └── result.png
│
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
Update Profile
      ↓
Select Subject
      ↓
Start Examination
      ↓
Answer Questions
      ↓
Submit Examination
      ↓
View Result
      ↓
    Logout
```

Students can move between questions using the **Next** and **Previous** buttons during the examination.

---

## 📚 Examination Subjects

The application provides examinations for the following subjects:

```text
Java
DBMS
Data Structures
Operating Systems
Computer Networks
```

Each subject contains:

```text
25 Questions
      ↓
4 Options per Question
      ↓
30-Minute Timer
      ↓
Submit Examination
      ↓
View Result
```

---

## ❓ Examination Process

Students can:

- Select an examination subject.
- Answer multiple-choice questions.
- Navigate using **Previous** and **Next** buttons.
- View the answered-question counter.
- Track examination progress using the progress bar.
- Submit the examination manually.
- Continue until the timer expires.

---

## ⏱️ Examination Timer

Each examination has a **30-minute countdown timer**.

The timer is implemented using:

```text
javax.swing.Timer
```

When the timer reaches zero, the examination is **automatically submitted** and the final result is displayed.

---

## 🏆 Result

After submitting the examination, the result screen displays:

- Total score
- Correct answers
- Incorrect answers
- Unanswered questions
- Time taken to complete the examination

The result allows students to quickly evaluate their examination performance.

---

## 🔑 Login & Account Creation

Users can either:

- Log in using an existing account.
- Create a new account using the **Create Account** option.

### Demo Credentials

```text
Username: student
Password: 1234
```

These credentials are intended only for educational and demonstration purposes.

---

## 💾 Data Storage

This application does **not require an external database**.

User details and examination questions are maintained **in memory during the application session**.

The project uses Java collections to manage user and examination data.

---

## ▶️ How to Run

### Using IntelliJ IDEA

1. Open the project in **IntelliJ IDEA**.
2. Configure a compatible **Java JDK**.
3. Open:

```text
src/Main.java
```

4. Run the `Main` class.
5. The Java Swing login window will appear.

---

### Using Command Line

Navigate to the project directory.

Compile the Java files:

```bash
javac -d out src/*.java
```

Run the application:

```bash
java -cp out Main
```

---

## 📸 Application Screenshots

### 🔐 Login

![Login Screen](screenshots/login.png)

### 🆕 Create Account

![Create Account](screenshots/createaccount.png)

### 👤 Update Profile

![Update Profile](screenshots/Updateprofile.png)

### 📚 Select Subject

![Select Subject](screenshots/selectsubj.png)

### 📝 Examination

![Examination Screen](screenshots/examination.png)

### 🏆 Result

![Result Screen](screenshots/result.png)

---

## 🔒 Security & Application Notes

This project is developed for **educational and internship purposes**.

The current implementation stores user information in memory during the application session.

For a production-level examination system:

- User passwords should be securely hashed.
- User data should be stored in a secure database.
- Authentication should use stronger security practices.
- Examination data should be protected from unauthorized modification.
- Proper session management should be implemented.

---

## 📚 Concepts Demonstrated

This project demonstrates practical implementation of:

- Object-Oriented Programming
- Java Swing GUI development
- AWT event handling
- Java Collections Framework
- Event-driven programming
- User authentication
- Profile management
- Multiple-choice examination system
- Question management
- Timer-based application logic
- Progress tracking
- Result calculation
- Input validation
- Exception handling
- In-memory data management

---

## 🎓 Internship

**OIBSIP – Java Development Internship**

**Task 4 – Online Examination System**
