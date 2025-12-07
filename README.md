# 📚 Java OOP Quiz Application

This is a **Java console-based Quiz Application** designed to demonstrate fundamental **Object-Oriented Programming (OOP)** principles in a practical context. Users can select a subject, answer randomized questions, and store their results persistently using file handling.

## 📌 Core Features

* **Three Subjects:** Offers distinct question banks for **Maths, English, and Science**.
* **Question Randomization:** Uses the `Collections.shuffle()` method to ensure a fresh quiz order every time.
* **Robust Input Handling:** Implements **Exception Handling** to prevent crashes from non-numeric user input.
* **Persistent Storage:** Scores and quiz details are saved to a file (`results.txt`) using **File Handling**.
* **Modular Design:** Follows the Single Responsibility Principle, making the code clean and maintainable.

---

## 💡 OOP Concepts Demonstrated

The project structure is built around several core OOP pillars:

### 1. Classes & Objects

The application defines multiple classes as blueprints for its components:
* `Question`: Data model for quiz content.
* `Subject` (Abstract): Parent class for common functionality.
* `Maths`, `English`, `Science`: Concrete classes for specific question sets.
* `ResultSaver`: Handles file writing logic.
* `QuizApp1`: The main workflow class.

### 2. Encapsulation

The `Question` class uses the private access modifier to protect its data, exposing it only through controlled public methods (getters).

```java
// Data Hiding
private String question;
private String[] options;
private int answer;

// Controlled Access
public String getQuestion() { ... }
public String[] getOptions() { ... }
public int getAnswer() { ... }

### 3. Abstraction
The design utilizes an abstract parent class, Subject.

Java

abstract class Subject { 
    // abstract methods and common fields go here
}
Users cannot create a Subject object directly. The core complexity of specific question implementation is hidden, and users interact only with the necessary features.

4. Inheritance
The subject-specific classes inherit common properties and methods from the abstract parent class, promoting code reuse.

Java

class Maths extends Subject { ... }
class English extends Subject { ... }
class Science extends Subject { ... }
5. Polymorphism & Dynamic Binding
The system uses a single reference type (Subject) to point to different object types (Maths, English, Science).

Java

Subject subject;

// Polymorphism: Single reference holds different object types
if (choice == 1) subject = new Maths(); 
// ...
When subject.getQuestions() is called, Java decides at runtime which specific method to execute (Dynamic Method Dispatch), based on the actual object instance.

6. File Handling (Persistent Storage)
Scores are saved in append mode (true) to results.txt, ensuring persistent storage of all quiz attempts.

Java

// Example usage of FileWriter (ResultSaver Class)
FileWriter fw = new FileWriter("results.txt", true);
fw.write("Subject: " + subject.getName() + " Score: " + score + "/" + total + "\n");
// ... close writer
7. Exception Handling (Robustness)
A try-catch block is implemented around user input to handle non-numeric input gracefully, preventing program termination.

Java

try {
    return sc.nextInt();
} catch (InputMismatchException e) {
    System.out.println("Error: Enter numbers only. Please try again.");
    sc.next(); // Clears the bad input
}
🚀 How to Run the Project
Compile: Navigate to the source directory and compile the main file.

