package virtualclassroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VirtualClassroomManager {

    private Connection connection;

    public VirtualClassroomManager(Connection connection) {
        this.connection = connection;
    }
    public class ClassroomCreationException extends Exception {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ClassroomCreationException(String message) {
            super(message);
        }
    }

    public boolean addClassroom(String className) throws ClassroomCreationException {
        try {
            String sql = "INSERT INTO classrooms (className) VALUES (?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, className);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ClassroomCreationException("Failed to create classroom: " + e.getMessage());
        }
    }
    public class ClassroomRemovalException extends Exception {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ClassroomRemovalException(String message) {
            super(message);
        }
    }

    public boolean removeClassroom(String className) throws ClassroomRemovalException {
        try {
            String sql = "DELETE FROM classrooms WHERE className=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, className);
                int affectedRows = stmt.executeUpdate();
                if (affectedRows > 0) {
                    return true;
                } else {
                    System.out.println("Classroom not found.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ClassroomRemovalException("Failed to remove classroom: " + e.getMessage());
        }
    }
    public class StudentEnrollmentException extends Exception {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public StudentEnrollmentException(String message) {
            super(message);
        }
    }

    public boolean enrollStudent(int studentId, String studentName, String className) throws StudentEnrollmentException {
        try {
            String sql = "INSERT INTO students (studentId, studentName, classroom_name) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, studentId);
                stmt.setString(2, studentName);
                stmt.setString(3, className);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StudentEnrollmentException("Failed to enroll student: " + e.getMessage());
        }
    }
    public class AssignmentSchedulingException extends Exception {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AssignmentSchedulingException(String message) {
            super(message);
        }
    }

    public boolean scheduleAssignment(String className, String assignmentDetails) throws AssignmentSchedulingException {
        try {
            String sql = "INSERT INTO assignments (classroom_name, assignmentdetails) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, className);
                stmt.setString(2, assignmentDetails);
                stmt.executeUpdate();
                System.out.println("Assignment for " + className + " has been scheduled.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AssignmentSchedulingException("Failed to schedule assignment: " + e.getMessage());
        }
    }
    


    public boolean submitAssignment(int studentId, String className, String assignmentDetails) throws AssignmentSubmissionException {
        try {
            String sql = "INSERT INTO submitted_assignments (student_id, classroom_name, assignment_details) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, studentId);
                stmt.setString(2, className);
                stmt.setString(3, assignmentDetails);
                stmt.executeUpdate();
                System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AssignmentSubmissionException("Failed to submit assignment: " + e.getMessage());
        }
    }
    public class AssignmentSubmissionException extends Exception {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AssignmentSubmissionException(String message) {
            super(message);
        }
    }
    public List<String> listStudents(String className) {
        List<String> students = new ArrayList<>();
        try {
            String sql = "SELECT studentName FROM students WHERE classroom_name = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, className);
                try (ResultSet resultSet = stmt.executeQuery()) {
                    while (resultSet.next()) {
                        String studentName = resultSet.getString("studentName");
                        students.add(studentName);
                        
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<String> listClassrooms() {
        List<String> classrooms = new ArrayList<>();
        try {
            String sql = "SELECT className FROM classrooms";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = stmt.executeQuery()) {
                    System.out.println("List of Classrooms:");
                    while (resultSet.next()) {
                        String classroomName = resultSet.getString("className");
                        classrooms.add(classroomName);
                        
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }
}
