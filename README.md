# Student-Report-Generator

This project is a **Java-based desktop application** that manages student records using a **MySQL database**. It provides functionalities like student registration, login, and viewing student scores. The GUI is built using **Swing** and **AWT**, and the application interacts with the database using **JDBC**.

## Features

- **Student Registration**: Allows new students to register by entering their details and storing them in the database.
- **Login System**: Existing users can log in by verifying their credentials stored in the MySQL database.
- **Student Scores Display**: Displays individual student scores for different subjects after successful login.
- **Data Storage**: All student information is securely stored in a MySQL database.

## Technologies Used

- **Java** (Core, Swing, AWT, JDBC)
- **MySQL** (For database management)
- **SQL** (For querying and managing data)
- **Event-driven Programming** (For handling user actions)

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/Student-Report-Generator.git
   ```

2. Set up a MySQL database:
   - Create a database named `student`.
   - Create a table `records` with the following fields: `Student_ID`, `Name`, `Location`, `Mathematics`, `Science`, `English`, `Computer_Science`, `Hindi`, `Password`.

3. Update database credentials in the Java code:
   ```java
   String url = "jdbc:mysql://localhost:3306/student";
   String uname = "your-username";
   String pass = "your-password";
   ```

4. Compile and run the Java program:
   ```bash
   javac Data_form.java
   java Data_form
   ```

## Usage

- **Sign Up**: Click "Sign Up" to register a new student by entering their information.
- **Sign In**: Log in using the student ID and password. After successful login, student grades will be displayed.

## License

This project is licensed under the DIT University. Feel free to use, modify, and distribute it as per the license terms.

---

**Author**: Aryan Mishra  
**GitHub**: [Aryan8057](https://github.com/Aryan8057)
