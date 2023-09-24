

# Virtual Classroom Manager


A brief description of what this project does 

Introduction

**Purpose**
The Virtual Classroom Manager is a terminal-based application designed to manage virtual classrooms, student enrolment, and assignment scheduling and submission for an EdTech platform.

**Scope**
This documentation provides an overview of the project's architecture, setup instructions, usage guide, code structure, functionality, and other relevant information.

**Architecture Overview**


The application follows the Model-View-Controller (MVC) architecture, where MySQL databases act as the model. Key components include:

**Database:** MySQL database named "Virtual_Classrooms" with tables for STUDENTS (studentId, studentName, classroom_name), CLASSROOMS (className), ASSIGNMENTS (classroom_name, AssignmentDetails), SUBMITTED_ASSIGNMENTS (studentId, classroom_name, AssignmentDetails).

**Command-Line Interface (CLI):** The terminal-based user interface for interacting with the application.

**Java Codebase Connectivity:** The codebase responsible for handling classroom, student, and assignment operations.
![MVC](https://github.com/BassammaKorvi/Virtual-Classroom-Manager/assets/96287096/f6980bf5-51a6-4160-82ac-e1fca11fc910)


## Tech Stack

**Model:** MySQL database

**View:** Command-Line Interface (CLI)

**Controller:** Java Codebase Connectivity(Java)


## Installation


Setup Instructions Prerequisites:

Before running the Virtual Classroom Manager, make sure you have the following prerequisites installed on your system:
1. Java Runtime Environment (JRE): You can download and install the latest JRE from the official Oracle website: [Download JRE] (https://www.oracle.com/java/technologies/javase-downloads.html)
2. MySQL Database Server: Install MySQL Database Server if it's not already installed. You can download it from the official MySQL website: [MySQL Download] (https://dev.mysql.com/downloads/mysql/)


**Installation Steps:**
Follow these steps to set up and run the Virtual Classroom Manager:


**Step 1:**: Clone the Project Repository


Clone the project repository from the provided GitHub URL. You can use Git to clone the repository


**Step 2:** Create the Necessary Database and Tables


Execute the provided SQL script to create the required database and tables. You can use a MySQL client, such as MySQL Workbench or the command-line client, to run the script. 


**Step 3:** Configure the Database Connection in the Application


In your Java application code, configure the database connection. You'll need the MySQL JDBC driver for this. Follow these steps:


•   Download the MySQL JDBC Driver: Download the MySQL Connector/J JDBC driver from the MySQL website: [MySQL Connector/J Download] (https://dev.mysql.com/downloads/connector/j/)


•   Include the JDBC Driver: Add the downloaded JDBC driver (a JAR file) to your project's class path. You can do this using your preferred Java development environment (IDE), build tool (e.g., Maven or Gradle), or by manually placing the JAR file in your project's library folder.


**Step 4:** Compile and Run the Java Application


Compile your Java application. You can typically do this from your IDE.


With these steps completed, your Virtual Classroom Manager should be ready to use. It will connect to the MySQL database and allow you to manage virtual classrooms, students, and assignments through the terminal-based interface.




## Documentation


[Documentation](https://docs.google.com/document/d/1ipXvEyoQMqGD8bC6IH0ehQmcJJaKV4sT/edit?usp=sharing&ouid=109254172910611221108&rtpof=true&sd=true
)



