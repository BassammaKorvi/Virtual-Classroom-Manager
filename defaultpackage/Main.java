package defaultpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import virtualclassroom.VirtualClassroomManager;
import virtualclassroom.CP;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Welcome to the Virtual Classroom Manager");

        try (Connection connection = CP.createConnection()) {
            VirtualClassroomManager manager = new VirtualClassroomManager(connection);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Add Classroom");
                System.out.println("2. Remove Classroom");
                System.out.println("3. Enroll Student");
                System.out.println("4. Schedule Assignment");
                System.out.println("5. Submit Assignment");
                System.out.println("6. List Classrooms");
                System.out.println("7. List Students in Classroom");
                System.out.println("8. Exit");

                int choice = 0;
                try {
                    choice = Integer.parseInt(br.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input! Please enter a valid option.");
                    continue;
                }

                String className, studentName, assignmentDetails;
                int studentId;

                switch (choice) {
                    case 1:
                        System.out.print("Enter Classroom Name: ");
                        className = br.readLine();
                        try {
                            boolean classroomAdded = manager.addClassroom(className);
                            if (classroomAdded) {
                                System.out.println("Classroom " + className + " has been created.");
                            } else {
                                System.out.println("Failed to create classroom.");
                            }
                        } catch (VirtualClassroomManager.ClassroomCreationException e) {
                            System.err.println("Error creating classroom: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter Classroom Name to Remove: ");
                        className = br.readLine();
                        try {
                            boolean classroomRemoved = manager.removeClassroom(className);
                            if (classroomRemoved) {
                                System.out.println("Classroom " + className + " has been removed.");
                            } else {
                                System.out.println("Classroom not found.");
                            }
                        } catch (VirtualClassroomManager.ClassroomRemovalException e) {
                            System.err.println("Error removing classroom: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Enter Student ID: ");
                        studentId = Integer.parseInt(br.readLine());
                        System.out.print("Enter Student Name: ");
                        studentName = br.readLine();
                        System.out.print("Enter Classroom Name: ");
                        className = br.readLine();
                        try {
                            boolean studentEnrolled = manager.enrollStudent(studentId, studentName, className);
                            if (studentEnrolled) {
                                System.out.println("Student " + studentName + " has been enrolled in " + className + ".");
                            } else {
                                System.out.println("Failed to enroll student.");
                            }
                        } catch (VirtualClassroomManager.StudentEnrollmentException e) {
                            System.err.println("Error enrolling student: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Enter Classroom Name: ");
                        className = br.readLine();
                        System.out.print("Enter Assignment Details: ");
                        assignmentDetails = br.readLine();
                        try {
                            manager.scheduleAssignment(className, assignmentDetails);
                        } catch (VirtualClassroomManager.AssignmentSchedulingException e) {
                            System.err.println("Error scheduling assignment: " + e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.print("Enter Student ID: ");
                        studentId = Integer.parseInt(br.readLine());
                        System.out.print("Enter Classroom Name: ");
                        className = br.readLine();
                        System.out.print("Enter Assignment Details: ");
                        assignmentDetails = br.readLine();
                        try {
                            manager.submitAssignment(studentId, className, assignmentDetails);
                        } catch (VirtualClassroomManager.AssignmentSubmissionException e) {
                            System.err.println("Error submitting assignment: " + e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println("List of Classrooms:");
                        List<String> classrooms = manager.listClassrooms();
                        for (String classroom : classrooms) {
                            System.out.println(classroom);
                        }
                        break;
                    case 7:
                        System.out.print("Enter Classroom Name: ");
                        className = br.readLine();
                        System.out.println("List of Students in " + className + ":");
                        List<String> students = manager.listStudents(className);
                        for (String student : students) {
                            System.out.println(student);
                        }
                        break;
                    case 8:
                        System.out.println("Exiting the Virtual Classroom Manager.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Input! Please enter a valid option.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
