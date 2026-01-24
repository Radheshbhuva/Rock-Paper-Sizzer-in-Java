# 🪨📄✂️ Rock Paper Scissors (Java Console Game) #

An advanced, interactive Rock–Paper–Scissors game developed in Java, featuring Best-of-5 gameplay, robust input validation, randomized AI opponent, and a visually enhanced terminal interface using ANSI escape codes. 

## 📌 Project Overview ##

_This project is a console-based Java game that simulates a real Rock–Paper–Scissors match between a user and the computer._

#### Unlike basic implementations, this version includes: ####

- A Best-of-5 winning system

- Tie handling without round penalty

- Dynamic score tracking

- Color-coded, formatted terminal output

- Defensive input validation

The game continues until either the user or the computer wins 3 rounds.

### 🎯 Key Features ###

- 🎮 Best-of-5 gameplay (first to 3 wins)

- 🧠 Randomized computer opponent using Random

- 🛡️ Input validation to prevent invalid entries

- 🎨 ANSI color-coded and formatted console output

- 🔁 Fair tie handling (ties don’t consume rounds)

- 📊 Live score tracking after each round

- 🧹 Proper resource management (scanner.close())

### 🧠 Core Concepts Demonstrated ###

- Java control flow (while, if-else)

- Arrays and indexing

- Random number generation

- User input handling with validation

- Game state management

- Defensive programming

- Console UI enhancement using ANSI codes

### 🏗️ System Architecture ###
🔹High-Level Architecture
```
┌───────────────────────┐
│        User           │
│   (Keyboard Input)    │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│   Input Validation    │
│  (1 / 2 / 3 only)     │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│   Game Engine         │
│ - Rule Evaluation     │
│ - Score Update        │
│ - Tie Handling        │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│  Random AI Generator  │
│  (Computer Choice)    │
└───────────┬───────────┘
            │
            ▼
┌───────────────────────┐
│ Console Output Layer  │
│ (ANSI Styled Output)  │
└───────────────────────┘
 ```

### 🔄 Game Flow Diagram ###
```
Start Game
   ↓
Display Rules
   ↓
User Input → Validation → Computer Choice
   ↓
Compare Choices
   ↓
Win / Lose / Tie
   ↓
Update Score
   ↓
Check Winner (Score = 3?)
   ↓
Yes → Game Over
No  → Next Round
  ```

### 🎮 How to Play ###

**1.** At the start of each round, you will see:

- Current round number

- Current score (You vs Computer)

**2.** You will be prompted to enter your choice:

1. Rock
2. Paper
3. Scissors

**3.** Input Rules

- Enter only 1, 2, or 3

- Any other input is rejected with an error message

- The program will keep asking until valid input is provided

**4.** The computer randomly selects its choice.

**5.** Both choices are displayed on the screen.

**6.** The round result is announced:

- 🟢 You win

- 🔴 Computer wins

- 🟡 Tie (round does not count)

**7.** Scores are updated and displayed after every round.

**8.** The game continues until either:

- You win 3 rounds, or

- The computer wins 3 rounds

**9.** The final winner is announced, and the program exits cleanly.

### ⚙️ Technical Details ###
#### 🔹 Language & Platform ####

- Programming Language: Java

- Execution Type: Console / Terminal based

- Platform Independent: Yes (runs on any OS with Java support)

#### 🔹 Libraries Used ####
```
Library               |  Purpose
-------------------   |  --------------------------------- 
`java.util.Scanner`   |  Reads user input                  
`java.util.Random`    |  Generates random computer choices 

```

### 🖥️ Sample Console Output ### 
```
Rock Paper Scissors - Best of 5
Game History Logging Enabled
Game Number: 13
Select Difficulty:
1. Easy
2. Medium
3. Hard
1
Difficulty Selected: Easy

1. Rock
2. Paper
3. Scissors
1
You chose: Rock
Computer chose: Scissors
You win this round!
Score → You: 1 | Computer: 0

```

### Example Sessions ###
```
Rock Paper Scissors - Best of 5
Game History Logging Enabled
Game Number: 13
Select Difficulty:
1. Easy
2. Medium
3. Hard
1
Difficulty Selected: Easy

1. Rock
2. Paper
3. Scissors
1
You chose: Rock
Computer chose: Scissors
You win this round!
Score → You: 1 | Computer: 0

1. Rock
2. Paper
3. Scissors
3
You chose: Scissors
Computer chose: Scissors
Tie!
Score → You: 1 | Computer: 0

1. Rock
2. Paper
3. Scissors
1
You chose: Rock
Computer chose: Rock
Tie!
Score → You: 1 | Computer: 0

1. Rock
2. Paper
3. Scissors
2
You chose: Paper
Computer chose: Scissors
Computer wins this round!
Score → You: 1 | Computer: 1

1. Rock
2. Paper
3. Scissors
2
You chose: Paper
Computer chose: Rock
You win this round!
Score → You: 2 | Computer: 1

1. Rock
2. Paper
3. Scissors
3
You chose: Scissors
Computer chose: Rock
Computer wins this round!
Score → You: 2 | Computer: 2

1. Rock
2. Paper
3. Scissors
1
You chose: Rock
Computer chose: Paper
Computer wins this round!
Score → You: 2 | Computer: 3

Final Win Percentage: 28.57%

Process finished with exit code 0
```
### 🔹 Output Behavior ###

- Outputs are color-coded and formatted

- Supported terminals:

  - VS Code terminal

  - Linux/macOS terminals

- Limited support in older Windows CMD

### ⚙️ Logic Explanation ###
🔹 Why Best-of-5?

 - Prevents luck-based outcomes

 - Encourages strategic play

 - Mimics competitive match rules

🔹Why Random.nextInt(3)?

 - Ensures equal probability for all choices

 - Prevents predictable AI behavior

🔹 Why Ties Don’t Count as Rounds?

 - Maintains fairness

 - Avoids artificial round inflation

🔹 Why Input Validation?

 - Prevents crashes

 - Ensures valid game state

 - Demonstrates defensive programming

🔹 Game State Management

 - Scores and rounds are tracked using variables.

🔹Terminal UI Styling

 - ANSI escape codes used for:

    - Colored text

    - Emphasis (bold, size changes)

### 🚀 How to Run the Project ###
**Prerequisites**

- Java JDK 8 or higher

- Terminal / Command Prompt

### Compile & Run ###
```
javac ROCK_PAPER_SCISSOR_adv.java
java ROCK_PAPER_SCISSOR_adv
```
### ⚠️ Limitations ###

- Console-based only (no GUI)

- ANSI colors may not render in older terminals

- Single-player mode only

- No persistent score storage

- No difficulty levels

### 📚 Learning Resources ###

This project helps reinforce multiple foundational and intermediate concepts.
Below are recommended resources aligned with what this project teaches.

**📘 Java Fundamentals**
- Oracle Java Documentation
https://docs.oracle.com/javase/tutorial/

- Java Control Flow
https://www.geeksforgeeks.org/decision-making-javaif-else-switch-break-continue-jump/

**🎲 Randomization & Game Logic**

- Java Random Class
https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

- Designing Simple Game Logic
https://www.baeldung.com/java-game-loop

**🛡️ Input Validation**

- Java Input Validation Best Practices
https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/

**🎨 Console UI & ANSI Codes**

- ANSI Escape Codes Guide
https://en.wikipedia.org/wiki/ANSI_escape_code

- Terminal Styling in Java
https://www.baeldung.com/java-ansi

**🧠 Programming Practices**

- Defensive Programming Concepts
https://en.wikipedia.org/wiki/Defensive_programming

- Writing Clean Code in Java
https://www.baeldung.com/java-clean-code

### 🔮 Future Enhancements ###

- 🎨 GUI version using Java Swing / JavaFX

- 💾 Persistent score storage (file / database)

- 🌐 Multiplayer mode

- 🤖 AI difficulty levels

- 🕹️ Replay option without restarting program

- 📱 Port to mobile or web interface

### 👨‍💻 Author ###

[Radhesh Bhuva](https://github.com/Radheshbhuva)

Computer Engineering Student
