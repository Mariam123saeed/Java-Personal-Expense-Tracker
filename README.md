# Personal Expense Tracker

A console-based Java application for tracking personal expenses.

This project is an **individual Java Fundamentals task** focused on practicing methods, arrays, loops, operators, String methods, searching, and `Scanner` input.

The project uses a single Java file and does not use classes, objects, or `ArrayList`.

---

## 📌 Project Overview

The Personal Expense Tracker allows the user to:

* Add expenses
* List all recorded expenses
* Display a spending summary
* View spending by category
* Search expenses by description
* Quit the application

Each expense contains:

* Description
* Category
* Amount

Supported categories:

* Food
* Transport
* Bills
* Fun

---

## 🧠 Concepts Practiced

This project focuses on Java Fundamentals:

* Variables and data types
* Arithmetic operators
* `if / else`
* `switch`
* `while` and `for` loops
* Arrays
* String methods
* `Scanner`
* User-defined methods
* Method parameters and return values
* Searching
* Basic data processing
* Integer division and remainder

---

## 💵 Money Representation

Money is stored as an `int` in **piastres**, not as `double`.

For example:

```text
4550 piastres = 45.50 EGP
30000 piastres = 300.00 EGP
2805 piastres = 28.05 EGP
```

The project uses:

```java
piastres / 100
```

to get the pounds and:

```java
piastres % 100
```

to get the remaining piastres.

This keeps the calculations exact.

---

## 🔧 Required Methods

The main part of the task consists of seven methods:

| Method                | Purpose                                     |
| --------------------- | ------------------------------------------- |
| `total()`             | Calculates the total of entered expenses    |
| `average()`           | Calculates the average expense              |
| `highestIndex()`      | Finds the index of the biggest expense      |
| `totalForCategory()`  | Calculates spending for a specific category |
| `findByDescription()` | Searches expenses by description            |
| `money()`             | Converts piastres into readable EGP format  |
| `bar()`               | Creates a simple spending bar using `#`     |

The arrays and expense count are created inside `main()` and passed to the methods as parameters.

---

## 📋 Example

Example expenses:

```text
Taxi to campus    Transport    4550
Koshary lunch     Food         3200
Internet bill     Bills        30000
Cinema ticket     Fun          12000
Coffee            Food         2800
```

### List Expenses

```text
--------------------------------------------
[0] Taxi to campus (Transport) 45.50 EGP
[1] Koshary lunch (Food) 32.00 EGP
[2] Internet bill (Bills) 300.00 EGP
[3] Cinema ticket (Fun) 120.00 EGP
[4] Coffee (Food) 28.00 EGP
--------------------------------------------
Total: 525.50 EGP
```

### Summary

```text
Entries : 5
Total   : 525.50 EGP
Average : 105.10 EGP
Biggest : Internet bill 300.00 EGP
```

### Spending by Category

```text
Food
| #### 60.00 EGP
Transport | ### 45.50 EGP
Bills
| #################### 300.00 EGP
Fun
| ######## 120.00 EGP
```

### Search

Searching for:

```text
coffee
```

finds:

```text
Found [4] Coffee 28.00 EGP
```

---

## ▶️ Running the Project

The project can be run directly from the terminal using Java's source-file mode:

```bash
java ExpenseTracker.java
```

Or from IntelliJ IDEA by running the `ExpenseTracker.java` file.

---

## 🛠️ Technologies

* Java
* IntelliJ IDEA
* Git
* GitHub

---

## 📂 Project Structure

```text
Java-Personal-Expense-Tracker/
├── ExpenseTracker.java
├── README.md
└── .gitignore
```

---

## 🎯 Learning Progression

This project is part of a Java learning progression:

```text
Variables
   ↓
Conditions
   ↓
Loops
   ↓
Arrays
   ↓
Methods
   ↓
String Manipulation
   ↓
Searching
   ↓
Data Processing
```

It builds on Java Fundamentals before moving to Object-Oriented Programming.

---

## 👩‍💻 Author

**Mariam Saeed**

QA / Software Testing Engineer
