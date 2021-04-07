/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 03 - Main
 * Student(s) Name(s):
 */

import java.util.List;
import java.util.Scanner;

public class Main {

    private static int OPTION_ENROLL = 1;
    private static int OPTION_DROP   = 2;
    private static int OPTION_LIST   = 3;
    private static int OPTION_EXIT   = 4;


    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);
        while (true) {
            List<Course> courses = controller.getCourses();
            System.out.println(
                    String.format("%-7s|%-35s|%-15s|%-3s|%-6s|%-3s",
                            "code", "title", "instructor", "max", "actual", "remain")
            );
            for (Course course : courses)
                System.out.println(course);
            System.out.print("[1:enroll|2:drop|3:list|4:exit]? ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == OPTION_EXIT)
                break;
            System.out.print("course? ");
            String course = sc.nextLine();
            if (option == OPTION_LIST) {
                List<Student> students = controller.getStudentsEnrolled(course);
                if (students.isEmpty())
                    System.out.println("No student is currently enrolled in this class!");
                else
                    for (Student student: students)
                        System.out.println(student);
            }
            else {
                System.out.print("student id? ");
                int id = Integer.parseInt(sc.nextLine());
                Student student = controller.getStudent(id);
                if (student == null) {
                    System.out.print("student name? ");
                    String name = sc.nextLine();
                    student = new Student();
                    student.setId(id);
                    student.setName(name);
                    controller.addStudent(student);
                }
                else
                    System.out.println("student name: " + student.getName());
                if (option == OPTION_ENROLL) {
                    if (controller.enrollStudent(course, id))
                        System.out.println("Success!");
                    else
                        System.out.println("Failure!");
                }
                else {
                    if (controller.dropStudent(course, id))
                        System.out.println("Success!");
                    else
                        System.out.println("Failure!");
                }
            } // end else
        } // end while
    } // end main
} // end class
