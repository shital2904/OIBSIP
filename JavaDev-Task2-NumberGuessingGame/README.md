# Number Guessing Game – Java Swing

A desktop-based **Number Guessing Game** developed using **Java Swing** as part of the **OIBSIP Java Development Internship – Task 2**.

The application challenges the player to guess a randomly generated number within a limited number of attempts. It provides multiple difficulty levels, hints, score tracking, round management, and input validation through a simple graphical user interface.

## ✨ Features

- 🎲 Random number generation for every round
- 🎯 Three difficulty levels
- 🔢 Easy: Number range 1–50 with 10 attempts
- 🔢 Medium: Number range 1–100 with 7 attempts
- 🔢 Hard: Number range 1–200 with 5 attempts
- 💡 Hints indicating whether the guess is too high or too low
- 🔢 Attempts-left counter
- 🏆 Score calculation based on remaining attempts
- 🔄 Multiple rounds with cumulative score
- ▶️ Play Again functionality
- ⚠️ Input validation for invalid and empty entries
- 🚫 Range validation for guesses outside the selected difficulty
- 🖥️ User-friendly graphical interface
- ⌨️ Enter key support for submitting guesses
- 🎯 Automatic focus on the input field for convenient gameplay

## 🛠️ Technologies Used

- **Java**
- **Java Swing**
- **AWT**
- **java.util.Random**
- **JTextField**
- **JButton**
- **JComboBox**
- **JLabel**
- **JOptionPane**
- **GridBagLayout**

## 🎮 Difficulty Levels

| Level | Number Range | Attempts |
|---|---:|---:|
| Easy | 1 – 50 | 10 |
| Medium | 1 – 100 | 7 |
| Hard | 1 – 200 | 5 |

The default difficulty level is **Medium**.

## 🏆 Scoring System

The game awards points based on the number of attempts remaining when the player correctly guesses the number.

The score is calculated using:

```text
Score = (Remaining Attempts + 1) × 10
```

The total score is maintained across multiple rounds.

## 🔄 Game Flow

```text
Start Game
    ↓
Select Difficulty
    ↓
Generate Random Number
    ↓
Enter Guess
    ↓
Validate Input
    ↓
Check Guess
    ↓
 ┌───────────────┐
 │               │
Correct       Incorrect
 │               │
 ↓               ↓
Calculate      Too High /
Score          Too Low Hint
 │               │
 ↓               ↓
End Round     Try Again
 │
 ↓
Play Again
```

## ⚠️ Input Validation

The application handles different invalid-input situations, including:

- Empty input
- Non-numeric input
- Numbers outside the selected range

For example, if Medium difficulty is selected, the user must enter a number between **1 and 100**.

## 📂 Project Structure

```text
JavaDev-Task2-NumberGuessingGame
│
├── src
│   └── NumberGuessingGame.java
│
├── screenshots
│   └── Screenshot_2026.png
│
├── README.md
└── .gitignore
```

## ▶️ How to Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Configure a Java JDK.
3. Open:

```text
src/NumberGuessingGame.java
```

4. Run the `NumberGuessingGame` class.
5. The game window will open.
6. Select a difficulty level and start guessing.

### Using Command Line

Compile the program:

```bash
javac -d out src/NumberGuessingGame.java
```

Run the application:

```bash
java -cp out NumberGuessingGame
```

## 📸 Output

### Number Guessing Game

![Number Guessing Game Output](screenshots/Screenshot_2026.png)

## 💡 How to Play

1. Launch the application.
2. Select a difficulty level.
3. The system generates a random number.
4. Enter your guess in the input field.
5. Click **Submit Guess** or press **Enter**.
6. Use the displayed hint:
   - **Too Low** → Enter a higher number.
   - **Too High** → Enter a lower number.
7. Continue until you guess the correct number or run out of attempts.
8. If successful, your score is added to the total score.
9. Click **Play Again** to start another round.

## 🎓 Internship

**OIBSIP – Java Development Internship**

**Task 2 – Number Guessing Game**

### Project Highlights

- Developed a GUI-based Java application using Swing
- Implemented random number generation
- Added difficulty-based game logic
- Implemented score and round management
- Added input and range validation
- Designed an interactive desktop user interface

---

**Developed using Java Swing**
