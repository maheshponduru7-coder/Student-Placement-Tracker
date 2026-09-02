# Student Placement Tracker

A Java console-based application designed to help students
track coding problems and monitor their placement preparation.

## Features

### Problem Management
- Add a new coding problem
- Display all problems
- Update problem details
- Delete problems

### Problem Tracking
- Mark problems as solved
- Mark problems as unsolved
- Search problems by name
- Search problems by category

### Filtering and Sorting
- Filter problems by difficulty
- Filter problems by solved/unsolved status
- Sort problems by ID
- Sort problems by difficulty

### Progress Tracking
- Overall progress
- Difficulty-wise progress
- Category-wise progress
- Statistics dashboard
- Completion percentage
- Progress bar
- Most solved category

### Data Storage
- File handling using `problems.txt`
- Problems are automatically saved
- Problems are loaded when the application starts

### Input Validation
- Validates numeric input
- Prevents empty input
- Validates difficulty levels
- Prevents duplicate problem IDs

---

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- File Handling
- Searching
- Sorting
- Input Validation

---

## Project Structure

```text
Student-Placement-Tracker/
│
├── src/
│   ├── Main.java
│   ├── Problem.java
│   └── ProblemManager.java
│
├── data/
│   └── problems.txt
│
├── README.md
└── .gitignore