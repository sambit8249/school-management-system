# school-management-system


This is a School Management System project developed using Java, Servlet, JSP, Hibernate, and MySQL. The project consists of four main controllers: Admin, Student, Teacher, and Principal.

## Features

- **Admin Controller**: Manages school information, user accounts, and system settings.
  
- **Student Controller**: Handles student-related functionalities such as enrollment, attendance, and grades.
  
- **Teacher Controller**: Manages teacher information, class schedules, and assignments.
  
- **Principal Controller**: Provides overview and management of the entire school system, including reports and analytics.

## Technologies Used

- **Java**: Core programming language for backend development.
  
- **Servlet**: Handles HTTP requests and responses.
  
- **JSP (JavaServer Pages)**: Frontend for dynamic web content.
  
- **Hibernate**: Object-relational mapping (ORM) for database interaction.
  
- **MySQL**: Database management system for storing school data.

## Setup Instructions

1. **Clone the Repository**
   ```
   git clone https://github.com/yourusername/school-management-system.git
   ```
   
2. **Navigate to Project Directory**
   ```
   cd school-management-system
   ```
   
3. **Database Setup**
   - Create a MySQL database and import the provided SQL schema.
   - Update `hibernate.cfg.xml` with your database credentials.

4. **Build and Run**
   - Compile and build the project using your IDE or command line.
   - Deploy the WAR file to a servlet container like Apache Tomcat.

## Usage

1. **Admin**
   - Login with admin credentials to access admin functionalities.
  
2. **Student**
   - Students can log in to view their attendance, grades, and other information.
  
3. **Teacher**
   - Teachers can log in to manage class schedules, assignments, and student grades.
  
4. **Principal**
   - The principal can log in to oversee the entire school system, generate reports, and manage resources.

## Contributing

Feel free to fork the repository and submit pull requests or open issues for any bugs or feature requests.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.